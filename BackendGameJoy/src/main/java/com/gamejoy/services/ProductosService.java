package com.gamejoy.services;

import java.util.List;
import com.gamejoy.models.ProductosModel;

public interface ProductosService {

	List<ProductosModel> obtenerTodos();
	ProductosModel obtenerporId(Integer id);
	List<ProductosModel> obtenerPorCategoria(String categoria);
	ProductosModel nuevoProducto(ProductosModel producto);
	
}
