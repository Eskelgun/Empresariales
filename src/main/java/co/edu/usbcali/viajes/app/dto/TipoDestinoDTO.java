package co.edu.usbcali.viajes.app.dto;

import java.io.Serializable;
import java.util.Date;

public class TipoDestinoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2869386498879066469L;
	
	private Integer idTide;
	private String codigo;
	private String nombre;
	private String descripcion;	
	private Date fechaCreacion;	
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;

	
	/**
	 * @param idTide
	 * @param codigo
	 * @param nombre
	 * @param descripcion
	 */
	public TipoDestinoDTO(Integer idTide, String codigo, String nombre, String descripcion) {
		super();
		this.idTide = idTide;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	/**
	 * @return the idTide
	 */
	public Integer getIdTide() {
		return idTide;
	}
	/**
	 * @param idTide the idTide to set
	 */
	public void setIdTide(Integer idTide) {
		this.idTide = idTide;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the usuCreador
	 */
	public String getUsuCreador() {
		return usuCreador;
	}
	/**
	 * @param usuCreador the usuCreador to set
	 */
	public void setUsuCreador(String usuCreador) {
		this.usuCreador = usuCreador;
	}
	/**
	 * @return the usuModificador
	 */
	public String getUsuModificador() {
		return usuModificador;
	}
	/**
	 * @param usuModificador the usuModificador to set
	 */
	public void setUsuModificador(String usuModificador) {
		this.usuModificador = usuModificador;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
