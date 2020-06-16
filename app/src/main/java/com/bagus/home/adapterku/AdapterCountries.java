package com.bagus.home.adapterku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        public MyAdapterKu(@NonNull View itemView) {
            super(itemView);

            negara = itemView.findViewById(R.id.negara);
            image = itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_negara,parent,false);
        return new MyAdapterKu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {



        ((MyAdapterKu)holder).negara.setText(countries.get(position).getCountry());
        Picasso.get().load(countries.get(position).getFlag()).into(((MyAdapterKu)holder).image);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
