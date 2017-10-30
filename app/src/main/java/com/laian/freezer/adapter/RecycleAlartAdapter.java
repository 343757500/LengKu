package com.laian.freezer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.Alart;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;

public class RecycleAlartAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<Alart> Alarts;

    private View mHeaderView;


    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;




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




    public interface OnItemClickListner {
        public void onItemEmail(int position);

        public void onItemMsm(int position);

        public void onItemPhone(int position);

        public void onItemLight(int position);

        public void onItemEdit(int position);

    }

    public OnItemClickListner getOnItemClickListner() {
        return onItemClickListner;
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    private OnItemClickListner onItemClickListner;

    public RecycleAlartAdapter(Context mContent, ArrayList<Alart> Alarts) {
        this.mContent = mContent;
        this.Alarts = Alarts;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new Holder(mHeaderView);
        }else {
            return new Holder(View.inflate(mContent, R.layout.recycle_alart, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position)==TYPE_HEADER){
            return;
        }
        int  pos = getRealPosition(holder);
        ((Holder) holder).instanceView(pos);
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? Alarts.size() : Alarts.size() + 1;
    }

    class Holder extends BaseHolder implements View.OnClickListener {
        private TextView mTvName;
        private TextView mTvTime1;
        private TextView mTvTime2;
        private TextView mTvTime3;
        private TextView mTvEmailStatus;
        private TextView mTvSmsStatus;
        private TextView mTvSoundStatus;
        private TextView mTvPhoneStatus;
        private TextView mTvInterval;
        private TextView mTvEdt;
        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            if (itemView==mHeaderView){
                return;
            }
            mTvName = (TextView) findViewById(R.id.tv_name);
            mTvTime1 = (TextView) findViewById(R.id.tv_time1);
            mTvTime2 = (TextView) findViewById(R.id.tv_time2);
            mTvTime3 = (TextView) findViewById(R.id.tv_time3);
            mTvEmailStatus = (TextView) findViewById(R.id.tv_emailStatus);
            mTvSmsStatus = (TextView) findViewById(R.id.tv_smsStatus);
            mTvSoundStatus = (TextView) findViewById(R.id.tv_soundStatus);
            mTvPhoneStatus = (TextView) findViewById(R.id.tv_phoneStatus);
            mTvInterval = (TextView) findViewById(R.id.tv_interval);
            mTvEdt = (TextView) findViewById(R.id.tv_edt);

           /* mTvName.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvTime1.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvTime2.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvTime3.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvInterval.setTextColor(mTvName.getResources().getColor(R.color.black3));
*/
            mTvEmailStatus.setOnClickListener(this);
            mTvSmsStatus.setOnClickListener(this);
            mTvSoundStatus.setOnClickListener(this);
            mTvPhoneStatus.setOnClickListener(this);
            mTvEdt.setOnClickListener(this);
            mTvEdt.setText("更新");
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
            Alart alart = Alarts.get(position);
            mTvName.setText("" + alart.getName());
            mTvTime1.setText("" + alart.getTimeQuantum1());
            mTvTime2.setText("" + alart.getTimeQuantum2());
            mTvTime3.setText("" + alart.getTimeQuantum3());
            mTvInterval.setText("" + alart.getIntervalTime());
           // mTvEdt.setBackgroundColor(mTvName.getResources().getColor(R.color.colorAccent));
            if (alart.getEMailStatus() == 0) {
                mTvEmailStatus.setText("已关闭");
               // mTvEmailStatus.setBackgroundColor(mTvName.getResources().getColor(R.color.device_list1));
            } else {
                mTvEmailStatus.setText("已开启");
              //  mTvEmailStatus.setBackgroundColor(mTvName.getResources().getColor(R.color.colorPrimaryDark));
            }
            if (alart.getSmsStatus() == 0) {
                mTvSmsStatus.setText("已关闭");
              //  mTvSmsStatus.setBackgroundColor(mTvName.getResources().getColor(R.color.device_list1));
            } else {
                mTvSmsStatus.setText("已开启");
               // mTvSmsStatus.setBackgroundColor(mTvName.getResources().getColor(R.color.colorPrimaryDark));
            }
            if (alart.getSoundLightStatus() == 0) {
                mTvSoundStatus.setText("已关闭");
               // mTvSoundStatus.setBackgroundColor(mTvName.getResources().getColor(R.color.device_list1));
            } else {
                mTvSoundStatus.setText("已开启");
               // mTvSoundStatus.setBackgroundColor(mTvName.getResources().getColor(R.color.colorPrimaryDark));
            }
            if (alart.getPhoneStatus() == 0) {
                mTvPhoneStatus.setText("已关闭");
                //mTvPhoneStatus.setBackgroundColor(mTvName.getResources().getColor(R.color.device_list1));
            } else {
                mTvPhoneStatus.setText("已开启");
               // mTvPhoneStatus.setBackgroundColor(mTvName.getResources().getColor(R.color.colorPrimaryDark));
            }
        }

        @Override
        public void onClick(View v) {
            if (getOnItemClickListner() != null) {
                if (v.getId() == mTvEmailStatus.getId()) {
                    getOnItemClickListner().onItemEmail(getPosition()-1);
                } else if (v.getId() == mTvPhoneStatus.getId()) {
                    getOnItemClickListner().onItemPhone(getPosition()-1);
                } else if (v.getId() == mTvSmsStatus.getId()) {
                    getOnItemClickListner().onItemMsm(getPosition()-1);
                } else if (v.getId() == mTvSoundStatus.getId()) {
                    getOnItemClickListner().onItemLight(getPosition()-1);
                } else if (v.getId() == mTvEdt.getId()) {
                    getOnItemClickListner().onItemEdit(getPosition()-1);
                }
            }
        }
    }
}
