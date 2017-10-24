package com.laian.freezer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.activity.InformationChangeActivity;
import com.laian.freezer.activity.PersonalInfomationActivity;
import com.laian.freezer.activity.SettingActivity;

import cn.meiqu.baseproject.dao.SettingDao;
import cn.meiqu.baseproject.view.RippleView;

/**
 * Created by Administrator on 2017/5/25.
 */

public class MineFragment extends Fragment {
    private RippleView settingTv;
    private TextView personalInfomation;
    private TextView informationChange;
    private static final String ARG_SECTION_NUMBER = "section_number";

    public MineFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MineFragment newInstance(int sectionNumber) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        /**
         * SettingDao.getInstance().setIsLogin();
         SettingDao.getInstance().setAccount(userName);
         SettingDao.getInstance().setPwd(password);
         */
        //TextView settingTv = (TextView) rootView.findViewById(R.id.setting_tv);
       /* settingTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SettingActivity.class));
            }
        });*/

        personalInfomation = (TextView) rootView.findViewById(R.id.personal_information);
        informationChange = (TextView) rootView.findViewById(R.id.information_change);
        settingTv = (RippleView) rootView.findViewById(R.id.fb_logout);

        initOnClickListener();
        return rootView;
    }

    private void initOnClickListener() {
        personalInfomation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PersonalInfomationActivity.class));

            }
        });


        informationChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), InformationChangeActivity.class));

            }
        });





        settingTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingDao.getInstance().setIsLogin(0);
                SettingDao.getInstance().setAccount("");
                SettingDao.getInstance().setPwd("");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getActivity().finish();
                    }
                },300);
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        if(!SettingDao.getInstance().getIsLogin()){
            getActivity().finish();
        }
    }
}
