package com.example.androidassignmentitlabs.RecylerView.navigationframwork;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.androidassignmentitlabs.R;

public class NavApp extends AppCompatActivity implements
        SecondFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_app);

        /**
         * navigation refers to the interaction that allows user to navigate acroos into
         * and back out from the different pieces of the content within your app.
         *
         * android jetpack navigation component helps you implemenmt navigation from
         * simple button clicks to more complex patterns such as app bar and the navigation
         * drawer.
         *
         *Navigation component consist of three main parts:
         * NavigationGraph, Nav Host, Nav Control
         * **/

    }

    @Override
    public void OnFragmentInteraction(Uri uri) {

    }
}