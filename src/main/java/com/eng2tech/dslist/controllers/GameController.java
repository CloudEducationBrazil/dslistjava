package com.eng2tech.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eng2tech.dslist.dto.GameDTO;
import com.eng2tech.dslist.dto.GameMinDTO;
import com.eng2tech.dslist.services.GameService;

@RestController
@RequestMapping(value = "games")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> gameAll(){
		List<GameMinDTO> result = gameService.gameAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public GameDTO gameById(@PathVariable Long id ){
		GameDTO result = gameService.gameById(id);
		return result;
	}
}