package com.eng2tech.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng2tech.dslist.entities.Categoria;
import com.eng2tech.dslist.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
    @Transactional(readOnly = true)
	public List<Categoria> categoriaAll() {
		List<Categoria> result = categoriaRepository.findAll();
		return result;
	}
}