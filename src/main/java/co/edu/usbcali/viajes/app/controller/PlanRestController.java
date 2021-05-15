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

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.domain.Plan;
import co.edu.usbcali.viajes.app.domain.Usuario;
import co.edu.usbcali.viajes.app.dto.PlanDTO;
import co.edu.usbcali.viajes.app.service.ClienteService;
import co.edu.usbcali.viajes.app.service.PlanService;
import co.edu.usbcali.viajes.app.service.UsuarioService;

@RestController
@RequestMapping("/api/plan")
public class PlanRestController {

	@Autowired
	public PlanService planService;

	@Autowired
	public UsuarioService usuarioService;

	@Autowired
	public ClienteService clienteService;

	@GetMapping("/listarAll")
	public ResponseEntity<?> listarTodosPlanes() {
		try {
			return ResponseEntity.ok().body(planService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@DeleteMapping("/eliminarPlan/{id}")
	public ResponseEntity<?> eliminarPlan(@PathVariable("id") Integer idPlan) {

		try {
			Plan plan = new Plan();
			plan.setIdPlan(idPlan);
			planService.delete(plan);

			return ResponseEntity.ok().body("Se elimino satisfactoriamente");
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/guardarPlan")
	public ResponseEntity<?> guardarPlan(@RequestBody PlanDTO planDTO) {
		try {

			Optional<Usuario> idUs = usuarioService.buscarUsuarioPorId(planDTO.getIdUsua());
			Usuario idUsuario = idUs.get();

			Optional<Cliente> idCli = clienteService.buscarClientePorId(planDTO.getIdClie());
			Cliente idCliente = idCli.get();

			Plan plan = new Plan();
			plan.setCodigo(planDTO.getCodigo());
			plan.setDescripcionSolicitud(planDTO.getDescripcionSolicitud());
			plan.setNombre(planDTO.getNombre());
			plan.setCantidadPersonas(planDTO.getCantidadPersonas());
			plan.setFechaSolicitud(planDTO.getFechaSolicitud());
			plan.setFechaInicioViaje(planDTO.getFechaInicioViaje());
			plan.setFechaFinViaje(planDTO.getFechaFinViaje());
			plan.setValorTotal(planDTO.getValorTotal());
			plan.setFechaCreacion(planDTO.getFechaCreacion());
			plan.setUsuCreador(planDTO.getUsuCreador());
			plan.setEstado(planDTO.getEstado());
			plan.setIdUsua(idUsuario);
			plan.setIdClie(idCliente);
			planService.save(plan);
			return ResponseEntity.ok().body(plan);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PutMapping("/actualizarPlan")
	public ResponseEntity<?> actualizarPlan(@RequestBody PlanDTO planDTO) {
		try {

			Optional<Plan> optional;
			optional = planService.findById(planDTO.getIdPlan());
			Plan currentPlan = optional.get();
			currentPlan.setDescripcionSolicitud(planDTO.getDescripcionSolicitud());
			currentPlan.setNombre(planDTO.getNombre());
			currentPlan.setCantidadPersonas(planDTO.getCantidadPersonas());
			currentPlan.setFechaInicioViaje(new Date());
			currentPlan.setFechaFinViaje(new Date());
			currentPlan.setValorTotal(planDTO.getValorTotal());
			currentPlan.setEstado(planDTO.getEstado());
			currentPlan.setFechaModificacion(new Date());
			currentPlan.setUsuModificador(planDTO.getUsuModificador());
			planService.update(currentPlan);

			return ResponseEntity.ok().body(currentPlan);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
