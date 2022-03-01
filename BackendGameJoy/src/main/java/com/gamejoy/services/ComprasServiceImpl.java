package com.gamejoy.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamejoy.models.ComprasModel;
import com.gamejoy.repositories.ComprasRepository;

@Service
public class ComprasServiceImpl implements ComprasService{

	private ComprasRepository comprasRepository;
	
	public ComprasServiceImpl(@Autowired ComprasRepository comprasRepository) {
		this.comprasRepository = comprasRepository;
	}
	
	@Override
	public ComprasModel crearCompra(ComprasModel comprasModel) {
		return comprasRepository.save(comprasModel);
	}

	@Override
	public List<ComprasModel> obtenerCompras() {
		return comprasRepository.findAll();
	}

	@Override
	public List<ComprasModel> obtenerPorUsuario(Integer id) {
		return comprasRepository.findByUsuario(id);
		
	}


}
