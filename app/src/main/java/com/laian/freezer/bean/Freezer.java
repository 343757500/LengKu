package com.laian.freezer.bean;

import android.os.LocaleList;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/4.
 */

public class Freezer {
    /**
     {
     "ipList": [
     {
     "diId": 3,
     "diAddress": "192.168.1.200",
     "diPort": 1025,
     "diIsConnect": 0,
     "diOperate": 0,
     "diDeviceNumber": 0,
     "sdsn": 0
     }
     ],
     "locationList": [
     {
     "dlId": 4,
     "dlName": "test"
     }
     ],
     "doubleMap": [
     {
     "value": -10
     },
     {
     "value": 10.9
     }
     ],
     "galleryMap": {
     "1": 1,
     "2": 2,
     "3": 3,
     "4": 4,
     "5": 5,
     "6": 6,
     "7": 7,
     "8": 8
     },
     "intMap": {
     "1": 1,
     "2": 2,
     "3": 3,
     "4": 4,
     "5": 5,
     "6": 6,
     "7": 7,
     "8": 8,
     "9": 9,
     "10": 10,
     "11": 11,
     "12": 12,
     "13": 13,
     "14": 14,
     "15": 15,
     "16": 16,
     "17": 17,
     "18": 18,
     "19": 19,
     "20": 20
     },
     "ehmList": [
     {
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
     ]
     }
     */

    public ArrayList<IpList> ipList;
    public ArrayList<Location> locationList;
    public ArrayList<mapValue>   doubleMap;
    public ArrayList<EHum>   ehmList;


}
