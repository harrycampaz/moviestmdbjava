package com.dezzapps.moviestmdbjava.view;

import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.lifecycle.ViewModelProviders;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import com.dezzapps.moviestmdbjava.R;
import com.dezzapps.moviestmdbjava.adapter.MoviesAdapter;
import com.dezzapps.moviestmdbjava.databinding.ActivityMainBinding;
import com.dezzapps.moviestmdbjava.model.Posts;
import com.dezzapps.moviestmdbjava.model.Result;
import com.dezzapps.moviestmdbjava.services.PostsDataServices;
import com.dezzapps.moviestmdbjava.services.RetrofitInstance;
import com.dezzapps.moviestmdbjava.utils.ConstantsData;
import com.dezzapps.moviestmdbjava.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private List<Result> resultsMovies;

    private RecyclerView recyclerView;

    private MoviesAdapter moviesAdapter;

    private SwipeRefreshLayout swipeRefreshLayout;

    private MainActivityViewModel mainActivityViewModel;

    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setTitle("Movies");


        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainActivityViewModel =  ViewModelProviders.of(this).get(MainActivityViewModel.class);

        getPopularMovies();

        swipeRefreshLayout = activityMainBinding.swipeLayout;

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();

            }
        });

    }

    private void getPopularMovies() {



        mainActivityViewModel.getAllPosts().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                resultsMovies = results;
                showOnReciclerView();
            }
        });





    }

    private void showOnReciclerView() {


        recyclerView = activityMainBinding.rvPosts;

        moviesAdapter = new MoviesAdapter(this, resultsMovies);


        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        }else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(moviesAdapter);
        moviesAdapter.notifyDataSetChanged();


    }
}
