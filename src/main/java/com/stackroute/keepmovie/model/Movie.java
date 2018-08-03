package com.stackroute.keepmovie.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * The class "movie" will be acting as the data model for the movie Table in the database. Please
 * movie that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */

@Entity
public class Movie {
    @Id
    private int movieId;
    private String movieTitle;
    private String rating;
    private String yearOfRelease;

    public Movie() {

    }

    public Movie(int movieId, String movieTitle, String rating, String yearOfRelease) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
    }

    public int getmovieId() {
        return movieId;
    }

    public void setmovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getmovieTitle() {
        return movieTitle;
    }

    public void setmovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getrating() {
        return rating;
    }

    public void setrating(String rating) {
        this.rating = rating;
    }

    public String getyearOfRelease() {
        return yearOfRelease;
    }

    public void setyearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

  

}