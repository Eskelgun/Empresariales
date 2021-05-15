package co.edu.usbcali.viajes.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;

public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Integer> {

	/* Metodos Query */

//	Buscar por codigo
	public List<TipoIdentificacion> findByCodigo(String codigo);


}
