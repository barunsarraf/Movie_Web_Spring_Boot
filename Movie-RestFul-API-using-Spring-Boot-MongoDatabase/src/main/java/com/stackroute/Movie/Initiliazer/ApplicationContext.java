package com.stackroute.Movie.Initiliazer;

import com.stackroute.Movie.Exception.MovieNotFoundException;
import com.stackroute.Movie.model.Movie;
import com.stackroute.Movie.service.MovieService;
//import com.stackroute.Movie.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;

@Component
// @PropertySource(value = { "classpath:application.properties" }) // this is via property source
@ConfigurationProperties(prefix = "movieapp")
public class ApplicationContext implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }


    MovieService movieService;
    //adding application context and commmaandlinerunner added already



    //uncomment it for using property source and remove the property source bean from application configuration
    /*@Autowired
    private Environment environment;
*/

    //uncomment this for using value annotation injection
   /* @Value("${movieid1:56}")
    private int movieid1;

    @Value("${moviename:newmovie}")
    private String moviename;

    @Value("${moviecast:newmoviecast}")
    private String moviecast;

    @Value("${moviegenre:newmoviegenre}")
    private String moviegenre;

    @Value("${moviebudget:3}")
    private BigDecimal moviebudget;

    @Value("${moviedate:friday 2018}")
    private String moviedate;*/


    private int movieid1;
    private String moviename;
    private String moviecast;
    private String moviegenre;
    private BigDecimal moviebudget;
    private String moviedate;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        System.out.println("This is via Application Context");
/*
        try {
            Movie movie= new Movie(1,"Application Mission Impossible","Tom Cruise","Action",new BigDecimal(1000),"Wednesday 2018");
            movieService.saveMovie(movie);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
        }*/

        //this is via property source
       /* try {
            Movie movie= new Movie(Integer.parseInt(environment.getProperty("movieid1")),environment.getProperty("moviename"),environment.getProperty("moviecast"),environment.getProperty("moviegenre"), new BigDecimal(Integer.parseInt(environment.getProperty("moviebudget"))),environment.getProperty("moviedate"));
            movieService.saveMovie(movie);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
        }*/



        //this is via value source
     /*   try {
            Movie movie= new Movie(movieid1,moviename,moviecast,moviegenre,moviebudget,moviedate);
            movieService.saveMovie(movie);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
        }*/



     //this is via configuration properties

      /*  try {
            System.out.println(movieid1);
            Movie movie= new Movie(movieid1,moviename,moviecast,moviegenre,moviebudget,moviedate);
            movieService.saveMovie(movie);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
        }*/



    }
}
