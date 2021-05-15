package co.edu.usbcali.viajes.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.dto.TipoDestinoDTO;

public interface TipoDestinoRepository extends JpaRepository<TipoDestino, Integer> {

	/**
	 * 
	 * select * from Tipo_destino where codigo = ?
	 * 
	 */
	public TipoDestino findByCodigo(String codigo);

	/**
	 * 
	 * @param estado
	 * @return
	 */
	public List<TipoDestino> findByEstado(String estado);

	/**
	 * Se deben pasar en orden
	 * 
	 * @param codigo
	 * @param estado
	 * @return
	 */
	public List<TipoDestino> findByCodigoAndEstadoOrderByCodigoDesc(String codigo, String estado);

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public List<TipoDestino> findByFechaCreacionBetween(Date fechaInicio, Date fechaFin);

	/**
	 * 
	 * @param estados
	 * @return
	 */
	public List<TipoDestino> findByEstadoIn(String[] estados);

	/**
	 * 
	 * @param estado
	 * @return
	 */
	public Long countByEstado(String estado);

	/**
	 * 
	 * @param codigo
	 * @param pageable
	 * @return
	 */
	public Page<TipoDestino> findByEstado(String estado, Pageable pageable);

	/**
	 * 
	 * @param estado
	 * @return
	 */
	@Query(nativeQuery = true)
	public List<TipoDestinoDTO> consultarTipoDestinoPorEstado(@Param("pEstado") String estado);

}
