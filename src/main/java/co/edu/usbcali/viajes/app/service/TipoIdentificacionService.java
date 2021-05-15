package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;

public interface TipoIdentificacionService {

	/* METODOS */

	/* CONSULTAR */
	
	/**
	 * Permite ver toda la lista de los tipo de identificación.
	 * 
	 * @return List<TipoIdentificacion>
	 * @throws Exception
	 */
	public List<TipoIdentificacion> consultarTipoIdentificaciones() throws Exception;

	/**
	 * Permite ver toda la lista de los tipo de identificación ordenados por nombre.
	 * 
	 * @return List<TipoIdentificacion>s
	 * @throws Exception
	 */
	public List<TipoIdentificacion> consultarTipoIdentificacionesOrdByNombre() throws Exception;

	/* BUSCAR */
	
	/**
	 * Busca un único tipo identificacion.
	 * 
	 * @param IdTipoIdentificacion
	 * @return Optional<TipoIdentificacion>
	 * @throws Exception
	 */
	public Optional<TipoIdentificacion> buscarTipoIdentificacionPorId(int IdTipoIdentificacion) throws Exception;

	/* GUARDAR */

	/**
	 * Guardar un tipo de identificacion
	 * 
	 * @param tipoIdenti
	 * @throws Exception
	 */
	public void guardarTipoIdentificacion(TipoIdentificacion tipoIdenti) throws Exception;

	/* ELIMINAR */
	/**
	 * Elimina un tipo de identificacion
	 * 
	 * @param tipoIdenti
	 * @throws Exception
	 */
	public void eliminarTipoIdentificacion(TipoIdentificacion tipoIdenti) throws Exception;

	/* ACTUALIZAR */
	/**
	 * Actualiza los datos de un tipo de identificación
	 * 
	 * @param tipoIdenti
	 * @throws Exception
	 */
	public void actualizarTipoIdentificacion(TipoIdentificacion tipoIdenti) throws Exception;

	/* QUERY METODOS */

	/**
	 * Permite ver toda la lista de los codigos iguales.
	 * 
	 * @param codigo
	 * @return List<TipoIdentificacion>
	 */
	public List<TipoIdentificacion> findByCodigo(String codigo) throws Exception;

}// END
