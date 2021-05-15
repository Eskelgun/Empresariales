package co.edu.usbcali.viajes.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "plan")
public class Plan implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -2088021937129950090L;

	/* Atributos */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_plan", nullable = false, unique = true)
	private Integer idPlan;

	@Column(name = "codigo", nullable = false, length = 5, unique = true)
	private String codigo;

	@Column(name = "descripcion_solicitud", nullable = false, length = 300)
	private String descripcionSolicitud;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "cantidad_personas", nullable = false)
	private Integer cantidadPersonas;

	@Column(name = "fecha_solicitud", nullable = false)
	private Date fechaSolicitud;

	@Column(name = "fecha_inicio_viaje")
	private Date fechaInicioViaje;

	@Column(name = "fecha_fin_viaje")
	private Date fechaFinViaje;

	@Column(name = "valor_total", nullable = false)
	private Integer valorTotal;

	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;

	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "usu_creador", nullable = false, length = 10)
	private String usuCreador;

	@Column(name = "usu_modificador", length = 10)
	private String usuModificador;

	@Column(name = "estado", nullable = false, length = 1)
	private String estado;

//	llaves foraneas y relaciones

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_clie", nullable = false)
	private Cliente idClie;

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usua", nullable = false)
	private Usuario idUsua;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idPlan")
	private List<DetallePlan> detallePlan = new ArrayList<>();

	/* Constructor sobrecargado */
	public Plan(Integer idPlan, String codigo, String descripcionSolicitud, String nombre, Integer cantidadPersonas,
			Date fechaSolicitud, Date fechaInicioViaje, Date fechaFinViaje, Integer valorTotal, Date fechaCreacion,
			Date fechaModificacion, String usuCreador, String usuModificador, String estado, Cliente idClie,
			Usuario idUsua) {
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

	/* Constructor */
	public Plan() {
		super();
	}

	/* Getters and Setters */
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

	public Cliente getIdClie() {
		return idClie;
	}

	public void setIdClie(Cliente idClie) {
		this.idClie = idClie;
	}

	public Usuario getIdUsua() {
		return idUsua;
	}

	public void setIdUsua(Usuario idUsua) {
		this.idUsua = idUsua;
	}

} /* END CLASS */
