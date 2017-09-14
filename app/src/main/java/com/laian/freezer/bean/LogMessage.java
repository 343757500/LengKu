package com.laian.freezer.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */

public class LogMessage {

    /**
     * total : 2171
     * rows : [{"id":2171,"username":"admin","createTime":"2017-09-13 17:26:31.0","description":"登入系统","modual":"系统管理","logType":"登入事件","logIp":"192.168.1.33"},{"id":2170,"username":"admin","createTime":"2017-09-13 17:26:07.0","description":"登入系统","modual":"系统管理","logType":"登入事件","logIp":"192.168.1.33"},{"id":2169,"username":"admin","createTime":"2017-09-13 17:25:55.0","description":"登入系统","modual":"系统管理","logType":"登入事件","logIp":"192.168.1.33"},{"id":2168,"username":"admin","createTime":"2017-09-13 17:08:13.0","description":"登入系统","modual":"系统管理","logType":"登入事件","logIp":"192.168.1.33"},{"id":2167,"username":"admin","createTime":"2017-09-13 17:08:09.0","description":"登入系统","modual":"系统管理","logType":"登入事件","logIp":"192.168.1.33"},{"id":2166,"username":"admin","createTime":"2017-09-13 17:08:07.0","description":"登入系统","modual":"系统管理","logType":"登入事件","logIp":"192.168.1.33"},{"id":2165,"username":"admin","createTime":"2017-09-13 17:08:02.0","description":"登入系统","modual":"系统管理","logType":"登入事件","logIp":"192.168.1.33"},{"id":2164,"username":"admin","createTime":"2017-09-13 17:07:55.0","description":"登入系统","modual":"系统管理","logType":"登入事件","logIp":"192.168.1.33"},{"id":2163,"username":"admin","createTime":"2017-09-13 17:07:47.0","description":"登入系统","modual":"系统管理","logType":"登入事件","logIp":"192.168.1.33"},{"id":2162,"username":"admin","createTime":"2017-09-13 17:07:41.0","description":"登入系统","modual":"系统管理","logType":"登入事件","logIp":"192.168.1.33"}]
     */

    private int total;
    private List<RowsBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * id : 2171
         * username : admin
         * createTime : 2017-09-13 17:26:31.0
         * description : 登入系统
         * modual : 系统管理
         * logType : 登入事件
         * logIp : 192.168.1.33
         */

        private int id;
        private String username;
        private String createTime;
        private String description;
        private String modual;
        private String logType;
        private String logIp;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getModual() {
            return modual;
        }

        public void setModual(String modual) {
            this.modual = modual;
        }

        public String getLogType() {
            return logType;
        }

        public void setLogType(String logType) {
            this.logType = logType;
        }

        public String getLogIp() {
            return logIp;
        }

        public void setLogIp(String logIp) {
            this.logIp = logIp;
        }
    }
}
