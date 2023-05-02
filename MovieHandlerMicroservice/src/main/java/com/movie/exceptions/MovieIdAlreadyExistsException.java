package com.movie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason="movie id already exists, Handled by custom exception")
public class MovieIdAlreadyExistsException {

}
