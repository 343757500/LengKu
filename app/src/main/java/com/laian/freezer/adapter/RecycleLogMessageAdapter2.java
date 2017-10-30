package com.laian.freezer.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.Location;
import com.laian.freezer.bean.LogMessage;

import java.util.ArrayList;

import cn.meiqu.baseproject.adapter.BaseRecycleAdapter;
import cn.meiqu.baseproject.baseRecycle.BaseHolder;


/**
 * Created by zsp on 2017/8/2.
 */

public class RecycleLogMessageAdapter2 extends BaseRecycleAdapter {
    ArrayList<LogMessage.RowsBean> LogMessage;

    private Context mContent;



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







    public RecycleLogMessageAdapter2(Context mContent, ArrayList<LogMessage.RowsBean> LogMessage) {
        this.mContent = mContent;
        this.LogMessage = LogMessage;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

//        View inflate = LayoutInflater.from(mContent).inflate(R.layout.recycle_log_message, parent, false);
//        Holder holder = new Holder(inflate);
//        return holder;


        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new Holder(mHeaderView);
        }else {
           // View.inflate(mContent, R.layout.recycle_log_message, null)
            return new Holder(LayoutInflater.from(mContent).inflate(R.layout.recycle_log_message, parent, false));
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
      //  return LogMessage.size();
        return mHeaderView == null ? LogMessage.size() : LogMessage.size() + 1;
    }


    class Holder extends BaseHolder {
        TextView tv_addr;
        TextView tv_name;
        TextView tv_info;
        TextView tv_man;
        TextView tv_time;

        public Holder(View itemView) {
            super(itemView);
            tv_addr = (TextView) itemView.findViewById(R.id.tv_addr);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_info = (TextView) itemView.findViewById(R.id.tv_info);
            tv_man = (TextView) itemView.findViewById(R.id.tv_man);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);


        }

        @Override
        public void instanceView(int position) {
            if (position % 2 == 0) {
                itemView.setBackgroundColor(tv_addr.getResources().getColor(R.color.white));
            } else {
                itemView.setBackgroundColor(tv_addr.getResources().getColor(R.color.item_bg));
            }
          /*  Location location = Locations.get(position);
            mTvId.setText("" + location.getDlId());
            mTvName.setText("" + location.getDlName());
            mTvEdt.setText("更新");*/

            tv_addr.setText(LogMessage.get(position).getLogType());
            tv_name.setText(LogMessage.get(position).getModual());
            tv_info.setText(LogMessage.get(position).getDescription());
            tv_man.setText(LogMessage.get(position).getUsername());
            tv_time.setText(LogMessage.get(position).getCreateTime());
        }
    }


}
