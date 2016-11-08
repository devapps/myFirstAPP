package com.example.manojk.ors.Models;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by manojK on 07/11/2016.
 */
public class orsAvailableServicesTask {
    Context context;
    ArrayList<orsAvailableServices> arrayList = new ArrayList<>();
    String json_url = "http://hartrans.gov.in/ors/api/orsAvailableServices";

    public orsAvailableServicesTask(Context context)
    {
        this.context = context;
    }

    public ArrayList<orsAvailableServices> getList()
    {

        final Map<String, String> params = new HashMap<String,String>();
        params.put("sLeaving","Chandigarh");
        params.put("sDeparting","Delhi");
        params.put("busType","Volvo");
        params.put("dDate","07-Nov-2016");

//        String pp = "sLeaving=Chandigarh&sDeparting=Delhi&dDate=11-jul-2016";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, json_url,new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("myApp", "orsAvailableServices Task JSON post-response  " + response);

                        try {
                            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
                            JSONArray ja = response.getJSONArray("model");
                            Log.d("myApp", "orsAvailableServices Task JSON post-response  " + ja);

                            int count = 0;
                            while (count < ja.length()) {
                                JSONObject jsonObject = ja.getJSONObject(count);
                                Date jTime1 = new Date();
                                try {
                                    jTime1 =  formatter.parse(jsonObject.getString("jTime1"));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                orsAvailableServices ors_AvailableServices =
                                        new orsAvailableServices(
                                                jsonObject.getInt("trip_srno"),
                                                jsonObject.getInt("ID"),
                                                jsonObject.getInt("onlineSeats"),
                                                jsonObject.getInt("rKMS"),
                                                jsonObject.getInt("rFare"),
                                                jsonObject.getInt("depotID"),
                                                jsonObject.getInt("reservationCharges"),
                                                jsonObject.getInt("rTripID"),
                                                jsonObject.getInt("tripID"),
                                                jsonObject.getInt("totalSeats"),
                                                jsonObject.getInt("availableSeats"),
                                                jsonObject.getInt("closeTime"),
                                                jsonObject.getString("busType"),
                                                jsonObject.getString("tripCode"),
                                                jsonObject.getString("Leaving"),
                                                jsonObject.getString("Departing"),
                                                jsonObject.getString("Via"),
                                                jsonObject.getString("rDesc"),
                                                jsonObject.getString("Boarding"),
                                                jsonObject.getString("Plateform"),
                                                jsonObject.getString("Dropping"),
                                                jsonObject.getString("tripRoute"),
                                                jsonObject.getString("depotShortName"),
                                                jTime1
                                        );
                                arrayList.add(ors_AvailableServices);
                                count++;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context,"error....", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String> headers = new HashMap<String, String>();
                //headers.put("Content-Type","application/x-www-form-urlencoded");
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
/*
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String,String>();
                params.put("sLeaving","Chandigarh");
                params.put("sDeparting","Delhi");
                params.put("busType","Volvo");
                params.put("dDate","07-Nov-2016");

                return params;
            }
*/
/*
@Override
public byte[] getBody() {

    JSONObject jsonObject = new JSONObject();
    String body = null;
    try {
        jsonObject.put("sLeaving", "Chandigarh");
        jsonObject.put("sDeparting", "Delhi");

        body = jsonObject.toString();
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    try {
        return body.toString().getBytes("utf-8");
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return null;
}
*/
        };

        myVolleyService.getInstance(context).addToRequestQueue(jsonObjectRequest);
        return arrayList;
    }

}
