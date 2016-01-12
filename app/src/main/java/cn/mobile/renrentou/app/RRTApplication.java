package cn.mobile.renrentou.app;

import android.app.Application;
import android.content.Context;

import cn.mobile.renrentou.app.config.InitEveryDependence;
import cn.mobile.renrentou.controller.modul.action.UserInfoAction;
import cn.mobile.renrentou.controller.store.sp.impl.ShareStoreAction;
import cn.mobile.renrentou.utils.LogUtils;

/**
 * 名称：RRTApplication
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/23 下午4:36
 * 版本：V1.0
 * 修改历史：
 */
public class RRTApplication extends Application {
    private static Context mContext;
    public static boolean isLogin = false;
    @Override
    public void onCreate() {
        super.onCreate();
        initSDK();
        mContext = this;

        notifyLoginStatue();//本地赋值变量
        initLog();


    }

    private void initLog() {
        LogUtils.allowAll = true;
        LogUtils.allowD = false;
        LogUtils.allowW = false;
        LogUtils.allowI = false;
        LogUtils.allowV = false;
        LogUtils.allowV = false;
        LogUtils.allowString = new String[]{"ProjectFragment","MainFragmentAdapter","PageStaggeredGridView"};
    }

    private void initSDK(){
        InitEveryDependence.getInstance(this).start();
    }
    public static Context getContext(){
        return mContext;
    }

    /**
     * 更新登录状态
     */
    public static void notifyLoginStatue(){
        isLogin = ShareStoreAction.getInstance(mContext).isLogin();
    }
}
