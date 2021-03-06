package com.laian.freezer.fragment.enviroment.fridge;

import android.content.DialogInterface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.laian.freezer.R;
import com.laian.freezer.adapter.RecycleColdManagerAdapter;
import com.laian.freezer.adapter.RecycleFridgeManagerAdapter;
import com.laian.freezer.adapter.RecycleTempAlertAdapter;
import com.laian.freezer.bean.ColdAlart;
import com.laian.freezer.bean.FridgeAlart;
import com.laian.freezer.bean.FridgeReal;
import com.laian.freezer.bean.Ip;
import com.laian.freezer.bean.Location;
import com.laian.freezer.bean.TempAlart;
import com.laian.freezer.bean.TempReal;
import com.laian.freezer.fragment.FragmentAlert;
import com.laian.freezer.fragment.FragmentControl;
import com.laian.freezer.fragment.enviroment.constanttemperature.FragmentTempReal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.httpGet.HttpGetController;
import cn.meiqu.baseproject.util.StringUtil;
import cn.meiqu.baseproject.util.ToastUtil;

import static com.laian.freezer.fragment.FragmentControl.number2;

/**
 * Created by zsp on 2017/8/24.
 */

public class FragmentFridgeAlert extends FragmentAlert {

    String action_getData = className + API.getFridgeAlart;
    ArrayList<TempAlart> TempAlarts = new ArrayList<>();
    RecycleTempAlertAdapter adapter;

    @Override
    public RecyclerView.Adapter getAdapter() {
        adapter = new RecycleTempAlertAdapter(getActivity(), TempAlarts);
        return adapter;
    }

    @Override
    public View getTopView() {
        return LayoutInflater.from(getActivity()).inflate(R.layout.recycle_alart_type1, null);
    }

    @Override
    public String getAction() {
        return action_getData;
    }

    @Override
    public void requestData(String start, String end, String deviceId) {
        showProgressDialog();
        HttpGetController.getInstance().getColdAlart(deviceId, start, end, className);
    }

    public void handleData(String data) {
        ArrayList<TempAlart> temps = new Gson().fromJson(data, new TypeToken<ArrayList<TempAlart>>() {
        }.getType());
        TempAlarts.clear();
        TempAlarts.addAll(temps);
        adapter.notifyDataSetChanged();
    }

    @Override
    public String[] getDeviceNames() {
        ArrayList<TempReal> tempReals = ((FragmentTempReal) ((FragmentControl) getParentFragment()).fragments.get(0)).tempReals;
        String names[] = new String[tempReals.size() + 1];
        for (int i = 1; i < names.length; i++) {
            names[i] = tempReals.get(i - 1).getEhmName();
        }
        return names;
    }

    @Override
    public String getDeviceId(int position) {
        ArrayList<TempReal> tempReals = ((FragmentTempReal) ((FragmentControl) getParentFragment()).fragments.get(0)).tempReals;
        return tempReals.get(position - 1).getEhmId() + "";
    }

    /**
     * Created by Fatel on 16-5-10.
     */
    public static class FragmentFridgeManage extends FragmentAlert implements RecycleFridgeManagerAdapter.OnItemClickListner,SwipeRefreshLayout.OnRefreshListener{
        String action_getData = className + API.getFridgeManage;
        String action_add = className + API.addFridge;
        String action_edt = className + API.edtFridge;
        String action_del = className + API.delFridge;
        String action_getIP = className + API.getTempIP;
        String action_getLocation = className + API.getTemplocations;
        FridgeAlart Temps = new FridgeAlart();
        ArrayList<FridgeAlart.EhmListBean> ehmList=new ArrayList<>();
        ArrayList<Location> locations = new ArrayList<>();
        ArrayList<Ip> ips = new ArrayList<>();
        RecycleFridgeManagerAdapter adapter;
        String[] addrs = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        String[] grally = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};

        @Override
        public RecyclerView.Adapter getAdapter() {
            adapter = new RecycleFridgeManagerAdapter(getActivity(), ehmList);
            adapter.setOnItemClickListner(this);
            adapter.setHeaderView(LayoutInflater.from(getActivity()).inflate(R.layout.layout_cold_top,null));
            return adapter;
        }

        @Override
        public View getTopView() {
            requestLocations();
            requestIps();
            viewGBody.getChildAt(0).setVisibility(View.GONE);
            mFab.setVisibility(View.VISIBLE);
            return LayoutInflater.from(getActivity()).inflate(R.layout.layout_temp_top_null, null);
        }

        @Override
        public String getAction() {
            return action_getData;
        }

        @Override
        public String[] getActions() {
            return new String[]{action_getData, action_add, action_del, action_edt, action_getIP, action_getLocation};
        }

        @Override
        public void requestData(String start, String end, String deviceId) {
            showProgressDialog();
            HttpGetController.getInstance().getFridgeManageList(className);
        }

        public void handleData(String data) {
            Temps = new Gson().fromJson(data, FridgeAlart.class);
            ehmList.clear();
            ehmList.addAll(Temps.getEhmList());
            adapter.notifyDataSetChanged();
        }

        public void requestLocations() {
            HttpGetController.getInstance().getTempLocationsList(className);
        }

        public void handleLocations(String data) {
            ArrayList<Location> temps = new Gson().fromJson(data, new TypeToken<ArrayList<Location>>() {
            }.getType());
            locations.clear();
            locations.addAll(temps);
        }

        public void requestIps() {
            HttpGetController.getInstance().getTempIpList(className,number2);
        }

        public void handleIps(String data) {
            ArrayList<Ip> temps = new Gson().fromJson(data, new TypeToken<ArrayList<Ip>>() {
            }.getType());
            ips.clear();
            ips.addAll(temps);
        }

        public void requestAdd(String key,String value) {
            showProgressDialog();
            HttpGetController.getInstance().addFridgeManage(className,key,value);
        }

        public void requestEdt(String key,String value) {
            showProgressDialog();
            HttpGetController.getInstance().edtFridgeManage(className,key,value);
        }

        //
        public void requestDel(String id, String ip) {
            HttpGetController.getInstance().delFridgeManage(id, ip, className);
        }

        public void handleEdt(String data) {
            try {
                requestData(null, null, null);
                JSONObject object = (JSONObject) new JSONArray(data).get(0);
                showAlart(object.getString("msg"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onHttpHandle(String action, String data) {
            super.onHttpHandle(action, data);
            if (getHttpStatus(data)) {
                if (action.equals(action_add) || action.equals(action_del) || action.equals(action_edt)) {
                    handleEdt(data);
                    ToastUtil.show(getContext(),data);
                } else if (action.equals(action_getLocation)) {
                    handleLocations(data);
                } else if (action.equals(action_getIP)) {
                    handleIps(data);
                }
                if (action.equals(action_getData)){
                    handleData(data);
                }

            }
        }


        @Override
        public String[] getDeviceNames() {
            String names[] = new String[1];
            return names;
        }

        @Override
        public String getDeviceId(int position) {
            return "0";
        }
        int currentGrally = 0;
        int currentAddr = 0;
        int currentTemp = 0;
        int currentIp = 0;

        public void showEdtDialog(final int position) {
            View body = LayoutInflater.from(getActivity()).inflate(R.layout.layout_cold_input, null);
            final EditText mEdtAddress;
            final EditText edt_gallery;
            final EditText mEdtLocation;
            final EditText mEdtIp;
            final EditText mEdtName;
            final EditText mEdtMaxTemp;
            final EditText mEdtMinTemp;
            final EditText mEdtInterval;

            mEdtAddress = (EditText) body.findViewById(R.id.edt_address);
            edt_gallery = (EditText) body.findViewById(R.id.edt_gallery);
            mEdtLocation = (EditText) body.findViewById(R.id.edt_location);
            mEdtIp = (EditText) body.findViewById(R.id.edt_ip);
            mEdtName = (EditText) body.findViewById(R.id.edt_name);
            mEdtMaxTemp = (EditText) body.findViewById(R.id.edt_maxTemp);
            mEdtMinTemp = (EditText) body.findViewById(R.id.edt_minTemp);
            mEdtInterval = (EditText) body.findViewById(R.id.edt_interval);

            String title = "设备修改";
            if (position != -1) {
                List<FridgeAlart.EhmListBean> ehmList = Temps.getEhmList();
                mEdtAddress.setText("" + ehmList.get(position).getEhmAddress());
                edt_gallery.setText(ehmList.get(position).getGallery() + "");
                mEdtLocation.setText("" + ehmList.get(position).getDeviceLocationPojo().getDlName());
                mEdtIp.setText("" + ehmList.get(position).getIpPort());
                mEdtName.setText(ehmList.get(position).getEhmName() + "");
                mEdtMaxTemp.setText("" + ehmList.get(position).getEhmMaxTemp());
                mEdtMinTemp.setText("" + ehmList.get(position).getEhmMinTemp());
                mEdtInterval.setText("" + ehmList.get(position).getEhmInterval());
            } else {
                title = "设备添加";
                mEdtAddress.setText("" + addrs[0]);
                edt_gallery.setText("" + grally[0]);
                if (locations.isEmpty()) {
                    requestLocations();
                } else {
                    mEdtLocation.setText("" + Temps.getLocationList().get(0).getDlName());
                     mEdtLocation.setText("" + locations.get(0).getDlName());
                }
                if (ips.isEmpty()) {
                    requestIps();
                } else {
                    mEdtIp.setText("" + ips.get(0).getDiAddress() + ":" + ips.get(0).getDiPort());
                }
                currentAddr = 0;
                currentIp = 0;
                currentTemp = 0;
                mEdtLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String[] names = new String[Temps.getLocationList().size()];
                        if (names.length == 0) {
                            //requestLocations();
                            return;
                        }
                        for (int i = 0; i < Temps.getLocationList().size(); i++) {
                            names[i] = Temps.getLocationList().get(i).getDlName();
                        }
                        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setSingleChoiceItems(names, currentTemp, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                currentTemp = which;
                                mEdtLocation.setText(Temps.getLocationList().get(which).getDlName() + "");
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();
                    }
                });
                mEdtAddress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setSingleChoiceItems(addrs, currentAddr, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                currentAddr = which;
                                mEdtAddress.setText(addrs[which] + "");
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();
                    }
                });

                edt_gallery.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setSingleChoiceItems(grally, currentGrally, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                currentGrally = which;
                                edt_gallery.setText(grally[which] + "");
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();
                    }
                });
                mEdtIp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String[] names = new String[ips.size()];
                        if (names.length == 0) {
                            requestIps();
                            return;
                        }
                        for (int i = 0; i < ips.size(); i++) {
                            names[i] = ips.get(i).getDiAddress() + ":" + ips.get(i).getDiPort();
                        }
                        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setSingleChoiceItems(names, currentIp, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                currentIp = which;
                                mEdtIp.setText(ips.get(which).getDiAddress() + ":" + ips.get(which).getDiPort());
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();
                    }
                });

            }
            AlertDialog dialog = new AlertDialog.Builder(getActivity()).setTitle(title).setPositiveButton("提交", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String name = mEdtName.getText().toString();
                    if (StringUtil.isEmpty(name)) {
                        toast("请输入名称");
                        return;
                    }
                    if (position == -1) {
                        // requestAdd(addrs[currentAddr] + "", Temps.getLocationList().get(currentTemp).getDlId() + "", ips.get(currentIp).getDiId() + "", name, mEdtMaxTemp.getText().toString(), mEdtMinTemp.getText().toString(), mEdtMaxHum.getText().toString(), mEdtMinHum.getText().toString(), mEdtInterval.getText().toString());
                        FridgeAlart.EhmListBean ehmListBean=new FridgeAlart.EhmListBean();
                        ehmListBean.setEhmName(name);
                        ehmListBean.setEhmAddress(Integer.parseInt(addrs[currentAddr]));
                        //ehmListBean.setIpPort(ips.get(currentIp).getDiId() + "");
                        ehmListBean.setIp(ips.get(currentIp).getDiId());
                        ehmListBean.setEhmMaxTemp(Double.parseDouble(mEdtMaxTemp.getText().toString()));
                        ehmListBean.setEhmMinTemp(Double.parseDouble(mEdtMinTemp.getText().toString()));
                        ehmListBean.setGallery(Integer.parseInt(grally[currentGrally]));
                        ehmListBean.setDeviceLocationPojo(Temps.getEhmList().get(currentTemp).getDeviceLocationPojo());
                       /* ColdAlart.LocationListBean locationListBean=new ColdAlart.LocationListBean();
                        locationListBean.setDlId(Temps.getLocationList().get(currentTemp).getDlId());*/

                        String EhmListBeanStr = new Gson().toJson(ehmListBean);
                        requestAdd("humiturePT100ManagePojo",EhmListBeanStr);


                    } else {

                        //要先给对象里面的元素赋值再把Gson对象转成字符串
                        Temps.getEhmList().get(position).setEhmHum(Temps.getEhmList().get(position).getEhmHum());
                        Temps.getEhmList().get(position).setEhmAddress(Temps.getEhmList().get(position).getEhmAddress());
                        Temps.getEhmList().get(position).setEhmName(name);
                        Temps.getEhmList().get(position).setEhmMaxTemp(Double.parseDouble(mEdtMaxTemp.getText().toString()));
                        Temps.getEhmList().get(position).setEhmMinTemp(Double.parseDouble(mEdtMinTemp.getText().toString()));
                       /* Temps.getEhmList().get(position).setEhmMaxHum(Double.parseDouble(mEdtMaxHum.getText().toString()));
                        Temps.getEhmList().get(position).setEhmMinHum(Double.parseDouble(mEdtMinHum.getText().toString()));*/
                        Temps.getEhmList().get(position).setEhmInterval(Integer.parseInt(mEdtInterval.getText().toString()));
                        String EhmListBeanStr = new Gson().toJson(Temps.getEhmList().get(position));
                        // //get请求不知道为什么不可以，所以封装了post请求
                        requestEdt("humiturePT100ManagePojo",EhmListBeanStr);
                    }
                }
            }).setNegativeButton("取消", null).setView(body).show();
        }

        public void onClickAdd() {
            super.onClickAdd();
            showEdtDialog(-1);
        }

        @Override
        public void onItemDel(final int position) {
            AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setMessage("是否要删除" + Temps.getEhmList().get(position).getEhmName() + "?").setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).setPositiveButton("是", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    requestDel(Temps.getEhmList().get(position).getEhmId() + "", Temps.getEhmList().get(position).getIp() + "");
                }
            }).show();

        }

        @Override
        public void onItemEdit(int position) {
            showEdtDialog(position);
        }
    }
}
