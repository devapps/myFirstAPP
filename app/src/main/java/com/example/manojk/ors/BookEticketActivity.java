package com.example.manojk.ors;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BookEticketActivity extends AppCompatActivity {

    IResult mResultCallback = null;
    VolleyService mVolleyService;

    private ArrayList<String> stations_leaving_from, stations_departing_to, list_departure_date;
    private ArrayAdapter<String> booking_stations_spinnerArrayAdapter;
    private Spinner sp_leaving_from, sp_departing_to, sp_departure_date, sp_bus_types;

    String[] bus_types = {"Super Luxury Bus", "Ordinary Bus"};
    String[] bus_sub_types = {"Mercedes/Volvo Bus", "Standard/General Bus"};
    int[] bus_images = {R.drawable.bus_volvo, R.drawable.bus_ordinary};
    private ProgressBar progressBar;

    Button bCheckAvailability = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_eticket);

        if (!appStatus.getInstance(this).isOnline()) {
            Toast.makeText(this, "Internet connection not available..", Toast.LENGTH_LONG).show();
            finish();
        }

        initVolleyCallback();
        mVolleyService = new VolleyService(mResultCallback, this);
        mVolleyService.getDataVolley("GETCALL_leaving_from", "http://hartrans.gov.in/ors/api/bookingStations");
        mVolleyService.getDataVolley("GETCALL_departure_date", "http://hartrans.gov.in/ors/api/bookingDays");

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);


        ((TextView) findViewById(R.id.display_info_query)).setText(Html.fromHtml(getText(R.string.prompt_info_query).toString()));

        stations_leaving_from = new ArrayList<String>();
        stations_departing_to = new ArrayList<String>();
        list_departure_date = new ArrayList<String>();

        stations_leaving_from.add("select Leaving from");
        stations_departing_to.add("select Departing to");
        list_departure_date.add("select Departure date");

        sp_bus_types = (Spinner) findViewById(R.id.sp_bus_types);
        sp_leaving_from = (Spinner) findViewById(R.id.sp_leaving_from);
        sp_departing_to = (Spinner) findViewById(R.id.sp_departing_to);
        sp_departure_date = (Spinner) findViewById(R.id.sp_departure_date);

        sp_departing_to.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, stations_departing_to));

        // custom toolbar settings
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle(R.string.my_book_eticket_title);
        getSupportActionBar().setSubtitle(R.string.my_subtitle);
        getSupportActionBar().setIcon(R.mipmap.ic_toolbar);

        //bus types dropdown listbox customsed with bus Images
        sp_bus_types.setAdapter(new CustomAdaptor(this, R.layout.spinner, bus_types));
        sp_bus_types.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String busType = ((TextView) findViewById(R.id.sp_main_item)).getText().toString();
                Toast.makeText(getApplicationContext(), busType, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        progressBar.setVisibility(View.GONE);



        bCheckAvailability = (Button) findViewById(R.id.bCheckAvailability);
        bCheckAvailability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookEticketActivity.this, AvailableServices.class));

            }
        });
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
                Toast.makeText(BookEticketActivity.this, "Book eTicket clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void initVolleyCallback() {
        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                //Log.d(TAG, "Volley requester " + requestType);
                //Log.d(TAG, "Volley JSON post" + response);
                //return response;
            }

            @Override
            public void notifySuccess(String requestType, JSONArray response) {
                Log.d("myApp", "Volley requester " + requestType);
                Log.d("myApp", "Volley JSON post" + response);
                //return response;
                if (requestType.equals("GETCALL_leaving_from")) {
                    updateLeavingFrom(response);
                }
                if (requestType.equals("GETCALL_departing_to")) {
                    updateDepartingTo(response);
                }
                if (requestType.equals("GETCALL_departure_date")) {
                    updateDepartureDate(response);
                }
            }

            @Override
            public void notifyError(String requestType, VolleyError error) {
                Log.d("myApp", "Volley requester " + requestType);
                Log.d("myApp", "Volley JSON post" + "That didn't work!");
            }
        };
    }

    private void updateDepartureDate(JSONArray j) {
        //Traversing through all the items in the json array
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                list_departure_date.add(json.getString("stationName"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        //Setting adapter to show the items in the spinner
        sp_departure_date.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list_departure_date) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(
                    int position,
                    View convertView,
                    ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                //tv.setLines(1);
                //tv.setShadowLayer(1.3f, 4.0f, 4.0f, Color.parseColor("#fdab52"));
                return view;
            }
        });
    }

    private void updateLeavingFrom(JSONArray j) {
        //Traversing through all the items in the json array
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                stations_leaving_from.add(json.getString("stationName"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        //Setting adapter to show the items in the spinner
        sp_leaving_from.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, stations_leaving_from) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(
                    int position,
                    View convertView,
                    ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                //tv.setLines(1);
                //tv.setShadowLayer(1.3f, 4.0f, 4.0f, Color.parseColor("#fdab52"));
                return view;
            }
        });

        sp_leaving_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    //Toast.makeText(getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT).show();
                    stations_departing_to.clear();
                    stations_departing_to.add("select Departing to");
                    mVolleyService.getDataVolley("GETCALL_departing_to", "http://hartrans.gov.in/ors/api/bookingStations/"+selectedItemText);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void updateDepartingTo(JSONArray j) {
        //Traversing through all the items in the json array
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                stations_departing_to.add(json.getString("stationName"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        //Setting adapter to show the items in the spinner
        sp_departing_to.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, stations_departing_to) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(
                    int position,
                    View convertView,
                    ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                //tv.setLines(1);
                //tv.setShadowLayer(1.3f, 4.0f, 4.0f, Color.parseColor("#fdab52"));
                return view;
            }
        });
    }

    public class CustomAdaptor extends ArrayAdapter<String> {

        public CustomAdaptor(Context context, int textViewResourceId, String[] objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public View getView(int position, View cnvtView, ViewGroup prnt) {
            return getCustomView(position, cnvtView, prnt);
        }

        @Override
        public View getDropDownView(int pos, View cnvtView, ViewGroup prnt) {
            return getCustomView(pos, cnvtView, prnt);
        }

        public View getCustomView(int position, View ConvertView, ViewGroup parent) {
            //LayoutInflater inflater =  getLayoutInflater();
            LayoutInflater inflater = LayoutInflater.from(super.getContext());

            View mySpinner = inflater.inflate(R.layout.spinner, parent, false);

            TextView txt = (TextView) mySpinner.findViewById(R.id.sp_main_item);
            txt.setText(bus_types[position]);

            TextView subtxt = (TextView) mySpinner.findViewById(R.id.sp_sub_item);
            subtxt.setText(bus_sub_types[position]);

            ImageView img = (ImageView) mySpinner.findViewById(R.id.image);
            img.setImageResource(bus_images[position]);
            return mySpinner;
        }
    }
}

