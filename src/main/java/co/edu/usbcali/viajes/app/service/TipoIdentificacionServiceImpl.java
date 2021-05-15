package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;
import co.edu.usbcali.viajes.app.repository.TipoIdentificacionRepository;

@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {

	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;

	/* METODOS */

	/* CONSULTAR */

//	Consultar todos los tipos de identificacion
	@Override
	public List<TipoIdentificacion> consultarTipoIdentificaciones() throws Exception {

		List<TipoIdentificacion> listTipoIdent = tipoIdentificacionRepository.findAll();

//		Validar si la lista está vacía
		if (listTipoIdent.isEmpty()) {
			throw new Exception("No hay tipos de identificación existentes en el sistema.");
		}

		return listTipoIdent;
	}

	@Override
	public List<TipoIdentificacion> consultarTipoIdentificacionesOrdByNombre() throws Exception {

		List<TipoIdentificacion> listTipoIdent = tipoIdentificacionRepository.findAll(Sort.by("nombre"));

//		Validar si la lista está vacía
		if (listTipoIdent.isEmpty()) {
			throw new Exception("No hay tipos de identificación existentes en el sistema.");
		}

		return listTipoIdent;
	}

	/* BUSCAR */
	@Override
	public Optional<TipoIdentificacion> buscarTipoIdentificacionPorId(int IdTipoIdentificacion) throws Exception {

		Optional<TipoIdentificacion> tipoIdenti = tipoIdentificacionRepository.findById(IdTipoIdentificacion);

//		Validar si el cliente existe
		if (!tipoIdenti.isPresent()) {
			throw new Exception("No existe tipo identificacion con ese ID.");
		}
//		Validar si el ID CLIENTE es mayor o igual a 0
		if (IdTipoIdentificacion < 0) {
			throw new Exception("Dato incoherente, debe ser mayor o igual a '0'.");
		}

		return tipoIdenti;
	}

	/* GUARDAR */
	@Override
	public void guardarTipoIdentificacion(TipoIdentificacion tipoIdenti) throws Exception {

//		Validar si el tipo identificación existe
		if (tipoIdenti == null) {
			throw new Exception("El cliente no existe");
		}

//		Validar CODIGO
		if (tipoIdenti.getCodigo() == null || tipoIdenti.getCodigo().trim().equals("")
				|| tipoIdenti.getCodigo().length() > 5 || findByCodigo(tipoIdenti.getCodigo()).size() > 0) {
			throw new Exception(
					"Dato incoherente 'CODIGO', debe ser menor a '6' caracteres, SIN espacios y NO existir.");
		}
//		Validar NOMBRE
		if (tipoIdenti.getNombre() == null || tipoIdenti.getNombre().trim().equals("")
				|| tipoIdenti.getNombre().length() > 100) {
			throw new Exception("Dato incoherente 'NOMBRE', debe ser menor a '101' caracteres y SIN espacios.");

		}

//		Validar FECHA CREACION
		if (tipoIdenti.getFechaCreacion() == null) {
			throw new Exception("Dato incoherente 'NOMBRE', debe ser menor a '101' caracteres, NO nulo.");
		}

//		Validar USUARIO CREADOR
		if (tipoIdenti.getUsuCreador() == null || tipoIdenti.getUsuCreador().trim().equals("")
				|| tipoIdenti.getUsuCreador().length() > 10) {
			throw new Exception("Dato incoherente 'USUARIO CREADOR', debe ser menor a '11' caracteres, NO nulo.");

		}

//		Validar USUARIO MODIFICADOR
		if (tipoIdenti.getUsuModificador() != null) {
			if (tipoIdenti.getUsuCreador().trim().equals("") || tipoIdenti.getUsuModificador().length() > 10) {
				throw new Exception(
						"Dato incoherente 'USUARIO MODIFICADOR', debe ser menor a '11' caracteres, NO nulo.");

			}
		}

//		Validar ESTADO
		if (tipoIdenti.getEstado() == null || tipoIdenti.getEstado().trim().equals("")
				|| tipoIdenti.getEstado().length() > 1) {
			throw new Exception("Dato incoherente 'ESTADO', debe ser menor a '2' caracteres, NO nulo.");
		}

//		GUARDAR TIPO IDENTIFICACION
		tipoIdentificacionRepository.save(tipoIdenti);

	}

	/* ELIMINAR */
	@Override
	public void eliminarTipoIdentificacion(TipoIdentificacion tipoIdenti) throws Exception {

		if (tipoIdenti == null) {
			throw new Exception("El cliente no existe");
		}

		tipoIdentificacionRepository.delete(tipoIdenti);

	}

	/* ACTUALIZAR */
	@Override
	public void actualizarTipoIdentificacion(TipoIdentificacion tipoIdenti) throws Exception {

//		Validar si el tipo identificación existe
		if (tipoIdenti == null) {
			throw new Exception("El cliente no existe");
		}

//		Validar CODIGO
		if (tipoIdenti.getCodigo() == null || tipoIdenti.getCodigo().trim().equals("")
				|| tipoIdenti.getCodigo().length() > 5 || findByCodigo(tipoIdenti.getCodigo()).size() > 0) {
			throw new Exception(
					"Dato incoherente 'CODIGO', debe ser menor a '6' caracteres, SIN espacios y NO existir.");
		}
//		Validar NOMBRE

		if (tipoIdenti.getNombre() == null || 
				tipoIdenti.getNombre().trim().equals("")
			|| tipoIdenti.getNombre().length() > 100) {
			throw new Exception("Dato incoherente 'NOMBRE', debe ser menor a '101' caracteres y SIN espacios.");

		}

//		Validar FECHA CREACION
		if (tipoIdenti.getFechaCreacion() == null) {
			throw new Exception("Dato incoherente 'NOMBRE', debe ser menor a '101' caracteres, NO nulo.");
		}

//		Validar USUARIO CREADOR
		if (tipoIdenti.getUsuCreador() == null || tipoIdenti.getUsuCreador().trim().equals("")
				|| tipoIdenti.getUsuCreador().length() > 10) {
			throw new Exception("Dato incoherente 'USUARIO CREADOR', debe ser menor a '11' caracteres, NO nulo.");

		}

//		Validar USUARIO MODIFICADOR
		if (tipoIdenti.getUsuModificador() != null) {
			if (tipoIdenti.getUsuCreador().trim().equals("") || tipoIdenti.getUsuModificador().length() > 10) {
				throw new Exception(
						"Dato incoherente 'USUARIO MODIFICADOR', debe ser menor a '11' caracteres, NO nulo.");

			}
		}

//		Validar ESTADO
		if (tipoIdenti.getEstado() == null || tipoIdenti.getEstado().trim().equals("")
				|| tipoIdenti.getEstado().length() > 1) {
			throw new Exception("Dato incoherente 'ESTADO', debe ser menor a '2' caracteres, NO nulo.");
		}

//		GUARDAR TIPO IDENTIFICACION
		tipoIdentificacionRepository.save(tipoIdenti);

	}

//	/* QUERY METODOS */
	@Override
	public List<TipoIdentificacion> findByCodigo(String codigo) throws Exception {

		List<TipoIdentificacion> listTipoIdenti = null;

//		Validar CODIGO
		if (codigo == null || codigo.trim().equals("") || codigo.length() > 5) {
			throw new Exception("Dato incoherente 'CODIGO', debe ser menor a '6' caracteres y NO nulo.");
		} else {

			listTipoIdenti = tipoIdentificacionRepository.findByCodigo(codigo);

			return listTipoIdenti;
		}
	} // end

}
