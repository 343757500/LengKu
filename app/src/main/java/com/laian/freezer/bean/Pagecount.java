package com.laian.freezer.bean;

/**
 * Created by Administrator on 2017/9/15.
 */

public class Pagecount {
   private  String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getModual() {
        return modual;
    }

    public void setModual(String modual) {
        this.modual = modual;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    private String logType;
    private String modual;
    private String keyword;
}
