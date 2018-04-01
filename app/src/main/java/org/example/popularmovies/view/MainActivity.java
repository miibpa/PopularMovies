package org.example.popularmovies.view;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import org.example.popularmovies.Inject;
import org.example.popularmovies.R;
import org.example.popularmovies.data.MoviesSource;
import org.example.popularmovies.data.source.remote.MoviesRemoteSource;
import org.example.popularmovies.domain.model.Movie;
import org.example.popularmovies.domain.usecase.GetMoviesByPopularity;
import org.example.popularmovies.domain.usecase.GetMoviesByRating;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private MoviesAdapter adapter;
    private MainActivityPresenter presenter;
    private MenuItem currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        MoviesSource moviesSource = new MoviesRemoteSource(Inject.getMoviesApi());
        presenter = new MainActivityPresenter(this,new GetMoviesByPopularity(moviesSource),new GetMoviesByRating(moviesSource));
        configureRecyclerView();

    }

    private void configureRecyclerView() {
        presenter.reserPageCounter();
        RecyclerView recyclerViewMovies = findViewById(R.id.recyclerViewMovies);
        adapter = new MoviesAdapter(new ArrayList<Movie>(), new MoviesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Movie item, ImageView imageView) {
                openDetailActivity(item,imageView);
            }
        });
        recyclerViewMovies.setAdapter(adapter);
        recyclerViewMovies.setLayoutManager(new GridLayoutManager(this,2));
        recyclerViewMovies.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1)) {
                    loadNewPage();

                }
            }
        });
        if(currentItem != null) {
            loadNewPage();
        }else{
            presenter.getMoviesByPopularityNewPage();
        }
    }

    private void openDetailActivity(Movie movie, ImageView imageView) {
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra("movie",movie);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, (View)imageView, "movieThumbnail");
        startActivity(intent,options.toBundle());
    }

    private void loadNewPage() {
        switch (currentItem.getItemId()){
            case R.id.sort_by_popularity:
                presenter.getMoviesByPopularityNewPage();
            case R.id.sort_by_rating:
                presenter.getMoviesByRatingNewPage();
        }
    }

    @Override
    public void loadMoviesPage(List<Movie> movies) {
        adapter.addItems(movies);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        currentItem = item;
        configureRecyclerView();
        return super.onOptionsItemSelected(item);

    }


}
