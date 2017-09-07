package com.laian.freezer.adapter;

import android.content.Context;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.TempAlart;
import java.util.ArrayList;
import cn.meiqu.baseproject.adapter.BaseRecycleHolder;
import cn.meiqu.baseproject.adapter.CommonAdapter;

/**
 * Created by Administrator on 2017/8/2.
 */

public class RecycleTempAlertAdapter extends CommonAdapter<TempAlart> {

    private ArrayList<TempAlart> mList;
    private Context mContext;

    public RecycleTempAlertAdapter(Context context, ArrayList<TempAlart> list){
        super(context,list);
        mList = list;
        mContext = context;
    }

    @Override
    public void instanceOfViewHolder(BaseRecycleHolder holder, TempAlart tempAlart, int position) {
         TextView mTvAddr = (TextView) holder.getView(R.id.tv_addr);
         TextView mTvName = (TextView) holder.getView(R.id.tv_name);
         TextView mTvInfo = (TextView) holder.getView(R.id.tv_info);
         TextView mTvTime = (TextView) holder.getView(R.id.tv_time);

         mTvAddr.setTextColor(mTvAddr.getResources().getColor(R.color.black3));
         mTvName.setTextColor(mTvAddr.getResources().getColor(R.color.black3));
         mTvInfo.setTextColor(mTvAddr.getResources().getColor(R.color.black3));
         mTvTime.setTextColor(mTvAddr.getResources().getColor(R.color.black3));

        if (position % 2 == 0) {
            holder.getItemView().setBackgroundColor(mTvAddr.getResources().getColor(R.color.white));
        } else {
            holder.getItemView().setBackgroundColor(mTvAddr.getResources().getColor(R.color.item_bg));
        }
        TempAlart TempAlart = mList.get(position);
        mTvAddr.setText(TempAlart.getEhaLocation() + "");
        mTvName.setText(TempAlart.getEhaName() + "");
        mTvInfo.setText(TempAlart.getEhaInfo() + "");
        mTvTime.setText(TempAlart.getEhaTime() + "");

    }

    @Override
    public int getItemLayoutId() {
        return R.layout.recycle_alart_type1;
    }

    @Override
    public int getItemOtherLayoutId() {
        return 0;
    }
}
