package cn.mobile.renrentou.domain;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.io.Serializable;

/**
 * 名称：EveryTest
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/14 上午10:54
 * 版本：V1.0
 * 修改历史：
 */

public class UserInfo implements Serializable {


    private String status;
    private String msg;
    private UserDataEntity data;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(UserDataEntity data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public UserDataEntity getData() {
        return data;
    }
    //onCreated = "CREATE UNIQUE INDEX index_name ON UserInfo(name,email,headpic,age)"
    @Table(name = "UserDataEntity")
    public static class UserDataEntity implements Serializable {
        @Column(name = "realname")
        private String realname;
        @Column(name = "usernick")
        private String usernick;
        @Column(name = "email")
        private String email;
        @Column(name = "mobile",isId = true,property = "UNIQUE")
        private String mobile;
        @Column(name = "sex")
        private String sex;
        @Column(name = "face")
        private String face;
        @Column(name = "is_idcard")
        private String is_idcard;
        @Column(name = "is_bindbank")
        private String is_bindbank;
        @Column(name = "is_auto_yeepay")
        private String is_auto_yeepay;
        @Column(name = "u_body_photo")
        private String u_body_photo;
        @Column(name = "u_body_photof")
        private String u_body_photof;
        @Column(name = "u_body_num")
        private String u_body_num;
        @Column(name = "newpm")
        private String newpm;
        @Column(name = "investor_num")
        private String investor_num;
        @Column(name = "publish_num")
        private String publish_num;
        @Column(name = "focus_num")
        private String focus_num;
        @Column(name = "usertype")
        private String usertype;
        @Column(name = "area")
        private String area;
        @Column(name = "address")
        private String address;
        @Column(name = "tel")
        private String tel;
        @Column(name = "tzf_level")
        private String tzf_level;
        @Column(name = "xmf_level")
        private String xmf_level;
        @Column(name = "tzf_level_img")
        private String tzf_level_img;
        @Column(name = "xmf_level_img")
        private String xmf_level_img;
        @Column(name = "auto_yeepay_url")
        private String auto_yeepay_url;

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getUsernick() {
            return usernick;
        }

        public void setUsernick(String usernick) {
            this.usernick = usernick;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getIs_idcard() {
            return is_idcard;
        }

        public void setIs_idcard(String is_idcard) {
            this.is_idcard = is_idcard;
        }

        public String getIs_bindbank() {
            return is_bindbank;
        }

        public void setIs_bindbank(String is_bindbank) {
            this.is_bindbank = is_bindbank;
        }

        public String getIs_auto_yeepay() {
            return is_auto_yeepay;
        }

        public void setIs_auto_yeepay(String is_auto_yeepay) {
            this.is_auto_yeepay = is_auto_yeepay;
        }

        public String getU_body_photo() {
            return u_body_photo;
        }

        public void setU_body_photo(String u_body_photo) {
            this.u_body_photo = u_body_photo;
        }

        public String getU_body_photof() {
            return u_body_photof;
        }

        public void setU_body_photof(String u_body_photof) {
            this.u_body_photof = u_body_photof;
        }

        public String getU_body_num() {
            return u_body_num;
        }

        public void setU_body_num(String u_body_num) {
            this.u_body_num = u_body_num;
        }

        public String getNewpm() {
            return newpm;
        }

        public void setNewpm(String newpm) {
            this.newpm = newpm;
        }

        public String getInvestor_num() {
            return investor_num;
        }

        public void setInvestor_num(String investor_num) {
            this.investor_num = investor_num;
        }

        public String getPublish_num() {
            return publish_num;
        }

        public void setPublish_num(String publish_num) {
            this.publish_num = publish_num;
        }

        public String getFocus_num() {
            return focus_num;
        }

        public void setFocus_num(String focus_num) {
            this.focus_num = focus_num;
        }

        public String getUsertype() {
            return usertype;
        }

        public void setUsertype(String usertype) {
            this.usertype = usertype;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getTzf_level() {
            return tzf_level;
        }

        public void setTzf_level(String tzf_level) {
            this.tzf_level = tzf_level;
        }

        public String getXmf_level() {
            return xmf_level;
        }

        public void setXmf_level(String xmf_level) {
            this.xmf_level = xmf_level;
        }

        public String getTzf_level_img() {
            return tzf_level_img;
        }

        public void setTzf_level_img(String tzf_level_img) {
            this.tzf_level_img = tzf_level_img;
        }

        public String getXmf_level_img() {
            return xmf_level_img;
        }

        public void setXmf_level_img(String xmf_level_img) {
            this.xmf_level_img = xmf_level_img;
        }

        public String getAuto_yeepay_url() {
            return auto_yeepay_url;
        }

        public void setAuto_yeepay_url(String auto_yeepay_url) {
            this.auto_yeepay_url = auto_yeepay_url;
        }
    }
}
