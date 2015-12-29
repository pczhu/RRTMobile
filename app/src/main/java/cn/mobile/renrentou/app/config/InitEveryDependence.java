package cn.mobile.renrentou.app.config;

import android.app.Application;
import android.content.Context;

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
    }

    /**
     * 初始化xUtils
     */
    public void initXutils(){
        x.Ext.init(app);
        x.Ext.setDebug(true);
    }
}
