package com.eng2tech.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng2tech.dslist.dto.GameDTO;
import com.eng2tech.dslist.dto.GameMinDTO;
import com.eng2tech.dslist.entities.Game;
import com.eng2tech.dslist.projections.GameMinProjection;
import com.eng2tech.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> gameAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto =  result.stream().map(x -> new GameMinDTO(x)).toList();
		
		return dto;
	}

	@Transactional(readOnly = true)
	public GameDTO gameById(Long gameId){
		Game result = gameRepository.findById(gameId).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> categoriesByGames(Long categoriaId){
		List<GameMinProjection> result = gameRepository.searchByCategorie(categoriaId);
		List<GameMinDTO> dto =  result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
