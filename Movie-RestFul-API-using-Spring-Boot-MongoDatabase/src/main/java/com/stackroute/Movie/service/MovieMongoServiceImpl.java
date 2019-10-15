package com.stackroute.Movie.service;

import com.stackroute.Movie.Exception.MovieNotFoundException;
import com.stackroute.Movie.model.Movie;
import com.stackroute.Movie.repository.MovieMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary()
public class MovieMongoServiceImpl implements MovieService {


    private MovieMongoRepository movieMongoRepository;

    @Autowired
    public MovieMongoServiceImpl(MovieMongoRepository movieRepository) {
        this.movieMongoRepository = movieRepository;
    }


    @Override
    public Movie saveMovie(Movie movie) throws MovieNotFoundException {

        System.out.println("this is save method in movie service impl");
        Optional option = movieMongoRepository.findById(movie.getMovieId());
        if(option.isPresent())
        {
            throw new MovieNotFoundException("Movie already present with this id");
        }
        else
        {
            Movie savedmovie =movieMongoRepository.save(movie);
            return savedmovie;
        }


    }

    @Override
    public List<Movie> getallmovie() {
        return movieMongoRepository.findAll();
    }

/*    @Override
    public Movie updateMovie(int movieId,String movieCast) {
        Movie updatemovie=movieRepository.findById(movieId).get();
        updatemovie.setMovieCast(movieCast);
        movieRepository.save(updatemovie);
        return updatemovie;
    }*/

    @Override
    public Movie updateMovieusingput(Movie movie) throws MovieNotFoundException {
        if(movieMongoRepository.existsById(movie.getMovieId()))
        {
            movieMongoRepository.save(movie);
            return movie;
        }
        else
        {
            throw new MovieNotFoundException("Movie is not present with this id");
        }

    }

    @Override
    public Movie getmoviebyid(int movieId) {
        Movie moviebyid=movieMongoRepository.findById(movieId).get();
        return moviebyid;
    }

    @Override
    public Movie deletemoviebyid(int movieId) {
        Movie movie_to_be_deleted = movieMongoRepository.findById(movieId).get();
        movieMongoRepository.delete(movie_to_be_deleted);
        return movie_to_be_deleted;
    }


    @Override
    public Movie getmoviebyname(String movieName) {

        Movie moviebyname= movieMongoRepository.findByMovieName(movieName);
        System.out.println("got movie this"+moviebyname);
        return moviebyname;
    }
}
