package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.repository.TipoDestinoRepository;

@Scope("singleton")
@Service
public class TipoDestinoServiceImpl implements TipoDestinoService {

		
		@Autowired
		private TipoDestinoRepository tipoDestinoRepository;
		
		/**
		 * Metodo que consulta todos los tipos de destino
		 */
		@Override
		public List<TipoDestino> consultarTiposDestino() throws Exception{
			
			//Se consulta todos los tipos de destino
			List<TipoDestino> lstTipoDestino = tipoDestinoRepository.findAll();
		
			return lstTipoDestino;
		}

		/**
		 * Metodo que consulta un tipo de destino, dado el id del registro en la tabla id_tide
		 */
		@Override
		public TipoDestino buscarPorId(Integer id) throws Exception {
			
				if(id == null || id == 0) {
					throw new Exception("Por favor ingrese el id del tipo de destino");
				}
				
				//Se consulta por id el tipo de destino
				Optional<TipoDestino> optional = tipoDestinoRepository.findById(id);
				
				//Se valida si existe el tipo de destino
				if(optional.isPresent()) {
					return optional.get();
				}else {
					throw new Exception("No se encontró un tipo de destino con id "+id);
				}
		}
		
		@Override
		public void eliminarTipoDestino(TipoDestino tipoDestino) throws Exception {
			
			//Se valida que el tipo de destino a eliminar se ingrese
			if(tipoDestino == null) {
				throw new Exception("Se debe ingresar un tipo destino a eliminar");
			}
			
			//Se valida que el tipo de destino venga con su llave primaria
			if(tipoDestino.getIdTide() == null) {
				throw new Exception("El tipo destino a eliminar debe tener un identificador");
			}
			
			tipoDestinoRepository.deleteById(tipoDestino.getIdTide());

		}
		
		@Override
		public List<TipoDestino> buscarTodosTiposDestinoOrdenados() throws Exception {
			
			 //Se consulta los tipos de destino ordenados por codigo
			List<TipoDestino> tiposDestino = tipoDestinoRepository.findAll(Sort.by("codigo").descending());
			
			return tiposDestino;
		}

		
		@Override
		public TipoDestino consultaTipoDestinoPorCodigo(String codigo) throws Exception {
			
			//Se valida que se ingrese un código
			if(codigo == null || codigo.trim().equals("")) {
				throw new Exception("Se debe ingresar un codigo del tipo destino");
			}		
			
			return tipoDestinoRepository.findByCodigo(codigo);
		}

		@Override
		public List<TipoDestino> consultaTiposDestinoPorEstadoPorCodigo(String estado, String codigo) throws Exception {
			
			//Se valida que se ingrese un estado
			if(estado == null || estado.trim().equals("")) {
				throw new Exception("Se debe ingresar un estado");
			}
			
			//Se valida que se ingrese un código
			if(codigo == null || codigo.trim().equals("")) {
				throw new Exception("Se debe ingresar un código");
			}
			
			//Retorna la lista resultante de la consulta
			return tipoDestinoRepository.findByCodigoAndEstadoOrderByCodigoDesc(codigo,estado);
			
		}


}
