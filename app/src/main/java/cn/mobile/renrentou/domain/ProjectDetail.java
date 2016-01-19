package cn.mobile.renrentou.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/19 下午3:30
 * 版本：V1.0
 * 修改历史：
 */
public class ProjectDetail implements Serializable {



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
        private String id;
        private String uid;
        private String username;
        private String name;
        private String oneword;
        private String img_app;
        private String pintroduce;
        private String trade_one;
        private String shortname;
        private String city;
        private String area;
        private String lest_finance;
        private String finance_total;
        private String finance_amount;
        private String finance_amount2;
        private String fraction;
        private String org_fraction;
        private String star_fraction;
        private String talk_count;
        private String pre_invest_count;
        private String focus_count;
        private String invest_count;
        private String amount_begin_time;
        private String funding_cycle;
        private String finsh_time;
        private String status;
        private String founder_pay;
        private String founder_pay_rate;
        private String surplus_fraction;
        private String org_surplus_fraction;
        private String star_surplus_fraction;
        private String is_share;
        private String is_business;
        private String longitude;
        private String latitude;
        private String is_auto_repayment;
        private String address;
        private String opening_time;
        private String share_time;
        private String pre_invest_amount;
        private String distance;
        private String videos;
        private String is_oneself;
        private String progress_bar;
        private String surplus_time;
        private String wind_control_review;
        private String electronic_agreement;
        private String is_attention;
        private String share_url;
        private String detail_url;
        private String groupid;
        private String is_group;
        private String risk_survey;
        private String rish_analyze;
        private String risksurvey;
        private String xmf_level;
        private String month_amount_income;
        private String month_amount_profit;
        private String share_amount;
        private String month_rate;
        private String shares_url;
        private String pre_surplus_time;
        private String timestamp;
        private String risk;
        private String advice;
        private String face;
        /**
         * name : 啊啊啊啊
         * img : http://img.dev2.renrentou.com/s/upload/user_authentication/2015/1130/dcb04240644b6fc2759d3bd4b8c3f41b.jpg
         */

        private List<LeaderEntity> leader;
        /**
         * name : 白
         * img : http://img.dev2.renrentou.com/s/upload/user_authentication/2015/1130/43c33aa98668d3d9e96031c916ba56e8.jpg
         */

        private List<UnitersEntity> uniters;

        public void setId(String id) {
            this.id = id;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setUsername(String username) {
            this.username = username;
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

        public void setPintroduce(String pintroduce) {
            this.pintroduce = pintroduce;
        }

        public void setTrade_one(String trade_one) {
            this.trade_one = trade_one;
        }

        public void setShortname(String shortname) {
            this.shortname = shortname;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public void setLest_finance(String lest_finance) {
            this.lest_finance = lest_finance;
        }

        public void setFinance_total(String finance_total) {
            this.finance_total = finance_total;
        }

        public void setFinance_amount(String finance_amount) {
            this.finance_amount = finance_amount;
        }

        public void setFinance_amount2(String finance_amount2) {
            this.finance_amount2 = finance_amount2;
        }

        public void setFraction(String fraction) {
            this.fraction = fraction;
        }

        public void setOrg_fraction(String org_fraction) {
            this.org_fraction = org_fraction;
        }

        public void setStar_fraction(String star_fraction) {
            this.star_fraction = star_fraction;
        }

        public void setTalk_count(String talk_count) {
            this.talk_count = talk_count;
        }

        public void setPre_invest_count(String pre_invest_count) {
            this.pre_invest_count = pre_invest_count;
        }

        public void setFocus_count(String focus_count) {
            this.focus_count = focus_count;
        }

        public void setInvest_count(String invest_count) {
            this.invest_count = invest_count;
        }

        public void setAmount_begin_time(String amount_begin_time) {
            this.amount_begin_time = amount_begin_time;
        }

        public void setFunding_cycle(String funding_cycle) {
            this.funding_cycle = funding_cycle;
        }

        public void setFinsh_time(String finsh_time) {
            this.finsh_time = finsh_time;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setFounder_pay(String founder_pay) {
            this.founder_pay = founder_pay;
        }

        public void setFounder_pay_rate(String founder_pay_rate) {
            this.founder_pay_rate = founder_pay_rate;
        }

        public void setSurplus_fraction(String surplus_fraction) {
            this.surplus_fraction = surplus_fraction;
        }

        public void setOrg_surplus_fraction(String org_surplus_fraction) {
            this.org_surplus_fraction = org_surplus_fraction;
        }

        public void setStar_surplus_fraction(String star_surplus_fraction) {
            this.star_surplus_fraction = star_surplus_fraction;
        }

        public void setIs_share(String is_share) {
            this.is_share = is_share;
        }

        public void setIs_business(String is_business) {
            this.is_business = is_business;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public void setIs_auto_repayment(String is_auto_repayment) {
            this.is_auto_repayment = is_auto_repayment;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setOpening_time(String opening_time) {
            this.opening_time = opening_time;
        }

        public void setShare_time(String share_time) {
            this.share_time = share_time;
        }

        public void setPre_invest_amount(String pre_invest_amount) {
            this.pre_invest_amount = pre_invest_amount;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public void setVideos(String videos) {
            this.videos = videos;
        }

        public void setIs_oneself(String is_oneself) {
            this.is_oneself = is_oneself;
        }

        public void setProgress_bar(String progress_bar) {
            this.progress_bar = progress_bar;
        }

        public void setSurplus_time(String surplus_time) {
            this.surplus_time = surplus_time;
        }

        public void setWind_control_review(String wind_control_review) {
            this.wind_control_review = wind_control_review;
        }

        public void setElectronic_agreement(String electronic_agreement) {
            this.electronic_agreement = electronic_agreement;
        }

        public void setIs_attention(String is_attention) {
            this.is_attention = is_attention;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public void setDetail_url(String detail_url) {
            this.detail_url = detail_url;
        }

        public void setGroupid(String groupid) {
            this.groupid = groupid;
        }

        public void setIs_group(String is_group) {
            this.is_group = is_group;
        }

        public void setRisk_survey(String risk_survey) {
            this.risk_survey = risk_survey;
        }

        public void setRish_analyze(String rish_analyze) {
            this.rish_analyze = rish_analyze;
        }

        public void setRisksurvey(String risksurvey) {
            this.risksurvey = risksurvey;
        }

        public void setXmf_level(String xmf_level) {
            this.xmf_level = xmf_level;
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

        public void setShares_url(String shares_url) {
            this.shares_url = shares_url;
        }

        public void setPre_surplus_time(String pre_surplus_time) {
            this.pre_surplus_time = pre_surplus_time;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public void setRisk(String risk) {
            this.risk = risk;
        }

        public void setAdvice(String advice) {
            this.advice = advice;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public void setLeader(List<LeaderEntity> leader) {
            this.leader = leader;
        }

        public void setUniters(List<UnitersEntity> uniters) {
            this.uniters = uniters;
        }

        public String getId() {
            return id;
        }

        public String getUid() {
            return uid;
        }

        public String getUsername() {
            return username;
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

        public String getPintroduce() {
            return pintroduce;
        }

        public String getTrade_one() {
            return trade_one;
        }

        public String getShortname() {
            return shortname;
        }

        public String getCity() {
            return city;
        }

        public String getArea() {
            return area;
        }

        public String getLest_finance() {
            return lest_finance;
        }

        public String getFinance_total() {
            return finance_total;
        }

        public String getFinance_amount() {
            return finance_amount;
        }

        public String getFinance_amount2() {
            return finance_amount2;
        }

        public String getFraction() {
            return fraction;
        }

        public String getOrg_fraction() {
            return org_fraction;
        }

        public String getStar_fraction() {
            return star_fraction;
        }

        public String getTalk_count() {
            return talk_count;
        }

        public String getPre_invest_count() {
            return pre_invest_count;
        }

        public String getFocus_count() {
            return focus_count;
        }

        public String getInvest_count() {
            return invest_count;
        }

        public String getAmount_begin_time() {
            return amount_begin_time;
        }

        public String getFunding_cycle() {
            return funding_cycle;
        }

        public String getFinsh_time() {
            return finsh_time;
        }

        public String getStatus() {
            return status;
        }

        public String getFounder_pay() {
            return founder_pay;
        }

        public String getFounder_pay_rate() {
            return founder_pay_rate;
        }

        public String getSurplus_fraction() {
            return surplus_fraction;
        }

        public String getOrg_surplus_fraction() {
            return org_surplus_fraction;
        }

        public String getStar_surplus_fraction() {
            return star_surplus_fraction;
        }

        public String getIs_share() {
            return is_share;
        }

        public String getIs_business() {
            return is_business;
        }

        public String getLongitude() {
            return longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public String getIs_auto_repayment() {
            return is_auto_repayment;
        }

        public String getAddress() {
            return address;
        }

        public String getOpening_time() {
            return opening_time;
        }

        public String getShare_time() {
            return share_time;
        }

        public String getPre_invest_amount() {
            return pre_invest_amount;
        }

        public String getDistance() {
            return distance;
        }

        public String getVideos() {
            return videos;
        }

        public String getIs_oneself() {
            return is_oneself;
        }

        public String getProgress_bar() {
            return progress_bar;
        }

        public String getSurplus_time() {
            return surplus_time;
        }

        public String getWind_control_review() {
            return wind_control_review;
        }

        public String getElectronic_agreement() {
            return electronic_agreement;
        }

        public String getIs_attention() {
            return is_attention;
        }

        public String getShare_url() {
            return share_url;
        }

        public String getDetail_url() {
            return detail_url;
        }

        public String getGroupid() {
            return groupid;
        }

        public String getIs_group() {
            return is_group;
        }

        public String getRisk_survey() {
            return risk_survey;
        }

        public String getRish_analyze() {
            return rish_analyze;
        }

        public String getRisksurvey() {
            return risksurvey;
        }

        public String getXmf_level() {
            return xmf_level;
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

        public String getShares_url() {
            return shares_url;
        }

        public String getPre_surplus_time() {
            return pre_surplus_time;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public String getRisk() {
            return risk;
        }

        public String getAdvice() {
            return advice;
        }

        public String getFace() {
            return face;
        }

        public List<LeaderEntity> getLeader() {
            return leader;
        }

        public List<UnitersEntity> getUniters() {
            return uniters;
        }

        public static class LeaderEntity  implements Serializable{
            private String name;
            private String img;

            public void setName(String name) {
                this.name = name;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public String getImg() {
                return img;
            }
        }

        public static class UnitersEntity  implements Serializable{
            private String name;
            private String img;

            public void setName(String name) {
                this.name = name;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public String getImg() {
                return img;
            }
        }
    }
}
