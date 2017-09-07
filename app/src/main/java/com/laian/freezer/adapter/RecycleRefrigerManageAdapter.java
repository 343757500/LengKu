package com.laian.freezer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.RefrigerReal;
import com.laian.freezer.bean.TempReal;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;


public class RecycleRefrigerManageAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private  ArrayList<RefrigerReal>  TempReals;

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

    public RecycleRefrigerManageAdapter(Context mContent, ArrayList<RefrigerReal>  TempReals) {
        this.mContent = mContent;
        this.TempReals = TempReals;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(View.inflate(mContent, R.layout.recycle_refrigertemp_manage, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Holder) holder).instanceView(position);
    }

    @Override
    public int getItemCount() {
        return TempReals.size();
    }

    class Holder extends BaseHolder implements View.OnClickListener {
        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        private TextView mTvAddr;
        private TextView mTvLocationName;
        private TextView tv_phone;
        private TextView tv_personname;
        private TextView tv_personphone;
        private TextView tv_carNumber;
        private TextView tv_uppertop;
        private TextView tv_upperup;
        private TextView tv_humiditytop;
        private TextView mTvEdt;
        private TextView tv_humidityup;
        private TextView tv_time;
        private TextView mTvDel;
        private TextView mTvStop;

        public void assignViews() {
            mTvAddr = (TextView) findViewById(R.id.tv_addr);
            mTvLocationName = (TextView) findViewById(R.id.tv_locationName);
            tv_phone = (TextView) findViewById(R.id.tv_phone);
            tv_personname = (TextView) findViewById(R.id.tv_personname);
            tv_personphone = (TextView) findViewById(R.id.tv_personphone);
            tv_carNumber = (TextView) findViewById(R.id.tv_carNumber);
            tv_uppertop = (TextView) findViewById(R.id.tv_uppertop);
            tv_upperup = (TextView) findViewById(R.id.tv_upperup);
            tv_humiditytop = (TextView) findViewById(R.id.tv_humiditytop);
            tv_humidityup = (TextView) findViewById(R.id.tv_humidityup);
            tv_time = (TextView) findViewById(R.id.tv_time);

            mTvEdt = (TextView) findViewById(R.id.tv_edt);
            mTvDel = (TextView) findViewById(R.id.tv_del);
            mTvStop = (TextView) findViewById(R.id.tv_stop);


            mTvAddr.setTextColor(tv_phone.getResources().getColor(R.color.black3));
            mTvLocationName.setTextColor(tv_phone.getResources().getColor(R.color.black3));
            tv_phone.setTextColor(tv_phone.getResources().getColor(R.color.black3));
            tv_humiditytop.setTextColor(tv_phone.getResources().getColor(R.color.black3));
            tv_personname.setTextColor(tv_phone.getResources().getColor(R.color.black3));
            tv_personphone.setTextColor(tv_phone.getResources().getColor(R.color.black3));
            tv_carNumber.setTextColor(tv_phone.getResources().getColor(R.color.black3));
            tv_uppertop.setTextColor(tv_phone.getResources().getColor(R.color.black3));
            tv_upperup.setTextColor(tv_phone.getResources().getColor(R.color.black3));

            mTvEdt.setBackgroundColor(tv_phone.getResources().getColor(R.color.colorPrimary));
            mTvDel.setBackgroundColor(tv_phone.getResources().getColor(R.color.colorAccent));
            mTvStop.setBackgroundColor(tv_phone.getResources().getColor(R.color.colorPrimary));

            mTvEdt.setOnClickListener(this);
            mTvDel.setOnClickListener(this);
            mTvStop.setOnClickListener(this);
        }


        @Override
        public void instanceView(final int position) {
            if (position % 2 == 0) {
                itemView.setBackgroundColor(tv_phone.getResources().getColor(R.color.white));
            } else {
                itemView.setBackgroundColor(tv_phone.getResources().getColor(R.color.item_bg));
            }
            RefrigerReal TempReal = TempReals.get(position);
            mTvAddr.setText("" + TempReal.getDevName());
            mTvLocationName.setText("" + TempReal.getDriverPhone());
            tv_phone.setText("" + TempReal.getDevPhone());
           // mTvIp.setText("" + TempReal.getIpPort());
            tv_personname.setText("" + TempReal.getDevName());

            tv_personphone.setText(""+TempReal.getDevPhone());

            tv_carNumber.setText(""+TempReal.getCarNumber());

            tv_uppertop.setText(""+TempReal.getTempMaxValue());

            tv_upperup.setText(""+TempReal.getTempMinValue());

            tv_humiditytop.setText(""+TempReal.getTempMaxValue());

            tv_humidityup.setText(""+TempReal.getHumiMinValue());

            tv_time.setText(""+TempReal.getSaveInterval());


        }

        @Override
        public void onClick(View v) {
            if (getOnItemClickListner() != null) {
                if (v.getId() == mTvEdt.getId()) {
                    getOnItemClickListner().onItemEdit(getPosition());
                } else if (v.getId() == mTvDel.getId()) {
                    getOnItemClickListner().onItemDel(getPosition());
                }else if(v.getId()==mTvStop.getId()){

                }
            }
        }
    }
}
