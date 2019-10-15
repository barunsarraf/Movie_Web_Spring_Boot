package com.stackroute.Movie.repository;

import com.stackroute.Movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>
{ // this is for mysql
    @Query("FROM Movie where movieName = ?1")
    Movie findmovie(String movieName);
}*/
