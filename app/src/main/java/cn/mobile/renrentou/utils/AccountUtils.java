package cn.mobile.renrentou.utils;

import android.content.Context;

import cn.mobile.renrentou.controller.store.db.LoginData;
import cn.mobile.renrentou.controller.store.db.impl.DbAction;

/**
 * 名称：AccountUtils
 * 作用：账号相关工具类
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/5 下午12:20
 * 版本：V1.0
 * 修改历史：
 */
public class AccountUtils {
    // 返回MD5加密后的accessToken
    public static String getSign(String time,Context context) {
        String mAccessToken = getAppAccessToken(context);
        if(mAccessToken != null)
            return  MD5Utils.toMD5(time + "&" + mAccessToken);
        return "";
    }

    public static String getAppAccessToken(Context context) {
        LoginData loginData = DbAction.getInstance(context);
        if(loginData != null)
            return loginData.getAssessToken();
        return null;
    }
}
