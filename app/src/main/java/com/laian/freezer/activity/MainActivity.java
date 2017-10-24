package com.laian.freezer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.adapter.PagerHomeAdapter;
import com.laian.freezer.fragment.HomeFragment;
import com.laian.freezer.fragment.MineFragment;
import com.laian.freezer.view.NoScrollViewPager;

import java.util.ArrayList;

import cn.meiqu.baseproject.util.UpdateUtil;

public class MainActivity extends AppCompatActivity {

    private String[] mTitles = {"Home","Mine"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    //禁止滑动
    private NoScrollViewPager mViewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        UpdateUtil.checkUpdate(getApplication(), false);
        addFragments();
        setViewPager();
    }

    private void addFragments(){
        mFragments.add(new HomeFragment());
        mFragments.add(new MineFragment());
    }

    private void setViewPager(){

        PagerHomeAdapter tabAdapter = new PagerHomeAdapter(getSupportFragmentManager(),mFragments,mTitles);
        mViewPager.setAdapter(tabAdapter);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.color_backround));
        tabLayout.setTabTextColors(getResources().getColor(R.color.black), getResources().getColor(R.color.white));//设置文本在选中和为选中时候的颜色
       // tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.black));//设置指示器的颜色
        tabLayout.setupWithViewPager(mViewPager);
    }



    public void assignViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.layout_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((TextView) findViewById(R.id.tv_title)).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.tv_title)).setText("冷库监控系统");

        mViewPager = (NoScrollViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout)findViewById(R.id.table);

    }



    public void jumpControlActivity(String pId, String cId, String name) {
        Intent intent = new Intent(this, ControlActivity.class);
        intent.putExtra(ControlActivity.extra_pId, pId);
        intent.putExtra(ControlActivity.extra_cId, cId);
        intent.putExtra(ControlActivity.extra_name, name);
        startActivity(intent);
    }

}
