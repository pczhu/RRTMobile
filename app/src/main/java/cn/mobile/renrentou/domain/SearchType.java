package cn.mobile.renrentou.domain;

import java.util.List;

/**
 * 名称：SearchType
 * 作用：查找类型
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/11 下午3:19
 * 版本：V1.0
 * 修改历史：
 */
public class SearchType {


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
        /**
         * id : 0
         * name : 所有行业
         */

        private List<TradeEntity> trade;
        /**
         * id : 0
         * name : 默认排序
         */

        private List<OrderEntity> order;
        /**
         * id : 0
         * name : 全部项目
         */

        private List<SearchEntity> search;

        public void setTrade(List<TradeEntity> trade) {
            this.trade = trade;
        }

        public void setOrder(List<OrderEntity> order) {
            this.order = order;
        }

        public void setSearch(List<SearchEntity> search) {
            this.search = search;
        }

        public List<TradeEntity> getTrade() {
            return trade;
        }

        public List<OrderEntity> getOrder() {
            return order;
        }

        public List<SearchEntity> getSearch() {
            return search;
        }

        public static class TradeEntity {
            private String id;
            private String name;

            public void setId(String id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }

        public static class OrderEntity {
            private String id;
            private String name;

            public void setId(String id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }

        public static class SearchEntity {
            private String id;
            private String name;

            public void setId(String id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }
    }
}
