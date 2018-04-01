package org.example.popularmovies.view;

import org.example.popularmovies.domain.model.Movie;

import java.util.List;

public interface MainActivityView {

    void loadMoviesPage(List<Movie> movies);

}
