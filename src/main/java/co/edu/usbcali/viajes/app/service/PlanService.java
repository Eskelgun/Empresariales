package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import co.edu.usbcali.viajes.app.domain.Plan;

public interface PlanService {

	/**
	 * 
	 * @return List<Plan>
	 * @throws Exception
	 */
	public List<Plan> findAll() throws Exception;

	/**
	 * 
	 * @param idPlan
	 * @return Optional<Plan>
	 * @throws Exception
	 */
	public Optional<Plan> findById(Integer idPlan) throws Exception;

	/**
	 * 
	 * @param plan
	 * @throws Exception
	 */
	public void save(Plan plan) throws Exception;

	/**
	 * 
	 * @param plan
	 * @throws Exception
	 */
	public void update(Plan plan) throws Exception;

	/**
	 * 
	 * @param plan
	 * @throws Exception
	 */
	public void delete(Plan plan) throws Exception;

	/**
	 * 
	 * @param idUsuario
	 * @throws Exception
	 */
	public void deleteById(Plan idUsuario) throws Exception;

}
