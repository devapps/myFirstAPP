package com.example.manojk.ors.Models;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manojk.ors.R;

import java.util.ArrayList;

/**
 * Created by manojK on 07/11/2016.
 */
public class orsAvailableServicesAdapter  extends RecyclerView.Adapter<orsAvailableServicesAdapter.MyViewHolder>{
    ArrayList<orsAvailableServices> arrayList=new ArrayList<>();
    public orsAvailableServicesAdapter(ArrayList<orsAvailableServices> arrayList)
    {
        this.arrayList =arrayList;
        Log.d("myApp", "orsAvailableServices Adapter  " + arrayList);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_available_services_row_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.TripID.setText(arrayList.get(position).getTripID());
        holder.TripRoute.setText(arrayList.get(position).getTripRoute());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView TripID, TripRoute;
        public MyViewHolder(View itemView) {
            super(itemView);
            TripID = (TextView)itemView.findViewById(R.id.tripID);
            TripRoute = (TextView)itemView.findViewById(R.id.tripRoute);
        }
    }
}