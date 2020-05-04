package mx.com.teclo.sai.ccenter.ws.rest.infraccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.teclo.arquitectura.ortogonales.responsehttp.NotFoundHttpResponse;
import mx.com.teclo.arquitectura.ortogonales.responsehttp.OKHttpResponse;
import mx.com.teclo.arquitectura.ortogonales.service.bitacora.BitacoraCambiosService;
import mx.com.teclo.sai.ccenter.ws.negocio.service.infraccion.IvrInfraccionService;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.InfraccionesVO;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.RespuestaVO;


@RestController
public class IvrInfraccionRestController {
	
	private static final String AUTOR_APP="TCL";
	private static final String NUMERO_SERVICIO="01";
	
	@Autowired
	private IvrInfraccionService ivrInfraccionService;
	
	@Autowired
	private BitacoraCambiosService bitacoraCambiosService;
	
	
	/**
	 * @name servicio 01
	 * @author DanielUnitis
	 * @param placa
	 * @return OKHttpResponse,NotFoundHttpResponse
	 * @throws NotFoundHttpResponse
	 * @throws OKHttpResponse
	 */
	@RequestMapping(value="/ivrInfraccionesPorPlaca", method = RequestMethod.GET)	
	public  ResponseEntity<InfraccionesVO> obtenerNumInfraccionesPorPlaca(@RequestParam(name = "placa",defaultValue="null") 
													String placa) throws NotFoundHttpResponse,OKHttpResponse{
		
		
		
		RespuestaVO respuestaVO=ivrInfraccionService.obtenerNumeroInfraccionesPorPlaca(placa);
		
		
		
		InfraccionesVO infraccionesVO=respuestaVO.getInfraccionesVO();
		String codigo=AUTOR_APP+respuestaVO.getCodigoHttp()+NUMERO_SERVICIO;
		
		if(infraccionesVO==null){
			//bitacoraCambiosService.guardarBitacoraCambiosParametros("TAI_BITACORA_CAMBIOS", 2L, 2L,placa,"0",99L, placa, "W");
			throw new NotFoundHttpResponse(respuestaVO.getDescripcion(),codigo,infraccionesVO);
		}else{
			//bitacoraCambiosService.guardarBitacoraCambiosParametros("TAI_BITACORA_CAMBIOS", 2L,2L,placa, infraccionesVO.getNumeroInfracciones().toString(), 99L,placa, "W");
			throw new OKHttpResponse(respuestaVO.getDescripcion(),codigo,infraccionesVO);
		}
			
	}

}
