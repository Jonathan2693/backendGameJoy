package com.gamejoy.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamejoy.models.UsuariosModel;
import com.gamejoy.repositories.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService{

private final UsuariosRepository usuariosRepository;
	
	public UsuariosServiceImpl(@Autowired UsuariosRepository usuariosRepository) {	//Inyeccion de dependencia a traves del repositorio
		this.usuariosRepository = usuariosRepository;
	}
	
	public ArrayList<UsuariosModel>  obtenerUsuarios() {		//Metodo para obtener un usuario por ID
		return (ArrayList<UsuariosModel>) usuariosRepository.findAll();
	}
	
	public UsuariosModel obtenerUsuarioPorId(Integer id) {		//Se obtiene el usuario por ID
		return usuariosRepository.getById(id);
	}
	
	public UsuariosModel obtenerUsuarioPorNombre(String nombre) {	//Se obtiene el usuario por nombre
		return usuariosRepository.findByNombre(nombre);
	}
	
	public Integer iniciarSesion(String correo, String contrasenia) {	//Se obtiene el id del usuario que intente iniciar sesion
		Optional<UsuariosModel> sesion = usuariosRepository.findByCorreoAndContrasenia(correo, contrasenia);
		return sesion.isPresent() ? sesion.get().getId() : 0;
	}
	
	public UsuariosModel crearGuardarUsuario(UsuariosModel usuariosModel) {	//Metodo para guardar datos
		return usuariosRepository.save(usuariosModel);
	}
}
