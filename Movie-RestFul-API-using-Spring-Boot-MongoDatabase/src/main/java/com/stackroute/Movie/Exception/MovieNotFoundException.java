package com.stackroute.Movie.Exception;

public class MovieNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return message;
    }

    private String message;

    public MovieNotFoundException()
    {

    }

    public MovieNotFoundException(String message1) {
        super(message1);
        this.message = message1;
    }
}
