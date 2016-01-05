package cn.mobile.renrentou.controller.store.db;


import cn.mobile.renrentou.domain.LoginInfo;
import cn.mobile.renrentou.domain.dbentity.TokenEntity;

/**
 * 名称：LoginData
 * 作用：登录信息保存
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/5 上午9:28
 * 版本：V1.0
 * 修改历史：
 */
public interface LoginData {
    /**
     * token唯一保存，表内不允许两条数据
     * @return
     */
    public String getAssessToken();
    public LoginInfo.DataEntity.UserinfoEntity getLoginUserInfo();

    public void setToken(TokenEntity tokenEntity);
    public void setLoginUserInfo(LoginInfo.DataEntity.UserinfoEntity loginUserInfo);
}
