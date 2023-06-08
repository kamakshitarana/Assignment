package com.example.androidassignmentitlabs.RecylerView.integration.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit=null;
    private static String BASE_URL = "https://api.printful.com/";

    //Singleton pattern  used to create an instance of retrofit
    public static GetCountryName getService(){

        //instance is not created before
        if (retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        //if instance is alrdy created
        return retrofit.create(GetCountryName.class);
    }

}
