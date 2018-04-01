package org.example.popularmovies;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.example.popularmovies.data.source.remote.MoviesApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Inject {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    public static MoviesApi getMoviesApi(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(MoviesApi.class);
    }
}
