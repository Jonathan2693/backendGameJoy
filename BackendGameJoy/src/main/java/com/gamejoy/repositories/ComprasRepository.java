package com.gamejoy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamejoy.models.ComprasModel;

@Repository
public interface ComprasRepository extends JpaRepository<ComprasModel, Integer> {
	
	@Query("select c from ComprasModel c where c.usuario.id = ?1")
	List<ComprasModel> findByUsuario(Integer id);
}
