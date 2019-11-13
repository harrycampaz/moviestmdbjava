package com.dezzapps.moviestmdbjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dezzapps.moviestmdbjava.R;
import com.dezzapps.moviestmdbjava.databinding.ResultItemBinding;
import com.dezzapps.moviestmdbjava.holder.MovieViewHolder;
import com.dezzapps.moviestmdbjava.model.Result;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Result> resultArrayList;




    public MoviesAdapter(Context context, List<Result> resultArrayList) {
        this.context = context;
        this.resultArrayList = resultArrayList;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ResultItemBinding resultItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.result_item, parent, false);


       // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item, parent, false);
        return new MovieViewHolder(resultItemBinding, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        MovieViewHolder movieViewHolder = (MovieViewHolder) holder;
        movieViewHolder.bind(this.resultArrayList.get(position));

        movieViewHolder.resultItemBinding.setResult(this.resultArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return resultArrayList.size();
    }
}
