package com.stackroute.Movie.Initiliazer;

import com.stackroute.Movie.Exception.MovieNotFoundException;
import com.stackroute.Movie.model.Movie;
import com.stackroute.Movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    MovieService movieService;

    @Autowired
    public CommandLineRunner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("this is via command line runner");
      /*  try {
            Movie movie= new Movie(2,"CommandLineRunner Mission Impossible","Tom Cruise","Action",new BigDecimal(1000),"Wednesday 2018");
            movieService.saveMovie(movie);

        } catch (MovieNotFoundException e) {
            e.printStackTrace();
        }*/
    }
}
