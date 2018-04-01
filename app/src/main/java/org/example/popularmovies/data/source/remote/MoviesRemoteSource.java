package org.example.popularmovies.data.source.remote;

import android.support.annotation.NonNull;

import org.example.popularmovies.BuildConfig;
import org.example.popularmovies.data.MovieDataModel;
import org.example.popularmovies.data.MoviesSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesRemoteSource implements MoviesSource {
    private final MoviesApi moviesApi;

    public MoviesRemoteSource(MoviesApi moviesApi) {

        this.moviesApi = moviesApi;
    }

    @Override
    public void getMoviesByPopularity(int pageNumber, LoadMoviesCallback callback) {
        moviesApi.getPopularMoviesPage(pageNumber, BuildConfig.TheMovieDatabaseApiKey).enqueue(getCallback(callback));
    }



    @Override
    public void getMoviesByRating(int pageNumber,LoadMoviesCallback callback) {
        moviesApi.getRatedMoviesPage(pageNumber, BuildConfig.TheMovieDatabaseApiKey).enqueue(getCallback(callback));
    }

    @NonNull
    private Callback<MovieDataModel> getCallback(final LoadMoviesCallback callback) {
        return new Callback<MovieDataModel>() {
            @Override
            public void onResponse(Call<MovieDataModel> call, Response<MovieDataModel> response) {
                if(response.code() == 200) {
                    MovieDataModel movieDataModel = response.body();
                    callback.onMoviesLoaded(movieDataModel.getMovies());
                }else{
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<MovieDataModel> call, Throwable t) {
                callback.onDataNotAvailable();
            }
        };
    }


}
