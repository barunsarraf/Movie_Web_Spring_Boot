package com.stackroute.Movie.service;

import com.stackroute.Movie.Exception.MovieNotFoundException;
import com.stackroute.Movie.model.Movie;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie) throws MovieNotFoundException;
    public List<Movie> getallmovie();
   /* public Movie updateMovie(int movieId,String movieCast);*/
    public Movie updateMovieusingput(Movie movie) throws MovieNotFoundException;
    public Movie getmoviebyid(int movieId);
    public Movie deletemoviebyid(int movieId);
    public Movie getmoviebyname(String movieName);
}
