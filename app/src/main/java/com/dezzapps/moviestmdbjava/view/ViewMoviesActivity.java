package com.dezzapps.moviestmdbjava.view;

import android.content.Intent;
import android.os.Bundle;

import com.dezzapps.moviestmdbjava.databinding.ActivityMainBinding;
import com.dezzapps.moviestmdbjava.databinding.ActivityViewMoviesBinding;
import com.dezzapps.moviestmdbjava.model.Result;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.View;
import android.widget.Toast;

import com.dezzapps.moviestmdbjava.R;

public class ViewMoviesActivity extends AppCompatActivity {


    private Result result;



    private ActivityViewMoviesBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_movies);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_movies);

        Intent intent = getIntent();

        if(intent.hasExtra("movie")){
            this.result = intent.getParcelableExtra("movie");

            activityMainBinding.setResult(this.result);
            Toast.makeText(getApplicationContext(), this.result.getTitle(), Toast.LENGTH_SHORT).show();
        }

    }

}
