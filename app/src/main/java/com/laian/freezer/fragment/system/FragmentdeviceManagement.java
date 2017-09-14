package com.laian.freezer.fragment.system;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.laian.freezer.bean.ThirdPage;
import com.laian.freezer.fragment.FragmentAlert;
import com.laian.freezer.fragment.FragmentControl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */

 public class FragmentdeviceManagement extends FragmentAlert {

    @Override
    public RecyclerView.Adapter getAdapter() {
        return null;
    }

    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public String getAction() {
        return null;
    }

    @Override
    public void requestData(String start, String end, String deviceId) {

    }

    @Override
    public void handleData(String data) {

    }

    @Override
    public String[] getDeviceNames() {
        return new String[0];
    }

    @Override
    public String getDeviceId(int position) {
        return null;
    }
}
