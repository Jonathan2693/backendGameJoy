package com.gamejoy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamejoy.models.ProductosModel;

@Repository
public interface ProductosRepository extends JpaRepository<ProductosModel, Integer>{
	@Query("select p from ProductosModel p where p.categoria = ?1")
	List<ProductosModel> findByCategoria(String categoria);
}
