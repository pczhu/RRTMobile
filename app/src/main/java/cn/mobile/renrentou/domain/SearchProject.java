package cn.mobile.renrentou.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/8 下午4:46
 * 版本：V1.0
 * 修改历史：
 */
public class SearchProject implements Serializable{


    private String status;
    private String msg;


    private ArrayList<DataEntity> data;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(ArrayList<DataEntity> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public ArrayList<DataEntity> getData() {
        return data;
    }

    public static class DataEntity implements Serializable{
        private String id;
        private String name;
        private String oneword;
        private String img_app;
        private String trade_one;
        private String province;
        private String city;
        private String area;
        private String finance_total;
        private String lest_finance;
        private String is_share;
        private String is_business;
        private String share_time;
        private String opening_time;
        private String amount_begin_time;
        private String funding_cycle;
        private String finance_amount;
        private String finsh_time;
        private String status;
        private String longitude;
        private String latitude;
        private String invest_progress;
        private String provincename;
        private String cityname;
        private String areaname;
        private String diqu;
        private String diqu2;
        private String distance;
        private String surplus_time;
        private String progress_bar;
        private String pre_surplus_time;
        private String timestamp;
        private String shortname;
        private String address;
        private String month_amount_income;
        private String month_amount_profit;
        private String share_amount;
        private String month_rate;
        private AuthenticationEntity authentication;

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setOneword(String oneword) {
            this.oneword = oneword;
        }

        public void setImg_app(String img_app) {
            this.img_app = img_app;
        }

        public void setTrade_one(String trade_one) {
            this.trade_one = trade_one;
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

        public void setFinance_total(String finance_total) {
            this.finance_total = finance_total;
        }

        public void setLest_finance(String lest_finance) {
            this.lest_finance = lest_finance;
        }

        public void setIs_share(String is_share) {
            this.is_share = is_share;
        }

        public void setIs_business(String is_business) {
            this.is_business = is_business;
        }

        public void setShare_time(String share_time) {
            this.share_time = share_time;
        }

        public void setOpening_time(String opening_time) {
            this.opening_time = opening_time;
        }

        public void setAmount_begin_time(String amount_begin_time) {
            this.amount_begin_time = amount_begin_time;
        }

        public void setFunding_cycle(String funding_cycle) {
            this.funding_cycle = funding_cycle;
        }

        public void setFinance_amount(String finance_amount) {
            this.finance_amount = finance_amount;
        }

        public void setFinsh_time(String finsh_time) {
            this.finsh_time = finsh_time;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public void setInvest_progress(String invest_progress) {
            this.invest_progress = invest_progress;
        }

        public void setProvincename(String provincename) {
            this.provincename = provincename;
        }

        public void setCityname(String cityname) {
            this.cityname = cityname;
        }

        public void setAreaname(String areaname) {
            this.areaname = areaname;
        }

        public void setDiqu(String diqu) {
            this.diqu = diqu;
        }

        public void setDiqu2(String diqu2) {
            this.diqu2 = diqu2;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public void setSurplus_time(String surplus_time) {
            this.surplus_time = surplus_time;
        }

        public void setProgress_bar(String progress_bar) {
            this.progress_bar = progress_bar;
        }

        public void setPre_surplus_time(String pre_surplus_time) {
            this.pre_surplus_time = pre_surplus_time;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public void setShortname(String shortname) {
            this.shortname = shortname;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setMonth_amount_income(String month_amount_income) {
            this.month_amount_income = month_amount_income;
        }

        public void setMonth_amount_profit(String month_amount_profit) {
            this.month_amount_profit = month_amount_profit;
        }

        public void setShare_amount(String share_amount) {
            this.share_amount = share_amount;
        }

        public void setMonth_rate(String month_rate) {
            this.month_rate = month_rate;
        }

        public void setAuthentication(AuthenticationEntity authentication) {
            this.authentication = authentication;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getOneword() {
            return oneword;
        }

        public String getImg_app() {
            return img_app;
        }

        public String getTrade_one() {
            return trade_one;
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

        public String getFinance_total() {
            return finance_total;
        }

        public String getLest_finance() {
            return lest_finance;
        }

        public String getIs_share() {
            return is_share;
        }

        public String getIs_business() {
            return is_business;
        }

        public String getShare_time() {
            return share_time;
        }

        public String getOpening_time() {
            return opening_time;
        }

        public String getAmount_begin_time() {
            return amount_begin_time;
        }

        public String getFunding_cycle() {
            return funding_cycle;
        }

        public String getFinance_amount() {
            return finance_amount;
        }

        public String getFinsh_time() {
            return finsh_time;
        }

        public String getStatus() {
            return status;
        }

        public String getLongitude() {
            return longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public String getInvest_progress() {
            return invest_progress;
        }

        public String getProvincename() {
            return provincename;
        }

        public String getCityname() {
            return cityname;
        }

        public String getAreaname() {
            return areaname;
        }

        public String getDiqu() {
            return diqu;
        }

        public String getDiqu2() {
            return diqu2;
        }

        public String getDistance() {
            return distance;
        }

        public String getSurplus_time() {
            return surplus_time;
        }

        public String getProgress_bar() {
            return progress_bar;
        }

        public String getPre_surplus_time() {
            return pre_surplus_time;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public String getShortname() {
            return shortname;
        }

        public String getAddress() {
            return address;
        }

        public String getMonth_amount_income() {
            return month_amount_income;
        }

        public String getMonth_amount_profit() {
            return month_amount_profit;
        }

        public String getShare_amount() {
            return share_amount;
        }

        public String getMonth_rate() {
            return month_rate;
        }

        public AuthenticationEntity getAuthentication() {
            return authentication;
        }

        public static class AuthenticationEntity implements Serializable{
            private List<String> leader;
            private List<String> uniters;

            public void setLeader(List<String> leader) {
                this.leader = leader;
            }

            public void setUniters(List<String> uniters) {
                this.uniters = uniters;
            }

            public List<String> getLeader() {
                return leader;
            }

            public List<String> getUniters() {
                return uniters;
            }
        }
    }
}
