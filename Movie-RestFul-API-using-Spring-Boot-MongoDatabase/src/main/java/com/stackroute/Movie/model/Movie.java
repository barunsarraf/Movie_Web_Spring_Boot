package com.stackroute.Movie.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Movie {

    @Id
    private int movieId;

    private String movieName;
    private String movieCast;
    private String movieGenre;
    private BigDecimal movieBudget;
    private String movieReleaseDate;

   /* public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieCast() {
        return movieCast;
    }

    public void setMovieCast(String movieCast) {
        this.movieCast = movieCast;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public BigDecimal getMovieBudget() {
        return movieBudget;
    }

    public void setMovieBudget(BigDecimal movieBudget) {
        this.movieBudget = movieBudget;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }



   public Movie() {
    }

    public Movie(int movieId, String movieName, String movieCast, String movieGenre, BigDecimal movieBudget, String movieReleaseDate) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieCast = movieCast;
        this.movieGenre = movieGenre;
        this.movieBudget = movieBudget;
        this.movieReleaseDate = movieReleaseDate;
    }*/
}
