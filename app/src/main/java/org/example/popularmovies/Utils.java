package org.example.popularmovies;

public class Utils {
    private final static String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185/";

    public static String buildMovieImageUrl(String path){
        return BASE_IMAGE_URL + path;
    }
}
