package com.laian.freezer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.FridgeReal;
import com.laian.freezer.bean.RefrigeReal;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;
import cn.meiqu.baseproject.baseRecycle.BaseOnRecycleClickListener;
import cn.meiqu.baseproject.view.RippleView;

/**
 * Created by Administrator on 2017/8/24.
 */

public class RecycleReFridgeRealAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<RefrigeReal> fridgeReals;

    public RecycleReFridgeRealAdapter(Context mContent, ArrayList<RefrigeReal> fridgeReals) {

        this.mContent = mContent;
        this.fridgeReals = fridgeReals;

    }

    private BaseOnRecycleClickListener clickListener;

    public BaseOnRecycleClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(BaseOnRecycleClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecycleReFridgeRealAdapter.Holder(View.inflate(mContent, R.layout.recycle_fidge_real, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecycleReFridgeRealAdapter.Holder) holder).instanceView(position);
    }

    @Override
    public int getItemCount() {
        return fridgeReals.size();
    }


    class Holder extends BaseHolder implements RippleView.OnRippleCompleteListener {
        public Holder(View itemView) {
            super(itemView);
        }

        private TextView mTvdeviceName;
        private TextView mTvdeviceStatus;
        private TextView mTvdevicePhone;

        private TextView mTvcarDriver;
        private TextView mTvcarPhone;
        private TextView mTvcarNumber;



        private TextView mTvdevName;
        private TextView mTvdevNameTwo;
        private TextView mTvdevValue;

        private TextView mTvdevValueTwo;
        private TextView mTvdevHumiValue;
        private TextView mTvdevHumiValueTwo;

        public void assignViews() {
            mTvdeviceName = (TextView) findViewById(R.id.deviceName);
            mTvdeviceStatus = (TextView) findViewById(R.id.tv_deviceStatus);
            mTvdevicePhone = (TextView) findViewById(R.id.tv_decicePhone);
            mTvcarDriver = (TextView) findViewById(R.id.tv_carDriver);
            mTvcarPhone = (TextView) findViewById(R.id.tv_carPhone);
            mTvcarNumber = (TextView) findViewById(R.id.tv_carNumber);


            mTvdevName = (TextView) findViewById(R.id.tv_devName);
            mTvdevNameTwo = (TextView) findViewById(R.id.tv_devNametwo);
            mTvdevValue = (TextView) findViewById(R.id.DevValue);
            mTvdevValueTwo = (TextView) findViewById(R.id.DevValueTwo);
            mTvdevHumiValue = (TextView) findViewById(R.id.DevHumiValue);
            mTvdevHumiValueTwo = (TextView) findViewById(R.id.DevHumiValueTwo);
        }

        @Override
        public void instanceView(final int position) {

            mTvdeviceName.setText(fridgeReals.get(position).getDevName() + "");
            boolean status = fridgeReals.get(position).isStatus();
            if (status){
                mTvdeviceStatus.setText("在线");
            }else{
                mTvdeviceStatus.setText("离线");
            }
            mTvdevicePhone.setText(fridgeReals.get(position).getDevPhone());
            mTvcarDriver.setText(fridgeReals.get(position).getDevDriver());

            mTvcarPhone.setText(fridgeReals.get(position).getDriverPhone());
            mTvcarNumber.setText(fridgeReals.get(position).getCarNumber());
            mTvdevName.setText(fridgeReals.get(position).getDevice().get(0).getDevName());
            mTvdevNameTwo.setText(fridgeReals.get(position).getDevice().get(1).getDevName());
            mTvdevValue.setText(fridgeReals.get(position).getDevice().get(0).getDevTempValue()+  "℃");
            mTvdevValueTwo.setText(fridgeReals.get(position).getDevice().get(1).getDevTempValue()+  "℃");

            mTvdevHumiValue.setText(fridgeReals.get(position).getDevice().get(0).getDevHumiValue()+  "%");
            mTvdevHumiValueTwo.setText(fridgeReals.get(position).getDevice().get(1).getDevHumiValue()+  "%");
          /*  mTvTemp.setText(ehmList.get(position).getGallery() + "℃");
            //mTvWet.setText(ehmList.get(position).getEhmHum() + "%");
            if (ehmList.get(position).getEhmTemp() >= ehmList.get(position).getEhmMinTemp() && ehmList.get(position).getEhmTemp() <= ehmList.get(position).getEhmMaxTemp()) {
                mTvTemp.setBackgroundColor(mTvTemp.getResources().getColor(R.color.colorPrimary));
            } else {
                mTvTemp.setBackgroundColor(mTvTemp.getResources().getColor(R.color.red));
            }

            if (ehmList.get(position).getEhmHum() >= ehmList.get(position).getEhmMinHum() && ehmList.get(position).getEhmTemp() <= ehmList.get(position).getEhmMaxHum()) {
               // mTvWet.setBackgroundColor(mTvTemp.getResources().getColor(R.color.colorPrimary));
            } else {
               // mTvWet.setBackgroundColor(mTvTemp.getResources().getColor(R.color.red));
            }*/
        }

        @Override
        public void onComplete(RippleView rippleView) {
            if (getClickListener() != null) {
                getClickListener().OnRecycleItemClick(getPosition());
            }
        }
    }
}
