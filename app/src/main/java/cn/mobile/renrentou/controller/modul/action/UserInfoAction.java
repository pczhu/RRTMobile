package cn.mobile.renrentou.controller.modul.action;

import android.content.Context;

import cn.mobile.renrentou.app.Constants;
import cn.mobile.renrentou.controller.http.HttpAction;
import cn.mobile.renrentou.controller.http.HttpResponseListener;
import cn.mobile.renrentou.controller.store.db.UserData;
import cn.mobile.renrentou.controller.store.db.impl.DbAction;
import cn.mobile.renrentou.controller.ui.fragment.main.CenterFragment;
import cn.mobile.renrentou.domain.UserInfo;
import cn.mobile.renrentou.utils.LogUtils;

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
                            LogUtils.i("是否是空"+(CenterFragment.intance!=null));
                            if(CenterFragment.intance != null){
                                CenterFragment.intance.onRefresh();
                            }
                        }
                    }
                });
    }
}
