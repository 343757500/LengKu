package com.laian.freezer.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.laian.freezer.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.meiqu.baseproject.baseUi.BaseActivity;
import cn.meiqu.baseproject.dao.SettingDao;


/**
 * Created by Administrator on 2017/6/12.
 */

public class SettingActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initTitle("设置");
    }

    @Override
    public int getlayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void onHttpHandle(String action, String data) {

    }

    @Override
    public void initFragment() {

    }

    @OnClick({R.id.fb_logout})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.fb_logout:

                SettingDao.getInstance().setIsLogin(0);
                SettingDao.getInstance().setAccount("");
                SettingDao.getInstance().setPwd("");
                toast("已退出！");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                },300);
                break;
        }
    }
}
