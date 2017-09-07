package com.laian.freezer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.Freezer;
import com.laian.freezer.bean.TempReal;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;

/**
 * Created by Administrator on 2017/8/4.
 */

public class RecycleFreezerAdapter extends BaseRecycleAdapter {

    private Context mContent;
    private ArrayList<Freezer> freezers;

    public interface OnItemClickListner {
        public void onItemDel(int position);

        public void onItemEdit(int position);

    }

    public OnItemClickListner getOnItemClickListner() {
        return onItemClickListner;
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    private OnItemClickListner onItemClickListner;

    public RecycleFreezerAdapter(Context mContent, ArrayList<Freezer> freezers) {
        this.mContent = mContent;
        this.freezers = freezers;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(View.inflate(mContent, R.layout.recycle_temp_manage, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Holder) holder).instanceView(position);
    }

    @Override
    public int getItemCount() {
        return freezers.size();
    }

    class Holder extends BaseHolder implements View.OnClickListener {
        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        private TextView mTvAddr;
        private TextView mTvLocationName;
        private TextView mTvName;
        private TextView mTvMaxTemp;
        private TextView mTvMinTemp;
        private TextView mTvMaxHum;
        private TextView mTvMinHum;
        private TextView mTvInterval;
        private TextView mTvIp;
        private TextView mTvEdt;
        private TextView mTvDel;

        public void assignViews() {
            mTvAddr = (TextView) findViewById(R.id.tv_addr);
            mTvLocationName = (TextView) findViewById(R.id.tv_locationName);
            mTvName = (TextView) findViewById(R.id.tv_name);
            mTvMaxTemp = (TextView) findViewById(R.id.tv_maxTemp);
            mTvMinTemp = (TextView) findViewById(R.id.tv_minTemp);
            mTvMaxHum = (TextView) findViewById(R.id.tv_maxHum);
            mTvMinHum = (TextView) findViewById(R.id.tv_minHum);
            mTvInterval = (TextView) findViewById(R.id.tv_interval);
            mTvIp = (TextView) findViewById(R.id.tv_ip);
            mTvEdt = (TextView) findViewById(R.id.tv_edt);
            mTvDel = (TextView) findViewById(R.id.tv_del);

            mTvAddr.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvLocationName.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvName.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvIp.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvMaxTemp.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvMinTemp.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvMaxHum.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvMinHum.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvInterval.setTextColor(mTvName.getResources().getColor(R.color.black3));

            mTvEdt.setBackgroundColor(mTvName.getResources().getColor(R.color.colorPrimary));
            mTvDel.setBackgroundColor(mTvName.getResources().getColor(R.color.colorAccent));

            mTvEdt.setOnClickListener(this);
            mTvDel.setOnClickListener(this);
        }


        @Override
        public void instanceView(final int position) {
            if (position % 2 == 0) {
                itemView.setBackgroundColor(mTvName.getResources().getColor(R.color.white));
            } else {
                itemView.setBackgroundColor(mTvName.getResources().getColor(R.color.item_bg));
            }
            Freezer freezer = freezers.get(position);
            mTvAddr.setText("" + freezer.ehmList.get(0).ehmAddress);
            mTvLocationName.setText("" + freezer.ehmList.get(0).deviceLocationPojo.dlName);
            mTvName.setText("" + freezer.ehmList.get(0).ehmName);
            mTvIp.setText("" + freezer.ehmList.get(0).ip);
            mTvMaxTemp.setText("" + freezer.ehmList.get(0).ehmMaxTemp);
            mTvMinTemp.setText("" + freezer.ehmList.get(0).ehmMinTemp);
            mTvMaxHum.setText("" + freezer.ehmList.get(0).ehmMaxHum);
            mTvMinHum.setText("" + freezer.ehmList.get(0).ehmMinHum);
            mTvInterval.setText("" + freezer.ehmList.get(0).ehmInterval);

        }

        @Override
        public void onClick(View v) {
            if (getOnItemClickListner() != null) {
                if (v.getId() == mTvEdt.getId()) {
                    getOnItemClickListner().onItemEdit(getPosition());
                } else if (v.getId() == mTvDel.getId()) {
                    getOnItemClickListner().onItemDel(getPosition());
                }
            }
        }
    }
}
