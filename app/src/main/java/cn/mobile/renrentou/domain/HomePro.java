package cn.mobile.renrentou.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/7 上午11:53
 * 版本：V1.0
 * 修改历史：
 */
public class HomePro implements Serializable{



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

    public static class DataEntity implements Serializable {
        private String time;
        private List<InvestEntity> invest;
        private List<WaitingEntity> waiting;

        public void setTime(String time) {
            this.time = time;
        }

        public void setInvest(List<InvestEntity> invest) {
            this.invest = invest;
        }

        public void setWaiting(List<WaitingEntity> waiting) {
            this.waiting = waiting;
        }

        public String getTime() {
            return time;
        }

        public List<InvestEntity> getInvest() {
            return invest;
        }

        public List<WaitingEntity> getWaiting() {
            return waiting;
        }

        public static class InvestEntity implements Serializable {
            private String id;
            private String name;
            private String img_app;
            private String img_cover;
            private String finance_total;
            private String founder_pay;
            private String finance_amount;
            private String amount_begin_time;
            private String funding_cycle;
            private String invest_amount;
            private String founder_amount;
            private String invest_progress;
            private String invest_type;
            private String surplus_time;

            public void setId(String id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setImg_app(String img_app) {
                this.img_app = img_app;
            }

            public void setImg_cover(String img_cover) {
                this.img_cover = img_cover;
            }

            public void setFinance_total(String finance_total) {
                this.finance_total = finance_total;
            }

            public void setFounder_pay(String founder_pay) {
                this.founder_pay = founder_pay;
            }

            public void setFinance_amount(String finance_amount) {
                this.finance_amount = finance_amount;
            }

            public void setAmount_begin_time(String amount_begin_time) {
                this.amount_begin_time = amount_begin_time;
            }

            public void setFunding_cycle(String funding_cycle) {
                this.funding_cycle = funding_cycle;
            }

            public void setInvest_amount(String invest_amount) {
                this.invest_amount = invest_amount;
            }

            public void setFounder_amount(String founder_amount) {
                this.founder_amount = founder_amount;
            }

            public void setInvest_progress(String invest_progress) {
                this.invest_progress = invest_progress;
            }

            public void setInvest_type(String invest_type) {
                this.invest_type = invest_type;
            }

            public void setSurplus_time(String surplus_time) {
                this.surplus_time = surplus_time;
            }

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getImg_app() {
                return img_app;
            }

            public String getImg_cover() {
                return img_cover;
            }

            public String getFinance_total() {
                return finance_total;
            }

            public String getFounder_pay() {
                return founder_pay;
            }

            public String getFinance_amount() {
                return finance_amount;
            }

            public String getAmount_begin_time() {
                return amount_begin_time;
            }

            public String getFunding_cycle() {
                return funding_cycle;
            }

            public String getInvest_amount() {
                return invest_amount;
            }

            public String getFounder_amount() {
                return founder_amount;
            }

            public String getInvest_progress() {
                return invest_progress;
            }

            public String getInvest_type() {
                return invest_type;
            }

            public String getSurplus_time() {
                return surplus_time;
            }
        }

        public static class WaitingEntity implements Serializable{
            private String id;
            private String name;
            private String img_app;
            private String img_cover;
            private String finance_total;
            private String founder_pay;
            private String finance_amount;
            private String amount_begin_time;
            private String funding_cycle;
            private String invest_type;

            public void setId(String id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setImg_app(String img_app) {
                this.img_app = img_app;
            }

            public void setImg_cover(String img_cover) {
                this.img_cover = img_cover;
            }

            public void setFinance_total(String finance_total) {
                this.finance_total = finance_total;
            }

            public void setFounder_pay(String founder_pay) {
                this.founder_pay = founder_pay;
            }

            public void setFinance_amount(String finance_amount) {
                this.finance_amount = finance_amount;
            }

            public void setAmount_begin_time(String amount_begin_time) {
                this.amount_begin_time = amount_begin_time;
            }

            public void setFunding_cycle(String funding_cycle) {
                this.funding_cycle = funding_cycle;
            }

            public void setInvest_type(String invest_type) {
                this.invest_type = invest_type;
            }

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getImg_app() {
                return img_app;
            }

            public String getImg_cover() {
                return img_cover;
            }

            public String getFinance_total() {
                return finance_total;
            }

            public String getFounder_pay() {
                return founder_pay;
            }

            public String getFinance_amount() {
                return finance_amount;
            }

            public String getAmount_begin_time() {
                return amount_begin_time;
            }

            public String getFunding_cycle() {
                return funding_cycle;
            }

            public String getInvest_type() {
                return invest_type;
            }
        }
    }
}
