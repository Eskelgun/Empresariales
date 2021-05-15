package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import co.edu.usbcali.viajes.app.domain.Cliente;

public interface ClienteService {
	

	/* METODOS */

	/* CONSULTAR */

	/**
	 * Permite ver toda la lista de clientes.
	 * 
	 * @return List<Cliente>
	 * @throws Exception
	 */
	public List<Cliente> consultarClientes() throws Exception;

	/**
	 * Permite ver toda la lista de clientes ordenados por Número identificación
	 * paginados.
	 * 
	 * @return List<Cliente>
	 * @throws Exception
	 */
	public Page<Cliente> consultarClientesOrdByNumIdePage() throws Exception;

	/* BUSCAR */

	/**
	 * Busca un único cliente por su ID; puede o no retornar resultado.
	 * 
	 * @param idCliente
	 * @return Cliente
	 * @throws Exception
	 */
	public Optional<Cliente> buscarClientePorId(int idCliente) throws Exception;

	/* GUARDAR */

	/**
	 * Guarda un nuevo cliente con todos sus datos de entrada.
	 * 
	 * @param cliente
	 * @throws Exception
	 */

	public void guardarCliente(Cliente cliente) throws Exception;
	
	/* ELIMINAR */
	/**
	 * Elimina un cliente
	 * 
	 * @param cliente
	 * @throws Exception
	 */
	public void eliminarCliente(Cliente cliente) throws Exception;

	/* ACTUALIZAR */
	/**
	 * Actualiza un cliente
	 * 
	 * @param cliente
	 * @throws Exception
	 */
	public void actualizarCliente(Cliente cliente) throws Exception;

	/* QUERY METODOS */

	/**
	 * 
	 * @param numIdenti
	 * @return Lista de clientes con igual número de identificación.
	 * @throws Exception
	 */
	public List<Cliente> findByNumeroIdentificacion(String numIdenti) throws Exception;


}
