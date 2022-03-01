package com.gamejoy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name  = "productos")
public class ProductosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto", nullable = false)
	private int id;
	
	@Column(name = "nombre_producto", nullable = false, length = 255)	
	private String nombreProducto;	
	
	@Column(name = "descripcion", columnDefinition = "text")	
	private String descripcion;	
	
	@Column(name = "imagen", length = 255, nullable = true)	
	private String imagen;
	
	@Column(name = "costo")	
	private Float costo;	
	
	@Column(name = "cantidad")	
	private int cantidad;
	
	@Column(name = "categoria",length = 20)	
	private String categoria;	
	
	@Column(name = "fecha_producto",length = 10)	
	private String fechaProducto;
	
	@ManyToOne
	//@JoinColumn(name = "id")
	@JsonProperty(access = Access.WRITE_ONLY)
    private UsuariosModel usuario;
	
	
	/*@OneToOne(mappedBy = "producto")
    private ComprasModel compras;
	//public ProductosModel() {	
	//}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFechaProducto() {
		return fechaProducto;
	}

	public void setFechaProducto(String fechaProducto) {
		this.fechaProducto = fechaProducto;
	}

	public UsuariosModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuariosModel usuario) {
		this.usuario = usuario;
	}
	
}

	