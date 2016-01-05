package cn.mobile.renrentou.controller.store.db;


import cn.mobile.renrentou.domain.UserInfo;

/**
 * 名称：UserData
 * 作用：针对UserInfo的数据接口
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/14 下午12:02
 * 版本：V1.0
 * 修改历史：
 */
public interface UserData {

    public void setUserInfo(UserInfo.UserDataEntity userInfo);
    public UserInfo.UserDataEntity getUserInfo();
    public UserInfo.UserDataEntity getUserInfo(String id);
    public UserInfo.UserDataEntity getUserInfo(String key, String value);
    public String getRealName(String id);
    public String isIdcard(String id);
    public String getFace(String id);
    public String getUsertype(String id);
    public boolean is_Auto_Yeepay(String id);
}
