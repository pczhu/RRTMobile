package cn.mobile.renrentou.app;

import android.app.Application;

import cn.mobile.renrentou.app.config.InitEveryDependence;
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
    @Override
    public void onCreate() {
        super.onCreate();
        initLog();

        initSDK();
    }

    private void initLog() {
        LogUtils.allowAll = true;
        LogUtils.allowD = false;
        LogUtils.allowW = false;
        LogUtils.allowI = false;
        LogUtils.allowV = false;
        LogUtils.allowV = false;
        LogUtils.allowString = new String[]{"MainActivity"};
    }

    private void initSDK(){
        InitEveryDependence.getInstance(this).start();
    }
}
