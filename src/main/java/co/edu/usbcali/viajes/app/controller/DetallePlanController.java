package co.edu.usbcali.viajes.app.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.DetallePlan;
import co.edu.usbcali.viajes.app.domain.Plan;
import co.edu.usbcali.viajes.app.dto.DetallePlanDTO;
import co.edu.usbcali.viajes.app.service.DestinoService;
import co.edu.usbcali.viajes.app.service.DetallePlanService;
import co.edu.usbcali.viajes.app.service.PlanService;

@RestController
@RequestMapping("/api/detallePlan")
public class DetallePlanController {

	@Autowired
	public DetallePlanService detallePService;

	@Autowired
	public DestinoService destinoService;

	@Autowired
	public PlanService planService;

	@GetMapping("/listarAll")
	public ResponseEntity<?> listarTodosDetalles() {
		try {
			return ResponseEntity.ok().body(detallePService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@DeleteMapping("/eliminarDetalle/{id}")
	public ResponseEntity<?> eliminarDetalle(@PathVariable("id") Integer idDetalle) {

		try {
			DetallePlan detallePlan = new DetallePlan();
			detallePlan.setIdDepl(idDetalle);
			detallePService.delete(detallePlan);

			return ResponseEntity.ok().body("Se elimino satisfactoriamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

	@PostMapping("/guardarDetalle")
	public ResponseEntity<?> guardarDetalle(@RequestBody DetallePlanDTO detalleDTO) {
		try {

			Optional<Destino> tide = destinoService.buscarPorId(detalleDTO.getIdDest());
			Destino idDestino = tide.get();

			Optional<Plan> tipl = planService.findById(detalleDTO.getIdPlan());
			Plan idPlan = tipl.get();

			DetallePlan detalle = new DetallePlan();
			detalle.setAlimentacion(detalleDTO.getAlimentacion());
			detalle.setCantidadNoches(detalleDTO.getCantidadNoches());
			detalle.setCantidadDias(detalleDTO.getCantidadDias());
			detalle.setEstado(detalleDTO.getEstado());
			detalle.setFechaCreacion(detalleDTO.getFechaCreacion());
			detalle.setHospedaje(detalleDTO.getHospedaje());
			detalle.setTransporte(detalleDTO.getTransporte());
			detalle.setTraslados(detalleDTO.getTraslados());
			detalle.setUsuCreador(detalleDTO.getUsuCreador());
			detalle.setValor(detalleDTO.getValor());
			detalle.setIdDest(idDestino);
			detalle.setIdPlan(idPlan);
			detallePService.save(detalle);
			return ResponseEntity.ok().body(detalle);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PutMapping("/actualizarDetalle")
	public ResponseEntity<?> actualizarDetalle(@RequestBody DetallePlanDTO detalleDTO) {
		try {

			Optional<DetallePlan> optional;
			optional = detallePService.buscarDetallePorId(detalleDTO.getIdDepl());
			DetallePlan detalleNew = optional.get();

			detalleNew.setAlimentacion(detalleDTO.getAlimentacion());
			detalleNew.setCantidadNoches(detalleDTO.getCantidadNoches());
			detalleNew.setCantidadDias(detalleDTO.getCantidadDias());
			detalleNew.setEstado(detalleDTO.getEstado());
			detalleNew.setHospedaje(detalleDTO.getHospedaje());
			detalleNew.setTransporte(detalleDTO.getTransporte());
			detalleNew.setTraslados(detalleDTO.getTraslados());
			detalleNew.setValor(detalleDTO.getValor());
			detalleNew.setUsuModificador(detalleDTO.getUsuModificador());
			detalleNew.setFechaModificacion(new Date());
			detallePService.update(detalleNew);

			return ResponseEntity.ok().body(detalleNew);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
