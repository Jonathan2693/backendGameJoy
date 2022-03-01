package com.gamejoy.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gamejoy.models.UsuariosModel;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosModel, Integer>{	//El repositorio de informacion de usuarios (Tabla de usuarios) hereda metodos de JpaRepository para poder trabajar con la informacion

	UsuariosModel findByNombre(String nombre);			//Metodos personalizados
	Optional<UsuariosModel> findByCorreoAndContrasenia(String correo, String contrasenia);	//Metodo personalizado para verificar que exista correo y contraseña, si es asi se crea un objeto Optional que puede contener entidades de usuarios
}
