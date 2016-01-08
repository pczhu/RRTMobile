package cn.mobile.renrentou.controller.modul.action;

import android.content.Context;
import android.content.Intent;

import cn.mobile.renrentou.app.Constants;
import cn.mobile.renrentou.controller.http.HttpAction;
import cn.mobile.renrentou.controller.http.HttpResponseListener;
import cn.mobile.renrentou.controller.receive.AppReceiver;
import cn.mobile.renrentou.controller.store.db.UserData;
import cn.mobile.renrentou.controller.store.db.impl.DbAction;
import cn.mobile.renrentou.controller.store.sp.impl.ShareStoreAction;
import cn.mobile.renrentou.domain.Failed;
import cn.mobile.renrentou.domain.UserInfo;

/**
 * 名称：UserInfoAction
 * 作用：请求个人信息的动作
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/5 下午1:42
 * 版本：V1.0
 * 修改历史：
 */
public class UserInfoAction {
    private static Context mContext;
    private static UserInfoAction userInfoAction = null;

    public static UserInfoAction getInstance(Context context){
        UserInfoAction.mContext = context;
        if(userInfoAction == null){
            userInfoAction = new UserInfoAction();
        }
        return userInfoAction;
    }


    public void getUserInfo() {
        HttpAction.getInstance(mContext).post(
                HttpAction.getRequestParams(Constants.BASE_SERVER_URL2 + Constants.GET_USER_INFO_URL),
                UserInfo.class,
                new HttpResponseListener<UserInfo>() {
                    @Override
                    public void onSuccessForData(UserInfo userInfo) {
                        if(userInfo!= null && userInfo.getData()!=null){
                            UserData userData = DbAction.getInstance(mContext);
                            userData.setUserInfo(userInfo.getData());
                            ShareStoreAction.getInstance(mContext).setIsLogin(true);//设置全局登录状态为YES
                            sendBroadCaseReceiver();
                        }
                    }

                    @Override
                    public void onSuccessButNoData(Failed failed) {
                        super.onSuccessButNoData(failed);
                        ShareStoreAction.getInstance(mContext).setIsLogin(false);//拿不到数据登录状态为No
                        sendBroadCaseReceiver();
                    }
                });
    }
    private void sendBroadCaseReceiver(){
        Intent intent = new Intent();
        intent.setAction(AppReceiver.REFRESH_USERINFO);
        mContext.sendOrderedBroadcast(intent, null);
    }
}
