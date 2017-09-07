package com.laian.freezer.fragment.enviroment.fridge;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.laian.freezer.adapter.RecycleFridgeRealAdapter;
import com.laian.freezer.adapter.RecycleTempRealAdapter;
import com.laian.freezer.bean.FridgeReal;
import com.laian.freezer.bean.TempReal;
import com.laian.freezer.fragment.FragmentReal;

import java.util.ArrayList;

import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.httpGet.HttpGetController;

/**
 * Created by zsp on 2017/8/24.
 */

public class FragmentFridgeReal extends FragmentReal {


    String action_getData = className + API.getFridgeReal;
    public ArrayList<FridgeReal.EhmListBean> fridgeReals = new ArrayList<>();
    RecycleFridgeRealAdapter adapter;

    @Override
    public RecyclerView.Adapter getAdapter() {
        adapter = new RecycleFridgeRealAdapter(getActivity(), fridgeReals);
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
        HttpGetController.getInstance().getFridgeReal(className);
    }

    public void handleData(String data) {
        FridgeReal fridgeReal = new Gson().fromJson(data, FridgeReal.class);
        if (fridgeReal!=null) {
            fridgeReals.clear();
            fridgeReals.addAll(fridgeReal.getEhmList());
            adapter.notifyDataSetChanged();
        }
    }
}

