package com.example.androidassignmentitlabs.RecylerView.integration.services;

import com.example.androidassignmentitlabs.RecylerView.integration.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryName {
    //retrofit interface

    @GET("countries")
    Call<Result> getResult();


}
