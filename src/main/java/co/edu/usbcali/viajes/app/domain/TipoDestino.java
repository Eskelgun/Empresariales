package co.edu.usbcali.viajes.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import co.edu.usbcali.viajes.app.dto.TipoDestinoDTO;

@NamedNativeQueries({
		@NamedNativeQuery(name = "TipoDestino.consultarTipoDestinoPorEstado", query = "", resultSetMapping = "consultarTipoDestinoPorEstado"), })

@SqlResultSetMappings({ @SqlResultSetMapping(name = "consultarTipoDestinoPorEstado", classes = {
		@ConstructorResult(targetClass = TipoDestinoDTO.class, columns = {
				@ColumnResult(name = "idTide", type = Integer.class),
				@ColumnResult(name = "codigo", type = String.class),
				@ColumnResult(name = "nombre", type = String.class),
				@ColumnResult(name = "descripcion", type = String.class),

		}) }), })

@Entity
@Table(name = "tipo_destino")
public class TipoDestino implements Serializable {

	private static final long serialVersionUID = 3930530604134388814L;

	/* Atributos */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tide", nullable = false, unique = true)
	private Integer idTide;

	@Column(name = "codigo", nullable = false, length = 5, unique = true)
	private String codigo;

	@Column(name = "nombre", nullable = false, length = 100, unique = true)
	private String nombre;

	@Column(name = "descripcion", nullable = false, length = 300)
	private String descripcion;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDestino")
	private List<Destino> destino = new ArrayList<>();

	/* Constructor sobrecargado */
	public TipoDestino(Integer idTide, String codigo, String nombre, String descripcion, Date fechaCreacion,
			Date fechaModificacion, String usuCreador, String usuModificador, String estado) {
		super();
		this.idTide = idTide;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
	}

	/* Constructor */
	public TipoDestino() {
		super();
	}

	/* Getters y Setters */
	public Integer getIdTide() {
		return idTide;
	}

	public void setIdTide(Integer idTide) {
		this.idTide = idTide;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

} /* END CLASS */
