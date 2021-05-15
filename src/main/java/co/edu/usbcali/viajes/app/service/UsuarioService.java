package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import co.edu.usbcali.viajes.app.domain.Usuario;

public interface UsuarioService {

	/* METODOS */

	/* CONSULTAR */

	/**
	 * Permite ver toda la lista de Usuarios.
	 * 
	 * @return List<Usuario>
	 * @throws Exception
	 */
	public List<Usuario> consultarUsuarios() throws Exception;

	/* BUSCAR */

	/**
	 * Busca un único Usuario por su ID; puede o no retornar resultado.
	 * 
	 * @param idCliente
	 * @return Usuario
	 * @throws Exception
	 */
	public Optional<Usuario> buscarUsuarioPorId(int idUsuario) throws Exception;

	/* GUARDAR */

	/**
	 * Guarda un nuevo Usuario con todos sus datos de entrada.
	 * 
	 * @param Usuario
	 * @throws Exception
	 */

	public void guardarUsuario(Usuario usuario) throws Exception;

	/* ELIMINAR */
	/**
	 * Elimina un Usuario
	 * 
	 * @param Usuario
	 * @throws Exception
	 */
	public void eliminarUsuario(Usuario usuario) throws Exception;

	/* ACTUALIZAR */
	/**
	 * Actualiza un cliente
	 * 
	 * @param Usuario
	 * @throws Exception
	 */
	public void actualizarUsuario(Usuario usuario) throws Exception;

}
