package org.example.popularmovies.data.source.remote;

import org.example.popularmovies.data.MovieDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApi {

    @GET("movie/popular")
    Call<MovieDataModel> getPopularMoviesPage(@Query("page")int page,@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Call<MovieDataModel> getRatedMoviesPage(@Query("page")int page,@Query("api_key") String apiKey);
}
