package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entity.Theater;
import com.movie.service.TheaterServiceImpl;

@RestController
@RequestMapping("/api/v1/theater")
public class TheaterController {
	@Autowired
	TheaterServiceImpl theaterService;
	
	@PostMapping("/addtheater")
	public Theater addTheater(@RequestBody Theater theater) {
		Theater theaterObj = theaterService.addTheater(theater);
		return theaterObj;
	}
}
