package com.laian.freezer.fragment.system.manage;

import android.content.DialogInterface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.google.gson.Gson;
import com.laian.freezer.R;
import com.laian.freezer.adapter.RecycleLogMessageAdapter;
import com.laian.freezer.bean.LogMessage;
import com.laian.freezer.bean.Pager;
import com.laian.freezer.bean.TempReal;
import com.laian.freezer.fragment.FragmentAlert;
import com.laian.freezer.fragment.FragmentControl;
import com.laian.freezer.fragment.enviroment.constanttemperature.FragmentTempReal;
import java.util.ArrayList;
import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.httpGet.HttpGetController;

/**
 * Created by zsp on 2017/9/13.
 */

public class FragmentLogmessage extends FragmentAlert implements RecycleLogMessageAdapter.OnItemClickListner,SwipeRefreshLayout.OnRefreshListener{
    String action_getData = className + API.requestLogMessageUrl;
    ArrayList<LogMessage.RowsBean> TempAlarts = new ArrayList<>();
    Pager pager=new Pager();
    RecycleLogMessageAdapter adapter;
    LogMessage logMessage=new LogMessage();

    @Override
    public RecyclerView.Adapter getAdapter() {
        adapter = new RecycleLogMessageAdapter(getActivity(), TempAlarts);
        adapter.setOnItemClickListner(this);
        return adapter;
    }

    @Override
    public View getTopView() {
        return LayoutInflater.from(getActivity()).inflate(R.layout.f_alart2, null);
    }

    @Override
    public String getAction() {
        return action_getData;
    }

    @Override
    public void requestData(String start, String end, String deviceId) {
       // showProgressDialog();
        pager.setPage("1");
        pager.setPageCapacity("10");
        String EhmListBeanStr = new Gson().toJson(pager);
        HttpGetController.getInstance().getLogMessage(className,"pager",EhmListBeanStr);
    }

    public void handleData(String data) {
        logMessage = new Gson().fromJson(data,LogMessage.class);
        if (logMessage!=null) {

            TempAlarts.clear();
            TempAlarts.addAll(logMessage.getRows());
            adapter.notifyDataSetChanged();
        }
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

    @Override
    public void onHttpHandle(String action, String data) {
        super.onHttpHandle(action, data);
        if (getHttpStatus(data)) {
            if (action.equals(action_getData)){
                handleData(data);
            }

        }
    }


    @Override
    public void onItemDel(int position) {

    }

    @Override
    public void onItemEdit(int position) {

    }
}
