package cn.mobile.renrentou.domain;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
import org.xutils.http.annotation.HttpResponse;

import java.io.Serializable;

import cn.mobile.renrentou.controller.http.JsonResponseParser;

/**
 * 名称：LoginInfo
 * 作用：登录后的个人信息
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/4 下午4:48
 * 版本：V1.0
 * 修改历史：
 */

public class LoginInfo implements Serializable{

    private String status;
    private String msg;
    private DataEntity data;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity implements Serializable{
        private String access_token;

        private UserinfoEntity userinfo;

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public void setUserinfo(UserinfoEntity userinfo) {
            this.userinfo = userinfo;
        }

        public String getAccess_token() {
            return access_token;
        }

        public UserinfoEntity getUserinfo() {
            return userinfo;
        }
        @Table(name = "UserinfoEntity")
        public static class UserinfoEntity implements Serializable{
            @Column(name = "uid", isId = true,property = "UNIQUE")
            private String uid;
            @Column(name = "username")
            private String username;
            @Column(name = "realname")
            private String realname;
            @Column(name = "password")
            private String password;
            @Column(name = "email")
            private String email;
            @Column(name = "mobile")
            private String mobile;
            @Column(name = "usernick")
            private String usernick;
            @Column(name = "is_idcard")
            private String is_idcard;
            @Column(name = "is_bindbank")
            private String is_bindbank;
            @Column(name = "is_company_check")
            private String is_company_check;
            @Column(name = "is_admin")
            private String is_admin;
            @Column(name = "sex")
            private String sex;
            @Column(name = "face")
            private String face;
            @Column(name = "province")
            private String province;
            @Column(name = "city")
            private String city;
            @Column(name = "area")
            private String area;
            @Column(name = "usertype")
            private String usertype;

            public void setUid(String uid) {
                this.uid = uid;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public void setUsernick(String usernick) {
                this.usernick = usernick;
            }

            public void setIs_idcard(String is_idcard) {
                this.is_idcard = is_idcard;
            }

            public void setIs_bindbank(String is_bindbank) {
                this.is_bindbank = is_bindbank;
            }

            public void setIs_company_check(String is_company_check) {
                this.is_company_check = is_company_check;
            }

            public void setIs_admin(String is_admin) {
                this.is_admin = is_admin;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public void setUsertype(String usertype) {
                this.usertype = usertype;
            }

            public String getUid() {
                return uid;
            }

            public String getUsername() {
                return username;
            }

            public String getRealname() {
                return realname;
            }

            public String getPassword() {
                return password;
            }

            public String getEmail() {
                return email;
            }

            public String getMobile() {
                return mobile;
            }

            public String getUsernick() {
                return usernick;
            }

            public String getIs_idcard() {
                return is_idcard;
            }

            public String getIs_bindbank() {
                return is_bindbank;
            }

            public String getIs_company_check() {
                return is_company_check;
            }

            public String getIs_admin() {
                return is_admin;
            }

            public String getSex() {
                return sex;
            }

            public String getFace() {
                return face;
            }

            public String getProvince() {
                return province;
            }

            public String getCity() {
                return city;
            }

            public String getArea() {
                return area;
            }

            public String getUsertype() {
                return usertype;
            }
        }
    }
}
