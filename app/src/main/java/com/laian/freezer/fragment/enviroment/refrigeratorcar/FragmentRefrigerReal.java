package com.laian.freezer.fragment.enviroment.refrigeratorcar;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.laian.freezer.adapter.RecycleFridgeRealAdapter;
import com.laian.freezer.adapter.RecycleReFridgeRealAdapter;
import com.laian.freezer.bean.FridgeReal;
import com.laian.freezer.bean.RefrigeReal;
import com.laian.freezer.bean.TempReal;
import com.laian.freezer.fragment.FragmentRealTwo;

import java.util.ArrayList;

import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.httpGet.HttpGetController;

/**
 * Created by zsp on 2017/8/24.
 * 冷藏车实时数据页面
 */

public class FragmentRefrigerReal extends FragmentRealTwo{

    String action_getData = className + API.getRefrigerReal;
    public ArrayList<RefrigeReal> fridgeReals = new ArrayList<>();
    RecycleReFridgeRealAdapter adapter;

    @Override
    public RecyclerView.Adapter getAdapter() {
        adapter = new RecycleReFridgeRealAdapter(getActivity(), fridgeReals);
        adapter.setOnItemClickListner(new BaseRecycleAdapter.ItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                //你的逻辑
            }
        });
        return adapter;
    }

    @Override
    public String getAction() {
        return action_getData;
    }

    public void requestData() {
        HttpGetController.getInstance().getRefrigerReal(className);
    }

    public void handleData(String data) {
        ArrayList<RefrigeReal> fridgeReal = new Gson().fromJson(data, new TypeToken<ArrayList<RefrigeReal>>() {
        }.getType());
       // RefrigeReal fridgeReal = new Gson().fromJson(data, RefrigeReal.class);

        if (fridgeReal!=null) {
            fridgeReals.clear();
           fridgeReals.addAll(fridgeReal);
            adapter.notifyDataSetChanged();
        }
    }
}

