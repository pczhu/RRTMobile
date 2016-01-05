package cn.mobile.renrentou.controller.store.sp.impl;

import android.content.Context;
import android.content.SharedPreferences;

import cn.mobile.renrentou.app.Constants;
import cn.mobile.renrentou.app.RRTApplication;
import cn.mobile.renrentou.controller.store.sp.ShareStoreData;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/5 下午2:27
 * 版本：V1.0
 * 修改历史：
 */
public class ShareStoreAction implements ShareStoreData {
    private static Context mContext;
    private static ShareStoreAction ssaction = null;
    private static final String DEFFAULT_SP_NAME = "rrtmobile";
    public static ShareStoreAction getInstance(Context context){
        ShareStoreAction.mContext = context;
        if(ssaction == null){
            ssaction = new ShareStoreAction();
        }
        return ssaction;
    }
    @Override
    public SharedPreferences getShare(String name) {

        return mContext.getSharedPreferences(name,Context.MODE_PRIVATE);
    }

    @Override
    public boolean getBoolean(String shKey) {

        return getShare(DEFFAULT_SP_NAME).getBoolean(shKey,false);
    }

    @Override
    public boolean setBoolean(String shKey, boolean value) {
        return getShare(DEFFAULT_SP_NAME).edit().putBoolean(shKey,value).commit();
    }

    @Override
    public String getString(String shKey) {
        return getShare(DEFFAULT_SP_NAME).getString(shKey,"");
    }

    @Override
    public void setString(String shkey, String value) {
        getShare(DEFFAULT_SP_NAME).edit().putString(shkey,value);
    }

    @Override
    public int getInt(String shKey) {
        return getShare(DEFFAULT_SP_NAME).getInt(shKey,0);
    }

    @Override
    public void setInt(String shKey, int value) {
        getShare(DEFFAULT_SP_NAME).edit().putInt(shKey,value).commit();
    }

    @Override
    public boolean isLogin() {
        return getShare(DEFFAULT_SP_NAME).getBoolean(Constants.Login_Tag,false);
    }

    @Override
    public void setIsLogin(boolean flag) {
        getShare(DEFFAULT_SP_NAME).edit().putBoolean(Constants.Login_Tag,flag).commit();
    }
}
