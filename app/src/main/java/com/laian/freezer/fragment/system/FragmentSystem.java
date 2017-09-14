package com.laian.freezer.fragment.system;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.laian.freezer.bean.ThirdPage;
import com.laian.freezer.fragment.FragmentControl;
import com.laian.freezer.fragment.system.manage.Fragment8052;
import com.laian.freezer.fragment.system.manage.Fragment8060;
import com.laian.freezer.fragment.system.manage.FragmentAdmin;
import com.laian.freezer.fragment.system.manage.FragmentAlart;
import com.laian.freezer.fragment.system.manage.FragmentIp;
import com.laian.freezer.fragment.system.manage.FragmentLocation;
import com.laian.freezer.fragment.system.manage.FragmentLogmessage;
import com.laian.freezer.fragment.system.manage.FragmentLogmessage2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsp on 2017/8/2.
 */

public class FragmentSystem extends FragmentControl {
    @Override
    public void initFragments(List<Fragment> fragments, ArrayList<ThirdPage> thirdPages) {
        Log.e("hei",number2);
        //设备管理
        if (number2.equals("1")) {
            if (thirdPages.size() >= 1)
                fragments.add(new FragmentLocation());
            if (thirdPages.size() >= 2)
                fragments.add(new FragmentAlart());
            if (thirdPages.size() >= 3)
               fragments.add(new FragmentIp());
            if (thirdPages.size() >= 4)
                fragments.add(new Fragment8060());
            if (thirdPages.size() >= 5)
                fragments.add(new Fragment8052());


        }
        //系统日志
        else if (number2.equals("4")) {
            fragments.add(new FragmentLogmessage2());
            mTabL.setVisibility(View.GONE);
        }

        //管理员
        else if (number2.equals("3")) {
            fragments.add(new FragmentAdmin());
            mTabL.setVisibility(View.GONE);
        }
    }
}
