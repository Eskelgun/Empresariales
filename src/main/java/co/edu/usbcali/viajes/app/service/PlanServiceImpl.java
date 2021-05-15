package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.Plan;
import co.edu.usbcali.viajes.app.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	public PlanRepository planRepository;

	// Metodos de los contratos hechos en la interfaz
	@Override
	public List<Plan> findAll() throws Exception {
		List<Plan> listPlan = planRepository.findAll();

//			Validar si la lista está vacía
		if (listPlan.isEmpty()) {
			throw new Exception("No hay planes existentes en el sistema.");
		}

		return listPlan;
	}

	@Override
	public Optional<Plan> findById(Integer idPlan) {

		return planRepository.findById(idPlan);
	}

	@Override
	public void save(Plan plan) throws Exception {
		if (plan == null) {
			throw new Exception("Debe ingresar un plan");
		}
		if (plan.getCodigo() == null || plan.getCodigo().trim().equals("")) {
			throw new Exception("El código no puede ser nulo ni vacio");
		}
		if (plan.getDescripcionSolicitud() == null || plan.getDescripcionSolicitud().trim().equals("")) {
			throw new Exception("La descripción no puede ser nulo ni vacio");
		}
		if (plan.getNombre() == null || plan.getNombre().trim().equals("")) {
			throw new Exception("El nombre no puede ser nulo ni vacio");
		}
		if (plan.getCantidadPersonas() <= 0) {
			throw new Exception("Debes ingresar un número de personas");
		}
		if (plan.getFechaSolicitud() == null) {
			throw new Exception("La fecha no puede ser nula");
		}
		if (plan.getFechaInicioViaje() == null) {
			throw new Exception("La fecha no puede ser nula");
		}
		if (plan.getFechaFinViaje() == null) {
			throw new Exception("La fecha no puede ser nula");
		}
		if (plan.getFechaCreacion() == null) {
			throw new Exception("La fecha no puede ser nula");
		}
		if (plan.getUsuCreador() == null || plan.getUsuCreador().trim().equals("")) {
			throw new Exception("El usuario creador no puede ser nulo ni vacio");
		}
		if (plan.getEstado() == null || plan.getEstado().trim().equals("")) {
			throw new Exception("El estado  no puede ser nulo ni vacio");
		}
		planRepository.save(plan);

	}

	@Override
	public void update(Plan plan) throws Exception {
		if (plan == null) {
			throw new Exception("Debe ingresar un plan");
		}
		if (plan.getUsuModificador() == null || plan.getUsuModificador().trim().equals("")) {
			throw new Exception("El usuario creador no puede ser nulo ni vacio");
		}
		planRepository.save(plan);

	}

	@Override
	public void delete(Plan plan) throws Exception {
		if (plan == null || plan.getIdPlan() == null) {
			throw new Exception("Se debe ingresar un plan a eliminar");
		}

		Optional<Plan> planOP = planRepository.findById(plan.getIdPlan());

		if (planOP.isPresent()) {
			planRepository.delete(planOP.get());
		} else {
			throw new Exception("No existe un destino con ese id.");
		}

	}

	@Override
	public void deleteById(Plan idUsuario) throws Exception {
		// TODO Auto-generated method stub

	}

}
