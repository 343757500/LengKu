package com.laian.freezer.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laian.freezer.R;
import com.laian.freezer.bean.LogMessage;

import java.util.ArrayList;


/**
 * Created by zsp on 2017/8/2.
 */

public class RecycleLogMessageAdapter2 extends RecyclerView.Adapter<RecycleLogMessageAdapter2.Holder> {
    ArrayList<LogMessage.RowsBean> LogMessage;

    private Context mContent;

    public RecycleLogMessageAdapter2(Context mContent, ArrayList<LogMessage.RowsBean> LogMessage) {
        this.mContent = mContent;
        this.LogMessage = LogMessage;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(mContent).inflate(R.layout.recycle_log_message, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
       holder.tv_addr.setText(LogMessage.get(position).getLogType());
        holder.tv_name.setText(LogMessage.get(position).getModual());
        holder.tv_info.setText(LogMessage.get(position).getDescription());
        holder.tv_man.setText(LogMessage.get(position).getUsername());
        holder.tv_time.setText(LogMessage.get(position).getCreateTime());
    }


    @Override
    public int getItemCount() {
        return LogMessage.size();
    }


    class Holder extends RecyclerView.ViewHolder {
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
    }


}
