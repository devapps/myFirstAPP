package com.example.manojk.ors;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manojk.ors.Models.orsAvailableServices;

public class CustomerDetails extends AppCompatActivity {
    orsAvailableServices orsAS;
    TextView tv_tripRoute,tv_jTime1;
    ImageView iv_bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        // Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        // setSupportActionBar(my_toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // custom toolbar settings
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle("Customer Details");
        getSupportActionBar().setSubtitle(R.string.my_subtitle);
        getSupportActionBar().setIcon(R.mipmap.ic_toolbar);

        tv_tripRoute = (TextView)findViewById(R.id.tv_tripRoute);
        tv_jTime1 = (TextView)findViewById(R.id.tv_jTime1);
        iv_bus = (ImageView)findViewById(R.id.iv_bus);

        Intent i = getIntent();
        orsAS = i.getExtras().getParcelable("orsAvailableServices");

        tv_tripRoute.setText(orsAS.getTripRoute());
        tv_jTime1.setText("Depart : " + orsAS.getjTime1().toString());

        if (orsAS.getBusType().equals("Volvo"))
        {iv_bus.setImageResource(R.drawable.bus_volvo);}
        else
        {iv_bus.setImageResource(R.drawable.bus_ordinary);}
    }
}
