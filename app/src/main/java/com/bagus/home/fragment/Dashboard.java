package com.bagus.home.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bagus.home.R;
import com.bagus.home.adapterku.AdapterCountries;
import com.bagus.home.modal.Countries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Dashboard extends Fragment {

    View view;
    RequestQueue queue;
    RecyclerView recyclerView;
    GridLayoutManager glm;
    ArrayList<Countries> countries;
    String country,flag;
    TextView click;
    String code;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dashboard,container,false);

        recyclerView = view.findViewById(R.id.recycle);
        countries = new ArrayList<>();

        click = view.findViewById(R.id.click);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Yeahh Di Klik",Toast.LENGTH_LONG).show();
            }
        });



        queue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://corona.lmao.ninja/v2/countries", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int k = 0; k < response.length(); k++) {
                    try {
                        JSONObject obj = response.getJSONObject(k);

                         country = obj.getString("country");

                        for (int i = 0; i < obj.length(); i++) {
                            JSONObject obj1 = obj.getJSONObject("countryInfo");

                            flag = obj1.getString("flag");
                            Log.d("flagku", flag + "");
                        }

                        Log.d("testing", country + "");
                        Countries contri = new Countries(country,flag);
                        countries.add(contri);
                        AdapterCountries adp = new AdapterCountries(countries,getActivity());
                        glm = new GridLayoutManager(getActivity(),2);
                        recyclerView.setLayoutManager(glm);
                        recyclerView.setAdapter(adp);

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
