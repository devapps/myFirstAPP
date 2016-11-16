package com.example.manojk.ors.Models;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manojk.ors.R;

import java.util.ArrayList;

/**
 * Created by manojK on 16/11/2016.
 */
public class orsTripLayoutAdapter extends RecyclerView.Adapter<orsTripLayoutAdapter.MyViewHolder> {
    ArrayList<orsTripLayout> arrayList = new ArrayList<>();

    public orsTripLayoutAdapter(ArrayList<orsTripLayout> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_trip_layout_row_item, parent, false);
        view.getBackground().setAlpha(160);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.Latout_c1.setText(arrayList.get(position).getLayout_c1());
        holder.Latout_c2.setText(arrayList.get(position).getLayout_c2());
        holder.Latout_c3.setText(arrayList.get(position).getLayout_c3());
        holder.Latout_c4.setText(arrayList.get(position).getLayout_c4());
        holder.Latout_c5.setText(arrayList.get(position).getLayout_c5());
        holder.Latout_c6.setText(arrayList.get(position).getLayout_c6());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Latout_c1, Latout_c2, Latout_c3, Latout_c4, Latout_c5, Latout_c6;

        public MyViewHolder(View itemView) {
            super(itemView);
            Latout_c1 = (TextView) itemView.findViewById(R.id.layout_c1);
            Latout_c2 = (TextView) itemView.findViewById(R.id.layout_c2);
            Latout_c3 = (TextView) itemView.findViewById(R.id.layout_c3);
            Latout_c4 = (TextView) itemView.findViewById(R.id.layout_c4);
            Latout_c5 = (TextView) itemView.findViewById(R.id.layout_c5);
            Latout_c6 = (TextView) itemView.findViewById(R.id.layout_c6);
        }
    }
}