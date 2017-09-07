package com.laian.freezer.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7.
 */

public class RefrigeReal {

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
     * device : [{"DevKey":"193841","DevName":"探头1","DevAddr":"21004643","DevTempValue":28.3,"DevHumiValue":67.4,"DevStatus":true,"TempStatus":0,"HumiStatus":0},{"DevKey":"193842","DevName":"探头2","DevAddr":"21004643","DevTempValue":28.4,"DevHumiValue":66.8,"DevStatus":true,"TempStatus":0,"HumiStatus":0}]
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
    private List<DeviceBean> device;

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

    public List<DeviceBean> getDevice() {
        return device;
    }

    public void setDevice(List<DeviceBean> device) {
        this.device = device;
    }

    public static class DeviceBean {
        /**
         * DevKey : 193841
         * DevName : 探头1
         * DevAddr : 21004643
         * DevTempValue : 28.3
         * DevHumiValue : 67.4
         * DevStatus : true
         * TempStatus : 0
         * HumiStatus : 0
         */

        private String DevKey;
        private String DevName;
        private String DevAddr;
        private double DevTempValue;
        private double DevHumiValue;
        private boolean DevStatus;
        private int TempStatus;
        private int HumiStatus;

        public String getDevKey() {
            return DevKey;
        }

        public void setDevKey(String DevKey) {
            this.DevKey = DevKey;
        }

        public String getDevName() {
            return DevName;
        }

        public void setDevName(String DevName) {
            this.DevName = DevName;
        }

        public String getDevAddr() {
            return DevAddr;
        }

        public void setDevAddr(String DevAddr) {
            this.DevAddr = DevAddr;
        }

        public double getDevTempValue() {
            return DevTempValue;
        }

        public void setDevTempValue(double DevTempValue) {
            this.DevTempValue = DevTempValue;
        }

        public double getDevHumiValue() {
            return DevHumiValue;
        }

        public void setDevHumiValue(double DevHumiValue) {
            this.DevHumiValue = DevHumiValue;
        }

        public boolean isDevStatus() {
            return DevStatus;
        }

        public void setDevStatus(boolean DevStatus) {
            this.DevStatus = DevStatus;
        }

        public int getTempStatus() {
            return TempStatus;
        }

        public void setTempStatus(int TempStatus) {
            this.TempStatus = TempStatus;
        }

        public int getHumiStatus() {
            return HumiStatus;
        }

        public void setHumiStatus(int HumiStatus) {
            this.HumiStatus = HumiStatus;
        }
    }
}
