package com.eng2tech.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eng2tech.dslist.dto.GameMinDTO;
import com.eng2tech.dslist.entities.Categoria;
import com.eng2tech.dslist.services.CategoriaService;
import com.eng2tech.dslist.services.GameService;

@RestController
@RequestMapping(value = "/categories")
public class CategoriaController {
	
	   @Autowired
	   private CategoriaService categoriaService;

	   @Autowired
	   private GameService gameService;

   @GetMapping
   public List<Categoria> categoriaAll() {
	   List<Categoria> result = categoriaService.categoriaAll();
	   return result;
   }

   @GetMapping(value = "/{idCategoria}/games")
   public List<GameMinDTO> categoriesByGames(@PathVariable Long idCategoria) {
	   List<GameMinDTO> result = gameService.categoriesByGames(idCategoria);
	   return result;
   }
}