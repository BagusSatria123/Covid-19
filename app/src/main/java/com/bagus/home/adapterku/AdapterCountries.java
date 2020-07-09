package com.bagus.home.adapterku;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bagus.home.R;
import com.bagus.home.modal.Countries;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterCountries extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Countries> countries;
    private Context context;


    public AdapterCountries(ArrayList<Countries> countries, Context context) {
        this.countries = countries;
        this.context = context;
    }

    class MyAdapterKu extends RecyclerView.ViewHolder{

        TextView negara;
        ImageView image;
        RelativeLayout cover;


        public MyAdapterKu(@NonNull View itemView) {
            super(itemView);

            negara = itemView.findViewById(R.id.negara);
            image = itemView.findViewById(R.id.image);
            cover = itemView.findViewById(R.id.cover);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_negara,parent,false);
        return new MyAdapterKu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {



        ((MyAdapterKu)holder).negara.setText(countries.get(position).getCountry());
        Picasso.get().load(countries.get(position).getFlag()).into(((MyAdapterKu)holder).image);
        ((MyAdapterKu) holder).cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bagus",countries.get(position).getCountry()+ " Posisi : "+position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
