package org.example.popularmovies.view;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.example.popularmovies.R;
import org.example.popularmovies.domain.model.Movie;
import org.example.popularmovies.Utils;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Movie item, ImageView imageView);
    }

    private List<Movie> movies;
    private OnItemClickListener onItemClickListener;

    public MoviesAdapter(List<Movie> movies, OnItemClickListener itemClickListener) {
        this.movies = movies;
        this.onItemClickListener = itemClickListener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_recyclerview_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        String imagePath = Utils.buildMovieImageUrl(movies.get(position).getImage());
        Picasso.get().load(imagePath).into(holder.movieThumbnail);
        holder.movieThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(movies.get(position),holder.movieThumbnail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView movieThumbnail;
        public ViewHolder(View itemView) {
            super(itemView);
            this.movieThumbnail = itemView.findViewById(R.id.movieThumbnail);
        }
    }

    public void addItems(List<Movie> movies) {
        this.movies.addAll(movies);
        notifyItemInserted(getItemCount()-1);
    }


}
