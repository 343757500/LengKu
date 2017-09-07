package com.laian.freezer.fragment.enviroment.coldstorage;

import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.laian.freezer.adapter.RecycleColdRealAdapter;
import com.laian.freezer.bean.Freezers;
import com.laian.freezer.fragment.FragmentReal;

import java.util.ArrayList;
import java.util.List;

import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.httpGet.HttpGetController;

/**
 * Created by Administrator on 2017/8/19.
 */

public class FragmentColdReal extends FragmentReal {
    String action_getData = className + API.getFreezerManage;
    public ArrayList<Freezers> tempReals = new ArrayList<>();
    public ArrayList<Freezers.EhmListBean> ehmList=new ArrayList<>();
    RecycleColdRealAdapter adapter;

    @Override
    public RecyclerView.Adapter getAdapter() {
        adapter = new RecycleColdRealAdapter(getActivity(), ehmList);
        return adapter;
    }

    @Override
    public String getAction() {
        return action_getData;
    }

    public void requestData() {
        HttpGetController.getInstance().getColdReal(className);
    }

    public void handleData(String data) {
        Freezers temps = new Gson().fromJson(data, Freezers.class);

        if (temps!=null) {
            ehmList.clear();
            ehmList.addAll(temps.getEhmList());
            adapter.notifyDataSetChanged();
        }
    }
}
