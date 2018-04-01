package org.example.popularmovies.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.example.popularmovies.R;
import org.example.popularmovies.Utils;
import org.example.popularmovies.domain.model.Movie;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Movie movie = getIntent().getParcelableExtra("movie");
        setupUI(movie);
    }

    private void setupUI(Movie movie) {
        TextView name = findViewById(R.id.textViewName);
        name.setText(movie.getName());
        TextView date = findViewById(R.id.textViewReleaseDate);
        date.setText(movie.getReleseDate());
        TextView rating = findViewById(R.id.textViewRating);
        rating.setText(String.format("%s/10", movie.getRating()));
        TextView description = findViewById(R.id.textViewDescriptiom);
        description.setText(movie.getSynopsis());
        String imagePath = Utils.buildMovieImageUrl(movie.getImage());
        ImageView imageThumbnail = findViewById(R.id.imageView);
        Picasso.get().load(imagePath).into(imageThumbnail);
    }
}
