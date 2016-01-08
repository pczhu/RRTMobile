package cn.mobile.renrentou.domain;

import java.io.Serializable;

/**
 * 名称：UploadFile
 * 作用：图片提交上传返回的json
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/5 下午6:11
 * 版本：V1.0
 * 修改历史：
 */
public class UploadFile implements Serializable{


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

    public static class DataEntity {
        private String save_img;
        private String img_url;

        public void setSave_img(String save_img) {
            this.save_img = save_img;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getSave_img() {
            return save_img;
        }

        public String getImg_url() {
            return img_url;
        }
    }
}
