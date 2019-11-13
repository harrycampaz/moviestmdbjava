package com.dezzapps.moviestmdbjava.holder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dezzapps.moviestmdbjava.R;
import com.dezzapps.moviestmdbjava.databinding.ResultItemBinding;
import com.dezzapps.moviestmdbjava.model.Result;
import com.dezzapps.moviestmdbjava.view.ViewMoviesActivity;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private TextView movieTitle, rate;
    private ImageView movieImage;
    private Context context;

    public ResultItemBinding resultItemBinding;

    public MovieViewHolder(@NonNull ResultItemBinding resultItemBinding, Context context) {
        super(resultItemBinding.getRoot());

        this.resultItemBinding = resultItemBinding;
        this.context = context;

      //  movieTitle = itemView.findViewById(R.id.tvTitle);

        //rate = itemView.findViewById(R.id.tvRating);

       // movieImage = itemView.findViewById(R.id.ivMovie);

    }

    public  void bind(final Result post){



        this.resultItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent  = new Intent(context, ViewMoviesActivity.class);
                intent.putExtra("movie", post);
                context.startActivity(intent);
            }
        });

    }



}
