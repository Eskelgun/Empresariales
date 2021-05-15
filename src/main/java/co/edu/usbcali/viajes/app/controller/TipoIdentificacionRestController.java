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

import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;
import co.edu.usbcali.viajes.app.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajes.app.service.TipoIdentificacionService;

@RestController
@RequestMapping("/api/tipoIdentificacion")
public class TipoIdentificacionRestController {

	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;

	/* METODOS */

	/* CONSULTAR */

//	Consultar todos los tipos de identificacion
	@GetMapping("/consultarTipoIdentificaciones")
	public ResponseEntity<?> consultarTipoIdentificaciones() {

		try {
			return ResponseEntity.ok(tipoIdentificacionService.consultarTipoIdentificaciones());
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* BUSCAR */
	@GetMapping("/buscarTipoIdentificacionPorId")
	public ResponseEntity<?> buscarTipoIdentificacionPorId(@RequestParam("idTipoIden") int IdTipoIdentificacion) {

		try {
			return ResponseEntity.ok(tipoIdentificacionService.buscarTipoIdentificacionPorId(IdTipoIdentificacion));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* GUARDAR */
	@PostMapping("/guardarTipoIdentificacion")
	public ResponseEntity<?> guardarTipoIdentificacion(@RequestBody TipoIdentificacionDTO TiIdenDTO) {

		try {

			TipoIdentificacion tiId = new TipoIdentificacion();

			tiId.setCodigo(TiIdenDTO.getCodigo());
			tiId.setEstado(TiIdenDTO.getEstado());
			tiId.setFechaCreacion(TiIdenDTO.getFechaCreacion());
			tiId.setNombre(TiIdenDTO.getNombre());
			tiId.setUsuCreador(TiIdenDTO.getUsuCreador());

			tipoIdentificacionService.guardarTipoIdentificacion(tiId);
			System.out.println("¡Tipo identificacion guardado con exito!");
			return ResponseEntity.ok().body(tiId);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}
	
	/* ACTUALIZAR */
	@PutMapping("/actualizarTipoIdentificacion")
	public ResponseEntity<?> actualizarTipoIdentificacion(@RequestBody TipoIdentificacionDTO TiIdenDTO) {

		Optional<TipoIdentificacion> tiIdOP = null;
		TipoIdentificacion tiId = null;

		try {
			tiIdOP = tipoIdentificacionService.buscarTipoIdentificacionPorId(TiIdenDTO.getIdTiId());

			tiId = tiIdOP.get();

			tiId.setNombre(TiIdenDTO.getNombre());
			tiId.setCodigo(TiIdenDTO.getCodigo());
			tiId.setFechaModificacion(TiIdenDTO.getFechaModificacion());
			tiId.setUsuModificador(TiIdenDTO.getUsuModificador());

			tipoIdentificacionService.actualizarTipoIdentificacion(tiId);
			System.out.println("¡Tipo identificacion actualizado con exito!");
			return ResponseEntity.ok().body(tiId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* ELIMINAR */
	@DeleteMapping("/eliminarTipoIdentificacion/{idTipoIdenti}")
	public ResponseEntity<?> eliminarTipoIdentificacion(@PathVariable("idTipoIdenti") int idTipoIdentificacion) {	
		
		Optional<TipoIdentificacion> tipoIdentificacionOp;

		try {
			tipoIdentificacionOp = tipoIdentificacionService.buscarTipoIdentificacionPorId(idTipoIdentificacion);
			tipoIdentificacionService.eliminarTipoIdentificacion(tipoIdentificacionOp.get());

			return ResponseEntity.ok().body(tipoIdentificacionOp.get());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}// END CLASS
