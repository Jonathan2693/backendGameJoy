package com.gamejoy.controllers;


import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gamejoy.models.UsuariosModel;
import com.gamejoy.services.UsuariosService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT} )
public class UsuariosController {

	private UsuariosService usuariosService;
	//private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UsuariosController(@Autowired UsuariosService usuariosService){//,@Autowired BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuariosService = usuariosService;
		//this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@GetMapping("Usuarios/obtenerUsuarios")			//Metodo para obtener todos los usuarios de MySQL
	public ArrayList<UsuariosModel> obtenerUsuarios() {
		return usuariosService.obtenerUsuarios();
	}
	
	@PostMapping(path = "/Usuarios/obtenerUsuarioPorId")		//Se obtiene 
	public UsuariosModel obtenerUsuarioPorId(@RequestBody Map<String,Integer> Json) {
		return usuariosService.obtenerUsuarioPorId(Json.get("id"));		//Implementar trycatch para cuando no exista el id
	}
	
	@PostMapping(path = "/Usuarios/obtenerUsuarioPorNombre")		//Se obtiene Usuario Por Nombre
	public UsuariosModel obtenerUsuarioPorNombre(@RequestBody Map<String,String> Json) {
		return usuariosService.obtenerUsuarioPorNombre(Json.get("nombre"));
	}

	
	@PostMapping(path = "/Usuarios/IniciarSesion")		//Metodo para iniciar sesion : Se obtiene el id del usuarios solo si existe el correo y contraseña
	public Integer iniciarSesion(@RequestBody Map<String,String> Json) {
		return usuariosService.iniciarSesion(Json.get("correo"),Json.get("contrasenia"));
	}
	
	@PostMapping(path = "/Usuarios/crearGuardarUsuario")		//Metodo para iniciar sesion : Se obtiene el id del usuarios solo si existe el correo y contraseña
	public UsuariosModel crearGuardarUsuario(@RequestBody UsuariosModel usuarioModel) {	//Se va a recibir un JSON tipo UsuariosModel para guardarlo o correo, SI EL MODELO TIENE ID, SE MODIFICARA EL USUARIO, DE LO CONTRARIO, SE CREARA UNO NUEVO
		//usuarioModel.setContrasenia(bCryptPasswordEncoder.encode(usuarioModel.getContrasenia()));
		return usuariosService.crearGuardarUsuario(usuarioModel);
	}
}
