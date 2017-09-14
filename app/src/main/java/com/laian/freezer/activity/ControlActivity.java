package com.laian.freezer.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.laian.freezer.R;
import com.laian.freezer.fragment.FragmentControl;
import com.laian.freezer.fragment.enviroment.FragmentEnv;
import com.laian.freezer.fragment.system.FragmentSystem;

import cn.meiqu.baseproject.baseUi.BaseActivity;


/**
 * ControlActivity这里选择我们对应的fragment
 */
public class ControlActivity extends BaseActivity {

    public static String extra_pId = "extra_pId";
    public static String extra_cId = "extra_cId";
    public static String extra_name = "extra_name";


    String pId = "";
    String cId = "";
    String name = "";
    Fragment f = new Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pId = getIntent().getStringExtra(extra_pId);
        cId = getIntent().getStringExtra(extra_cId);
        name = getIntent().getStringExtra(extra_name);
        Log.e("pId cId name",pId+" | "+cId+" | "+name);
        initTitle("" + name);
        checkInput();
        initCurrentFragment();
    }

    @Override
    public int getlayoutId() {
        return R.layout.activity_control;
    }

    //创建加载我们的fragments
    public void checkInput() {

        if(pId.equals("2")){
            //环境监控
            f = new FragmentEnv();
            Log.e("number2",cId);
        }

        if(pId.equals("6")){
            //系统管理
            f = new FragmentSystem();
        }
//        //环境监控
//        if (pId.equals("2")) {
//            f = new FragmentEnv();
//        }
//        //动力监控
//        else if (pId.equals("3")) {
//            f = new FragmentPower();
//        }
//
//        //安防监控
//        else if (pId.equals("4")) {
//            f = new FragmentSecy();
//        }
//
//        //运维监控
//        else if (pId.equals("5")) {
//            f = new FragmentOper();
//            FragmentOper.number1 = pId;
//            FragmentOper.number2 = cId;
//        }
//        //系统管理
//        else if (pId.equals("6")) {
//            f = new FragmentSystem();
//        }
    }

    @Override
    public void initFragment() {

    }

    public void initCurrentFragment(){
        FragmentControl.number1 = pId;
        FragmentControl.number2 = cId;
        showFirst(f);
    }


    @Override
    public void onHttpHandle(String action, String data) {

    }
}
