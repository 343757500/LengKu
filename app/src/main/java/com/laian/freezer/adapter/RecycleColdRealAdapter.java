package com.laian.freezer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.EHum;
import com.laian.freezer.bean.Freezer;
import com.laian.freezer.bean.Freezers;

import java.util.ArrayList;
import java.util.List;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;
import cn.meiqu.baseproject.baseRecycle.BaseOnRecycleClickListener;
import cn.meiqu.baseproject.view.RippleView;

/**
 * Created by zsp on 2017/8/19.
 */

public class RecycleColdRealAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<Freezers> tempReals;
    private ArrayList<Freezers.EhmListBean> ehmList;

    public RecycleColdRealAdapter(Context mContent, ArrayList<Freezers.EhmListBean> ehmList) {

        this.mContent = mContent;
        this.ehmList = ehmList;

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
        return new RecycleColdRealAdapter.Holder(View.inflate(mContent, R.layout.recycle_cold_real, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecycleColdRealAdapter.Holder) holder).instanceView(position);
    }

    @Override
    public int getItemCount() {
        return ehmList.size();
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
          //  mTvWet = (TextView) findViewById(R.id.tv_wet);
        }

        @Override
        public void instanceView(final int position) {

            if (ehmList.size()>0) {
                mTvName.setText(ehmList.get(position).getEhmName() + "");
                mTvTemp.setText(ehmList.get(position).getEhmTemp() + "℃");
               // mTvWet.setText(ehmList.get(position).getEhmHum() + "%");
                if (ehmList.get(position).getEhmTemp() >= ehmList.get(position).getEhmMinTemp() && ehmList.get(position).getEhmTemp() <= ehmList.get(position).getEhmMaxTemp()) {
                } else {
                   /* mTvTemp.setBackgroundColor(mTvTemp.getResources().getColor(R.color.red));*/
                    mTvTemp.setTextColor(android.graphics.Color.RED);
                }

                if (ehmList.get(position).getEhmHum() >= ehmList.get(position).getEhmMinHum() && ehmList.get(position).getEhmHum() <= ehmList.get(position).getEhmMaxHum()) {
                 //   mTvWet.setBackgroundColor(mTvTemp.getResources().getColor(R.color.colorPrimary));
                } else {
               //     mTvWet.setBackgroundColor(mTvTemp.getResources().getColor(R.color.red));
                   // mTvWet.setTextColor(android.graphics.Color.RED);
                }
            }else{

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
