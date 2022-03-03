package com.gamejoy.models;
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
/*
 *
 * Para la implementacion de USUARIOS Se requiere lo siguiente:
 * 
 * 
 *  **********************iniciar sesion****************************
 * 
 * Un metodo para iniciar sesion, desde el front se enviara el correo y contraseña en ocultos (metodo POST), si existe el usuario traer su info y que regrese el id del usuario o su correo (Int o String) para guardarlo en SESSIONSTORAGE.
 * 
 * 
 *  *****************Cargar usuario***************************
 * Cuando se registre un nuevo usuario o se inicie sesion, SESSIONSTORAGE va a contener el IDUSUARIO.
 * CUANDO TERMINE DE CARGAR LA PAGINA DE PERFIL-USUARIO, SE MANDARA A TRAER LA FILA DEL USUARIO QUE CORRESPONDA A IDUSUARIO (METODO GET CON EL IDUSUARIO OCULTO), SE RECIBIRA COMO JSON Y LOS CAMPOS DE LOS FORMULARIOS SE RELLENARAN CON ESOS VALORES
 * 
 * 
 * 
 * *****************crear un nuevo usuario***************************
 * Crear un nuevo usuario va a requerir del constructor por defecto, que esta basado en el formulario Registrate del FRONTEND
 * SE VA A REALIZAR CON UN METODO POST CON LOS DATOS OCULTOS (DE PREFERENCIA), se enviara un objeto JSON con la info del nuevo usuario, se ingresaran al constructor por defecto y se inyectaran a la base de datos por un servicio
 * 
 * 
 * 
 * ************Actualizar Usuario SOLO DATOS PERSONALES*******************
 * SE ACTUALIZARA EL USUARIO CON UN METODO POST, SE ARMARA UN OBJETO JSON CON LOS DATOS DEL FORMULARIO USUARIO, DESPUES CON UN METODO POST Y EL VALOR QUE TENEMOS EN SESSIONSTORAGE (CORREO O IDUSUARIO), MANDAREMOS A BUSCAR EL LA FILA CORRESPONDIENTE, OBTENEMOS LA FILA Y HACEMOS UNA COPIA, A LA COPIA LE COLOCAMOS LOS VALORES DEL OBJETO JSON Y DESPUES MANDAMOS A GUARDAR ESA COPIA A LA BASE DE DATOS
 * 
 * Actualizar Usuario SOLO DATOS VENDEDOR*******************
 * SE ACTUALIZARA EL USUARIO  DE SUS CAMPOS VENDEDOR CON UN METODO POST, SE ARMARA UN OBJETO JSON CON LOS DATOS DEL FORMULARIO VENDEDOR, DESPUES CON UN METODO POST Y EL VALOR QUE TENEMOS EN SESSIONSTORAGE (CORREO O IDUSUARIO), MANDAREMOS A BUSCAR EL LA FILA CORRESPONDIENTE, OBTENEMOS LA FILA Y HACEMOS UNA COPIA, A LA COPIA LE COLOCAMOS LOS VALORES DEL OBJETO JSON Y DESPUES MANDAMOS A GUARDAR ESA COPIA A LA BASE DE DATOS
 * 
 * **************NO TENEMOS OPCION DE BORRAR USUARIO************************
 * 
 * 
 * 
 * 
 * 
 */

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity		 
@Table(name  = "usuarios")
public class UsuariosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", nullable = false)
	private int id;			//id de usuario
	
	@Column(name = "nombre", nullable = false, length = 255)	
	private String nombre;	//Nombre del usuario
	
	@Column(name = "apellido", nullable = false, length = 255)
	private String apellido;	//apellido de usuario
	
	@Column(name = "correo", nullable = false, length = 255, unique = true)
	private String correo;	//Correo de usuario
	
	@Column(name = "contrasenia", nullable = false, length = 255)
	private String contrasenia;	//Contraseña del usuario
	
	@Column(name = "telefono", nullable = false, length = 255)
	private String telefono;	//Telefono de usuario
	
	@Column(name = "direccion", nullable = false, length = 1000)
	private String direccion;	//Direccion de usuario
	
	@Column(name = "fecha_ingreso", nullable = false, length = 10)
	private String fechaIngreso;	//Fecha de ingreso de usuario
	
	@Column(name = "numero_tarjeta", length = 16)
	private String numeroTarjeta;	//Numero de tarjeta de usuario
	
	@Column(name = "fecha_expiracion", length = 5)
	private String fechaExpiracion;	//Fecha de expiracion de tarjeta
	
	@Column(name = "cvv", length = 3)
	private String cvv;	//CVV de tarjeta
	
	@Column(name = "foto", length = 255)
	private String foto;	//Foto de usuario	*Revisar si el dato es suficiente
	
	@Column(name = "es_vendedor", nullable = false)
	private boolean esVendedor;		//Revisar si hay compatibilidad con MySQL
	
	@Column(name = "comercio", length = 255)
	private String comercio;
	
	@Column(name = "correo_empresa", length = 255)
	private String correoEmpresa;
	
	@Column(name = "telefono_empresa", length = 255)
	private String telefonoEmpresa;
	
	@Column(name = "direccion_empresa", length = 255)
	private String direccionEmpresa;
	
	@OneToMany(mappedBy = "usuario")
	//@JoinColumn(name = "id_usuario")
	private List<ProductosModel> productos;
	
	@OneToMany(mappedBy = "usuario")
	private List<ComprasModel> compras;
	
	public UsuariosModel() {
		}
	/*
	

	public UsuariosModel(int id, String nombre, String apellido, String correo, String contrasenia, String telefono,
			String direccion, String fechaIngreso, String numeroTarjeta, String fechaExpiracion, String cvv,
			String foto, boolean esVendedor, String comercio, String correoEmpresa, String telefonoEmpresa,
			String direccionEmpresa, List<ProductosModel> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaIngreso = fechaIngreso;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaExpiracion = fechaExpiracion;
		this.cvv = cvv;
		this.foto = foto;
		this.esVendedor = esVendedor;
		this.comercio = comercio;
		this.correoEmpresa = correoEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.direccionEmpresa = direccionEmpresa;
		this.productos = productos;
	}
*/


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


	public String getFechaExpiracion() {
		return fechaExpiracion;
	}


	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public boolean isEsVendedor() {
		return esVendedor;
	}


	public void setEsVendedor(boolean esVendedor) {
		this.esVendedor = esVendedor;
	}


	public String getComercio() {
		return comercio;
	}


	public void setComercio(String comercio) {
		this.comercio = comercio;
	}


	public String getCorreoEmpresa() {
		return correoEmpresa;
	}


	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}


	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}


	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}


	public String getDireccionEmpresa() {
		return direccionEmpresa;
	}


	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}


	public List<ProductosModel> getProductos() {
		return productos;
	}


	public void setProductos(List<ProductosModel> productos) {
		this.productos = productos;
	}
	
	
}

