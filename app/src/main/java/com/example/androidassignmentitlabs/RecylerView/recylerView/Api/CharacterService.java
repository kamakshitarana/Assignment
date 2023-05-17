package com.example.androidassignmentitlabs.RecylerView.recylerView.Api;

import com.example.androidassignmentitlabs.RecylerView.recylerView.model.CharacterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CharacterService {
    @GET("demos/marvel")
    Call<List<CharacterResponse>> getCharacters();
}
