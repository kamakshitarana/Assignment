package com.example.androidassignmentitlabs.RecylerView.reclyerVieww.recylerView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.androidassignmentitlabs.R;
import com.example.androidassignmentitlabs.RecylerView.reclyerVieww.recylerView.Api.CharacterService;
import com.example.androidassignmentitlabs.RecylerView.reclyerVieww.recylerView.adapter.CharacterAdapter;
import com.example.androidassignmentitlabs.RecylerView.reclyerVieww.recylerView.model.CharacterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView recyclerView;
    private CharacterAdapter characterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        characterAdapter = new CharacterAdapter(this);
        recyclerView.setAdapter(characterAdapter);
        characterAdapter.setClickListener(this);
        fetchCharacters();

    }

    private void fetchCharacters() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://simplifiedcoding.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CharacterService characterService = retrofit.create(CharacterService.class);
        Call<List<CharacterResponse>> call = characterService.getCharacters();
        call.enqueue(new Callback<List<CharacterResponse>>() {
            @Override
            public void onResponse(Call<List<CharacterResponse>> call, Response<List<CharacterResponse>> response) {
                if (response.isSuccessful()) {
                    List<CharacterResponse> characterResponses = response.body();
                    if (characterResponses != null) {
                        characterAdapter.setCharacters(characterResponses);
                    } else {
                        Log.e("Response Error", "Character list is null");
                    }
                } else {
                    Log.e("Response Error", "Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<CharacterResponse>> call, Throwable t) {
                Log.e("API Error", t.getMessage());
            }
        });
    }


    @Override
    public void onClick(View view, int pos) {
        CharacterResponse character = characterAdapter.getCharacters().get(pos);
        showPopup(character.getName());
        showPopup(character.getRealName());
        showPopup(character.getTeam());
        showPopup(character.getPublisher());
        showPopup(character.getCreatedBy());
        showPopup(character.getFirstAppearance());
        showPopup(character.getBio());
        showPopup(character.getImageUrl());
    }

    private void showPopup(String characterName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Character Name");
        builder.setMessage(characterName);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
