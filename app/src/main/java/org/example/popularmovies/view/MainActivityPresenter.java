package org.example.popularmovies.view;

import org.example.popularmovies.data.MoviesSource;
import org.example.popularmovies.domain.model.Movie;
import org.example.popularmovies.domain.usecase.GetMoviesByPopularity;
import org.example.popularmovies.domain.usecase.GetMoviesByRating;

import java.util.List;

public class MainActivityPresenter {

    private final MainActivityView view;
    private final GetMoviesByPopularity getMoviesByPopularity;
    private final GetMoviesByRating getMoviesByRating;
    private int currentPage = 0;

    public MainActivityPresenter(MainActivityView view, GetMoviesByPopularity getMoviesByPopularity, GetMoviesByRating getMoviesByRating) {
        this.view = view;
        this.getMoviesByPopularity = getMoviesByPopularity;
        this.getMoviesByRating = getMoviesByRating;
    }

    public void reserPageCounter(){
        currentPage = 0;
    }

    public void getMoviesByPopularityNewPage(){
        currentPage += 1;
        this.getMoviesByPopularity.execute(currentPage, new MoviesSource.LoadMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                view.loadMoviesPage(movies);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    public void getMoviesByRatingNewPage(){
        currentPage += 1;
        this.getMoviesByRating.execute(currentPage, new MoviesSource.LoadMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                view.loadMoviesPage(movies);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

}
