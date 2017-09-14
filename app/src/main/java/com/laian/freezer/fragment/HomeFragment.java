package com.laian.freezer.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.laian.freezer.R;
import com.laian.freezer.activity.IpSettingActivity;
import com.laian.freezer.adapter.PagerHomeAdapter;
import com.laian.freezer.bean.HomePage;

import java.util.ArrayList;
import java.util.List;

import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.baseUi.BaseFragment;
import cn.meiqu.baseproject.dao.SettingDao;
import cn.meiqu.baseproject.httpGet.HttpGetController;
import cn.meiqu.baseproject.util.LogUtil;
import cn.meiqu.baseproject.util.StringUtil;

/**
 * Created by Administrator on 2017/5/26.
 */

public class HomeFragment extends BaseFragment {


    String className = getClass().getName();
    String action_getHomePage = className + API.getHomePage;
    String action_login = className + API.login;
    private TabLayout mTabL;
    private ViewPager mViewP;
    private PagerHomeAdapter adapter;
    private List<Fragment> fragments = new ArrayList<>();
    ArrayList<HomePage> homePages = new ArrayList<>();
    String titles[] = new String[100];
    private View homeView;
    AlertDialog dialog;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       homeView = inflater.inflate(R.layout.home_fragment,container,false);
        assignViews();
        initPager();
        initReceiver(new String[]{action_getHomePage,action_login});
        return homeView;
    }

    @Override
    public void onHttpHandle(String action, String data) {
        if (getHttpStatus(data)) {
            if (action.equals(action_getHomePage)) {
                handleHomePage(data);
            }

            if(action.equals(action_login)){
                requestHomePage();
            }
        } else {

            if (dialog == null || !dialog.isShowing()) {
                dialog = new AlertDialog.Builder(getActivity()).setTitle("服务器没响应").setMessage("请检查域名设置是否正确").setPositiveButton("马上去", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getActivity(),IpSettingActivity.class));
                    }
                }).show();
            }
        }
    }

    private String mData; //jsondata

    public void handleHomePage(String data) {
        ArrayList<HomePage> temps = new Gson().fromJson(data, new TypeToken<ArrayList<HomePage>>() {
        }.getType());
        mData = data;
        initData();
    }

    private void assignViews() {

        mTabL = (TabLayout) homeView.findViewById(R.id.tabL);
        mViewP = (ViewPager) homeView.findViewById(R.id.viewP);
    }


    private void initPager() {
        adapter = new PagerHomeAdapter(getFragmentManager(), fragments, titles);
        mViewP.setAdapter(adapter);
        mTabL.setupWithViewPager(mViewP);
        mTabL.setTabTextColors(getResources().getColor(R.color.color_gravy), getResources().getColor(R.color.black));//设置文本在选中和为选中时候的颜色
        mTabL.setSelectedTabIndicatorColor(getResources().getColor(R.color.black));//设置指示器的颜色
        mTabL.setTabMode(TabLayout.MODE_SCROLLABLE);
        //初始化数据
        initData();
    }


    public void initData() {
        homePages.clear();
        fragments.clear();
        if (!StringUtil.isEmpty(mData)) {
            ArrayList<HomePage> temps = new Gson().fromJson(mData, new TypeToken<ArrayList<HomePage>>() {
            }.getType());

            homePages.addAll(temps);
            for (int i = 0; i < homePages.size(); i++) {
                fragments.add(MainFragment.newInstance(homePages.get(i).getNumber() + ""));
                titles[i] = homePages.get(i).getName();


                SettingDao.getInstance().setStringArray("title",titles[i]);


            }


        }


        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        requestLogin();
    }

    public void requestHomePage() {
        HttpGetController.getInstance().getHome(className);
    }

    public void requestLogin(){
        String userName = SettingDao.getInstance().get("account");
        String password = SettingDao.getInstance().get("pwd");
        HttpGetController.getInstance().loginToServer(userName, password, className);
    }







}
