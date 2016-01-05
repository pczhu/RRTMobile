package cn.mobile.renrentou.app.config;

import android.app.Application;
import android.content.Context;

import org.lasque.tusdk.core.TuSdk;
import org.lasque.tusdk.core.TuSdkCrashException;
import org.xutils.x;

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
public class InitEveryDependence {
    private static InitEveryDependence initEveryDependence = null;
    private static Application app = null;
    public static InitEveryDependence getInstance(Application app){
        InitEveryDependence.app = app;
        if(initEveryDependence == null){
            initEveryDependence = new InitEveryDependence();
        }
        return initEveryDependence;
    }

    /**
     * 初始化一切
     */
    public void start(){

        initXutils();
        initTutu();
    }

    /**
     * 初始化xUtils
     */
    public void initXutils(){
        x.Ext.init(app);
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
        TuSdkCrashException.bindExceptionHandler(app);
        // 设置输出状态
        TuSdk.enableDebugLog(true);
        // 初始化SDK (请前往 http://tusdk.com 获取您的APP 开发秘钥)
        this.initPreLoader(app, "fb7f5db7e014e3e3-01-1oglo1");
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
    protected void initPreLoader(Context var1, String var2) {
        this.initPreLoader(var1, var2, (String) null);
    }
    protected void initPreLoader(Context var1, String var2, String var3) {
        TuSdk.init(var1, var2, var3);
    }
}
