package com.example.androidassignmentitlabs.RecylerView.integration;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidassignmentitlabs.R;
import com.example.androidassignmentitlabs.RecylerView.integration.adapter.CountryAdapter;
import com.example.androidassignmentitlabs.RecylerView.integration.model.CountryModel;
import com.example.androidassignmentitlabs.RecylerView.integration.model.Result;
import com.example.androidassignmentitlabs.RecylerView.integration.services.GetCountryName;
import com.example.androidassignmentitlabs.RecylerView.integration.services.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryActivity extends AppCompatActivity {
    ArrayList<CountryModel> countries;

    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
    
        GetCountries();
    
    }

    public void GetCountries() {
        GetCountryName getCountryName = RetrofitInstance.getService();
        Call<Result> call = getCountryName.getResult();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.isSuccessful()) {
                    Result result = response.body();
                    if (result != null) {
                        List<CountryModel> countryList = result.getResult();
                        countries = new ArrayList<>(countryList);
                        viewData(); // Call the method to display the data in RecyclerView
                    }
                } else {
                    // Handle unsuccessful response
                    Log.e("CountryActivity", "Failed to get countries. Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                // Handle failure
                Log.e("CountryActivity", "Failed to get countries. Error: " + t.getMessage());
            }
        });
    }


    private void viewData() {
        recyclerView =findViewById(R.id.recyclerView);
        countryAdapter =new CountryAdapter(countries);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(
                CountryActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapter);

    }

}