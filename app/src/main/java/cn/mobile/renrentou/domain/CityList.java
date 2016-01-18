package cn.mobile.renrentou.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/13 上午11:39
 * 版本：V1.0
 * 修改历史：
 */
public class CityList implements Serializable {


    private String status;
    private String msg;
    /**
     * id : 0
     * name : 全国
     * shortname : 全国
     * pinyin : quanguo
     */
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
        private int id;
        private String name;
        private String shortname;
        private String pinyin;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setShortname(String shortname) {
            this.shortname = shortname;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getShortname() {
            return shortname;
        }

        public String getPinyin() {
            return pinyin;
        }
    }
}
