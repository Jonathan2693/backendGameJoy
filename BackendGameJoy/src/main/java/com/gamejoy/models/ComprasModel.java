package com.gamejoy.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "compras")
public class ComprasModel {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra", nullable = false)
	private int id;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "fecha_Compra", length = 10)
	private String fechaCompra;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
    private UsuariosModel usuario;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	private ProductosModel producto;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public UsuariosModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuariosModel usuario) {
		this.usuario = usuario;
	}

	public ProductosModel getProducto() {
		return producto;
	}

	public void setProducto(ProductosModel producto) {
		this.producto = producto;
	}

	
    
}
