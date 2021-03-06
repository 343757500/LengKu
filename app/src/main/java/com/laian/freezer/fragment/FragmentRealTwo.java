package com.laian.freezer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laian.freezer.R;

import cn.meiqu.baseproject.baseUi.BaseFragment;

/**
 * Created by Fatel on 2017-8-25. 冷藏车实时数据页面跟别的页面不一样 mRecycleV.setLayoutManager(new GridLayoutManager(getActivity(), 2));改成1
 */
public abstract class FragmentRealTwo extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    public String className = getClass().getName() + Math.random() * 10000;
    private SwipeRefreshLayout mSwipe;
    public RecyclerView mRecycleV;
    public FloatingActionButton mFBtn;

    public abstract RecyclerView.Adapter getAdapter();

    public abstract String getAction();

    public String[] getActions() {
        return null;
    }

    public abstract void requestData();

    public abstract void handleData(String data);

    private void assignViews() {
        setSwipeRefresh(R.id.swipe, this);
        mFBtn = (FloatingActionButton)findViewById(R.id.fab);
        mSwipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        mRecycleV = (RecyclerView) findViewById(R.id.recycleV);
        mRecycleV.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        mRecycleV.setAdapter(getAdapter());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getActions() == null) {
            initReceiver(new String[]{getAction()});
        } else {
            initReceiver(getActions());
        }
        if (contain == null) {
            contain = inflater.inflate(R.layout.f_real, null);
            assignViews();
            initViews();
            setSwipeRefreshing(true);
        }
        return contain;
    }

    @Override
    public void onResume() {
        requestData();
        super.onResume();
    }

    public void initViews(){

    }

    @Override
    public void onHttpHandle(String action, String data) {
        if (getHttpStatus(data)) {
            if (action.equals(getAction())) {
                handleData(data);
            }
        }
    }

    @Override
    public void onRefresh() {
        requestData();
    }

}
