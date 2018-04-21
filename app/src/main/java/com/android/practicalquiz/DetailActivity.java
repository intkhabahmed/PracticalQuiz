package com.android.practicalquiz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        TextView mUsernameTextView, mEmailTextView, mDetailTextView;
        mUsernameTextView = findViewById(R.id.tv_username);
        mEmailTextView = findViewById(R.id.tv_email);
        mDetailTextView = findViewById(R.id.tv_detail);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mUsernameTextView.setText(sharedPreferences.getString(MainActivity.CONST_USERNAME, getString(R.string.demo_username)));
        mEmailTextView.setText(sharedPreferences.getString(MainActivity.CONST_EMAIL, getString(R.string.demo_email)));
        mDetailTextView.setText(sharedPreferences.getString(MainActivity.CONST_DESCRIPTION, getString(R.string.demo_detail)));
    }
}
