package com.dezzapps.moviestmdbjava.services;

import com.dezzapps.moviestmdbjava.model.Posts;
import com.dezzapps.moviestmdbjava.model.Result;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostsDataServices {

    @GET("movie/popular")
    Call<Result> getPosts();

    @GET("movie/popular")
    Call<Posts> getPopularMovies(@Query("api_key") String apiKey);



}
