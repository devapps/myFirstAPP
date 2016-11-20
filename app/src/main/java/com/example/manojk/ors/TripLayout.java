package com.example.manojk.ors;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.manojk.ors.Models.*;
import com.example.manojk.ors.R;

import java.util.ArrayList;

public class TripLayout extends AppCompatActivity implements orsTripLayout_iResult, orsTripLayoutAdapter.ItemClickCallback {
    RecyclerView recyclerView;
    //RecyclerView.Adapter adapter;
    orsTripLayoutAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<orsTripLayout> arList = new ArrayList<>();
    int seats_selected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        Intent i = getIntent();
        orsTripLayoutSearch orsTLS = i.getExtras().getParcelable("orsTripLayoutSearch");
        orsTripLayoutTask orsTLT = new orsTripLayoutTask(TripLayout.this);
        orsTLT.getTripLayout(orsTLS);
    }

    @Override
    public void notifyError(VolleyError error) {
        //Log.d("myApp", "orsTripLayout Adapter  -response  " + error.printStackTrace());
        error.printStackTrace();
    }

    @Override
    public void notifySuccess(ArrayList<orsTripLayout> orsTL) {
        //Log.d("myApp", "ors_availableServices TASK -response  " + orsAS);
        adapter = new orsTripLayoutAdapter(orsTL);
        recyclerView.setAdapter(adapter);
        adapter.setItemClickCallback(this);
        arList = orsTL;
    }

    @Override
    public void onLayout_c1_Click(View view, int p) {
        if (seats_selected>=4 && !arList.get(p).isLayout_c1_Selected())
        {
            Toast.makeText(TripLayout.this, "Maximum FOUR seats can be selected.", Toast.LENGTH_SHORT).show();
            return;
        }
        //Log.d("myAPP", "Name Click at " +p + "  " + view.getId());
        if (arList.get(p).isLayout_c1_Online() && !arList.get(p).isLayout_c1_Reserved() ) {
            if (arList.get(p).isLayout_c1_Selected()) {
                view.setBackgroundResource(R.drawable.bs_avl);
                arList.get(p).setLayout_c1_Selected(false);
                seats_selected--;
            }else
            {
                view.setBackgroundResource(R.drawable.bs_sel);
                arList.get(p).setLayout_c1_Selected(true);
                seats_selected++;
            }
        }
    }

    @Override
    public void onLayout_c2_Click(View view, int p) {
        if (seats_selected>=4 && !arList.get(p).isLayout_c2_Selected())
        {
            Toast.makeText(TripLayout.this, "Maximum FOUR seats can be selected.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (arList.get(p).isLayout_c2_Online() && !arList.get(p).isLayout_c2_Reserved() ) {
            if (arList.get(p).isLayout_c2_Selected()) {
                view.setBackgroundResource(R.drawable.bs_avl);
                arList.get(p).setLayout_c2_Selected(false);
                seats_selected--;
            }else
            {
                view.setBackgroundResource(R.drawable.bs_sel);
                arList.get(p).setLayout_c2_Selected(true);
                seats_selected++;
            }
        }
    }

    @Override
    public void onLayout_c3_Click(View view, int p) {
        if (seats_selected>=4 && !arList.get(p).isLayout_c3_Selected())
        {
            Toast.makeText(TripLayout.this, "Maximum FOUR seats can be selected.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (arList.get(p).isLayout_c3_Online() && !arList.get(p).isLayout_c3_Reserved() ) {
            if (arList.get(p).isLayout_c3_Selected()) {
                view.setBackgroundResource(R.drawable.bs_avl);
                arList.get(p).setLayout_c3_Selected(false);
                seats_selected--;
            }else
            {
                view.setBackgroundResource(R.drawable.bs_sel);
                arList.get(p).setLayout_c3_Selected(true);
                seats_selected++;
            }
        }
    }

    @Override
    public void onLayout_c4_Click(View view, int p) {
        if (seats_selected>=4 && !arList.get(p).isLayout_c4_Selected())
        {
            Toast.makeText(TripLayout.this, "Maximum FOUR seats can be selected.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (arList.get(p).isLayout_c4_Online() && !arList.get(p).isLayout_c4_Reserved() ) {
            if (arList.get(p).isLayout_c4_Selected()) {
                view.setBackgroundResource(R.drawable.bs_avl);
                arList.get(p).setLayout_c4_Selected(false);
                seats_selected--;
            }else
            {
                view.setBackgroundResource(R.drawable.bs_sel);
                arList.get(p).setLayout_c4_Selected(true);
                seats_selected++;
            }
        }
    }

    @Override
    public void onLayout_c5_Click(View view, int p) {
        if (seats_selected>=4 && !arList.get(p).isLayout_c5_Selected())
        {
            Toast.makeText(TripLayout.this, "Maximum FOUR seats can be selected.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (arList.get(p).isLayout_c5_Online() && !arList.get(p).isLayout_c5_Reserved() ) {
            if (arList.get(p).isLayout_c5_Selected()) {
                view.setBackgroundResource(R.drawable.bs_avl);
                arList.get(p).setLayout_c5_Selected(false);
                seats_selected--;
            }else
            {
                view.setBackgroundResource(R.drawable.bs_sel);
                arList.get(p).setLayout_c5_Selected(true);
                seats_selected++;
            }
        }
    }

    @Override
    public void onLayout_c6_Click(View view, int p) {
        if (seats_selected>=4 && !arList.get(p).isLayout_c6_Selected())
        {
            Toast.makeText(TripLayout.this, "Maximum FOUR seats can be selected.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (arList.get(p).isLayout_c6_Online() && !arList.get(p).isLayout_c6_Reserved() ) {
            if (arList.get(p).isLayout_c6_Selected()) {
                view.setBackgroundResource(R.drawable.bs_avl);
                arList.get(p).setLayout_c6_Selected(false);
                seats_selected--;
            }else
            {
                view.setBackgroundResource(R.drawable.bs_sel);
                arList.get(p).setLayout_c6_Selected(true);
                seats_selected++;
            }
        }
    }
}
