package com.gamejoy.services;
import java.util.ArrayList;

import com.gamejoy.models.UsuariosModel;

public interface UsuariosService {
	
	
	ArrayList<UsuariosModel>  obtenerUsuarios();
	
	UsuariosModel obtenerUsuarioPorId(Integer id);
	
	UsuariosModel obtenerUsuarioPorNombre(String nombre);
	
	Integer iniciarSesion(String correo, String contrasenia);
	
	UsuariosModel crearGuardarUsuario(UsuariosModel usuariosModel);
	/*
	public boolean guardarUsuario(String nombre, String apellido, String correo, String telefono, String direccion, String fechaIngreso, String )*/
}
