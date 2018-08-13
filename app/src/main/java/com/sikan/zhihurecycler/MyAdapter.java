package com.sikan.zhihurecycler;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator
 *
 * @time 2018/8/13
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Data> datas;


    public MyAdapter(List<Data> datas){
        this.datas=datas;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout, parent, false);
        return new ItemViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Data data=datas.get(position);
        ItemViewHolder holder1=(ItemViewHolder)holder;

        //加入每5条信息就有一条这样的广告
        if(position!=0 && position%5==0){
            holder1.titleTv.setText("");
            holder1.msgTv.setText("");
            holder1.mLayout.setBackgroundColor(0X00000000);
            holder1.ggTv.setVisibility(View.VISIBLE);
        }else{
            holder1.titleTv.setText(data.title);
            holder1.msgTv.setText(data.msg);
            holder1.mLayout.setBackgroundColor(0Xffffffff);
            holder1.ggTv.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTv;
        private TextView msgTv;
        private TextView ggTv;
        private CardView mLayout;

        public ItemViewHolder(View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.title_tv);
            msgTv = itemView.findViewById(R.id.msg_tv);
            ggTv = itemView.findViewById(R.id.gg_tv);
            mLayout=itemView.findViewById(R.id.layout);
        }
    }
}
