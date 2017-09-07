package com.laian.freezer.fragment.enviroment.constanttemperature;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.laian.freezer.adapter.RecycleTempRealAdapter;
import com.laian.freezer.bean.TempReal;
import com.laian.freezer.fragment.FragmentReal;

import java.util.ArrayList;

import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.httpGet.HttpGetController;


/**
 * Created by Fatel on 16-5-10.
 */
public class FragmentTempReal extends FragmentReal {

    String action_getData = className + API.getTempReal;
    public ArrayList<TempReal> tempReals = new ArrayList<>();
    RecycleTempRealAdapter adapter;

    @Override
    public RecyclerView.Adapter getAdapter() {
        adapter = new RecycleTempRealAdapter(getActivity(), tempReals);
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
        HttpGetController.getInstance().getTempReal(className);
    }

    public void handleData(String data) {
        ArrayList<TempReal> temps = new Gson().fromJson(data, new TypeToken<ArrayList<TempReal>>() {
        }.getType());
        if (!temps.isEmpty()) {
            tempReals.clear();
            tempReals.addAll(temps);
            adapter.notifyDataSetChanged();
        }
    }
}
