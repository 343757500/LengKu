package com.laian.freezer.bean;

/**
 * Created by Administrator on 2017/8/4.
 */

public class Humiture8ManagePojo extends IpPortPojo {

    /** @ehdId 温湿度管理地址*/
    private int ehmId;
    /** @ehmAddress 温湿度设备地址*/
    private int ehmAddress;
    /** @ehdName 温湿度设备名称*/
    private String ehmName;
    /** @ehdName 温湿度设备通道*/
    private int gallery;
    /** @ehmTemp 实时温度值*/
    private double ehmTemp;
    /** @ehmHum 实时湿度值*/
    private double ehmHum;
    /** @ehmMaxTemp 最大温度值*/
    private double ehmMaxTemp;
    /** @ehmMinTemp 最小温度值*/
    private double ehmMinTemp;
    /** @ehmMaxHum 最大湿度值*/
    private double ehmMaxHum;
    /** @ehmMinHum 最小湿度值*/
    private double ehmMinHum;
    /** @ehmInterval 历史保存间隔*/
    private int ehmInterval;
    /** @locationPojo 设备所在位置*/
    private DeviceLocationPojo deviceLocationPojo;

    public int getEhmId() {
        return ehmId;
    }
    public void setEhmId(int ehmId) {
        this.ehmId = ehmId;
    }
    public int getEhmAddress() {
        return ehmAddress;
    }
    public void setEhmAddress(int ehmAddress) {
        this.ehmAddress = ehmAddress;
    }
    public String getEhmName() {
        return ehmName;
    }
    public void setEhmName(String ehmName) {
        this.ehmName = ehmName;
    }
    public double getEhmTemp() {
        return ehmTemp;
    }
    public void setEhmTemp(double ehmTemp) {
        this.ehmTemp = ehmTemp;
    }
    public double getEhmHum() {
        return ehmHum;
    }
    public void setEhmHum(double ehmHum) {
        this.ehmHum = ehmHum;
    }
    public double getEhmMaxTemp() {
        return ehmMaxTemp;
    }
    public void setEhmMaxTemp(double ehmMaxTemp) {
        this.ehmMaxTemp = ehmMaxTemp;
    }
    public double getEhmMinTemp() {
        return ehmMinTemp;
    }
    public void setEhmMinTemp(double ehmMinTemp) {
        this.ehmMinTemp = ehmMinTemp;
    }
    public double getEhmMaxHum() {
        return ehmMaxHum;
    }
    public void setEhmMaxHum(double ehmMaxHum) {
        this.ehmMaxHum = ehmMaxHum;
    }
    public double getEhmMinHum() {
        return ehmMinHum;
    }
    public void setEhmMinHum(double ehmMinHum) {
        this.ehmMinHum = ehmMinHum;
    }
    public int getEhmInterval() {
        return ehmInterval;
    }
    public void setEhmInterval(int ehmInterval) {
        this.ehmInterval = ehmInterval;
    }
    public DeviceLocationPojo getDeviceLocationPojo() {
        return deviceLocationPojo;
    }
    public void setDeviceLocationPojo(DeviceLocationPojo deviceLocationPojo) {
        this.deviceLocationPojo = deviceLocationPojo;
    }
    public int getGallery() {
        return gallery;
    }
    public void setGallery(int gallery) {
        this.gallery = gallery;
    }
}
