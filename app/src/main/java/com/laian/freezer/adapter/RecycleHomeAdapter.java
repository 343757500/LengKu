package com.laian.freezer.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.HomePage;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleHolder;
import cn.meiqu.baseproject.adapter.CommonAdapter;

/**
 * Created by Administrator on 2017/7/28.
 */

public class RecycleHomeAdapter extends CommonAdapter<HomePage> {

    private ArrayList<HomePage> mList = new ArrayList<>();
    private Context mContext;

    public RecycleHomeAdapter(Context context,ArrayList<HomePage> list){
        super(context,list);
        mContext = context;
        mList = list;
    }
    @Override
    public void instanceOfViewHolder(BaseRecycleHolder holder, HomePage homePage, int position) {
        View itemView = holder.getItemView();
        itemView.setAlpha(0.0f);
        itemView.setScaleX(0.0f);
        itemView.animate().alpha(1.0f).scaleX(1.0f).setDuration(100 * position).start();
        String name = mList.get(position).getName();
        if (name.length() > 3) {
            name = name.substring(0, 2) + "\n" + name.substring(2, name.length());
        }
        ((TextView)holder.getView(R.id.tv)).setText(name);
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.recycle_home;
    }

    @Override
    public int getItemOtherLayoutId() {
        return 0;
    }
}
