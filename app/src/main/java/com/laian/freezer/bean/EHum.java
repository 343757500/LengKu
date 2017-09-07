package com.laian.freezer.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/4.
 */

public class EHum {

    /**
     *  {
     "ehmId": 20,
     "ehmAddress": 1,
     "ehmName": "test",
     "gallery": 1,
     "ehmTemp": 0,
     "ehmHum": 0,
     "ehmMaxTemp": 35,
     "ehmMinTemp": 10,
     "ehmMaxHum": 90,
     "ehmMinHum": 20,
     "ehmInterval": 30,
     "deviceLocationPojo": {
     "dlId": 4,
     "dlName": "test"
     },
     "ip": 3,
     "ipPort": "192.168.1.200:1025",
     "number": 0,
     "sn": 0
     }
     */

    public int ehmId;
    public int ehmAddress;
    public String ehmName;
    public int gallery;
    public int ehmTemp;
    public int ehmHum;
    public int ehmMaxTemp;
    public int ehmMinTemp;
    public int ehmMaxHum;
    public int ehmMinHum;
    public int ehmInterval;
    public DeviceLocationPojo deviceLocationPojo;
    public int ip;
    public String ipPort;
    public int number;
    public int sn;
}
