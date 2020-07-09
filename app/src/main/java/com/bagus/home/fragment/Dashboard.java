package com.bagus.home.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bagus.home.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Dashboard extends Fragment {

    View view;
    RequestQueue queue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dashboard,container,false);

        queue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://corona.lmao.ninja/v2/countries", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int k = 0; k < response.length(); k++) {
                    try {
                        JSONObject obj = response.getJSONObject(k);

                        String country = obj.getString("country");

                        for (int i = 0; i < obj.length(); i++) {
                            JSONObject obj1 = obj.getJSONObject("countryInfo");

                            String flag = obj1.getString("flag");
                            Log.d("flagku", flag + "");
                        }

                        Log.d("testing", country + "");
//                        Log.d("tampil", response + "");

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        return view;
    }
}
