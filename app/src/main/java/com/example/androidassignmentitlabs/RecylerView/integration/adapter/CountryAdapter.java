package com.example.androidassignmentitlabs.RecylerView.integration.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidassignmentitlabs.R;
import com.example.androidassignmentitlabs.RecylerView.integration.model.CountryModel;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private ArrayList<CountryModel> countryList;

    public CountryAdapter(ArrayList<CountryModel> countryList) {
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.recylerview_item, parent,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
    holder.textView.setText(countryList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    //View Holder
    class CountryViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            textView =itemView.findViewById(R.id.country_name);
        }
    }


}
