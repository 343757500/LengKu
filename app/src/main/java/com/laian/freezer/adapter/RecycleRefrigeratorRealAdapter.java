package com.laian.freezer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.Freezers;
import com.laian.freezer.bean.RefrigeratorReal;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;
import cn.meiqu.baseproject.baseRecycle.BaseOnRecycleClickListener;
import cn.meiqu.baseproject.view.RippleView;

/**
 * Created by zsp on 2017/8/19.
 */

public class RecycleRefrigeratorRealAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<RefrigeratorReal.EhmListBean> ehmList;

    public RecycleRefrigeratorRealAdapter(Context mContent, ArrayList<RefrigeratorReal.EhmListBean> ehmList) {

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
        return new RecycleRefrigeratorRealAdapter.Holder(View.inflate(mContent, R.layout.recycle_refrigerator_real, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecycleRefrigeratorRealAdapter.Holder) holder).instanceView(position);
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
                    mTvTemp.setBackgroundColor(mTvTemp.getResources().getColor(R.color.colorPrimary));
                } else {
                    mTvTemp.setBackgroundColor(mTvTemp.getResources().getColor(R.color.red));
                }

                if (ehmList.get(position).getEhmHum() >= ehmList.get(position).getEhmMinHum() && ehmList.get(position).getEhmHum() <= ehmList.get(position).getEhmMaxHum()) {
                 //   mTvWet.setBackgroundColor(mTvTemp.getResources().getColor(R.color.colorPrimary));
                } else {
               //     mTvWet.setBackgroundColor(mTvTemp.getResources().getColor(R.color.red));
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
