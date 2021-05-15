package co.edu.usbcali.viajes.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.dto.ClienteDTO;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	/* Metodos Query */

//	Buscar por Identificacion
	public List<Cliente> findByNumeroIdentificacion(String numeroIdentificacion);

//	Buscar por Correo
	public List<Cliente> findByCorreo(String correo);

//	Buscar por Estado
	public List<Cliente> findByEstado(String estado);

//	Buscar por Nombre LIKE
	public List<Cliente> findByNombreLike(String nombre);

//	Buscar por Nombre CONTAINING
	public List<Cliente> findByNombreContaining(String nombre);

//	Buscar por Fecha Nacimiento BETWEEN
	public List<Cliente> findByfechaNacimientoBetween(Date fechaIni, Date fechaFin);

//	Buscar por Número Identificacion LIKE
	public List<Cliente> findByNumeroIdentificacionLike(String numIdentificacion);

//	Buscar por Codigo de Tipo Identificación (FORANEA)
	public List<Cliente> findByidTiId_Codigo(String codigo);
	
	/* DTO */
//	Consultar Cliente por Codigo de Tipo Identificacion 
	@Query(nativeQuery = true)
	public List<ClienteDTO> consultarClientePorCodigoDeTipoIdentificacion(@Param("pCodigo") String codigo);

}
