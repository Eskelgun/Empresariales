package co.edu.usbcali.viajes.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.repository.DestinoRepository;
import co.edu.usbcali.viajes.app.utils.Constantes;

@Scope("singleton")
@Service
public class DestinoServiceImpl implements DestinoService {

	@Autowired
	private DestinoRepository destinoRepository;

	@Override
	public void guardarDestino(Destino destino) throws Exception {

		// Se valida que el destino sea ingresado
		if (destino == null) {
			throw new Exception("Debe ingresar un destino");
		}

		// Se valida que el destino tenga un codigo
		if (destino.getCodigo() == null || destino.getCodigo().equals("")) {
			throw new Exception("Debe ingresar un código de destino válido");
		}

		// Se valida que el codigo tenga máximo 5 caracteres
		if (destino.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un código de maximo de 5 caracteres");
		}

		// Se consulta si existe un destino con el codigo ingresado
		Destino destinoBd = consultarDestinoPorCodigoPorEstado(destino.getCodigo(), Constantes.ACTIVO);
		if (destinoBd != null) {
			throw new Exception("El destino con código " + destinoBd.getCodigo() + " ya existe");

		}

		// Se valida que se ingrese el nombre
		if (destino.getNombre() == null || destino.getNombre().equals("")) {
			throw new Exception("Debe ingresar un nombre de destino válido");
		}

		// Se valida que el nombre tenga máximo 100 caracteres
		if (destino.getCodigo().length() > 100) {
			throw new Exception("Debe ingresar un nombre de maximo de 100 caracteres");
		}

		// Se valida que se ingrese una descripcion
		if (destino.getDescripcion() == null || destino.getDescripcion().equals("")) {
			throw new Exception("Debe ingresar una descripción de destino válido");
		}

		// Se valida que la descripción tenga máximo 300 caracteres
		if (destino.getDescripcion().length() > 300) {
			throw new Exception("Debe ingresar una descripción de maximo de 100 caracteres");
		}

		// Se valida la información de acceso al sitio
		if (destino.getTierra() == null || destino.getTierra().equals("") || destino.getAire() == null
				|| destino.getAire().equals("") || destino.getMar() == null || destino.getMar().equals("")) {
			throw new Exception("Debe ingresar la información completa de acceso transporte");
		}

		// Se valida la información de acceso al sitio
		if (destino.getTierra().trim().length() > 1 || destino.getAire().trim().length() > 1
				|| destino.getMar().trim().length() > 1) {
			throw new Exception("Los campos de acceso al sitio deben ser máximo de un caracter");
		}

		// Se valida que se ingrese un usuario creador
		if (destino.getUsuCreador() == null || destino.getUsuCreador().trim().equals("")) {
			throw new Exception("Se debe ingresar un usuario creador");
		}

		if (destino.getUsuCreador().length() > 10) {
			throw new Exception("Se debe ingresar un usuario creador maximo de 10 caracteres");
		}

		// Se empieza a armar el objeto a guardar
		destino.setFechaCreacion(new Date());

		destinoRepository.save(destino);

	}

	@Override
	public void eliminarDestino(Destino destino) throws Exception {

		// Se valida que el destino a eliminar sea ingresado
		if (destino == null || destino.getIdDest() == null) {
			throw new Exception("Se debe ingresar un destino a eliminar");
		}

		// Se consulta ti el destino existe
		Optional<Destino> destinoBD = destinoRepository.findById(destino.getIdDest());

		if (destinoBD.isPresent()) {
			destinoRepository.delete(destinoBD.get());
		} else {
			throw new Exception("No existe un destino con id: " + destino.getIdDest());
		}

	}

	@Override
	public Destino consultarDestinoPorCodigoPorEstado(String codigo, String estado) throws Exception {

		// Se valida que se ingrese un codigo
		if (codigo == null || codigo.trim().equals("")) {
			throw new Exception("Se debe ingresar un código");
		}

		// Se valida que ingrese un estado
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("Se debe ingresar un estado");
		}

		return destinoRepository.findByCodigoAndEstado(codigo, estado);
	}

	@Override
	public void actualizarDestino(Destino destino) throws Exception {

		// Se valida que el destino sea ingresado
		if (destino == null || destino.getIdDest() == null) {
			throw new Exception("Debe ingresar un destino para actualizar");
		}

		// Se valida que el destino tenga un codigo
		if (destino.getCodigo() == null || destino.getCodigo().equals("")) {
			throw new Exception("Debe ingresar un código de destino válido");
		}

		// Se valida que el codigo tenga máximo 5 caracteres
		if (destino.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un código de maximo de 5 caracteres");
		}

		// Se consulta si existe un destino con el codigo ingresado
		Destino destinoBd = consultarDestinoPorCodigoPorEstado(destino.getCodigo(), Constantes.ACTIVO);
		if (destinoBd != null) {
			throw new Exception("El destino con código " + destinoBd.getCodigo() + " ya existe");

		}

		// Se valida que se ingrese el nombre
		if (destino.getNombre() == null || destino.getNombre().equals("")) {
			throw new Exception("Debe ingresar un nombre de destino válido");
		}

		// Se valida que el nombre tenga máximo 100 caracteres
		if (destino.getCodigo().length() > 100) {
			throw new Exception("Debe ingresar un nombre de maximo de 100 caracteres");
		}

		// Se valida que se ingrese una descripcion
		if (destino.getDescripcion() == null || destino.getDescripcion().equals("")) {
			throw new Exception("Debe ingresar una descripción de destino válido");
		}

		// Se valida que la descripción tenga máximo 300 caracteres
		if (destino.getDescripcion().length() > 300) {
			throw new Exception("Debe ingresar una descripción de maximo de 100 caracteres");
		}

		// Se valida la información de acceso al sitio
		if (destino.getTierra() == null || destino.getTierra().equals("") || destino.getAire() == null
				|| destino.getAire().equals("") || destino.getMar() == null || destino.getMar().equals("")) {
			throw new Exception("Debe ingresar la información completa de acceso transporte");
		}

		// Se valida la información de acceso al sitio
		if (destino.getTierra().trim().length() > 1 || destino.getAire().trim().length() > 1
				|| destino.getMar().trim().length() > 1) {
			throw new Exception("Los campos de acceso al sitio deben ser máximo de un caracter");
		}

		// Se valida que se ingrese un usuario creador
		if (destino.getUsuCreador() == null || destino.getUsuCreador().trim().equals("")) {
			throw new Exception("Se debe ingresar un usuario creador");
		}

		if (destino.getUsuCreador().length() > 10) {
			throw new Exception("Se debe ingresar un usuario creador maximo de 10 caracteres");
		}

		// Se valida que se ingrese un usuario creador
		if (destino.getUsuModificador() == null || destino.getUsuModificador().trim().equals("")) {
			throw new Exception("Se debe ingresar un usuario modificador");
		}

		if (destino.getUsuModificador().length() > 10) {
			throw new Exception("Se debe ingresar un usuario modificador maximo de 10 caracteres");
		}

		// Se empieza a armar el objeto a guardar
		destino.setFechaModificacion(new Date());

		destinoRepository.save(destino);

	}

	@Override
	public List<Destino> consultarDestinoPorCodigoTipoDestino(String codigoTipoDestino) throws Exception {

		// Se valida que se ingrese el codigo del tipo de destino
		if (codigoTipoDestino == null || codigoTipoDestino.trim().equals("")) {
			throw new Exception("Se debe ingresar el codigo del tipo de destino");
		}

		return destinoRepository.findByTipoDestino_Codigo(codigoTipoDestino);

	}

	@Override
	public Optional<Destino> buscarPorId(int idDestino) throws Exception {

		Optional<Destino> destinoOP = destinoRepository.findById(idDestino);

		if (destinoOP.isEmpty()) {
			throw new Exception("No se encontró el destino");
		}

		return destinoOP;
	}

}
