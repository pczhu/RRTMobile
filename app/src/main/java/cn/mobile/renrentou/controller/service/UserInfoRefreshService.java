package cn.mobile.renrentou.controller.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import cn.mobile.renrentou.app.Constants;
import cn.mobile.renrentou.controller.http.HttpAction;
import cn.mobile.renrentou.controller.http.HttpResponseListener;
import cn.mobile.renrentou.controller.modul.action.UserInfoAction;
import cn.mobile.renrentou.controller.store.db.LoginData;
import cn.mobile.renrentou.controller.store.db.impl.DbAction;
import cn.mobile.renrentou.domain.LoginInfo;
import cn.mobile.renrentou.domain.UserInfo;
import cn.mobile.renrentou.domain.dbentity.TokenEntity;
import cn.mobile.renrentou.utils.LogUtils;

/**
 * 名称：UserInfoRefreshService
 * 作用：想用这个服务刷新用户UserInfo 的 暂时搁置。没有想到好的刷新方案
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/5 上午9:24
 * 版本：V1.0
 * 修改历史：
 */
public class UserInfoRefreshService extends Service {
    private LoginInfo loginInfo;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        loginInfo = (LoginInfo) intent.getSerializableExtra("logininfo");
        LoginData loginData = DbAction.getInstance(this);
        loginData.setToken(new TokenEntity(loginInfo.getData().getUserinfo().getUid(),
                loginInfo.getData().getAccess_token()));
        loginData.setLoginUserInfo(loginInfo.getData().getUserinfo());
        UserInfoAction.getInstance(this).getUserInfo();
        LogUtils.i("数据存储完毕");
        return START_NOT_STICKY;
    }


    @Override
    public void onCreate() {
        super.onCreate();

    }
    //TODO 待实现的东西
}
