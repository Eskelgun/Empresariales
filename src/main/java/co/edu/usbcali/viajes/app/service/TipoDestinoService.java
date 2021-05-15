package co.edu.usbcali.viajes.app.service;

import java.util.List;

import co.edu.usbcali.viajes.app.domain.TipoDestino;

public interface TipoDestinoService {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<TipoDestino> consultarTiposDestino() throws Exception;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TipoDestino buscarPorId(Integer id) throws Exception;

	/**
	 * 
	 * @param tipoDestino
	 * @throws Exception
	 */
	public void eliminarTipoDestino(TipoDestino tipoDestino) throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<TipoDestino> buscarTodosTiposDestinoOrdenados() throws Exception;

	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public TipoDestino consultaTipoDestinoPorCodigo(String codigo) throws Exception;

	/**
	 * 
	 * @param estado
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public List<TipoDestino> consultaTiposDestinoPorEstadoPorCodigo(String estado, String codigo) throws Exception;
}
