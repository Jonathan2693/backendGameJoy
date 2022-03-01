package com.gamejoy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamejoy.models.ProductosModel;
import com.gamejoy.repositories.ProductosRepository;

@Service
public class ProductosServiceImpl implements ProductosService{

	private ProductosRepository productosRepository;
	
	public ProductosServiceImpl(@Autowired ProductosRepository productosRepository) {
		this.productosRepository =productosRepository;
	}
	
	@Override
	public List<ProductosModel> obtenerTodos() {
	   return productosRepository.findAll();
	}

	@Override
	public ProductosModel obtenerporId(Integer id) {
		return productosRepository.getById(id);
	}

	@Override
	public List<ProductosModel> obtenerPorCategoria(String categoria) {
		return productosRepository.findByCategoria(categoria);
	}

	@Override
	public ProductosModel nuevoProducto(ProductosModel producto) {
		return productosRepository.save(producto);
	}
}
