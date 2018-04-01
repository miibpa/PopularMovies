package org.example.popularmovies.domain.model;

import com.google.gson.annotations.SerializedName;

public class Movie {


    private int id;
    @SerializedName("original_title")
    private String name;
    @SerializedName("poster_path")
    private String image;
    @SerializedName("overview")
    private String synopsis;
    @SerializedName("vote_average")
    private double rating;
    @SerializedName("release_date")
    private String releseDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public double getRating() {
        return rating;
    }

    public String getReleseDate() {
        return releseDate;
    }
}
