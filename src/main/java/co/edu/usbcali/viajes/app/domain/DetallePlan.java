package co.edu.usbcali.viajes.app.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_plan")
public class DetallePlan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6187512224921166305L;

	/* Atributos */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_depl", nullable = false, unique = true)
	private Integer idDepl;

	@Column(name = "alimentacion", nullable = false, length = 1)
	private String alimentacion;

	@Column(name = "hospedaje", nullable = false, length = 1)
	private String hospedaje;

	@Column(name = "transporte", nullable = false, length = 1)
	private String transporte;

	@Column(name = "traslados", nullable = false, length = 1)
	private String traslados;

	@Column(name = "valor", nullable = false)
	private Integer valor;

	@Column(name = "cantidad_noches", nullable = false)
	private Integer cantidadNoches;

	@Column(name = "cantidad_dias", nullable = false)
	private Integer cantidadDias;

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
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_plan", nullable = false)
	private Plan idPlan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dest", nullable = false)
	private Destino idDest;

	/* Constructor sobrecargado */
	public DetallePlan(Integer idDepl, String alimentacion, String hospedaje, String transporte, String traslados,
			Integer valor, Integer cantidadNoches, Integer cantidadDias, Date fechaCreacion, Date fechaModificacion,
			String usuCreador, String usuModificador, String estado, Plan idPlan, Destino idDest) {
		super();
		this.idDepl = idDepl;
		this.alimentacion = alimentacion;
		this.hospedaje = hospedaje;
		this.transporte = transporte;
		this.traslados = traslados;
		this.valor = valor;
		this.cantidadNoches = cantidadNoches;
		this.cantidadDias = cantidadDias;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
		this.idPlan = idPlan;
		this.idDest = idDest;
	}

	/* Constructor */
	public DetallePlan() {
		super();
	}

	/* Getters y Setters */
	public Integer getIdDepl() {
		return idDepl;
	}

	public void setIdDepl(Integer idDepl) {
		this.idDepl = idDepl;
	}

	public String getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}

	public String getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(String hospedaje) {
		this.hospedaje = hospedaje;
	}

	public String getTransporte() {
		return transporte;
	}

	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

	public String getTraslados() {
		return traslados;
	}

	public void setTraslados(String traslados) {
		this.traslados = traslados;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer getCantidadNoches() {
		return cantidadNoches;
	}

	public void setCantidadNoches(Integer cantidadNoches) {
		this.cantidadNoches = cantidadNoches;
	}

	public Integer getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(Integer cantidadDias) {
		this.cantidadDias = cantidadDias;
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

	public Plan getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Plan idPlan) {
		this.idPlan = idPlan;
	}

	public Destino getIdDest() {
		return idDest;
	}

	public void setIdDest(Destino idDest) {
		this.idDest = idDest;
	}

} /* END CLASS */
