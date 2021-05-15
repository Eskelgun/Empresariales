package co.edu.usbcali.viajes.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajes.app.domain.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
