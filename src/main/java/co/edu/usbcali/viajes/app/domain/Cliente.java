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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.usbcali.viajes.app.dto.ClienteDTO;

/*Query Nativos*/

@NamedNativeQueries({
//	Consultar Cliente por Codigo de Tipo Identificacion
		@NamedNativeQuery(name = "Cliente.consultarClientePorCodigoDeTipoIdentificacion", query = "", resultSetMapping = "consultarClientePorCodigoDeTipoIdentificacion"),
})

@SqlResultSetMappings({
		@SqlResultSetMapping(name = "consultarClientePorCodigoDeTipoIdentificacion", classes = {
				@ConstructorResult(targetClass = ClienteDTO.class, columns = {
						@ColumnResult(name = "numeroIdentificacion", type = String.class),
						@ColumnResult(name = "nombre", type = String.class),
						@ColumnResult(name = "primerApellido", type = String.class), })
					
		}),
})

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4563260005966831557L;

	/* Atributos */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clie", nullable = false, unique = true)
	private Integer idClie;

	@Column(name = "numero_identificacion", nullable = false, length = 15)
	private String numeroIdentificacion;

	@Column(name = "primer_apellido", nullable = false, length = 100)
	private String primerApellido;

	@Column(name = "segundo_apellido", length = 100)
	private String segundoApellido;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "telefono1", length = 15)
	private String telefono1;

	@Column(name = "telefono2", length = 15)
	private String telefono2;

	@Column(name = "correo")
	private String correo;

	@Column(name = "sexo", nullable = false, length = 1)
	private String sexo;

	@Column(name = "fecha_nacimiento", nullable = false)
	private Date fechaNacimiento;

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
	@JoinColumn(name = "id_tiid", nullable = false)
	private TipoIdentificacion idTiId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idClie")
	private List<Plan> plan = new ArrayList<>();

	/* Constructor sobrecargado */
	public Cliente(Integer idClie, String numeroIdentificacion, String primerApellido, String segundoApellido,
			String nombre, String telefono1, String telefono2, String correo, String sexo, Date fechaNacimiento,
			Date fechaCreacion, Date fechaModificacion, String usuCreador, String usuModificador, String estado,
			TipoIdentificacion idTiId) {
		super();
		this.idClie = idClie;
		this.numeroIdentificacion = numeroIdentificacion;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.nombre = nombre;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.correo = correo;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
		this.idTiId = idTiId;
	}

	/* Constructor */
	public Cliente() {
		super();
	}

	/* Getters y Setters */
	public Integer getIdClie() {
		return idClie;
	}

	public void setIdClie(Integer idClie) {
		this.idClie = idClie;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public TipoIdentificacion getIdTiId() {
		return idTiId;
	}

	public void setIdTiId(TipoIdentificacion idTiid) {
		this.idTiId = idTiid;
	}

} /* END CLASS */
