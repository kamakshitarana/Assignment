package com.example.androidassignmentitlabs.RecylerView.fireBase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidassignmentitlabs.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    Button btn;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        //the below line have an error
        mDatabase = FirebaseDatabase.getInstance().getReference("GoldPrice").child("price");
        // Initialize FirebaseApp
        FirebaseApp.initializeApp(this);

        btn =findViewById(R.id.btn);
        editText =findViewById(R.id.editTextNumber);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.setValue(editText.getText().toString());
            }
        });
    }
}