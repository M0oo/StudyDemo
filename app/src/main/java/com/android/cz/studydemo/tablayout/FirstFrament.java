package com.android.cz.studydemo.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.cz.studydemo.R;

/**
 * Created by Administrator on 2017/7/11.
 */
public class FirstFrament extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_main_list_item,null);
        TextView tv = (TextView) view.findViewById(R.id.main_item_tv);
        Bundle bundle = getArguments();
        if(bundle != null){
            tv.setText(bundle.getString("content"));
        }
        return view;
    }

}
