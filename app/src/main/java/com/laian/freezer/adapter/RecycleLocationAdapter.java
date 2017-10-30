package com.laian.freezer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.Location;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;
import cn.meiqu.baseproject.view.RippleView;


public class RecycleLocationAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<Location> Locations;

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















    public OnItemClickListner getOnItemClickListner() {
        return onItemClickListner;
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    private OnItemClickListner onItemClickListner;

    public RecycleLocationAdapter(Context mContent, ArrayList<Location> Locations) {
        this.mContent = mContent;
        this.Locations = Locations;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new Holder(mHeaderView);
        }else {
            return new Holder(View.inflate(mContent, R.layout.recycle_location_message, null));
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
        return mHeaderView == null ? Locations.size() : Locations.size() + 1;
    }

    class Holder extends BaseHolder implements  View.OnClickListener {

        private TextView mTvId;
        private TextView mTvName;
        private TextView mTvEdt;
        private TextView mTvDel;
        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            if (itemView==mHeaderView){
                return;
            }
            mTvId = (TextView) findViewById(R.id.tv_id);
            mTvName = (TextView) findViewById(R.id.tv_name);
            mTvEdt = (TextView) findViewById(R.id.tv_edt);
            mTvDel = (TextView) findViewById(R.id.tv_del);

            mTvId.setTextColor(mTvId.getResources().getColor(R.color.black3));
            mTvName.setTextColor(mTvId.getResources().getColor(R.color.black3));

            mTvEdt.setOnClickListener(this);
            mTvDel.setOnClickListener(this);
        }




        public void assignViews() {

        }


        @Override
        public void instanceView(final int position) {
            if (position % 2 == 0) {
                itemView.setBackgroundColor(mTvId.getResources().getColor(R.color.white));
            } else {
                itemView.setBackgroundColor(mTvId.getResources().getColor(R.color.item_bg));
            }
            Location location = Locations.get(position);
            mTvId.setText("" + location.getDlId());
            mTvName.setText("" + location.getDlName());
            mTvEdt.setText("更新");
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
