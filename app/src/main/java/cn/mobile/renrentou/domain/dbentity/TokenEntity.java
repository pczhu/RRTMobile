package cn.mobile.renrentou.domain.dbentity;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.io.Serializable;

/**
 * 名称：TokenEntity
 * 作用：用于存储token
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/5 上午9:53
 * 版本：V1.0
 * 修改历史：
 */
@Table(name = "TokenEntity")
public class TokenEntity implements Serializable{
    /**
     * UID
     */
    @Column(name = "uid", isId = true,  property = "UNIQUE")
    private String uid;
    /**
     * access_token
     */
    @Column(name = "access_token")
    private String access_token;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public TokenEntity() {
    }

    public TokenEntity(String uid, String access_token) {
        this.uid = uid;
        this.access_token = access_token;
    }
}
