package org.example.popularmovies.domain.usecase;

import org.example.popularmovies.data.MoviesSource;

public class GetMoviesByRating {

    private final MoviesSource moviesSource;

    public GetMoviesByRating(MoviesSource moviesSource) {
        this.moviesSource = moviesSource;
    }

    public void execute(int pageNumber, MoviesSource.LoadMoviesCallback callback){

        moviesSource.getMoviesByRating(pageNumber,callback);

    }
}
