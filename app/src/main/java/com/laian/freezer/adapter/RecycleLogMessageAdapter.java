package com.laian.freezer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.LogMessage;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;

/**
 * Created by Administrator on 2017/8/2.
 */

public class RecycleLogMessageAdapter extends BaseRecycleAdapter {

    private Context mContent;
    ArrayList<LogMessage.RowsBean> ehmList=new ArrayList<>();

    public interface OnItemClickListner {
        public void onItemDel(int position);

        public void onItemEdit(int position);

    }

    public RecycleLogMessageAdapter.OnItemClickListner getOnItemClickListner() {
        return onItemClickListner;
    }
    public void setOnItemClickListner(RecycleLogMessageAdapter.OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    private RecycleLogMessageAdapter.OnItemClickListner onItemClickListner;

    public RecycleLogMessageAdapter(Context mContent,  ArrayList<LogMessage.RowsBean>  ehmList) {
        this.mContent = mContent;
        this.ehmList = ehmList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecycleLogMessageAdapter.Holder(View.inflate(mContent, R.layout.recycle_log_message, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecycleLogMessageAdapter.Holder)holder).instanceView(position);
    }

    @Override
    public int getItemCount() {
        return ehmList.size();
    }

    class Holder extends BaseHolder {
        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        private TextView mTvAddr;
        private TextView mTvName;

        public void assignViews() {
            mTvAddr = (TextView) findViewById(R.id.tv_addr);
            mTvName = (TextView) findViewById(R.id.tv_name);

            mTvAddr.setTextColor(mTvName.getResources().getColor(R.color.black3));

            mTvName.setTextColor(mTvName.getResources().getColor(R.color.black3));


        }


        @Override
        public void instanceView(final int position) {
            if (position % 2 == 0) {
                itemView.setBackgroundColor(mTvName.getResources().getColor(R.color.white));
            } else {
                itemView.setBackgroundColor(mTvName.getResources().getColor(R.color.item_bg));
            }
           if (ehmList!=null){
                mTvAddr.setText("" + ehmList.get(position).getUsername());

            }




        }

    }
}
