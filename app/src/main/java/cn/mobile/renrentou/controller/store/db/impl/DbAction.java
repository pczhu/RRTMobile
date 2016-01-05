package cn.mobile.renrentou.controller.store.db.impl;

import android.content.Context;
import android.os.Environment;

import org.xutils.DbManager;
import org.xutils.common.util.KeyValue;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.db.table.DbModel;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.io.File;
import java.util.Calendar;
import java.util.List;


import cn.mobile.renrentou.controller.store.db.LoginData;
import cn.mobile.renrentou.domain.LoginInfo;
import cn.mobile.renrentou.domain.UserInfo;
import cn.mobile.renrentou.domain.WelcomeInfo;
import cn.mobile.renrentou.domain.dbentity.TokenEntity;
import cn.mobile.renrentou.utils.LogUtils;
import cn.mobile.renrentou.utils.MyLong;
import cn.mobile.renrentou.controller.store.db.DbData;
import cn.mobile.renrentou.controller.store.db.UserData;
import cn.mobile.renrentou.controller.store.db.WelcomeInfoData;
/**
 * 名称：DbAction
 * 作用：数据库实现
 * 描述：数据库接口的具体实现
 * 作者：pczhu
 * 创建时间： 15/12/14 上午10:00
 * 版本：V1.0
 * 修改历史：
 */
public class DbAction implements DbData,UserData,WelcomeInfoData,LoginData {
    private static Context mContext;
    private static DbAction dbAction = null;
    private static DbManager db;
    private static DbManager.DaoConfig daoConfig;
    private static final String defaultCode = "0";
    public static DbAction getInstance(Context context){
        DbAction.mContext = context;
        if( dbAction == null){
            dbAction = new DbAction();
            daoConfig = new DbManager.DaoConfig()
                    .setDbName("mydb.db")
                    .setDbDir(new File(Environment.getExternalStorageState()+"/test"))
                    .setDbVersion(1)
                    .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                        @Override
                        public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                            // TODO: ...
                            // db.addColumn(...);
                            // db.dropTable(...);
                            // ...
                        }
                    });
        }
        if(db == null){
            db =  x.getDb(daoConfig);
        }

        return dbAction;
    }
    private DbAction(){

    }

    @Override
    public <T> void setObject(T object) {

        try {
            db.save(object);
        } catch (org.xutils.ex.DbException e) {
            e.printStackTrace();
        }

    }


    @Override
    public String getDataByKeyWord(Class clz,String key) {
        String result = null;

        DbModel first = null;
        try {
            first = db.selector(clz).select(key).findFirst();
            result = first.getString(key);
        } catch (DbException e) {
            e.printStackTrace();
        }


        return result;
    }

    @Override
    public List<Object> getDataByObjectName(Class clz) {
        List all = null;
        try {
            all = db.findAll(clz);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return all;
    }

    @Override
    public List<Object> getDataByObjectNameAndKey(Class clz, String name, String sign, String target) {
        List<Object> all = null;
        try {
            all = db.selector(clz).where(name,sign,target).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return all;
    }




    @Override
    public void setUserInfo(UserInfo.UserDataEntity userInfo) {
        try {
            db.dropTable(UserInfo.UserDataEntity.class);
        } catch (DbException e) {
            e.printStackTrace();
            return;
        }
        setObject(userInfo);
    }

    @Override
    public UserInfo.UserDataEntity getUserInfo() {
        List<Object> result = getDataByObjectName(UserInfo.UserDataEntity.class);
        if(result != null){
            return (UserInfo.UserDataEntity)result.get(0);
        }
        return null;
    }

    @Override
    public UserInfo.UserDataEntity getUserInfo(String id) {
        if(defaultCode.equals(id)){
            return getUserInfo();
        }
        List<Object> result = getDataByObjectNameAndKey(UserInfo.UserDataEntity.class, "id", "=", id);
        if(result != null && result.size() == 1){
            return (UserInfo.UserDataEntity) result.get(0);
        }
        return null;
    }

    @Override
    public UserInfo.UserDataEntity getUserInfo(String key, String value) {
        List<Object> result = getDataByObjectNameAndKey(UserInfo.UserDataEntity.class, key, "=", value);
        if(result != null && result.size() == 1){
            return (UserInfo.UserDataEntity) result.get(0);
        }
        return null;
    }

    @Override
    public String getRealName(String id) {
        UserInfo.UserDataEntity userinfo = getUserInfo(id);
        return (userinfo != null?userinfo.getRealname():null);
    }

    @Override
    public String isIdcard(String id) {
        UserInfo.UserDataEntity userinfo = getUserInfo(id);
        return (userinfo != null?userinfo.getIs_idcard():null);

    }

    @Override
    public String getFace(String id) {
        UserInfo.UserDataEntity userinfo = getUserInfo(id);
        return (userinfo != null?userinfo.getFace():null);
    }

    @Override
    public String getUsertype(String id) {
        UserInfo.UserDataEntity userinfo = getUserInfo(id);
        return (userinfo != null?userinfo.getUsertype():null);
    }

    @Override
    public boolean is_Auto_Yeepay(String id) {
        UserInfo.UserDataEntity userinfo = getUserInfo(id);
        return (userinfo != null?(userinfo.getIs_auto_yeepay().equals(0) ?false:true):false);
    }


    @Override
    public void setWelcomeInfo(WelcomeInfo welcomeInfo,boolean drop) {
        if(drop) {
            try {
                db.dropTable(WelcomeInfo.class);
            } catch (DbException e) {
                e.printStackTrace();
            }
        }
        setObject(welcomeInfo);
    }

    @Override
    public WelcomeInfo getWelcomeInfo() {
        List<WelcomeInfo> all = null;
        try {
            all =  db.selector(WelcomeInfo.class).orderBy("adversion",true).limit(2).findAll();

        } catch (DbException e) {
            e.printStackTrace();
        }
        if(all == null){
            return null;
        }
        for(WelcomeInfo welcomeInfo : all){
            LogUtils.i(welcomeInfo.toString());
        }
        for (WelcomeInfo welcomeInfo : all){

            Calendar calendar = Calendar.getInstance();
            if(MyLong.parseString(welcomeInfo.getBeginData())<calendar.getTimeInMillis()
                && MyLong.parseString(welcomeInfo.getEndData()) > calendar.getTimeInMillis()){
                return welcomeInfo;
            }
        }
        return null;
    }

    @Override
    public String getAssessToken() {
        List<Object> result = getDataByObjectName(TokenEntity.class);
        if(result != null && result.size() == 1){
            return ((TokenEntity) result.get(0)).getAccess_token();
        }
        return null;
    }

    @Override
    public LoginInfo.DataEntity.UserinfoEntity getLoginUserInfo() {
        List<Object> result = getDataByObjectName(LoginInfo.DataEntity.UserinfoEntity.class);
        if(result != null && result.size() == 1){
            return (LoginInfo.DataEntity.UserinfoEntity) result.get(0);
        }
        return null;
    }

    @Override
    public void setToken(TokenEntity tokenEntity) {
        try {
            db.dropTable(TokenEntity.class);
        } catch (DbException e) {
            e.printStackTrace();
            return;
        }
        setObject(tokenEntity);
    }

    @Override
    public void setLoginUserInfo(LoginInfo.DataEntity.UserinfoEntity loginUserInfo) {
        try {
            db.dropTable(LoginInfo.DataEntity.UserinfoEntity.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        setObject(loginUserInfo);
    }
}
