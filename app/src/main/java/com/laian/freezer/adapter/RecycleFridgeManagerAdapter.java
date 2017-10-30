package com.laian.freezer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.ColdAlart;
import com.laian.freezer.bean.FridgeAlart;
import com.laian.freezer.bean.FridgeReal;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;

/**
 * Created by Administrator on 2017/8/24.
 */

public class RecycleFridgeManagerAdapter extends BaseRecycleAdapter {
    private Context mContent;
    ArrayList<FridgeAlart.EhmListBean> ehmList=new ArrayList<>();

    private View mHeaderView;


    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;

    public interface OnItemClickListner {
        public void onItemDel(int position);

        public void onItemEdit(int position);

    }


    @Override
    public int getItemViewType(int position) {
        if(mHeaderView == null) return TYPE_NORMAL;
        if(position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }



    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }











    public RecycleFridgeManagerAdapter.OnItemClickListner getOnItemClickListner() {
        return onItemClickListner;
    }
    public void setOnItemClickListner(RecycleFridgeManagerAdapter.OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    private RecycleFridgeManagerAdapter.OnItemClickListner onItemClickListner;

    public RecycleFridgeManagerAdapter(Context mContent,  ArrayList<FridgeAlart.EhmListBean> ehmList) {
        this.mContent = mContent;
        this.ehmList = ehmList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new Holder(mHeaderView);
        }else {
            return new Holder(View.inflate(mContent, R.layout.recycle_cold_manage, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position)==TYPE_HEADER){
            return;
        }
        int  pos = getRealPosition(holder);
        ((RecycleFridgeManagerAdapter.Holder) holder).instanceView(pos);
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }


    @Override
    public int getItemCount() {
        return mHeaderView == null ? ehmList.size() : ehmList.size() + 1;
    }

    class Holder extends BaseHolder implements View.OnClickListener {

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
        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            if (itemView==mHeaderView){
                return;
            }
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


            mTvEdt.setOnClickListener(this);
            mTvDel.setOnClickListener(this);
        }



        public void assignViews() {

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
                mTvMaxHum.setText("" + ehmList.get(position).getEhmId());
                mTvMinHum.setText("" + ehmList.get(position).getGallery());
                mTvInterval.setText("" + ehmList.get(position).getEhmInterval());
            }




        }

        @Override
        public void onClick(View v) {
            if (getOnItemClickListner() != null) {
                if (v.getId() == mTvEdt.getId()) {
                    getOnItemClickListner().onItemEdit(getPosition()-1);
                } else if (v.getId() == mTvDel.getId()) {
                    getOnItemClickListner().onItemDel(getPosition()-1);
                }
            }
        }
    }
}
