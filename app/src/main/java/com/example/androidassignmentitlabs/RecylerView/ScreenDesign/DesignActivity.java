package com.example.androidassignmentitlabs.RecylerView.ScreenDesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidassignmentitlabs.R;

public class DesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        TextView welcomeTextView = findViewById(R.id.welcomeTextView);
        TextView signInTextView = findViewById(R.id.signInTextView);
        ImageView profileImageView = findViewById(R.id.profileImageView);
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        CheckBox rememberMeCheckbox = findViewById(R.id.checkbox);
        TextView forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (username.equals("your_username") && password.equals("your_password")) {
                    Toast.makeText(DesignActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DesignActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}