package org.example.popularmovies.data;

import com.google.gson.annotations.SerializedName;

import org.example.popularmovies.domain.model.Movie;

import java.util.List;

public class MovieDataModel {

    @SerializedName("page")
    private int pageNumber;

    @SerializedName("results")
    private List<Movie> movies;

    public int getPageNumber() {
        return pageNumber;
    }

    public List<Movie> getMovies() {
        return movies;
    }



}
