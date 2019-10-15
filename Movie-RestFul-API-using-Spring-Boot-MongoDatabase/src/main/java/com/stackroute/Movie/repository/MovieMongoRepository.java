package com.stackroute.Movie.repository;

import com.stackroute.Movie.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieMongoRepository extends MongoRepository<Movie,Integer>{ // this is for mongodb

    Movie findByMovieName(String movieName);
}
