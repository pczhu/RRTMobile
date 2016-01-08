package cn.mobile.renrentou.domain;

import java.io.Serializable;

/**
 * 名称：HomeCount
 * 作用：首页统计信息
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/7 上午9:06
 * 版本：V1.0
 * 修改历史：
 */
public class HomeCount implements Serializable {



    private String status;
    private String msg;
    /**
     * user_count : 会员总数
     * project_count : 项目总数
     * investment_count : 预约认购总额
     * invest_amount : 成功融资总额
     */
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
        private String user_count;
        private String project_count;
        private String investment_count;
        private String invest_amount;

        public void setUser_count(String user_count) {
            this.user_count = user_count;
        }

        public void setProject_count(String project_count) {
            this.project_count = project_count;
        }

        public void setInvestment_count(String investment_count) {
            this.investment_count = investment_count;
        }

        public void setInvest_amount(String invest_amount) {
            this.invest_amount = invest_amount;
        }

        public String getUser_count() {
            return user_count;
        }

        public String getProject_count() {
            return project_count;
        }

        public String getInvestment_count() {
            return investment_count;
        }

        public String getInvest_amount() {
            return invest_amount;
        }
    }
}
