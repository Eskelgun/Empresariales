package co.edu.usbcali.viajes.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajes.app.domain.Destino;

public interface DestinoRepository extends JpaRepository<Destino, Integer> {

	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public Destino findByCodigo(@Param("pCodigo") String codigo);

	/**
	 * 
	 * @param codigo
	 * @param estado
	 * @return
	 */
	public Destino findByCodigoAndEstado(@Param("pCodigo") String codigo, @Param("pEstado") String estado);

	/**
	 * 
	 * @param usuCreador
	 * @return
	 */
	public List<Destino> findByTipoDestino_Codigo(String usuCreador);

}
