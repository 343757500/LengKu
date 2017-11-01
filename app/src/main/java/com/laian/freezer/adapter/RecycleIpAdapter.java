package com.laian.freezer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.Ip;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;


public class RecycleIpAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<Ip> Ips;



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
        public void onItemStatus(int position);

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

    public RecycleIpAdapter(Context mContent, ArrayList<Ip> Ips) {
        this.mContent = mContent;
        this.Ips = Ips;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new Holder(mHeaderView);
        }else {
            return new Holder(View.inflate(mContent, R.layout.recycle_ip, null));
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
        return mHeaderView == null ? Ips.size() : Ips.size() + 1;
    }

    class Holder extends BaseHolder implements View.OnClickListener {
        private TextView mTvName;
        private TextView mTvIp;
        private TextView mTvPort;
        private TextView mTvStatus;
        private TextView mTvAction;
        private TextView mTvEdt;
        private TextView mTvDel;
        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            if (itemView==mHeaderView){
                return;
            }
            mTvName = (TextView) findViewById(R.id.tv_name);
            mTvIp = (TextView) findViewById(R.id.tv_ip);
            mTvPort = (TextView) findViewById(R.id.tv_port);
            mTvStatus = (TextView) findViewById(R.id.tv_status);
            mTvAction = (TextView) findViewById(R.id.tv_action);
            mTvEdt = (TextView) findViewById(R.id.tv_edt);
            mTvDel = (TextView) findViewById(R.id.tv_del);

            mTvName.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvIp.setTextColor(mTvIp.getResources().getColor(R.color.black3));
            mTvPort.setTextColor(mTvPort.getResources().getColor(R.color.black3));

            mTvAction.setOnClickListener(this);
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
            Ip ip = Ips.get(position);
            mTvName.setText("" + ip.getDiName());
            mTvIp.setText("" + ip.getDiAddress());
            mTvPort.setText("" + ip.getDiPort());
           /* mTvAction.setBackgroundColor(mTvName.getResources().getColor(R.color.colorPrimary));
            mTvEdt.setBackgroundColor(mTvName.getResources().getColor(R.color.colorPrimary));
            mTvDel.setBackgroundColor(mTvName.getResources().getColor(R.color.colorAccent));*/

            if (ip.getDiIsConnect() == 0) {
                mTvStatus.setText("" + "通信中断");
                mTvStatus.setTextColor(mTvName.getResources().getColor(R.color.selorgerds));
            } else {
                mTvStatus.setText("" + "通信正常");
                mTvStatus.setTextColor(mTvName.getResources().getColor(R.color.black3));
            }
            if (ip.getDiOperate() == 0) {
                mTvAction.setText("启动");
            } else {
                mTvAction.setText("断开");
            }
        }

        @Override
        public void onClick(View v) {
            if (getOnItemClickListner() != null) {
                if (v.getId() == mTvAction.getId()) {
                    getOnItemClickListner().onItemStatus(getPosition()-1);
                } else if (v.getId() == mTvEdt.getId()) {
                    getOnItemClickListner().onItemEdit(getPosition()-1);
                } else if (v.getId() == mTvDel.getId()) {
                    getOnItemClickListner().onItemDel(getPosition()-1);
                }
            }
        }
    }
}
