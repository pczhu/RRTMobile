package cn.mobile.renrentou.app.config;

import android.app.Application;
import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.google.gson.Gson;
import com.litesuits.android.async.SimpleCachedTask;
import com.litesuits.android.async.TaskExecutor;

import org.lasque.tusdk.core.TuSdk;
import org.lasque.tusdk.core.TuSdkCrashException;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.mobile.renrentou.app.Constants;
import cn.mobile.renrentou.app.RRTApplication;
import cn.mobile.renrentou.controller.store.cache.CacheUtils;
import cn.mobile.renrentou.domain.CityList;
import cn.mobile.renrentou.domain.HomeCount;
import cn.mobile.renrentou.utils.FileUtils;
import cn.mobile.renrentou.utils.LogUtils;
import me.imid.swipebacklayout.lib.Utils;

/**
 * 名称：CustomTestxUtils
 * 作用：初始化各种工具 控件 引用等
 * 描述：
 *      在Application进行调用的，将各种第三方进行初始化的单例工具
 *      InitEveryDependence.getInstanc(context).start();即可
 * 作者：pczhu
 * 创建时间： 15/11/20 上午9:45
 * 版本：V1.0
 * 修改历史：
 */
public class InitEveryDependence implements AMapLocationListener {
    private static InitEveryDependence initEveryDependence = null;
    private SimpleCachedTask<CityList> simpleCachedTask;
    private static Context mContext;


    private List<CityList.DataEntity> dataEntitys;
    public static InitEveryDependence getInstance(Context mContext){
        InitEveryDependence.mContext = mContext;
        if(initEveryDependence == null){
            initEveryDependence = new InitEveryDependence();
        }
        return initEveryDependence;
    }

    /**
     * 初始化一切
     */
    public void start(Application application){

        initXutils(application);
        initTutu();
        initLocation();
        initCityJson();
    }

    /**
     * 初始化xUtils
     */
    public void initXutils(Application application){
        x.Ext.init(application);
        x.Ext.setDebug(true);
    }

    /**
     * 初始化涂图
     */
    public void initTutu(){
        /**
         * ！！！！！！！！！！！！！！！！！！！！！！！！！特别提示信息要长！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
         * 关于TuSDK体积（SDK编译后仅为0.9MB）：
         * 1,如果您不需要使用本地贴纸功能，或仅需要使用在线贴纸功能，请删除/app/assets/TuSDK.bundle/stickers文件夹
         * 2,如果您仅需要几款滤镜，您可以删除/app/assets/TuSDK.bundle/textures下的*.gsce文件
         * 3,如果您不需要使用滤镜功能，请删除/app/assets/TuSDK.bundle/textures文件夹
         * 4,TuSDK在线管理功能请访问：http://tusdk.com/
         * 开发文档:http://tusdk.com/docs/android/api/
         */
        TuSdkCrashException.bindExceptionHandler(mContext);
        // 设置输出状态
        TuSdk.enableDebugLog(true);
        // 初始化SDK (请前往 http://tusdk.com 获取您的APP 开发秘钥)
        TuSdk.init(mContext, "fb7f5db7e014e3e3-01-1oglo1");
        // 需要指定开发模式 需要与lsq_tusdk_configs.json中masters.key匹配， 如果找不到devType将默认读取master字段
        // this.initPreLoader(this.getApplicationContext(), "12aa4847a3a9ce68-04-ewdjn1", "debug");

        // 如果不想继承TuSdkApplication，直接在自定义Application.onCreate()方法中调用以下方法
        // 初始化全局变量
        // TuSdk.enableDebugLog(true);
        // 开发ID (请前往 http://tusdk.com 获取您的APP 开发秘钥)
        // TuSdk.init(this.getApplicationContext(), "12aa4847a3a9ce68-04-ewdjn1");
        // 需要指定开发模式 需要与lsq_tusdk_configs.json中masters.key匹配， 如果找不到devType将默认读取master字段
        // TuSdk.init(this.getApplicationContext(), "12aa4847a3a9ce68-04-ewdjn1", "debug");
    }
    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    /**
     * 初始化地理位置信息
     */
    public void initLocation(){
        locationClient = new AMapLocationClient(mContext);
        locationOption = new AMapLocationClientOption();
        // 设置定位模式为高精度模式
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //单词定位
        locationOption.setOnceLocation(true);
        // 设置定位监听
        locationClient.setLocationListener(this);
        /**
         * 设置是否优先返回GPS定位结果，如果30秒内GPS没有返回定位结果则进行网络定位
         * 注意：只有在高精度模式下的单次定位有效，其他方式无效
         */
        locationOption.setGpsFirst(true);
        // 设置定位参数
        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();
    }


    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        //String result = aMapLocation.getLocationDetail().toString();
        String location = "纬度"+aMapLocation.getLatitude() +"精度"+ aMapLocation.getLongitude();
        LogUtils.i("地理信息位置坐标：" + location + "；详细地址" + aMapLocation.toString());
    }
    CityList cityList = null;
    /**
     * 查找分站信息
     */
    private void initCityJson() {
        Gson gson = new Gson();
        try {
            cityList = gson.fromJson(FileUtils.getAssetString("city.json",mContext),CityList.class);//先初始化为本地信息
            setDataEntitys(cityList.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }

        simpleCachedTask = new SimpleCachedTask<CityList>(
                mContext,"get_city_list",3L, TimeUnit.DAYS) {
            @Override
            protected CityList doConnectNetwork() throws Exception {
                String json = null;
                CityList cityList = null;
                try {
                    json = x.http().postSync(
                            new RequestParams(Constants.BASE_SERVER_URL2 + Constants.GET_CITY_LIST),
                            String.class);
                    cityList = new Gson().fromJson(json,CityList.class);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                LogUtils.i("执行city地址请求一次");
                return cityList;
            }

            @Override
            protected void onPostExecuteSafely(CityList cityList, Exception e) throws Exception {
                super.onPostExecuteSafely(cityList, e);
                if(cityList != null){
                    dataEntitys = cityList.getData();
                }

            }
        };
        TaskExecutor.newCyclicBarrierExecutor().start(simpleCachedTask);
    }


    public List<CityList.DataEntity> getDataEntitys() {
        return dataEntitys;
    }

    public void setDataEntitys(List<CityList.DataEntity> dataEntitys) {
        this.dataEntitys = dataEntitys;
    }
}
