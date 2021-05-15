package co.edu.usbcali.viajes.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.usbcali.viajes.app.repository.ClienteRepository;
import co.edu.usbcali.viajes.app.repository.DestinoRepository;
import co.edu.usbcali.viajes.app.repository.TipoDestinoRepository;
import co.edu.usbcali.viajes.app.repository.TipoIdentificacionRepository;
import co.edu.usbcali.viajes.app.service.ClienteService;
import co.edu.usbcali.viajes.app.service.TipoIdentificacionService;

@SpringBootApplication
public class ViajesusbApplication implements CommandLineRunner {

	/* QUITAAAAAAAAAAAAAAAR " " A "" EN SERVICESIMP */

	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private TipoDestinoRepository tipoDestinoRepository;
	@Autowired
	private DestinoRepository destinoRepository;

	/* BORRAR REPOSITORY */
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;

//	MAIN
	public static void main(String[] args) {
		SpringApplication.run(ViajesusbApplication.class, args);
	}

//	run
	@Override
	public void run(String... args) throws Exception {



//		consultarTiposDestinos();
//		consultarClientes();
//		consultarClientesOrdByNumIdePage();
//		consultarTipoIdentificaciones();
//		consultarTipoIdentificacionesOrdByNombre();
//
//		buscarTipoDestinoPorId(null);
//		buscarTipoIdentificacionPorId(null);
//		buscarClientePorId(1);
//
//		guardarCliente();
//		guardarDestino();
//		guardarTipoIdentificacion();
//
//		eliminarCliente(16);
//		eliminarDestino();
//		eliminarTipoIdentificacion(2);
//
//		actualizarCliente();
//		actualizarDestino();
//		actualizarTipoIdentificacion(null);

//		findByNumeroIdentificacion("123");
//		findByCorreo("prueba@hotmail.com");
//		findByEstado(Constantes.ACTIVO);
//		findByNombreLike("%ar%");
//		findByNombreContaining("Car");
//		findByfechaNacimientoBetween();
//		findByNumeroIdentificacionLike("123");
//		findByidTiId_Codigo("CC");

//		consultarClientePorCodigoDeTipoIdentificacion("CC");

	}

	/* CRUD */

	/* Consultar Todos */
//
////	Consultar Todos Tipo Destinos
//	private void consultarTiposDestinos() {
//
//		List<TipoDestino> listTipoDestino = tipoDestinoRepository.findAll();
//		if (!listTipoDestino.isEmpty()) {
//			for (TipoDestino tipoDestino : listTipoDestino) {
//				System.out.println("Tipo destino: " + tipoDestino.getCodigo() + " - " + tipoDestino.getNombre());
//			}
//		} else {
//			System.out.println("No existen datos");
//		}
//
//	}
//
////	Consultar Todos Clientes
//	private void consultarClientes() {
//
//		List<Cliente> lisClientes = null;
//
//		try {
//
//			lisClientes = clienteService.consultarClientes();
//
//			for (Cliente cliente : lisClientes) {
//				System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " ("
//						+ cliente.getIdClie() + ")" + " (" + cliente.getNumeroIdentificacion() + ")  "
//						+ cliente.getCorreo() + "  " + cliente.getFechaNacimiento());
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
////	Consultar Todos Clientes Ordenados por Identificación
//	private void consultarClientesOrdByNumIdePage() {
//
//		Page<Cliente> pageClientes = null;
//
//		try {
//
//			pageClientes = clienteService.consultarClientesOrdByNumIdePage();
//
//			for (Cliente cliente : pageClientes) {
//				System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " ("
//						+ cliente.getIdClie() + ")" + " (" + cliente.getNumeroIdentificacion() + ")");
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//	}
//
////	Consultar Todos Tipo Identificaciones
//	private void consultarTipoIdentificaciones() {
//		List<TipoIdentificacion> listTipoIdentificacion;
//		try {
//			listTipoIdentificacion = tipoIdentificacionService.consultarTipoIdentificaciones();
//
//			for (TipoIdentificacion tipoIdentificacion : listTipoIdentificacion) {
//				System.out.println("Tipo identificacion: " + tipoIdentificacion.getNombre() + " ("
//						+ tipoIdentificacion.getidTiId() + ") " + tipoIdentificacion.getCodigo());	
//
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//
//		}
//
////	Consultar Todos Tipo Identificaciones Ordenados por Nombre
//	private void consultarTipoIdentificacionesOrdByNombre() {
//		List<TipoIdentificacion> listTipoIdentificacion;
//		try {
//			listTipoIdentificacion = tipoIdentificacionService.consultarTipoIdentificacionesOrdByNombre();
//
//			for (TipoIdentificacion tipoIdentificacion : listTipoIdentificacion) {
//				System.out.println("Tipo identificacion: " + tipoIdentificacion.getNombre() + " ("
//						+ tipoIdentificacion.getidTiId() + ")");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//
//	}
//
//	/* FIN Consultar Todos */
//
//	/* Buscar ID */
//
////	Buscar ID Tipo Destino
//	private TipoDestino buscarTipoDestinoPorId(Integer id) {
//
//		Optional<TipoDestino> tipoDestino = tipoDestinoRepository.findById(id);
//
//		if (tipoDestino.isPresent()) {
//			return tipoDestino.get();
//		} else {
//			return null;
//		}
//	}
//
////	Buscar ID Tipo Identificacion
//	private TipoIdentificacion buscarTipoIdentificacionPorId(Integer id) {
//
//		Optional<TipoIdentificacion> tipoIdentificacion = null;
//		try {
//			tipoIdentificacion = tipoIdentificacionService.buscarTipoIdentificacionPorId(id);
//
//			System.out.println(tipoIdentificacion.get().getNombre());
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		return tipoIdentificacion.get();
//
//	}
//
////	Buscar ID Cliente
//	private Optional<Cliente> buscarClientePorId(Integer id) {
//
//		Optional<Cliente> cliente = null;
//
//		try {
//
//			cliente = clienteService.buscarClientePorId(id);
//
//			System.out.println(cliente.get().getNombre());
//
//		} catch (Exception e) {
//
//			System.out.println(e.getMessage());
//		}
//
//		return cliente;
//
//	}
//
//	/* FIN Buscar ID */
//
//	/* Guardar */
//
////	Guardar Destino
//	private void guardarDestino() {
//
//		TipoDestino tide = buscarTipoDestinoPorId(2); //
//
//		Destino destino = new Destino();
//		destino.setAire(Constantes.SI);
//		destino.setCodigo("SAND");
//		destino.setDescripcion("Destino San Andres");
//		destino.setEstado(Constantes.ACTIVO);
//		destino.setFechaCreacion(new Date()); // fecha actual
//		destino.setMar(Constantes.SI);
//		destino.setNombre("San Andres");
//		destino.setTierra(Constantes.SI);
//		destino.setUsuCreador("ESKELGUN");
//		destino.setTipoDestino(tide);
//
//		destinoRepository.save(destino);
//		System.out.println("¡Destino creado satisfactoriamente!");
//
//	}
//
////	Guardar Cliente
//	private void guardarCliente() {
//
//		Cliente cliente = new Cliente();
//
//		try {
//
//			TipoIdentificacion tiIde = buscarTipoIdentificacionPorId(1);
//
//			cliente.setNumeroIdentificacion("564");
//			cliente.setPrimerApellido("Garrido");
//			cliente.setSegundoApellido("");
//			cliente.setNombre("David");
//			cliente.setTelefono1("123");
//			cliente.setCorreo("david@hotmail.com");
//			cliente.setSexo(Constantes.MASCULINO);
//			cliente.setFechaNacimiento(new Date(98, 7, 3));
//			cliente.setFechaCreacion(new Date());
//			cliente.setUsuCreador("ESKELGUN");
//			cliente.setEstado(Constantes.ACTIVO);
//			cliente.setIdTiId(tiIde);
//
//
//			clienteService.guardarCliente(cliente);
//			System.out.println("¡Cliente guardado!");
//		} catch (Exception e) {
//
//			System.out.println(e.getMessage());
//		}
//
//
//	}
//
////	Guardar Tipo Identificacion	
//	private void guardarTipoIdentificacion() {
//
//		TipoIdentificacion tiId = new TipoIdentificacion();
//
//		try {
//			tipoIdentificacionService.guardarTipoIdentificacion(tiId);
//			
//			tiId.setCodigo("CP");
//			tiId.setEstado(Constantes.ACTIVO);
//			tiId.setFechaCreacion(new Date());
//			tiId.setNombre("Cedula Prueba");
//			tiId.setUsuCreador("ESKELGUN");
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("¡Tipo de identificacion insertado con exito!");
//
//	}
//	/* FIN Guardar */
//
//	/* Eliminar */
//
////	Eliminar Destino
//	private void eliminarDestino() {
//
//		Optional<Destino> destino = destinoRepository.findById(1);
//		if (destino.isPresent()) {
//			destinoRepository.delete(destino.get());
//		}
//
//	}
//
////	Eliminar Cliente
//	private void eliminarCliente(int idCliente) {
//
//		Optional<Cliente> clienteOp = null;
//
//
//		try {
//			clienteOp = clienteService.buscarClientePorId(idCliente);
//
//			clienteService.eliminarCliente(clienteOp.get());
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//	}
//
////	Eliminar Tipo Identificacion
//	private void eliminarTipoIdentificacion(int idTipoIdenti) {
//		// consulto el tipo identificacion por su id
//		Optional<TipoIdentificacion> tipoIdentificacionOp;
//		try {
//			tipoIdentificacionOp = tipoIdentificacionService.buscarTipoIdentificacionPorId(idTipoIdenti);
//
//			tipoIdentificacionService.eliminarTipoIdentificacion(tipoIdentificacionOp.get());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	/* FIN Eliminar */
//
//	/* Actualizar */
//
////	Actualizar Destino
//	private void actualizarDestino() {
//
//		Optional<Destino> optional = destinoRepository.findById(1);
//
//		Destino destino = optional.get();
//
//		System.out.println("Destino inicial: " + destino.getCodigo() + destino.getNombre());
//
//		destino.setNombre("Prueba update");
//		destino.setFechaModificacion(new Date());
//		destino.setUsuModificador("ESKELGUN");
//
//		destinoRepository.save(destino);
//
//	}
//
////	Actualizar Cliente
//	private void actualizarCliente() {
//
//		Optional<Cliente> optional = null;
//		Cliente cliente = null;
//
//		try {
//
//			optional = clienteService.buscarClientePorId(1);
//			cliente = optional.get();
//
//			System.out.println("Cliente inicial: " + cliente.getNombre() + " " + cliente.getPrimerApellido());
//
//			cliente.setNombre("David");
//			cliente.setSexo("gg");
//			cliente.setFechaModificacion(new Date());
//			cliente.setUsuModificador("ESKELGUN");
//
//			clienteService.actualizarCliente(cliente);
//			System.out.println("Cliente final: " + cliente.getNombre() + " " + cliente.getPrimerApellido());
//			System.out.println("¡Cliente actualizado con exito!");
//
//		} catch (Exception e) {
//
//			System.out.println(e.getMessage());
//		}
//
//
//	}
//
////	Actualizar Tipo Identificacion
//	private void actualizarTipoIdentificacion(int idTipoIdenti) {
//
//		Optional<TipoIdentificacion> tipoIdentificacionOp;
//		try {
//			tipoIdentificacionOp = tipoIdentificacionService.buscarTipoIdentificacionPorId(idTipoIdenti);
//
//			TipoIdentificacion tipoIdentificacion = tipoIdentificacionOp.get();
//
//			System.out.println("Tipo Identificacion inicial: " + tipoIdentificacion.getNombre());
//
//			tipoIdentificacion.setNombre("Cedula UPDATE");
//			tipoIdentificacion.setFechaModificacion(new Date());
//			tipoIdentificacion.setUsuModificador("ESKELGUN");
//
//			tipoIdentificacionRepository.save(tipoIdentificacion);
//			System.out.println("¡Tipo identificacion actualizado con exito!");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//
//	}
//
//	/* FIN Actualizar */
//
//	/* Metodos Query */
//
//	/* Consultar */
//
////	Consultar Todos Clientes por Número de Identificacion
//	private void findByNumeroIdentificacion(String id) {
//
//		List<Cliente> listClientes = clienteRepository.findByNumeroIdentificacion(id);
//		if (!listClientes.isEmpty()) {
//			for (Cliente cliente : listClientes) {
//				System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " ("
//						+ cliente.getIdClie() + ")" + " (" + cliente.getNumeroIdentificacion() + ")");
//			}
//		} else {
//			System.out.println("No existen datos");
//		}
//
//	}
//
////	Consultar Todos Clientes por Correo
//	private void findByCorreo(String correo) {
//
//		List<Cliente> listClientes = clienteRepository.findByCorreo(correo);
//		if (!listClientes.isEmpty()) {
//			for (Cliente cliente : listClientes) {
//				System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " ("
//						+ cliente.getIdClie() + ")" + " (" + cliente.getNumeroIdentificacion() + ")");
//			}
//		} else {
//			System.out.println("No existen datos");
//		}
//
//	}
//
////	Consultar Todos Clientes por Estado
//	private void findByEstado(String estado) {
//
//		List<Cliente> listClientes = clienteRepository.findByEstado(estado);
//		if (!listClientes.isEmpty()) {
//			for (Cliente cliente : listClientes) {
//				System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " ("
//						+ cliente.getIdClie() + ")" + " (" + cliente.getNumeroIdentificacion() + ")");
//			}
//		} else {
//			System.out.println("No existen datos");
//		}
//
//	}
//
////	Consultar Todos Clientes por Nombre LIKE
//	private void findByNombreLike(String nombre) {
//
//		List<Cliente> listClientes = clienteRepository.findByNombreLike(nombre);
//		if (!listClientes.isEmpty()) {
//			for (Cliente cliente : listClientes) {
//				System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " ("
//						+ cliente.getIdClie() + ")" + " (" + cliente.getNumeroIdentificacion() + ")");
//			}
//		} else {
//			System.out.println("No existen datos");
//		}
//
//	}
//
////	Consultar Todos Clientes por Nombre CONTAINING
//	private void findByNombreContaining(String nombre) {
//
//		List<Cliente> listClientes = clienteRepository.findByNombreContaining(nombre);
//		if (!listClientes.isEmpty()) {
//			for (Cliente cliente : listClientes) {
//				System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " ("
//						+ cliente.getIdClie() + ")" + " (" + cliente.getNumeroIdentificacion() + ")");
//			}
//		} else {
//			System.out.println("No existen datos");
//		}
//
//	}
//
////	Consultar Todos Clientes por Fecha Nacimiento BETWEEN
//	private void findByfechaNacimientoBetween() {
//
//		Calendar fechaIni = new GregorianCalendar(2021, 1, 8);
//		Calendar fechaFin = new GregorianCalendar(2021, 3, 28);
//
//		List<Cliente> listClientes = clienteRepository.findByfechaNacimientoBetween(fechaIni.getTime(),
//				fechaFin.getTime());
//		if (!listClientes.isEmpty()) {
//			for (Cliente cliente : listClientes) {
//				System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " ("
//						+ cliente.getIdClie() + ")" + " (" + cliente.getNumeroIdentificacion() + ")");
//			}
//		} else {
//			System.out.println("No existen datos");
//		}
//
//	}
//
////	Consultar Todos Clientes por Número Identificacion LIKE
//	private void findByNumeroIdentificacionLike(String numIdentificacion) {
//		List<Cliente> listClientes = clienteRepository.findByNumeroIdentificacionLike(numIdentificacion);
//		if (!listClientes.isEmpty()) {
//			for (Cliente cliente : listClientes) {
//				System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " ("
//						+ cliente.getIdClie() + ")" + " (" + cliente.getNumeroIdentificacion() + ")");
//			}
//		} else {
//			System.out.println("No existen datos");
//		}
//	}
//
////	Consultar Todos Clientes por Codigo de Tipo Identificación (FORANEA)
//	private void findByidTiId_Codigo(String codigo) {
//		List<Cliente> listClientes = clienteRepository.findByidTiId_Codigo(codigo);
//		if (!listClientes.isEmpty()) {
//			for (Cliente cliente : listClientes) {
//				System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " ("
//						+ cliente.getIdClie() + ")" + " (" + cliente.getNumeroIdentificacion() + ")");
//			}
//		} else {
//			System.out.println("No existen datos");
//		}
//	}
//
//	/* DTO */
////	Consultar Cliente por Codigo de Tipo Identificacion
//	private void consultarClientePorCodigoDeTipoIdentificacion(String codigo) {
//		List<ClienteDTO> listClientes = clienteRepository.consultarClientePorCodigoDeTipoIdentificacion(codigo);
//		if (!listClientes.isEmpty()) {
//			for (ClienteDTO cliente : listClientes) {
//				System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " ("
//						+ cliente.getNumeroIdentificacion() + ")");
//			}
//		} else {
//			System.out.println("No existen datos");
//		}
//	}
}
