package com.laian.freezer.fragment.system.manage;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.laian.freezer.R;
import com.laian.freezer.adapter.RecycleLogMessageAdapter;
import com.laian.freezer.adapter.RecycleLogMessageAdapter2;
import com.laian.freezer.bean.LogMessage;
import com.laian.freezer.bean.Pagecount;
import com.laian.freezer.bean.Pager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.baseUi.BaseFragment;
import cn.meiqu.baseproject.dao.SettingDao;
import cn.meiqu.baseproject.httpGet.HttpGetController;
import cn.meiqu.baseproject.util.LogUtil;
import cn.meiqu.baseproject.util.TimeUtil;
import cn.meiqu.baseproject.view.superrecyclerview.SuperRecyclerView;

import static com.laian.freezer.R.id.tv_start;

/**
 * Created by zsp on 2017/9/13.
 */

public class FragmentLogmessage2 extends BaseFragment implements RecycleLogMessageAdapter.ItemClickListener,View.OnClickListener {
    Pager pager = new Pager();
    String className = getClass().getName();
    String action_getData = className + API.requestLogMessageUrl;
    String action_update = className + API.requestLogMessageUrl;

    LogMessage logMessage = new LogMessage();
    ArrayList<LogMessage.RowsBean> TempAlarts = new ArrayList<>();
    RecycleLogMessageAdapter2 adapter;
    @BindView(tv_start)
    EditText tvStart;
    @BindView(R.id.tv_end)
    EditText tvEnd;
    @BindView(R.id.tv_range)
    EditText tvRange;
    @BindView(R.id.tv_device)
    EditText tvDevice;
    @BindView(R.id.recycleV)
    SuperRecyclerView recycleV;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.fragment_containId)
    FrameLayout fragmentContainId;
    @BindView(R.id.lin_top)
    LinearLayout linTop;



    String start = "";
    String end = "";
    String modual="";
    String logtype="";
    long startStamp = 0;
    long endStamp = 0;
    String deviceId = "0";

    String timeRange[] = {"全部", "登入事件", "登出事件", "添加事件","更新事件","删除事件","系统事件"};
    int currentTimeRange;

    String logType[] ={"环境监控","系统管理"};

    int currentLog;
    private Object[] objects;
    private String ehmListBeanStr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_alart_log, null);
        ButterKnife.bind(this, view);
        initReceiver(new String[]{action_getData, action_update});
        adapter = new RecycleLogMessageAdapter2(getActivity(), TempAlarts);
       // adapter.setOnItemClickListner(this);
        recycleV.setAdapter(adapter);
        recycleV.setLayoutManager(new LinearLayoutManager(getActivity()));

        tvStart.setOnClickListener(this);
        tvEnd.setOnClickListener(this);
        tvRange.setOnClickListener(this);
        tvDevice.setOnClickListener(this);

        //想动态添加logType数据，但是对话框AlertDialog.Builder(getActivity()).setSingleChoiceItems(logType, currentLog, new中第一个参数必须是String logType[] ={"环境变量","系统管理"};形式
       /* Set title = SettingDao.getInstance().getStringArray("title");
        objects = title.toArray();

        for(int i=0;i<objects.length;i++) {
            //方式一
            // logType[i]=objects[i].toString();


        }*/

            return view;

    }


    @Override
    public void onHttpHandle(String action, String data) {
        if (action.equals(action_getData)) {
            handleGetUpdateDate(data);
        }if (action.equals(action_update)){
            handleGetUpdateDate(data);
        }
    }

    private void handleGetUpdateDate(String data) {
        logMessage = new Gson().fromJson(data, LogMessage.class);
        if (logMessage != null) {

            TempAlarts.clear();
            TempAlarts.addAll(logMessage.getRows());
            adapter.notifyDataSetChanged();
        }
    }




    @Override
    public void onResume() {
        super.onResume();
        // showProgressDialog();
        pager.setPage("1");
        pager.setPageCapacity("100");
        ehmListBeanStr = new Gson().toJson(pager);
        HttpGetController.getInstance().getLogMessage(className, "pager", ehmListBeanStr);
    }

    @Override
    public void OnItemClick(View view, int position) {

    }

    @Override
    public void onClick(View v) {
         if (v.getId() == tvStart.getId()) {
            showStart();
        } else if (v.getId() == tvEnd.getId()) {
            showEnd();
        } else if (v.getId() == tvDevice.getId()) {
            showDevice();
        } else if (v.getId() == tvRange.getId()) {
            showRange();
        }

    }

    private void showRange() {
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setSingleChoiceItems(timeRange, currentTimeRange, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which != currentTimeRange) {
                    currentTimeRange = which;
                    dialog.dismiss();
                    setSelectRange();
                    request();
                }
            }
        }).create();
        alertDialog.show();
    }

    private void showDevice() {

        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setSingleChoiceItems(logType, currentLog, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which != currentLog) {
                    currentLog = which;
                    dialog.dismiss();
                   setSelectDevice();
                    request();
                }
            }
        }).create();
        alertDialog.show();
    }

    private void requestDevice() {

    }

    private void setSelectDevice() {

        tvDevice.setText(logType[currentLog]);
        modual=logType[currentLog];
        requestRange();
    }

    private void setSelectRange() {
        tvRange.setText(timeRange[currentTimeRange]);
        logtype=timeRange[currentTimeRange];
        requestRange();
    }

    private void requestRange() {

    }

    private void showEnd() {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(endStamp);
        int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog
                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.setTimeInMillis(0);
                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                endStamp = calendar.getTimeInMillis();
                onSelectTime();
            }
        }, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.getDatePicker().setMinDate(startStamp);
        datePickerDialog.show();
    }

    private void showStart() {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(startStamp);
        int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog
                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.setTimeInMillis(0);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                startStamp = calendar.getTimeInMillis();
                if (startStamp > endStamp) {
                    endStamp = System.currentTimeMillis();
                }
                onSelectTime();
            }
        }, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }


    private void onSelectTime() {
        start = TimeUtil.getTime(startStamp);
        end = TimeUtil.getTime(endStamp);
        tvStart.setText("" + TimeUtil.getTime(startStamp, TimeUtil.DATE_FORMAT_DATE));
        tvEnd.setText("" + TimeUtil.getTime(endStamp, TimeUtil.DATE_FORMAT_DATE)+1);
        request();
    }


    private void request() {
       // requestData(start, end, deviceId，modual,keyword);
        Pagecount pagecount=new Pagecount();
        pagecount.setEndTime(end);
        pagecount.setStartTime(start);
        pagecount.setLogType(logtype);
        pagecount.setKeyword("");
        pagecount.setModual(modual);
        String EhmListBeanStr = new Gson().toJson(pagecount);
        HttpGetController.getInstance().getQuestLogMessage(className,"pager",ehmListBeanStr,"params",EhmListBeanStr);
    }


}


