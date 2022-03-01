package com.gamejoy.services;


import java.util.List;

import com.gamejoy.models.ComprasModel;

public interface ComprasService {
	List<ComprasModel> obtenerCompras();
	ComprasModel crearCompra(ComprasModel comprasModel);
	List<ComprasModel> obtenerPorUsuario(Integer id);
}
