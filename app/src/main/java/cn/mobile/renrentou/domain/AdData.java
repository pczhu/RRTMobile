package cn.mobile.renrentou.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/6 下午12:04
 * 版本：V1.0
 * 修改历史：
 */
public class AdData implements Serializable{

    private String status;
    private String msg;
    private List<DataEntity> data;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity implements Serializable{
        private String id;
        private String title;
        private String link;
        private String img;
        private String mark_words;
        private String width;
        private String height;

        public void setId(String id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setMark_words(String mark_words) {
            this.mark_words = mark_words;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getImg() {
            return img;
        }

        public String getMark_words() {
            return mark_words;
        }

        public String getWidth() {
            return width;
        }

        public String getHeight() {
            return height;
        }
    }

    @Override
    public String toString() {
        return "AdData{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
