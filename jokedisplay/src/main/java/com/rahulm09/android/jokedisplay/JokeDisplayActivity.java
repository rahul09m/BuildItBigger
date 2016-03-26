package com.rahulm09.android.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JokeDisplayActivity extends AppCompatActivity {
    public static String JOKE_KEY = "Joke key";
    //public static final String = ""

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
    }
}
