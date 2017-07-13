package com.android.cz.studydemo.main;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public class InitDatas {
    public static SparseArray<String> datas = new SparseArray();
    public static List<String> listDatas = new ArrayList<>();

    private InitDatas(){initdatas();}

    static class Inner{
        private static InitDatas init = new InitDatas();
    }

    public static InitDatas init(){
        return Inner.init;
    }

    private void initdatas(){
        datas.put(0,"TabLayout");
        datas.put(1,"Material");
        datas.put(2,"Service");
        datas.put(3,"BroadcastReceiver");
        datas.put(4,"Notifacation");
        datas.put(5,"Weixin");
        datas.put(6,"TintDrawable");
        datas.put(7,"Activity");
        datas.put(8,"Activity");
        datas.put(9,"Activity");
        datas.put(10,"Activity");
        datas.put(11,"Activity");
        datas.put(12,"Activity");

        int size = datas.size();
        for (int i = 0; i <size ; i++) {
            listDatas.add(datas.get(i));
        }
    }

}
