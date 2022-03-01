package com.gamejoy.controllers;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamejoy.models.ComprasModel;
import com.gamejoy.services.ComprasService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT} )
public class ComprasController {

	private ComprasService comprasService;
	
	public ComprasController(@Autowired ComprasService comprasService) {
		this.comprasService = comprasService;
	}
	
	@GetMapping("Compras/obtenerCompras")
	public ArrayList<ComprasModel> obtenerCompras(){
		return (ArrayList<ComprasModel>) comprasService.obtenerCompras();
	}
	
	@PostMapping("Compras/crearCompra")
	public ComprasModel crearCompra(@RequestBody ComprasModel comprasModel) {
		return comprasService.crearCompra(comprasModel);
	}
	
	@GetMapping("Compras/buscarCompraPorUsuario/{id}")
	public ArrayList<ComprasModel> obtenerComprasPorUsuario(@PathVariable("id") Integer id) {
		return (ArrayList<ComprasModel>) comprasService.obtenerPorUsuario(id);
	}
	
}
