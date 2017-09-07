package com.laian.freezer.fragment.enviroment;

import android.support.v4.app.Fragment;

import com.laian.freezer.bean.ThirdPage;
import com.laian.freezer.fragment.FragmentControl;
import com.laian.freezer.fragment.enviroment.coldstorage.FragmentColdAlert;
import com.laian.freezer.fragment.enviroment.coldstorage.FragmentColdReal;
import com.laian.freezer.fragment.enviroment.constanttemperature.FragmentTempAlert;
import com.laian.freezer.fragment.enviroment.constanttemperature.FragmentTempChart;
import com.laian.freezer.fragment.enviroment.constanttemperature.FragmentTempReal;
import com.laian.freezer.fragment.enviroment.fridge.FragmentFridgeAlert;
import com.laian.freezer.fragment.enviroment.fridge.FragmentFridgeReal;
import com.laian.freezer.fragment.enviroment.refrigeratorcar.FragmentRefrigerAlert;
import com.laian.freezer.fragment.enviroment.refrigeratorcar.FragmentRefrigerReal;
import com.laian.freezer.fragment.freezer.FragementFreezerManage;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Fatel on 16-5-24.
 */
public class FragmentEnv extends FragmentControl {
    @Override
    public void initFragments(List<Fragment> fragments, ArrayList<ThirdPage> thirdPages) {
        //常温库
        if (number2.equals("1")) {

            if (thirdPages.size() >= 1)
                fragments.add(new FragmentTempReal());
            if (thirdPages.size() >= 2)
                fragments.add(new FragmentTempAlert());
            if (thirdPages.size() >= 3)
                fragments.add(new FragmentTempChart());
            if (thirdPages.size() >= 4)
                fragments.add(new FragmentTempAlert.FragmentTempManage());
        }

        if (number2.equals("13")) {
            //冷藏库
            if (thirdPages.size() >= 1)
                fragments.add(new FragmentColdReal());
            if (thirdPages.size() >= 2)
              //  fragments.add(new FragmentTempAlert());
            if (thirdPages.size() >= 3)
              //  fragments.add(new FragmentTempChart());
            if (thirdPages.size() >= 4) {
               // fragments.add(new FragementFreezerManage());
                fragments.add(new FragmentColdAlert.FragmentColdManage());
            }
        }

        if (number2.equals("14")) {
            //冷冻柜
            if (thirdPages.size() >= 1)
                fragments.add(new FragmentFridgeReal());
            if (thirdPages.size() >= 2)
               // fragments.add(new FragmentTempAlert());
            if (thirdPages.size() >= 3)
             //   fragments.add(new FragmentTempChart());
            if (thirdPages.size() >= 4)
                fragments.add(new FragmentFridgeAlert.FragmentFridgeManage());
        }

        if (number2.equals("15")) {
            //冷藏车
            if (thirdPages.size() >= 1)
                fragments.add(new FragmentRefrigerReal());
            if (thirdPages.size() >= 2)
                //fragments.add(new FragmentTempAlert());
            if (thirdPages.size() >= 3)
                //fragments.add(new FragmentTempChart());
            if (thirdPages.size() >= 4)
                fragments.add(new FragmentRefrigerAlert.FragmentRefrigeManage());
        }

        if (number2.equals("16")) {
            //冰箱
            if (thirdPages.size() >= 1)
                fragments.add(new FragmentTempReal());
            if (thirdPages.size() >= 2)
                fragments.add(new FragmentTempAlert());
            if (thirdPages.size() >= 3)
                fragments.add(new FragmentTempChart());
            if (thirdPages.size() >= 4)
                fragments.add(new FragmentTempAlert.FragmentTempManage());
        }


    }

}
