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
@Table(name = "destino")
public class Destino implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -942138183833489095L;

	/* Atributos */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dest", nullable = false, unique = true)
	private Integer idDest;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "codigo", nullable = false, length = 5, unique = true)
	private String codigo;

	@Column(name = "descripcion", nullable = false, length = 300)
	private String descripcion;

	@Column(name = "tierra", nullable = false, length = 1)
	private String tierra;

	@Column(name = "aire", nullable = false, length = 1)
	private String aire;

	@Column(name = "mar", nullable = false, length = 1)
	private String mar;

	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;

	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "usu_creador", nullable = false, length = 10)
	private String usuCreador;

	@Column(name = "usu_modificador")
	private String usuModificador;

	@Column(name = "estado", nullable = false, length = 1)
	private String estado;

//	llaves foraneas y relaciones

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tide", nullable = false)
	private TipoDestino tipoDestino;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idDest")
	private List<DetallePlan> detallePlan = new ArrayList<>();

	/* Constructor sobrecargado */
	public Destino(Integer idDest, String nombre, String codigo, String descripcion, String tierra, String aire,
			String mar, Date fechaCreacion, Date fechaModificacion, String usuCreador, String usuModificador,
			String estado, TipoDestino tipoDestino) {
		super();
		this.idDest = idDest;
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.tierra = tierra;
		this.aire = aire;
		this.mar = mar;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
		this.tipoDestino = tipoDestino;
	}

	/* Constructor */
	public Destino() {
		super();
	}

	/* Getters y Setters */
	public Integer getIdDest() {
		return idDest;
	}

	public void setIdDest(Integer idDest) {
		this.idDest = idDest;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTierra() {
		return tierra;
	}

	public void setTierra(String tierra) {
		this.tierra = tierra;
	}

	public String getAire() {
		return aire;
	}

	public void setAire(String aire) {
		this.aire = aire;
	}

	public String getMar() {
		return mar;
	}

	public void setMar(String mar) {
		this.mar = mar;
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

	public TipoDestino getTipoDestino() {
		return tipoDestino;
	}

	public void setTipoDestino(TipoDestino tipoDestino) {
		this.tipoDestino = tipoDestino;
	}

} /* END CLASS */
