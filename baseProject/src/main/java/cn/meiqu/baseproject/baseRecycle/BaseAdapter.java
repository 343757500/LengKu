package cn.meiqu.baseproject.baseRecycle;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Fatel on 16-2-16.
 */
public abstract class BaseAdapter extends RecyclerView.Adapter{
    private BaseOnRecycleClickListener listener;

    public BaseOnRecycleClickListener getClickListener() {
        return listener;
    }

    public void setClickListener(BaseOnRecycleClickListener listener) {
        this.listener = listener;
    }
}
