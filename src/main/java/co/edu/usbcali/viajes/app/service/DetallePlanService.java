package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import co.edu.usbcali.viajes.app.domain.DetallePlan;

public interface DetallePlanService {

	public List<DetallePlan> findAll() throws Exception;

	public Optional<DetallePlan> findById(Integer idDetallePlan);

	public void save(DetallePlan plan) throws Exception;

	public void update(DetallePlan plan) throws Exception;

	public void delete(DetallePlan plan) throws Exception;

	public void deleteById(DetallePlan idDetallePlan) throws Exception;

	public Optional<DetallePlan> buscarDetallePorId(Integer idDetalle) throws Exception;

}
