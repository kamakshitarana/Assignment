package com.example.androidassignmentitlabs.RecylerView.Click;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidassignmentitlabs.R;

public class ClickSendActivity extends AppCompatActivity {

    private Button shareButton;
    private String url = "http://pandora.yilstaging.com/writable/uploads/20210127/1611811599_2ac19cd41e8387119d7e.mp3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_send);

        shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareURL(url);
            }
        });
    }

    private void shareURL(String url) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(intent, "Share URL"));

    }
}