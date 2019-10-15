package com.stackroute.Movie;

//import com.stackroute.Movie.config.ApplicationConfiguration;
import com.stackroute.Movie.controller.MovieController;
import com.stackroute.Movie.model.Movie;
import com.stackroute.Movie.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;


@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = { ApplicationConfiguration.class })
@WebAppConfiguration
public class MovieControllerIT {
    private Movie movie;
    private MockMvc mockMvc;
    private List<Movie> allMovie;


    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;



    @Before
    public void setUp() throws Exception
    {
        movieController = new MovieController(movieService);

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(this.movieController).build();
        BigDecimal result = BigDecimal.valueOf(10000);
        movie= new Movie(1,"mission impossible","tom cruise","action",result,"wednesday 2016");
        Movie movie2= new Movie(2,"avengers","iron man","action",result,"wednesday 2018");
        Movie movie3= new Movie(3,"joker","batman","action",result,"wednesday 2019");
        allMovie = Arrays.asList(movie,movie2,movie3);
    }

    @Test
    public void testMockCreation(){
        assertNotNull(movieService);
        assertNotNull(movieController);
    }

    @Test
    public void testAddMovieSuccess() throws Exception {

        //mockMvc.perform(post("/movie").contentType(MediaType.APPLICATION_JSON).content(String.valueOf(movie)).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        //mockMvc.perform(post("/movie").param("movie", String.valueOf(movie))).andExpect(status().isOk());

    }

}