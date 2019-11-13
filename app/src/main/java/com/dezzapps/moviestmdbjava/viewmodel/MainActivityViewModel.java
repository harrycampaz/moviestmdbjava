package com.dezzapps.moviestmdbjava.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dezzapps.moviestmdbjava.model.PostsRepository;
import com.dezzapps.moviestmdbjava.model.Result;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {


    private PostsRepository postsRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        postsRepository = new PostsRepository();
    }

    public LiveData<List<Result>> getAllPosts (){
        return postsRepository.getMutableLiveData();
    }
}
