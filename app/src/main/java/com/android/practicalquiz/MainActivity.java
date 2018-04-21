package com.android.practicalquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String CONST_USERNAME = "username";
    public static final String CONST_EMAIL = "email";
    public static final String CONST_DESCRIPTION = "description";
    private EditText mUserNameEditText, mEmailEditText, mDescriptionEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUserNameEditText = findViewById(R.id.et_username);
        mEmailEditText = findViewById(R.id.et_email);
        mDescriptionEditText = findViewById(R.id.et_detail);

        if(savedInstanceState != null) {
            mUserNameEditText.setText(savedInstanceState.getString(CONST_USERNAME));
            mEmailEditText.setText(savedInstanceState.getString(CONST_EMAIL));
            mDescriptionEditText.setText(savedInstanceState.getString(CONST_DESCRIPTION));
        }
    }

    public void openDetail(View view) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        editor.putString(CONST_USERNAME, mUserNameEditText.getText().toString());
        editor.putString(CONST_EMAIL, mEmailEditText.getText().toString());
        editor.putString(CONST_DESCRIPTION, mDescriptionEditText.getText().toString());
        editor.apply();
        mUserNameEditText.setText("");
        mEmailEditText.setText("");
        mDescriptionEditText.setText("");
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.user_account) {
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String username = mUserNameEditText.getText().toString();
        String email = mEmailEditText.getText().toString();
        String description = mDescriptionEditText.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString(CONST_USERNAME, username);
        bundle.putString(CONST_EMAIL, email);
        bundle.putString(CONST_DESCRIPTION, description);
        super.onSaveInstanceState(outState);
    }
}
