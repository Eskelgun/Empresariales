package co.edu.usbcali.viajes.app.dto;

import java.io.Serializable;
import java.util.Date;

public class PlanDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3974338141504949819L;

	// Atributos de la clase
	private Integer idPlan;
	private String codigo;
	private String descripcionSolicitud;
	private String nombre;
	private Integer cantidadPersonas;
	private Date fechaSolicitud;
	private Date fechaInicioViaje;
	private Date fechaFinViaje;
	private Integer valorTotal;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;
	private Integer idClie;
	private Integer idUsua;

	// Constructores
	public PlanDTO(Integer idPlan, String codigo, String descripcionSolicitud, String nombre, Integer cantidadPersonas,
			Date fechaSolicitud, Date fechaInicioViaje, Date fechaFinViaje, Integer valorTotal, Date fechaCreacion,
			Date fechaModificacion, String usuCreador, String usuModificador, String estado, Integer idClie,
			Integer idUsua) {
		super();
		this.idPlan = idPlan;
		this.codigo = codigo;
		this.descripcionSolicitud = descripcionSolicitud;
		this.nombre = nombre;
		this.cantidadPersonas = cantidadPersonas;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicioViaje = fechaInicioViaje;
		this.fechaFinViaje = fechaFinViaje;
		this.valorTotal = valorTotal;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
		this.idClie = idClie;
		this.idUsua = idUsua;
	}

	public PlanDTO() {
		super();
	}

	// GETS Y SETS
	public Integer getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcionSolicitud() {
		return descripcionSolicitud;
	}

	public void setDescripcionSolicitud(String descripcionSolicitud) {
		this.descripcionSolicitud = descripcionSolicitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaInicioViaje() {
		return fechaInicioViaje;
	}

	public void setFechaInicioViaje(Date fechaInicioViaje) {
		this.fechaInicioViaje = fechaInicioViaje;
	}

	public Date getFechaFinViaje() {
		return fechaFinViaje;
	}

	public void setFechaFinViaje(Date fechaFinViaje) {
		this.fechaFinViaje = fechaFinViaje;
	}

	public Integer getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuCreador() {
		return usuCreador;
	}

	public void setUsuCreador(String usuCreador) {
		this.usuCreador = usuCreador;
	}

	public String getUsuModificador() {
		return usuModificador;
	}

	public void setUsuModificador(String usuModificador) {
		this.usuModificador = usuModificador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdClie() {
		return idClie;
	}

	public void setIdClie(Integer idClie) {
		this.idClie = idClie;
	}

	public Integer getIdUsua() {
		return idUsua;
	}

	public void setIdUsua(Integer idUsua) {
		this.idUsua = idUsua;
	}

}
