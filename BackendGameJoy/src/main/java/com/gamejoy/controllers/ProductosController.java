package com.gamejoy.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamejoy.models.ProductosModel;
import com.gamejoy.services.ProductosService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT} )
public class ProductosController {

	private ProductosService productosService;
	
	public ProductosController(@Autowired ProductosService productosService) {
		this.productosService = productosService;
	}
	
	@GetMapping("Productos/obtenerProductos")			//Metodo para obtener todos los usuarios de MySQL
	public ArrayList<ProductosModel> obtenerProductos(){
		return (ArrayList<ProductosModel>) productosService.obtenerTodos();
	}
	
	@PostMapping(path = "Productos/obtenerProductoPorId")		//Se obtiene 
	public ProductosModel obtenerProductoPorId(@RequestBody Map<String,Integer> Json) {
		return productosService.obtenerporId(Json.get("id"));
	}
	
	@GetMapping(path = "Productos/obtenerProductoPorCategoria/{categoria}")		//Se obtiene 
	public List<ProductosModel> obtenerProductoPorCategoria(@PathVariable("categoria") String categoria) {
		return productosService.obtenerPorCategoria(categoria);
	}
	
	@PostMapping(path = "Productos/nuevoProducto")		//Se obtiene 
	public ProductosModel nuevoProducto(@RequestBody ProductosModel productosModel) {
		return productosService.nuevoProducto(productosModel);
	}
}
