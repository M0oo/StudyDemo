package com.android.cz.studydemo.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.cz.studydemo.R;

/**
 * Created by Administrator on 2017/7/10.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MainItemViewHolder> {
    @Override
    public MainItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main_list_item,parent,false);
        return new MainItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainItemViewHolder holder, int position) {
        holder.tv.setText(InitDatas.init().listDatas.get(position));
        holder.tv.setTag(position);
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    int p = (int) view.getTag();
                     listener.onItemClick(view);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return InitDatas.init().listDatas.size();
    }

    static class MainItemViewHolder extends RecyclerView.ViewHolder{
      public  TextView tv;

        public MainItemViewHolder(View view){
            super(view);
            tv = (TextView) view.findViewById(R.id.main_item_tv);
        }
    }

    //自定义item点击回调接口,类似的还可以定义长点击事件
    interface ItemClickListener{
        void onItemClick(View view);
    }

    private ItemClickListener listener;

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

}
