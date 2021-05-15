package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	/* METODOS */

	/* CONSULTAR */

//	Consultar todos los clientes
	@Override
	public List<Cliente> consultarClientes() throws Exception {

		List<Cliente> listClientes = clienteRepository.findAll();

//		Validar si la lista está vacía
		if (listClientes.isEmpty()) {
			throw new Exception("No hay clientes existentes en el sistema.");
		}

		return listClientes;
	}

//	Consultar todos los clientes ordenados por número identificación paginados
	@Override
	public Page<Cliente> consultarClientesOrdByNumIdePage() throws Exception {

		Page<Cliente> pageClientes = clienteRepository.findAll(PageRequest.of(0, 1, Sort.by("numeroIdentificacion")));

//		Validar si la lista está vacía
		if (pageClientes.isEmpty()) {
			throw new Exception("No hay clientes existentes en el sistema.");
		}

		return pageClientes;
	}

	/* BUSCAR */

	@Override
	public Optional<Cliente> buscarClientePorId(int idCliente) throws Exception {

		Optional<Cliente> cliente = clienteRepository.findById(idCliente);

//		Validar si el cliente existe
		if (!cliente.isPresent()) {
			throw new Exception("No existe cliente con ese ID.");
		}
//		Validar si el ID CLIENTE es mayor o igual a 0
		if (idCliente < 0) {
			throw new Exception("Dato incoherente, debe ser mayor o igual a '0'.");
		}

		return cliente;
	}

	/* GUARDAR */
	@Override
	public void guardarCliente(Cliente cliente) throws Exception {

//		Validar si el cliente existe
		if (cliente == null) {
			throw new Exception("El cliente no existe");
		}

////		Validar ID CLIENTE
//		if (cliente.getIdClie() == null || 
//			cliente.getIdClie() < 0) {
//				throw new Exception("Dato incoherente 'ID CLIENTE', debe ser mayor o igual a '0'.");
//		}


//		Validar NÚMERO IDENTIFICACIÓN
		if (cliente.getNumeroIdentificacion() == null || 
				cliente.getNumeroIdentificacion().trim().equals("") ||
//			cliente.getNumeroIdentificacion().trim().equals("");
			cliente.getNumeroIdentificacion().length() > 15|| 
				findByNumeroIdentificacion(cliente.getNumeroIdentificacion()).size() > 0) {
			throw new Exception(
					"Dato incoherente 'NÚMERO IDENTIFICACIÓN', debe ser menor a '16' caracteres, SIN espacios o NO existente.");
		}
		
//		Validar PRIMER APELLIDO
		if(cliente.getPrimerApellido() == null ||
				cliente.getPrimerApellido().trim().equals("") ||
		   cliente.getPrimerApellido().length() > 100) {
			throw new Exception(
					"Dato incoherente 'PRIMER APELLIDO', debe ser menor a '101' caracteres y SIN espacios.");
			
		}
		
//		Validar SEGUNDO APELLIDO
		if (cliente.getSegundoApellido() != null) {
			if (cliente.getSegundoApellido().trim().equals("") ||
				cliente.getSegundoApellido().length() > 100) {
				throw new Exception(
						"Dato incoherente 'SEGUNDO APELLIDO', debe ser menor a '101' caracteres y SIN espacios.");
			}

		}

//		Validar NOMBRE
		if (cliente.getNombre() == null || 
				cliente.getNombre() == " " ||
			cliente.getNombre().length() > 100) {
			throw new Exception("Dato incoherente 'NOMBRE', debe ser menor a '101' caracteres y NO nulo.");
		}
		
//		Validar TELEFONO1
		if (cliente.getTelefono1() != null) {
			if (cliente.getTelefono1().trim().equals("") ||
				cliente.getTelefono1().length() > 15) {
				throw new Exception(
						"Dato incoherente 'TELEFONO1', debe ser menor a '16' caracteres y SIN espacios.");
			}
		}
		
//		Validar TELEFONO2

		if (cliente.getTelefono2() != null) {
			if (cliente.getTelefono2().trim().equals("") ||
				cliente.getTelefono2().length() > 15) {
				throw new Exception(
						"Dato incoherente 'TELEFONO2', debe ser menor a '16' caracteres y SIN espacios.");

			}
		}
		
//		Validar CORREO
		
//		Validar SEXO
		if (cliente.getSexo() == null || 
				cliente.getSexo().trim().equals("") ||
			cliente.getSexo().length() > 1) {
			throw new Exception("Dato incoherente 'SEXO', debe ser menor a '2' caracteres y SIN espacios.");
	}
		
//		Validar FECHA NACIMIENTO
		if (cliente.getFechaNacimiento() == null) {
				throw new Exception("Dato incoherente 'FECHA NACIMIENTO', NO nulo.");
	}
		
//		Validar FECHA CREACION
		if (cliente.getFechaCreacion() == null) {
				throw new Exception("Dato incoherente 'FECHA CREACION', NO nulo.");
	}
		
//		Validar USUARIO CREADOR
		if (cliente.getUsuCreador() == null || 
				cliente.getUsuCreador().trim().equals("") ||
			cliente.getUsuCreador().length() > 10) {
			throw new Exception("Dato incoherente 'USUARIO CREADOR', debe ser menor a '11' caracteres y NO nulo.");
	}
		
//		Validar USUARIO MODIFICADOR
	if (cliente.getUsuModificador() != null) {
		if (cliente.getUsuModificador().trim().equals("") ||
			cliente.getUsuModificador().length() > 10) {
			throw new Exception("Dato incoherente 'USUARIO MODIFICADOR', debe ser menor a '11' caracteres y NO nulo.");
		}	
	}
	
		
//		Validar ESTADO
		if (cliente.getEstado() == null || 
				cliente.getEstado().trim().equals("") ||
			cliente.getEstado().length() > 1) {
			throw new Exception("Dato incoherente 'ESTADO', debe ser menor a '2' caracteres y SIN espacios. .");
		}
		
//	GUARDAR CLIENTE
	clienteRepository.save(cliente);

	}

	/* ELIMINAR */
	@Override
	public void eliminarCliente(Cliente cliente) throws Exception {

		if (cliente == null) {
			throw new Exception("El cliente no existe");
		}

		clienteRepository.delete(cliente);

	}

	/* ACTUALIZAR */
	@Override
	public void actualizarCliente(Cliente cliente) throws Exception {

//		Validar si el cliente existe
		if (cliente == null) {
			throw new Exception("El cliente no existe");
		}

////		Validar ID CLIENTE
//		if (cliente.getIdClie() == null || 
//			cliente.getIdClie() < 0) {
//				throw new Exception("Dato incoherente 'ID CLIENTE', debe ser mayor o igual a '0'.");
//		}


//		Validar NÚMERO IDENTIFICACIÓN
		if (cliente.getNumeroIdentificacion() == null || 
				cliente.getNumeroIdentificacion().trim().equals("") ||
			cliente.getNumeroIdentificacion().length() > 15|| 
			findByNumeroIdentificacion(cliente.getNumeroIdentificacion()).size() != 0) {
			throw new Exception(
					"Dato incoherente 'NÚMERO IDENTIFICACIÓN', debe ser menor a '16' caracteres, SIN espacios o NO existente.");
		}
		
//		Validar PRIMER APELLIDO
		if(cliente.getPrimerApellido() == null ||
				cliente.getPrimerApellido().trim().equals("") ||
		   cliente.getPrimerApellido().length() > 100) {
			throw new Exception(
					"Dato incoherente 'PRIMER APELLIDO', debe ser menor a '101' caracteres y SIN espacios.");
			
		}
		
//		Validar SEGUNDO APELLIDO
		if (cliente.getSegundoApellido() != null) {
			if (cliente.getSegundoApellido().trim().equals("") ||
				cliente.getSegundoApellido().length() > 100) {
				throw new Exception(
						"Dato incoherente 'SEGUNDO APELLIDO', debe ser menor a '101' caracteres y SIN espacios.");
			}

		}

//		Validar NOMBRE
		if (cliente.getNombre() == null || 
				cliente.getNombre() == " " ||
			cliente.getNombre().length() > 100) {
			throw new Exception("Dato incoherente 'NOMBRE', debe ser menor a '101' caracteres y NO nulo.");
		}
		
//		Validar TELEFONO1
		if (cliente.getTelefono1() != null) {
			if (cliente.getTelefono1().trim().equals("") ||
				cliente.getTelefono1().length() > 15) {
				throw new Exception(
						"Dato incoherente 'TELEFONO1', debe ser menor a '16' caracteres y SIN espacios.");
			}
		}
		
//		Validar TELEFONO2

		if (cliente.getTelefono2() != null) {
			if (cliente.getTelefono2().trim().equals("") ||
				cliente.getTelefono2().length() > 15) {
				throw new Exception(
						"Dato incoherente 'TELEFONO2', debe ser menor a '16' caracteres y SIN espacios.");

			}
		}
		
//		Validar CORREO
		
//		Validar SEXO
		if (cliente.getSexo() == null || 
				cliente.getSexo().trim().equals("") ||
			cliente.getSexo().length() > 1) {
			throw new Exception("Dato incoherente 'SEXO', debe ser menor a '2' caracteres y SIN espacios.");
	}
		
//		Validar FECHA NACIMIENTO
		if (cliente.getFechaNacimiento() == null) {
				throw new Exception("Dato incoherente 'FECHA NACIMIENTO', NO nulo.");
	}
		
//		Validar FECHA CREACION
		if (cliente.getFechaCreacion() == null) {
				throw new Exception("Dato incoherente 'FECHA CREACION', NO nulo.");
	}
		
//		Validar USUARIO CREADOR
		if (cliente.getUsuCreador() == null || 
				cliente.getUsuCreador().trim().equals("") ||
			cliente.getUsuCreador().length() > 10) {
			throw new Exception("Dato incoherente 'USUARIO CREADOR', debe ser menor a '11' caracteres y NO nulo.");
	}
		
//		Validar USUARIO MODIFICADOR
	if (cliente.getUsuModificador() != null) {
		if (cliente.getUsuModificador().trim().equals("") ||
			cliente.getUsuModificador().length() > 10) {
			throw new Exception("Dato incoherente 'USUARIO MODIFICADOR', debe ser menor a '11' caracteres y NO nulo.");
		}	
	}
	
		
//		Validar ESTADO
		if (cliente.getEstado() == null || 
				cliente.getEstado().trim().equals("") ||
			cliente.getEstado().length() > 1) {
			throw new Exception("Dato incoherente 'ESTADO', debe ser menor a '2' caracteres y SIN espacios. .");
		}
		
//		GUARDAR CLIENTE
		clienteRepository.save(cliente);
	}

	/* QUERY METODOS */

	@Override
	public List<Cliente> findByNumeroIdentificacion(String numIdenti) throws Exception {
		
		List<Cliente> listClientes = null;
		
//		Validar NÚMERO IDENTIFICACIÓN
		if (numIdenti == null || 
				numIdenti.trim().equals("") ||
			numIdenti.length() > 15) {
			throw new Exception("Dato incoherente 'NÚMERO IDENTIFICACIÓN', debe ser menor a '16' caracteres .");
		}else {
			
			listClientes = clienteRepository.findByNumeroIdentificacion(numIdenti);

			return listClientes;
		}
		

	}


} // END
