package com.example.manojk.ors;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import com.example.manojk.ors.Models.*;
import com.example.manojk.ors.R;

public class PassengerInfo extends AppCompatActivity {
    orsAvailableServices orsAS;
    TextInputLayout til_pname1,til_pname2,til_pname3,til_pname4;
    RelativeLayout passenger2, passenger3, passenger4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent i = getIntent();
        orsAS = i.getExtras().getParcelable("orsAvailableServices");
        til_pname1 = (TextInputLayout)findViewById(R.id.til_p_name1);
        til_pname2 = (TextInputLayout)findViewById(R.id.til_p_name2);
        til_pname3 = (TextInputLayout)findViewById(R.id.til_p_name3);
        til_pname4 = (TextInputLayout)findViewById(R.id.til_p_name4);

        til_pname1.setHint("Passenger Name (Seat No. "+orsAS.getpSeat1()+")");
        til_pname2.setHint("Passenger Name (Seat No. "+orsAS.getpSeat2()+")");
        til_pname3.setHint("Passenger Name (Seat No. "+orsAS.getpSeat3()+")");
        til_pname4.setHint("Passenger Name (Seat No. "+orsAS.getpSeat4()+")");
        //tv_pname1.bringToFront();

        if (orsAS.gettSeats()==1) {
            passenger2 = (RelativeLayout) findViewById(R.id.passenger2);
            passenger3 = (RelativeLayout) findViewById(R.id.passenger3);
            passenger4 = (RelativeLayout) findViewById(R.id.passenger4);
            passenger2.setVisibility(View.GONE);
            passenger3.setVisibility(View.GONE);
            passenger4.setVisibility(View.GONE);
        }
        if (orsAS.gettSeats()==2) {
            passenger3 = (RelativeLayout) findViewById(R.id.passenger3);
            passenger4 = (RelativeLayout) findViewById(R.id.passenger4);
            passenger3.setVisibility(View.GONE);
            passenger4.setVisibility(View.GONE);
        }
        if (orsAS.gettSeats()==3) {
            passenger4 = (RelativeLayout) findViewById(R.id.passenger4);
            passenger4.setVisibility(View.GONE);
        }
    }
}
