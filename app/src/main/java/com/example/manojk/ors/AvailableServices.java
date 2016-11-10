package com.example.manojk.ors;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.manojk.ors.Models.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class AvailableServices extends AppCompatActivity implements myIResult {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<orsAvailableServices> arList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_services);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

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
        getSupportActionBar().setTitle(R.string.my_available_services_title);
        getSupportActionBar().setSubtitle(R.string.my_subtitle);
        getSupportActionBar().setIcon(R.mipmap.ic_toolbar);


        //myVolleyService.getInstance(this).addToRequestQueue(jsonrequestobject);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        orsAvailableServicesTask orsAS = new orsAvailableServicesTask(AvailableServices.this);
        orsAS.getList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.book_eticket:
                Toast.makeText(AvailableServices.this, "Book eTicket clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void notifySuccess(ArrayList<orsAvailableServices> orsAS){
        //Log.d("myApp", "ors_availableServices TASK -response  " + orsAS);
        adapter = new orsAvailableServicesAdapter(orsAS);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void notifySuccess(JSONObject response){}
    @Override
    public void notifySuccess(JSONArray response){}
    @Override
    public void notifyError(VolleyError error){}
}
