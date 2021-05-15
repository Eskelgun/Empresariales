package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.Usuario;
import co.edu.usbcali.viajes.app.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	/* METODOS */

	/* CONSULTAR */

//	Consultar todos los Usuarios
	@Override
	public List<Usuario> consultarUsuarios() throws Exception {

		List<Usuario> listUsuarios = usuarioRepository.findAll();

//		Validar si la lista está vacía
		if (listUsuarios.isEmpty()) {
			throw new Exception("No hay Usuarios existentes en el sistema.");
		}

		return listUsuarios;
	}

	/* BUSCAR */

	@Override
	public Optional<Usuario> buscarUsuarioPorId(int idUsuario) throws Exception {

		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);

//		Validar si el Usuario existe
		if (!usuario.isPresent()) {
			throw new Exception("No existe cliente con ese ID.");
		}
//		Validar si el ID Usuario es mayor o igual a 0
		if (idUsuario < 0) {
			throw new Exception("Dato incoherente, debe ser mayor o igual a '0'.");
		}

		return usuario;
	}

	/* GUARDAR */

	@Override
	public void guardarUsuario(Usuario usuario) throws Exception {

//		Validar si el Usuario existe
		if (usuario == null) {
			throw new Exception("El usuario no existe");
		}

//		ESTADO
		if (usuario.getEstado() == null || usuario.getEstado().trim().equals("")) {
			throw new Exception("Dato Estado no puede ser vacío ");
		}
//		Fecha Creacion
		if (usuario.getFechaCreacion() == null) {
			throw new Exception("Dato Fecha Creacion no puede ser vacío ");
		}

//		Identificacion
		if (usuario.getIdentificacion() == null || usuario.getIdentificacion().trim().equals("")) {
			throw new Exception("Dato Identificacion no puede ser vacío ");
		}

//		Login
		if (usuario.getLogin() == null || usuario.getLogin().trim().equals("")) {
			throw new Exception("Dato Login no puede ser vacío ");
		}

//		Nombre
		if (usuario.getNombre() == null || usuario.getNombre().trim().equals("")) {
			throw new Exception("Dato Nombre no puede ser vacío ");
		}

//		Password
		if (usuario.getPassword() == null || usuario.getPassword().trim().equals("")
				|| usuario.getPassword().length() <= 5) {
			throw new Exception("Dato Password no puede ser vacío o menor a 6 caracteres ");
		}
//		usuCredor
		if (usuario.getUsuCreador() == null || usuario.getUsuCreador().trim().equals("")) {
			throw new Exception("Usuario creador no puede ser vacío ");
		}

//		GUARDAR USUARIO
		usuarioRepository.save(usuario);

	}

	/* ELIMINAR */
	@Override
	public void eliminarUsuario(Usuario usuario) throws Exception {

		if (usuario == null) {
			throw new Exception("El cliente no existe");
		}

		usuarioRepository.delete(usuario);

	}

	@Override
	public void actualizarUsuario(Usuario usuario) throws Exception {

//		Validar si el Usuario existe
		if (usuario == null) {
			throw new Exception("El usuario no existe");
		}

//		ESTADO
		if (usuario.getEstado() == null || usuario.getEstado().trim().equals("")) {
			throw new Exception("Dato Estado no puede ser vacío ");
		}
//		Fecha Creacion
		if (usuario.getFechaCreacion() == null) {
			throw new Exception("Dato Fecha Creacion no puede ser vacío ");
		}

//		Identificacion
		if (usuario.getIdentificacion() == null || usuario.getIdentificacion().trim().equals("")) {
			throw new Exception("Dato Identificacion no puede ser vacío ");
		}

//		Login
		if (usuario.getLogin() == null || usuario.getLogin().trim().equals("")) {
			throw new Exception("Dato Login no puede ser vacío ");
		}

//		Nombre
		if (usuario.getNombre() == null || usuario.getNombre().trim().equals("")) {
			throw new Exception("Dato Nombre no puede ser vacío ");
		}

//		Password
		if (usuario.getPassword() == null || usuario.getPassword().trim().equals("")
				|| usuario.getPassword().length() <= 5) {
			throw new Exception("Dato Password no puede ser vacío o menor a 6 caracteres ");
		}
		
//		Usuario modificador
		if (usuario.getUsuModificador() == null || usuario.getUsuModificador().trim().equals("")) {
			throw new Exception("Dato Usuario modificador no puede ser vacío");
		}
		
//		Fecha modificacion
		if (usuario.getFechaModificacion() == null) {
			throw new Exception("Dato Fecha modificacion no puede ser vacío ");
		}

//		GUARDAR USUARIO
		usuarioRepository.save(usuario);

	}

}
