package com.dezzapps.moviestmdbjava.model;

import androidx.lifecycle.MutableLiveData;

import com.dezzapps.moviestmdbjava.services.PostsDataServices;
import com.dezzapps.moviestmdbjava.services.RetrofitInstance;
import com.dezzapps.moviestmdbjava.utils.ConstantsData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsRepository {

    private List<Result> movies = new ArrayList<>();

    private MutableLiveData<List<Result>>  mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Result>> getMutableLiveData() {

        PostsDataServices postsDataServices = RetrofitInstance.getPostsDataServices();


        Call<Posts> call = postsDataServices.getPopularMovies(ConstantsData.KEY_MOVIE);

        call.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {

                if(response.isSuccessful()){
                    Posts resultPosts = response.body();
                    if(resultPosts != null && resultPosts.getResults() != null){

                        movies = (List<Result>) response.body().getResults();

                        mutableLiveData.setValue(movies);

                    }

                }


            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }


}
