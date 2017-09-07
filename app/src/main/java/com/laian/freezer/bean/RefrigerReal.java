package com.laian.freezer.bean;

/**
 * Created by Administrator on 2017/9/7.
 */

public class RefrigerReal {
    /**
     * devId : 1
     * devAddr : 21004643
     * devName : device
     * devDriver : 陈威
     * devPhone : 13068501300
     * driverPhone : 13068501300
     * carNumber : 粤B99999
     * saveInterval : 10
     * tempMaxValue : 30.0
     * tempMinValue : 10.0
     * humiMaxValue : 90.0
     * humiMinValue : 20.0
     * devStatus : false
     * devLng : 0.0
     * devLat : 0.0
     * status : true
     */

    private int devId;
    private String devAddr;
    private String devName;
    private String devDriver;
    private String devPhone;
    private String driverPhone;
    private String carNumber;
    private int saveInterval;
    private double tempMaxValue;
    private double tempMinValue;
    private double humiMaxValue;
    private double humiMinValue;
    private boolean devStatus;
    private double devLng;
    private double devLat;
    private boolean status;

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public String getDevAddr() {
        return devAddr;
    }

    public void setDevAddr(String devAddr) {
        this.devAddr = devAddr;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDevDriver() {
        return devDriver;
    }

    public void setDevDriver(String devDriver) {
        this.devDriver = devDriver;
    }

    public String getDevPhone() {
        return devPhone;
    }

    public void setDevPhone(String devPhone) {
        this.devPhone = devPhone;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getSaveInterval() {
        return saveInterval;
    }

    public void setSaveInterval(int saveInterval) {
        this.saveInterval = saveInterval;
    }

    public double getTempMaxValue() {
        return tempMaxValue;
    }

    public void setTempMaxValue(double tempMaxValue) {
        this.tempMaxValue = tempMaxValue;
    }

    public double getTempMinValue() {
        return tempMinValue;
    }

    public void setTempMinValue(double tempMinValue) {
        this.tempMinValue = tempMinValue;
    }

    public double getHumiMaxValue() {
        return humiMaxValue;
    }

    public void setHumiMaxValue(double humiMaxValue) {
        this.humiMaxValue = humiMaxValue;
    }

    public double getHumiMinValue() {
        return humiMinValue;
    }

    public void setHumiMinValue(double humiMinValue) {
        this.humiMinValue = humiMinValue;
    }

    public boolean isDevStatus() {
        return devStatus;
    }

    public void setDevStatus(boolean devStatus) {
        this.devStatus = devStatus;
    }

    public double getDevLng() {
        return devLng;
    }

    public void setDevLng(double devLng) {
        this.devLng = devLng;
    }

    public double getDevLat() {
        return devLat;
    }

    public void setDevLat(double devLat) {
        this.devLat = devLat;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
