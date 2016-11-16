package com.example.manojk.ors;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.VolleyError;
import com.example.manojk.ors.Models.*;
import com.example.manojk.ors.R;

import java.util.ArrayList;

public class TripLayout extends AppCompatActivity implements orsTripLayout_iResult {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<orsTripLayout> arList = new ArrayList<>();

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
    }
}
