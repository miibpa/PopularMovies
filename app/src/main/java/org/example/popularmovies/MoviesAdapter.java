package org.example.popularmovies;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private String[] movieThumbnailUrl;
    private Context context;

    public MoviesAdapter(String[] movieThumbnailUrl, Context context) {
        this.movieThumbnailUrl = movieThumbnailUrl;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.get().load(movieThumbnailUrl[position]).into(holder.movieThumbnail);
    }

    @Override
    public int getItemCount() {
        return movieThumbnailUrl.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView movieThumbnail;
        public ViewHolder(View itemView) {
            super(itemView);
            this.movieThumbnail = itemView.findViewById(R.id.movieThumbnail);
        }
    }
}
