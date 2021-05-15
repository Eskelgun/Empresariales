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

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;
import co.edu.usbcali.viajes.app.dto.ClienteDTO;
import co.edu.usbcali.viajes.app.service.ClienteService;
import co.edu.usbcali.viajes.app.service.TipoIdentificacionService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;

	/* METODOS */

	/* CONSULTAR */

//	Consultar todos los clientes	
	@GetMapping("/consultarClientes")
	public ResponseEntity<?> consultarClientes() {

		try {
			return ResponseEntity.ok(clienteService.consultarClientes());
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

//	Consultar todos los clientes ordenados por número identificación paginados	
	@GetMapping("/consultarClientesOrdByNumIdePage")
	public ResponseEntity<?> consultarClientesOrdByNumIdePage() {

		try {
			return ResponseEntity.ok(clienteService.consultarClientesOrdByNumIdePage());
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	/* BUSCAR */

	@GetMapping("/buscarClientePorId")
	public ResponseEntity<?> buscarClientePorId(@RequestParam("idCliente") int idCliente) {

		try {
			return ResponseEntity.ok(clienteService.buscarClientePorId(idCliente));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* GUARDAR */
	@PostMapping("/guardarCliente")
	public ResponseEntity<?> guardarCliente(@RequestBody ClienteDTO clienteDTO) {
		
		TipoIdentificacion tipoIden = null;
		
		try {

			tipoIden = tipoIdentificacionService.buscarTipoIdentificacionPorId(clienteDTO.getIdTiId()).get();

			Cliente cliente = new Cliente();

			cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());
			cliente.setPrimerApellido(clienteDTO.getPrimerApellido());
			cliente.setNombre(clienteDTO.getNombre());
			cliente.setSexo(clienteDTO.getSexo());
			cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
			cliente.setFechaCreacion(clienteDTO.getFechaCreacion());
			cliente.setUsuCreador(clienteDTO.getUsuCreador());
			cliente.setEstado(clienteDTO.getEstado());
			cliente.setIdTiId(tipoIden);
			
			clienteService.guardarCliente(cliente);
			System.out.println("¡Cliente guardado con exito!");
			return ResponseEntity.ok().body(cliente);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* ACTUALIZAR */
	@PutMapping("/actualizarCliente")
	public ResponseEntity<?> actualizarCliente(@RequestBody ClienteDTO clienteDTO) {

		Optional<Cliente> clienteOP = null;
		Cliente cliente = null;

		try {
			clienteOP = clienteService.buscarClientePorId(clienteDTO.getIdClie());
			cliente = clienteOP.get();

			cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());
			cliente.setPrimerApellido(clienteDTO.getPrimerApellido());
			cliente.setNombre(clienteDTO.getNombre());
			cliente.setFechaModificacion(clienteDTO.getFechaModificacion());
			cliente.setUsuModificador(clienteDTO.getUsuModificador());

			clienteService.actualizarCliente(cliente);
			System.out.println("¡Tipo identificacion actualizado con exito!");
			return ResponseEntity.ok().body(cliente);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* ELIMINAR */
	@DeleteMapping("/eliminarCliente/{idCliente}")
	public ResponseEntity<?> eliminarCliente(@PathVariable("idCliente") int idCliente) {

		Optional<Cliente> clienteOP;

		try {
			clienteOP = clienteService.buscarClientePorId(idCliente);
			clienteService.eliminarCliente(clienteOP.get());

			return ResponseEntity.ok().body(clienteOP.get());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}// END CLASS


