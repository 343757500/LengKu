package com.laian.freezer.fragment.enviroment.refrigerator;

import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.laian.freezer.adapter.RecycleColdRealAdapter;
import com.laian.freezer.adapter.RecycleRefrigeratorRealAdapter;
import com.laian.freezer.bean.Freezers;
import com.laian.freezer.bean.RefrigeratorReal;
import com.laian.freezer.fragment.FragmentReal;

import java.util.ArrayList;

import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.httpGet.HttpGetController;

/**
 * Created by zsp on 2017/8/19.
 */

public class FragmentRefrigeratorReal extends FragmentReal {
    String action_getData = className + API.getGetRefrigeratorRealManage;
    public ArrayList<Freezers> tempReals = new ArrayList<>();
    public ArrayList<RefrigeratorReal.EhmListBean> ehmList=new ArrayList<>();
    RecycleRefrigeratorRealAdapter adapter;

    @Override
    public RecyclerView.Adapter getAdapter() {
        adapter = new RecycleRefrigeratorRealAdapter(getActivity(), ehmList);
        return adapter;
    }

    @Override
    public String getAction() {
        return action_getData;
    }

    public void requestData() {
        HttpGetController.getInstance().getRefrigertorReal(className);
    }

    public void handleData(String data) {
        RefrigeratorReal temps = new Gson().fromJson(data, RefrigeratorReal.class);

        if (temps!=null) {
            ehmList.clear();
            ehmList.addAll(temps.getEhmList());
            adapter.notifyDataSetChanged();
        }
    }
}
