package org.example.popularmovies.data;


import org.example.popularmovies.domain.model.Movie;

import java.util.List;

public interface MoviesSource {

    void getMoviesByPopularity(int pageNumber, LoadMoviesCallback callback);
    void getMoviesByRating(int pageNumber,LoadMoviesCallback callback);

    interface LoadMoviesCallback {

        void onMoviesLoaded(List<Movie> movies);

        void onDataNotAvailable();
    }


}