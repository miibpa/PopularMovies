package org.example.popularmovies.domain.usecase;

import org.example.popularmovies.data.MoviesSource;

public class GetMoviesByPopularity {
    private final MoviesSource moviesSource;


    public GetMoviesByPopularity(MoviesSource moviesSource) {
        this.moviesSource = moviesSource;
    }

    public void execute(int pageNumber, MoviesSource.LoadMoviesCallback callback){

        moviesSource.getMoviesByPopularity(pageNumber,callback);

    }
}
