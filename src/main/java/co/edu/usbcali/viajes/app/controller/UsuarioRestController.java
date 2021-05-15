package co.edu.usbcali.viajes.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajes.app.domain.Usuario;
import co.edu.usbcali.viajes.app.dto.UsuarioDTO;
import co.edu.usbcali.viajes.app.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;

	/* METODOS */

	/* CONSULTAR */

//	Consultar todos los clientes	
	@GetMapping("/consultarUsuarios")
	public ResponseEntity<?> consultarUsuarios() {

		try {
			return ResponseEntity.ok(usuarioService.consultarUsuarios());
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	/* BUSCAR */

	@GetMapping("/buscarUsuarioPorId")
	public ResponseEntity<?> buscarUsuarioPorId(@RequestParam("idUsuario") int idUsuario) {

		try {
			return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(idUsuario));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* GUARDAR */
	@PostMapping("/guardarUsuario")
	public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {

		try {

			Usuario usuario = new Usuario();

			usuario.setEstado(usuarioDTO.getEstado());
			usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
			usuario.setIdentificacion(usuarioDTO.getIdentificacion());
			usuario.setLogin(usuarioDTO.getLogin());
			usuario.setNombre(usuarioDTO.getNombre());
			usuario.setPassword(usuarioDTO.getPassword());
			usuario.setUsuCreador(usuarioDTO.getUsuCreador());

			usuarioService.guardarUsuario(usuario);
			System.out.println("¡usuario guardado con exito!");
			return ResponseEntity.ok().body(usuario);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* ACTUALIZAR */
	@PutMapping("/actualizarUsuario")
	public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {

		Optional<Usuario> usuarioOP = null;
		Usuario usuario = null;

		try {
			usuarioOP = usuarioService.buscarUsuarioPorId(usuarioDTO.getIdUsua());
			usuario = usuarioOP.get();

			usuario.setEstado(usuarioDTO.getEstado());
			usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
			usuario.setIdentificacion(usuarioDTO.getIdentificacion());
			usuario.setLogin(usuarioDTO.getLogin());
			usuario.setNombre(usuarioDTO.getNombre());
			usuario.setPassword(usuarioDTO.getPassword());

			usuarioService.actualizarUsuario(usuario);
			System.out.println("¡usuario guardado con exito!");
			return ResponseEntity.ok().body(usuario);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* ELIMINAR */
	@DeleteMapping("/eliminarUsuario/{idUsuario}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable("idUsuario") int idUsuario) {

		Optional<Usuario> usuarioOP;

		try {
			usuarioOP = usuarioService.buscarUsuarioPorId(idUsuario);
			usuarioService.eliminarUsuario(usuarioOP.get());

			return ResponseEntity.ok().body(usuarioOP.get());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
