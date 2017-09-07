package com.laian.freezer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.ColdAlart;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;

/**
 * Created by zsp on 2017/8/22.
 */

public class RecycleColdManagerAdapter extends BaseRecycleAdapter {
    private Context mContent;
    ArrayList<ColdAlart.EhmListBean> ehmList=new ArrayList<>();

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

    public RecycleColdManagerAdapter(Context mContent,  ArrayList<ColdAlart.EhmListBean> ehmList) {
        this.mContent = mContent;
        this.ehmList = ehmList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(View.inflate(mContent, R.layout.recycle_temp_manage, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Holder)holder).instanceView(position);
    }

    @Override
    public int getItemCount() {
       return ehmList.size();
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
            if (ehmList!=null){
                mTvAddr.setText("" + ehmList.get(position).getEhmAddress());
            String dlName = ehmList.get(position).getDeviceLocationPojo().getDlName();
            mTvLocationName.setText("" + dlName);
            mTvName.setText("" + ehmList.get(position).getEhmName());
            mTvIp.setText("" + ehmList.get(position).getIpPort());
            mTvMaxTemp.setText("" + ehmList.get(position).getEhmMaxTemp());
            mTvMinTemp.setText("" + ehmList.get(position).getEhmMinTemp());
            mTvMaxHum.setText("" + ehmList.get(position).getEhmMaxHum());
            mTvMinHum.setText("" + ehmList.get(position).getEhmMinHum());
            mTvInterval.setText("" + ehmList.get(position).getEhmInterval());
            }




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
