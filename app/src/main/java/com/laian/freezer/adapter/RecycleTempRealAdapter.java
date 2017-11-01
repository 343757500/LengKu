package com.laian.freezer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.TempReal;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.adapter.BaseRecycleHolder;
import cn.meiqu.baseproject.adapter.CommonAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;
import cn.meiqu.baseproject.baseRecycle.BaseOnRecycleClickListener;
import cn.meiqu.baseproject.view.RippleView;

/**
 * Created by Administrator on 2017/8/2.
 */

public class RecycleTempRealAdapter extends BaseRecycleAdapter {

    private Context mContent;
    private ArrayList<TempReal> tempReals;

    public RecycleTempRealAdapter(Context mContent, ArrayList<TempReal> tempReals) {

        this.mContent = mContent;
        this.tempReals = tempReals;

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
        return new Holder(View.inflate(mContent, R.layout.recycle_temp_real, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Holder) holder).instanceView(position);
    }

    @Override
    public int getItemCount() {
        return tempReals.size();
    }


    class Holder extends BaseHolder implements RippleView.OnRippleCompleteListener {
        public Holder(View itemView) {
            super(itemView);
        }

        private TextView mTvName;
        private TextView mTvTemp;
        private TextView mTvWet;

        public void assignViews() {
            mTvName = (TextView) findViewById(R.id.tv_name);
            mTvTemp = (TextView) findViewById(R.id.tv_temp);
            mTvWet = (TextView) findViewById(R.id.tv_wet);
        }

        @Override
        public void instanceView(final int position) {
            TempReal tempReal = tempReals.get(position);
            mTvName.setText(tempReal.getEhmName() + "");
            mTvTemp.setText(tempReal.getEhmTemp() + "℃");
            mTvWet.setText(tempReal.getEhmHum() + "%");
            if (tempReal.getEhmTemp() >= tempReal.getEhmMinTemp() && tempReal.getEhmTemp() <= tempReal.getEhmMaxTemp()) {
              //  mTvTemp.setBackgroundColor(mTvTemp.getResources().getColor(R.color.colorPrimary));
            } else {
              //  mTvTemp.setBackgroundColor(mTvTemp.getResources().getColor(R.color.red));
                mTvTemp.setTextColor(android.graphics.Color.RED);
            }

            if (tempReal.getEhmHum() >= tempReal.getEhmMinHum() && tempReal.getEhmTemp() <= tempReal.getEhmMaxHum()) {
               // mTvWet.setBackgroundColor(mTvTemp.getResources().getColor(R.color.colorPrimary));

            } else {
               // mTvWet.setBackgroundColor(mTvTemp.getResources().getColor(R.color.red));
                mTvWet.setTextColor(android.graphics.Color.RED);
            }
        }

        @Override
        public void onComplete(RippleView rippleView) {
            if (getClickListener() != null) {
                getClickListener().OnRecycleItemClick(getPosition());
            }
        }
    }
    }
