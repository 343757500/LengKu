package cn.meiqu.baseproject;

import android.util.Log;

import cn.meiqu.baseproject.dao.SettingDao;
import cn.meiqu.baseproject.util.StringUtil;

public class API {
    public static String getHomePage = "freezer/app/queHeadJson.html";
    public static String getHomeChildPage = "freezer/app/queMonitorJson.html";
    public static String getHomeChildThirdPage = "freezer/app/queMainMenuJson.html";
    public static String login = "freezer/app/login.html";
    public static String getTempReal = "freezer/app/reqHumitureDataJson.html";
    public static String getRefrigerReal = "freezer/app/requestGPRSData.html";
    public static String getFridgeReal = "freezer/app/queHumiturePT100ManageJson.html";
    public static String getNoLocationWaterReal = "freezer/app/reqNonLocationDataJson.html";
    public static String getLocationWaterReal = "freezer/app/reqLocationDataJson.html";
    public static String getDotWaterReal = "freezer/app/reqDotModelDataJson.html";
    public static String getThunderReal = "freezer/app/reqAntiThunderDataJson.html";
    public static String getCo2Real = "freezer/app/reqCo2DataJson.html";
    public static String getSElecReal = "freezer/app/reqElectricSupplyDataJson.html";
    public static String getPElecReal = "freezer/app/reqElectricBoxDataJson.html";
    public static String getFireReal = "freezer/app/reqFireControlDataJson.html";
    public static String getSmokeReal = "freezer/app/reqSmokeDataJson.html";
    public static String getInfraredReal = "freezer/app/reqInfraredDataJson.html";
    public static String getGlassReal = "freezer/app/reqGlassDataJson.html";
    public static String getDoorMagnReal = "freezer/app/reqDoorContactDataJson.html";
    public static String getNewFan = "freezer/app/reqNewFanDataJson.html";
    public static String siwtchNewFan = "freezer/app/switchKtr8060Json.html";
    public static String getWet = "freezer/app/reqHumidificationDataJson.html";
    public static String getLighting = "freezer/app/reqLightingDataJson.html";
    public static String getAirF = "freezer/app//queFissionAirControlJson.html";
    public static String switchAirF = "freezer/app/fissionAirControlJson.html";
    public static String getElecMachine = "freezer/app/reqElectricMeterDataJson.html";
    public static String getDoorControlReal = "freezer/app/reqDoorRealTimeJson.html";
    //
    public static String getTempAlart = "freezer/app/reqHumitureAlarmDataJson.html";
    public static String getColdAlart = "freezer/app/queHumiture8ManageJson.html";
    public static String getFridgeAlart = "freezer/app/queHumiturePT100ManageJson.html";
    public static String getFridgeatorAlart = "freezer/app/queIceboxManageJson.html";

    public static String getTemoHistroyData = "freezer/app/reqHumitureHisDataJson.html";
    public static String getNoLocationWaterAlart = "freezer/app/reqNonLocationAlarmDataJson.html";
    public static String getLocationWaterAlart = "freezer/app/reqLocationAlarmDataJson.html";
    public static String getDotLocationWaterAlart = "freezer/app/reqDotModelAlarmDataJson.html";
    public static String getAirJAlart = "freezer/app/reqCracAlarmDataJson.html";
    public static String getCo2Alart = "freezer/app/reqCo2AlarmDataJson.html";
    public static String getThunderAlart = "freezer/app/reqAntiThunderAlarmDataJson.html";
    public static String getElecMachineAlart = "freezer/app/reqElectricMeterAlarmDataJson.html";
    public static String getPElecAlart = "freezer/app/reqElectricBoxAlarmDataJson.html";
    public static String getSElecAlart = "freezer/app/reqElectricSupplyAlarmDataJson.html";
    public static String getUPSAlart = "freezer/app/reqUpsAlarmDataJson.html";
    public static String getInfraredAlart = "freezer/app/reqInfraredAlarmDataJson.html";
    public static String getGlassAlart = "freezer/app/reqGlassAlarmDataJson.html";
    public static String getFireAlart = "freezer/app/reqFireControlAlarmDataJson.html";
    public static String getSmokeAlart = "freezer/app/reqSmokeAlarmDataJson.html";
    public static String getDoorMagnAlart = "freezer/app/reqDoorContactAlarmDataJson.html";
    public static String getDoorControlHistroy = "freezer/app/reqDoorOpenRecordJson.html";

    //
    public static String getLocationList = "freezer/app/queDeviceLocationJson.html";
    public static String locationAdd = "freezer/app/addDeviceLocationJson.html";
    public static String locationEdt = "freezer/app/updDeviceLocationJson.html";
    public static String locationDel = "freezer/app/delDeviceLocationJson.html";

    public static String getAlartList = "freezer/app/queDeviceAlarmJson.html";
    public static String alartEdit = "freezer/app/updDeviceAlarmParameter.html";
    public static String alartStatus = "freezer/app/updDeviceAlarmStatusJson.html";

    public static String getIpList = "freezer/app/queIpParameterJson.html";
    public static String getIpSetionList = "freezer/app/queDeviceNameJson.html";
    public static String ipEdit = "freezer/app/updIpJson.html";
    public static String ipStart = "freezer/app/startConnectJson.html";
    public static String ipStop = "freezer/app/stopConnectJson.html";
    public static String ipAdd = "freezer/app/addIpJson.html";
    public static String ipDel = "freezer/app/delIpJson.html";
    public static String get8060 = "freezer/app/queKtr8060Json.html";
    public static String add8060 = "freezer/app/addKtr8060Json.html";
    public static String edt8060 = "freezer/app/updKtr8060Json.html";
    public static String del8060 = "freezer/app/delKtr8060Json.html";
    public static String get8060Location = "freezer/app/queLocationJson.html";
    public static String get8060Device = "freezer/app/queKTR8060DeviceJson.html";
    public static String get8060IP = "freezer/app/queIpJson.html";
    public static String get8052 = "freezer/app/queKtr8052Json.html";
    public static String add8052 = "freezer/app/addKtr8052Json.html";
    public static String edt8052 = "freezer/app/updKtr8052.html";
    public static String del8052 = "freezer/app/delKtr8052Json.html";
    public static String get8052Device = "freezer/app/queKTR8052DeviceJson.html";

    public static String getLocationManage = "freezer/app/queLocationManageJson.html";
    public static String edtLocation = "freezer/app/updLocationManageInfo.html";
    public static String addLocation = "freezer/app/addLocationManageInfo.html";
    public static String delLocation = "freezer/app/delLocationManageInfo.html";
    public static String getLocationIP = "freezer/app/queIpJson.html";
    public static String getLocationlocations = "freezer/app/queLocationJson.html";

    public static String getCo2Manage = "freezer/app/queCo2ManageJson.html";
    public static String edtCo2 = "freezer/app/updCo2ManageInfoJson.html";
    public static String addCo2 = "freezer/app/addCo2ManageInfoJson.html";
    public static String delCo2 = "freezer/app/delCo2ManageInfoJson.html";
    public static String getCo2IP = "freezer/app/queIpJson.html";
    public static String getCo2locations = "freezer/app/queLocationJson.html";

    public static String getTempManage = "freezer/app/queHumitureManageJson.html";
    public static String getColdManage = "freezer/app/queHumiture8ManageJson.html";
    public static String getFridgeManage = "freezer/app/queHumiturePT100ManageJson.html";
    public static String getFridgeratorManage = "freezer/app/queIceboxManageJson.html";
    public static String getRefiiferTempManage = "freezer/app/queGPRSManageJson.html";
    public static String edtTemp = "freezer/app/updHumitureManageInfo.html";
    public static String edtCold = "freezer/app/udpHumiture8ManageJson.html";
    public static String edtFridge = "freezer/app/udpHumiturePT100ManageJson.html";
    public static String edtFridgetor = "freezer/app/udpIceboxManageJson.html";
    public static String edtReFridge = "freezer/app/updateGPRSDeviceJson.html";

    public static String addTemp = "freezer/app/addHumitureManageInfo.html";
    public static String addRefrigertorTemp = "freezer/app/addIceboxManageJson.html";
    public static String addCold = "freezer/app/addHumiture8ManageJson.html";
    public static String addFridge = "freezer/app/addHumiturePT100ManageJson.html";
    public static String addReFridgeator = "freezer/app/addIceboxManageJson.html";
    public static String addReFridge = "freezer/app/addGPRSDeviceJson.html";
    public static String delTemp = "freezer/app/delHumitureManageInfo.html";
    public static String delCold = "freezer/app/delHumiture8ManageJson.html";
    public static String delFridge = "freezer/app/delHumiturePT100ManageJson.html";
    public static String delFridgerator = "freezer/app/delIceboxManageJson.html";
    public static String delReFridge = "freezer/app/delGPRSDeviceJson.html";

    public static String getTempIP = "freezer/app/queIpByNumberJson.html";
    public static String getTemplocations = "freezer/app/queLocationJson.html";

    public static String getFreezerManage = "freezer/app/queHumiture8ManageJson.html";
    public static String getGetRefrigeratorRealManage = "freezer/app/queIceboxManageJson.html";


    public static String addFreezerMachine = "freezer/app/addHumiture8ManageJson.html";
    public static String updateFreezerMachine = "freezer/app/udpHumiture8ManageJson.html";
    public static String deleteFreezerMachine = "freezer/app/delHumiture8ManageJson.html";

    public static String getAirFManage = "freezer/app/queFissionAirManageJson.html";
    public static String edtAirF = "freezer/app/updFissionAirManageInfoJson.html";
    public static String addAirF = "freezer/app/addFissionAirManageInfoJson.html";
    public static String delAirF = "freezer/app/delFissionAirManageInfoJson.html";
    public static String getAirFIP = "freezer/app/queIpJson.html";
    public static String getAirFlocations = "freezer/app/queLocationJson.html";

    public static String getDoorManage = "freezer/app/queDoorUserManageJson.html";
    public static String addDoorManage = "freezer/app/addDoorUser.html";
    public static String edtDoorF = "freezer/app/updFissionAirManageInfoJson.html";
    public static String delDoorF = "freezer/app/delFissionAirManageInfoJson.html";
    public static String getDoorIP = "freezer/app/queIpJson.html";
    public static String addDoorSection = "freezer/app/addSectionJson.html";
    public static String getDoorSection = "freezer/app/queSectionJson.html";
    public static String addDoorList = "freezer/app/addDoorJson.html";
    public static String getDoorList = "freezer/app/queDoorJson.html";
    //
    //
    public static String webOperateUrl = "freezer/app/main.html";
    public static String webAirCondUrl = "freezer/app/queCracRealTime.html";
    public static String webUPSUrl = "freezer/app/queUpsRealTime.html";
    public static String webDoorUrl = "freezer/app/queDoorUserManage.html";
    public static String webElecUrl = "freezer/app//queElectricMeterManage.html";


    //精密空调
    public static String  accurateAirUrl = "/freezer/app/reqCracRealTimeDataJson.html";
    //UPS
    public static String UpsUrl = "/freezer/app/reqUpsRealTimeDataJson.html";
    //Server服务器参数显示
    public static String ServerUrl = "/freezer/app/queServers.html";
    //门禁
    public static String doorcontrlUrl = "freezer/app/queDoorUserManageJson.html";
    //门禁信息返回
    public static String doorMessageUrl = "freezer/app/queDoorJson.html";
    //修改门禁
    public static String doorUpdateUrl = "freezer/app/updSeDoorJson.html";
    //部门信息
    public static String queSectionUrl = "freezer/app/queSectionJson.html";
    //提取卡号
    public static String getCardNumberUrl = "freezer/app/getCardNumber.html";
    //门禁用户添加
    public static String addDoorUserUrl = "freezer/app/addDoorUserJson.html";
    //修改部门
    public static String updateSelectionUrl = "freezer/app/updSectionJson.html";

    //删除用户
    public static String deleteUserUrl = "freezer/app/delDoorUserJson.html";
    //更改用户
    public static String updateUserNameUrl = "freezer/app/updDoorUserJson.html";
    //授权管理,解除权限
    public static String changModUrl = "freezer/app/relieveDoorUserJson.html";
    //请求权限
    public static String requestModUrl = "freezer/app/accreditDoorUserJson.html";
    //电量仪信息返回
    public static String batteryUrl = "freezer/app/queElectricMeterManageJson.html";
    //删除
    public static String deleteElctroMachineUrl = "freezer/app/delElectricMeterManageInfoJson.html";
    //更新
    public static String updateElctroMachineUrl = "freezer/app/updElectricMeterManageInfoJson.html";
    //添加电量仪设备
    public static String addElctroMachineUrl = "freezer/app/addElectricMeterManageInfoJson.html";
    //loginUser
    public static String showCurrentLoginUserUrl = "freezer/app/showCurrentLoginUserJson.html";
    //更新管理员
    public static String updateLoginUserUrl = "freezer/app/updCurrentLoginUserJson.html";

    public static String requestLogMessageUrl = "freezer/app/queSystemLogDataJson.html";

    //精密空调发送控制
    public static String kgjStateOpenUrl = "freezer/app/opencracJson.html";
    public static String kgjStateCloseUrl = "freezer/app/closecracJson.html";

    //导航
//    public static String freezer/appMointerUrl = "freezer/app/queMonitorTypeJson.html";


    public static String getBaseUrl() {
        String baseUrl = StringUtil.isEmpty(SettingDao.getInstance().getHostIp()) ? SettingDao.getInstance().getHostAddr() : SettingDao.getInstance().getHostIp();
        return "http://" + baseUrl  + "/";
    }

    public static String getAbsolutePath(String url) {
        Log.e("absoultePath",getBaseUrl()+url);
        return getBaseUrl() + url;
    }
}
