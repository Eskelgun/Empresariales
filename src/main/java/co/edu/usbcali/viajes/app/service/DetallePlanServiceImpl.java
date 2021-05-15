package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.DetallePlan;
import co.edu.usbcali.viajes.app.repository.DetallePlanRepository;

@Service
public class DetallePlanServiceImpl implements DetallePlanService {

	@Autowired
	public DetallePlanRepository detallePRepository;

	// Metodos de los contratos hechos en la interfaz
	@Override
	public List<DetallePlan> findAll() throws Exception {
		List<DetallePlan> listDetalle = detallePRepository.findAll();

//		Validar si la lista está vacía
		if (listDetalle.isEmpty()) {
			throw new Exception("No hay detalles de plan existentes.");
		}

		return listDetalle;
	}

	@Override
	public Optional<DetallePlan> findById(Integer idDetallePlan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(DetallePlan entity) throws Exception {
		if (entity == null) {
			throw new Exception("Debe ingresar un detalle de plan");
		}
		if (entity.getAlimentacion() == null || entity.getAlimentacion().trim().equals("")
				|| entity.getAlimentacion().length() > 1) {
			throw new Exception("Alimentacion no puede ser nulo, ni contener mas de 1 caracter o estar vacio");
		}
		if (entity.getHospedaje() == null || entity.getHospedaje().trim().equals("")
				|| entity.getHospedaje().length() > 1) {
			throw new Exception("Hospedaje no puede ser nulo, ni contener mas de 1 caracter o estar vacio");
		}
		if (entity.getTraslados() == null || entity.getTraslados().trim().equals("")
				|| entity.getTraslados().length() > 1) {
			throw new Exception("Traslados no puede ser nulo, ni contener mas de 1 caracter o estar vacio");
		}
		if (entity.getTransporte() == null || entity.getTransporte().trim().equals("")
				|| entity.getTransporte().length() > 1) {
			throw new Exception("Transporte no puede ser nulo, ni contener mas de 1 caracter o estar vacio");
		}
		if (entity.getValor() <= 0) {
			throw new Exception("Valor no puede ser menor o igual a 0");
		}
		if (entity.getCantidadDias() <= 0) {
			throw new Exception("Cantidad de días no puede ser menor o igual a 0");
		}
		if (entity.getCantidadNoches() <= 0) {
			throw new Exception("Cantidad de noches no puede ser menor o igual a 0");
		}
		if (entity.getUsuCreador() == null || entity.getUsuCreador().trim().equals("")) {
			throw new Exception("Usuario creador no debe ser nulo ni estar vacio");
		}
		if (entity.getEstado() == null || entity.getEstado().trim().equals("")) {
			throw new Exception("Estado no puede ser nulo ni estar vacio");
		}

		detallePRepository.save(entity);
	}

	@Override
	public void update(DetallePlan entity) throws Exception {

		if (entity == null) {
			throw new Exception("Debe ingresar un detalle de plan");
		}

		if (entity.getUsuModificador() == null || entity.getUsuModificador().trim().equals("")) {
			throw new Exception("El usuario modificador es obligatorio");
		}
		detallePRepository.save(entity);
	}

	@Override
	public void delete(DetallePlan entity) throws Exception {
		if (entity == null || entity.getIdDepl() == null) {
			throw new Exception("Se debe ingresar un detalle a eliminar");
		}

		Optional<DetallePlan> detalleDB = detallePRepository.findById(entity.getIdDepl());

		if (detalleDB.isPresent()) {
			detallePRepository.delete(detalleDB.get());
		} else {
			throw new Exception("No existe un destino con ese id.");
		}

	}

	@Override
	public void deleteById(DetallePlan idDetallePlan) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<DetallePlan> buscarDetallePorId(Integer idDetalle) throws Exception {

		Optional<DetallePlan> detalle = detallePRepository.findById(idDetalle);

//		Validar si el cliente existe
		if (!detalle.isPresent()) {
			throw new Exception("No existe cliente con ese ID.");
		}
//		Validar si el ID CLIENTE es valido
		if (idDetalle < 0) {
			throw new Exception("ID invalido");
		}

		return detalle;

	}

}
