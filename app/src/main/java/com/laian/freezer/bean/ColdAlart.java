package com.laian.freezer.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */

public class ColdAlart {

    /**
     * ipList : [{"diId":3,"diAddress":"192.168.1.200","diPort":1025,"diIsConnect":0,"diOperate":0,"diDeviceNumber":0,"sdsn":0}]
     * locationList : [{"dlId":4,"dlName":"test"}]
     * doubleMap : [{"value":-10},{"value":-9.9},{"value":-9.8},{"value":-9.7},{"value":-9.6},{"value":-9.5},{"value":-9.4},{"value":-9.3},{"value":-9.2},{"value":-9.1},{"value":-9},{"value":-8.9},{"value":-8.8},{"value":-8.7},{"value":-8.6},{"value":-8.5},{"value":-8.4},{"value":-8.3},{"value":-8.2},{"value":-8.1},{"value":-8},{"value":-7.9},{"value":-7.8},{"value":-7.7},{"value":-7.6},{"value":-7.5},{"value":-7.4},{"value":-7.3},{"value":-7.2},{"value":-7.1},{"value":-7},{"value":-6.9},{"value":-6.8},{"value":-6.7},{"value":-6.6},{"value":-6.5},{"value":-6.4},{"value":-6.3},{"value":-6.2},{"value":-6.1},{"value":-6},{"value":-5.9},{"value":-5.8},{"value":-5.7},{"value":-5.6},{"value":-5.5},{"value":-5.4},{"value":-5.3},{"value":-5.2},{"value":-5.1},{"value":-5},{"value":-4.9},{"value":-4.8},{"value":-4.7},{"value":-4.6},{"value":-4.5},{"value":-4.4},{"value":-4.3},{"value":-4.2},{"value":-4.1},{"value":-4},{"value":-3.9},{"value":-3.8},{"value":-3.7},{"value":-3.6},{"value":-3.5},{"value":-3.4},{"value":-3.3},{"value":-3.2},{"value":-3.1},{"value":-3},{"value":-2.9},{"value":-2.8},{"value":-2.7},{"value":-2.6},{"value":-2.5},{"value":-2.4},{"value":-2.3},{"value":-2.2},{"value":-2.1},{"value":-2},{"value":-1.9},{"value":-1.8},{"value":-1.7},{"value":-1.6},{"value":-1.5},{"value":-1.4},{"value":-1.3},{"value":-1.2},{"value":-1.1},{"value":-1},{"value":-0.9},{"value":-0.8},{"value":-0.7},{"value":-0.6},{"value":-0.5},{"value":-0.4},{"value":-0.3},{"value":-0.2},{"value":-0.1},{"value":0},{"value":0.1},{"value":0.2},{"value":0.3},{"value":0.4},{"value":0.5},{"value":0.6},{"value":0.7},{"value":0.8},{"value":0.9},{"value":1},{"value":1.1},{"value":1.2},{"value":1.3},{"value":1.4},{"value":1.5},{"value":1.6},{"value":1.7},{"value":1.8},{"value":1.9},{"value":2},{"value":2.1},{"value":2.2},{"value":2.3},{"value":2.4},{"value":2.5},{"value":2.6},{"value":2.7},{"value":2.8},{"value":2.9},{"value":3},{"value":3.1},{"value":3.2},{"value":3.3},{"value":3.4},{"value":3.5},{"value":3.6},{"value":3.7},{"value":3.8},{"value":3.9},{"value":4},{"value":4.1},{"value":4.2},{"value":4.3},{"value":4.4},{"value":4.5},{"value":4.6},{"value":4.7},{"value":4.8},{"value":4.9},{"value":5},{"value":5.1},{"value":5.2},{"value":5.3},{"value":5.4},{"value":5.5},{"value":5.6},{"value":5.7},{"value":5.8},{"value":5.9},{"value":6},{"value":6.1},{"value":6.2},{"value":6.3},{"value":6.4},{"value":6.5},{"value":6.6},{"value":6.7},{"value":6.8},{"value":6.9},{"value":7},{"value":7.1},{"value":7.2},{"value":7.3},{"value":7.4},{"value":7.5},{"value":7.6},{"value":7.7},{"value":7.8},{"value":7.9},{"value":8},{"value":8.1},{"value":8.2},{"value":8.3},{"value":8.4},{"value":8.5},{"value":8.6},{"value":8.7},{"value":8.8},{"value":8.9},{"value":9},{"value":9.1},{"value":9.2},{"value":9.3},{"value":9.4},{"value":9.5},{"value":9.6},{"value":9.7},{"value":9.8},{"value":9.9},{"value":10},{"value":10.1},{"value":10.2},{"value":10.3},{"value":10.4},{"value":10.5},{"value":10.6},{"value":10.7},{"value":10.8},{"value":10.9}]
     * galleryMap : {"1":1,"2":2,"3":3,"4":4,"5":5,"6":6,"7":7,"8":8}
     * intMap : {"1":1,"2":2,"3":3,"4":4,"5":5,"6":6,"7":7,"8":8,"9":9,"10":10,"11":11,"12":12,"13":13,"14":14,"15":15,"17":17,"16":16,"19":19,"18":18,"20":20}
     * ehmList : [{"ehmId":20,"ehmAddress":1,"ehmName":"test","gallery":1,"ehmTemp":0,"ehmHum":0,"ehmMaxTemp":35,"ehmMinTemp":10,"ehmMaxHum":90,"ehmMinHum":20,"ehmInterval":30,"deviceLocationPojo":{"dlId":4,"dlName":"test"},"ip":3,"ipPort":"192.168.1.200:1025","number":0,"sn":0}]
     */

    private GalleryMapBean galleryMap;
    private IntMapBean intMap;
    private List<IpListBean> ipList;
    private List<LocationListBean> locationList;
    private List<DoubleMapBean> doubleMap;
    private List<EhmListBean> ehmList;

    public GalleryMapBean getGalleryMap() {
        return galleryMap;
    }

    public void setGalleryMap(GalleryMapBean galleryMap) {
        this.galleryMap = galleryMap;
    }

    public IntMapBean getIntMap() {
        return intMap;
    }

    public void setIntMap(IntMapBean intMap) {
        this.intMap = intMap;
    }

    public List<IpListBean> getIpList() {
        return ipList;
    }

    public void setIpList(List<IpListBean> ipList) {
        this.ipList = ipList;
    }

    public List<LocationListBean> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<LocationListBean> locationList) {
        this.locationList = locationList;
    }

    public List<DoubleMapBean> getDoubleMap() {
        return doubleMap;
    }

    public void setDoubleMap(List<DoubleMapBean> doubleMap) {
        this.doubleMap = doubleMap;
    }

    public List<EhmListBean> getEhmList() {
        return ehmList;
    }

    public void setEhmList(List<EhmListBean> ehmList) {
        this.ehmList = ehmList;
    }

    public static class GalleryMapBean {
        /**
         * 1 : 1
         * 2 : 2
         * 3 : 3
         * 4 : 4
         * 5 : 5
         * 6 : 6
         * 7 : 7
         * 8 : 8
         */

        @SerializedName("1")
        private int _$1;
        @SerializedName("2")
        private int _$2;
        @SerializedName("3")
        private int _$3;
        @SerializedName("4")
        private int _$4;
        @SerializedName("5")
        private int _$5;
        @SerializedName("6")
        private int _$6;
        @SerializedName("7")
        private int _$7;
        @SerializedName("8")
        private int _$8;

        public int get_$1() {
            return _$1;
        }

        public void set_$1(int _$1) {
            this._$1 = _$1;
        }

        public int get_$2() {
            return _$2;
        }

        public void set_$2(int _$2) {
            this._$2 = _$2;
        }

        public int get_$3() {
            return _$3;
        }

        public void set_$3(int _$3) {
            this._$3 = _$3;
        }

        public int get_$4() {
            return _$4;
        }

        public void set_$4(int _$4) {
            this._$4 = _$4;
        }

        public int get_$5() {
            return _$5;
        }

        public void set_$5(int _$5) {
            this._$5 = _$5;
        }

        public int get_$6() {
            return _$6;
        }

        public void set_$6(int _$6) {
            this._$6 = _$6;
        }

        public int get_$7() {
            return _$7;
        }

        public void set_$7(int _$7) {
            this._$7 = _$7;
        }

        public int get_$8() {
            return _$8;
        }

        public void set_$8(int _$8) {
            this._$8 = _$8;
        }
    }

    public static class IntMapBean {
        /**
         * 1 : 1
         * 2 : 2
         * 3 : 3
         * 4 : 4
         * 5 : 5
         * 6 : 6
         * 7 : 7
         * 8 : 8
         * 9 : 9
         * 10 : 10
         * 11 : 11
         * 12 : 12
         * 13 : 13
         * 14 : 14
         * 15 : 15
         * 17 : 17
         * 16 : 16
         * 19 : 19
         * 18 : 18
         * 20 : 20
         */

        @SerializedName("1")
        private int _$1;
        @SerializedName("2")
        private int _$2;
        @SerializedName("3")
        private int _$3;
        @SerializedName("4")
        private int _$4;
        @SerializedName("5")
        private int _$5;
        @SerializedName("6")
        private int _$6;
        @SerializedName("7")
        private int _$7;
        @SerializedName("8")
        private int _$8;
        @SerializedName("9")
        private int _$9;
        @SerializedName("10")
        private int _$10;
        @SerializedName("11")
        private int _$11;
        @SerializedName("12")
        private int _$12;
        @SerializedName("13")
        private int _$13;
        @SerializedName("14")
        private int _$14;
        @SerializedName("15")
        private int _$15;
        @SerializedName("17")
        private int _$17;
        @SerializedName("16")
        private int _$16;
        @SerializedName("19")
        private int _$19;
        @SerializedName("18")
        private int _$18;
        @SerializedName("20")
        private int _$20;

        public int get_$1() {
            return _$1;
        }

        public void set_$1(int _$1) {
            this._$1 = _$1;
        }

        public int get_$2() {
            return _$2;
        }

        public void set_$2(int _$2) {
            this._$2 = _$2;
        }

        public int get_$3() {
            return _$3;
        }

        public void set_$3(int _$3) {
            this._$3 = _$3;
        }

        public int get_$4() {
            return _$4;
        }

        public void set_$4(int _$4) {
            this._$4 = _$4;
        }

        public int get_$5() {
            return _$5;
        }

        public void set_$5(int _$5) {
            this._$5 = _$5;
        }

        public int get_$6() {
            return _$6;
        }

        public void set_$6(int _$6) {
            this._$6 = _$6;
        }

        public int get_$7() {
            return _$7;
        }

        public void set_$7(int _$7) {
            this._$7 = _$7;
        }

        public int get_$8() {
            return _$8;
        }

        public void set_$8(int _$8) {
            this._$8 = _$8;
        }

        public int get_$9() {
            return _$9;
        }

        public void set_$9(int _$9) {
            this._$9 = _$9;
        }

        public int get_$10() {
            return _$10;
        }

        public void set_$10(int _$10) {
            this._$10 = _$10;
        }

        public int get_$11() {
            return _$11;
        }

        public void set_$11(int _$11) {
            this._$11 = _$11;
        }

        public int get_$12() {
            return _$12;
        }

        public void set_$12(int _$12) {
            this._$12 = _$12;
        }

        public int get_$13() {
            return _$13;
        }

        public void set_$13(int _$13) {
            this._$13 = _$13;
        }

        public int get_$14() {
            return _$14;
        }

        public void set_$14(int _$14) {
            this._$14 = _$14;
        }

        public int get_$15() {
            return _$15;
        }

        public void set_$15(int _$15) {
            this._$15 = _$15;
        }

        public int get_$17() {
            return _$17;
        }

        public void set_$17(int _$17) {
            this._$17 = _$17;
        }

        public int get_$16() {
            return _$16;
        }

        public void set_$16(int _$16) {
            this._$16 = _$16;
        }

        public int get_$19() {
            return _$19;
        }

        public void set_$19(int _$19) {
            this._$19 = _$19;
        }

        public int get_$18() {
            return _$18;
        }

        public void set_$18(int _$18) {
            this._$18 = _$18;
        }

        public int get_$20() {
            return _$20;
        }

        public void set_$20(int _$20) {
            this._$20 = _$20;
        }
    }

    public static class IpListBean {
        /**
         * diId : 3
         * diAddress : 192.168.1.200
         * diPort : 1025
         * diIsConnect : 0
         * diOperate : 0
         * diDeviceNumber : 0
         * sdsn : 0
         */

        private int diId;
        private String diAddress;
        private int diPort;
        private int diIsConnect;
        private int diOperate;
        private int diDeviceNumber;
        private int sdsn;

        public int getDiId() {
            return diId;
        }

        public void setDiId(int diId) {
            this.diId = diId;
        }

        public String getDiAddress() {
            return diAddress;
        }

        public void setDiAddress(String diAddress) {
            this.diAddress = diAddress;
        }

        public int getDiPort() {
            return diPort;
        }

        public void setDiPort(int diPort) {
            this.diPort = diPort;
        }

        public int getDiIsConnect() {
            return diIsConnect;
        }

        public void setDiIsConnect(int diIsConnect) {
            this.diIsConnect = diIsConnect;
        }

        public int getDiOperate() {
            return diOperate;
        }

        public void setDiOperate(int diOperate) {
            this.diOperate = diOperate;
        }

        public int getDiDeviceNumber() {
            return diDeviceNumber;
        }

        public void setDiDeviceNumber(int diDeviceNumber) {
            this.diDeviceNumber = diDeviceNumber;
        }

        public int getSdsn() {
            return sdsn;
        }

        public void setSdsn(int sdsn) {
            this.sdsn = sdsn;
        }
    }

    public static class LocationListBean {
        /**
         * dlId : 4
         * dlName : test
         */

        private int dlId;
        private String dlName;

        public int getDlId() {
            return dlId;
        }

        public void setDlId(int dlId) {
            this.dlId = dlId;
        }

        public String getDlName() {
            return dlName;
        }

        public void setDlName(String dlName) {
            this.dlName = dlName;
        }
    }

    public static class DoubleMapBean {
        /**
         * value : -10.0
         */

        private double value;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    public static class EhmListBean {
        /**
         * ehmId : 20
         * ehmAddress : 1
         * ehmName : test
         * gallery : 1
         * ehmTemp : 0.0
         * ehmHum : 0.0
         * ehmMaxTemp : 35.0
         * ehmMinTemp : 10.0
         * ehmMaxHum : 90.0
         * ehmMinHum : 20.0
         * ehmInterval : 30
         * deviceLocationPojo : {"dlId":4,"dlName":"test"}
         * ip : 3
         * ipPort : 192.168.1.200:1025
         * number : 0
         * sn : 0
         */

        private int ehmId;
        private int ehmAddress;
        private String ehmName;
        private int gallery;
        private double ehmTemp;
        private double ehmHum;
        private double ehmMaxTemp;
        private double ehmMinTemp;
        private double ehmMaxHum;
        private double ehmMinHum;
        private int ehmInterval;
        private DeviceLocationPojoBean deviceLocationPojo;
        private int ip;
        private String ipPort;
        private int number;
        private int sn;

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

        public int getGallery() {
            return gallery;
        }

        public void setGallery(int gallery) {
            this.gallery = gallery;
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

        public DeviceLocationPojoBean getDeviceLocationPojo() {
            return deviceLocationPojo;
        }

        public void setDeviceLocationPojo(DeviceLocationPojoBean deviceLocationPojo) {
            this.deviceLocationPojo = deviceLocationPojo;
        }

        public int getIp() {
            return ip;
        }

        public void setIp(int ip) {
            this.ip = ip;
        }

        public String getIpPort() {
            return ipPort;
        }

        public void setIpPort(String ipPort) {
            this.ipPort = ipPort;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getSn() {
            return sn;
        }

        public void setSn(int sn) {
            this.sn = sn;
        }

        public static class DeviceLocationPojoBean {
            /**
             * dlId : 4
             * dlName : test
             */

            private int dlId;
            private String dlName;

            public int getDlId() {
                return dlId;
            }

            public void setDlId(int dlId) {
                this.dlId = dlId;
            }

            public String getDlName() {
                return dlName;
            }

            public void setDlName(String dlName) {
                this.dlName = dlName;
            }
        }
    }
}
