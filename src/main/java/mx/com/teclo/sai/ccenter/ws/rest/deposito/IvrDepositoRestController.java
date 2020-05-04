package mx.com.teclo.sai.ccenter.ws.rest.deposito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.teclo.sai.ccenter.ws.negocio.service.deposito.IvrDepositoService;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.DepositoVO;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.RespuestaVO;
import mx.com.teclo.arquitectura.ortogonales.responsehttp.NotFoundHttpResponse;
import mx.com.teclo.arquitectura.ortogonales.responsehttp.OKHttpResponse;

@RestController
public class IvrDepositoRestController {

	private static final String AUTOR_APP="TCL";
	private static final String NUMERO_SERVICIO_02="02";
	private static final String NUMERO_SERVICIO_03="03";
	
	@Autowired
	private IvrDepositoService ivrDepositoService;
	
	/**
	 * @name   servicio 02
	 * @author DanielUnitis
	 * @param placa
	 * @return NotFoundHttpResponse,OKHttpResponse
	 * @throws NotFoundHttpResponse
	 * @throws OKHttpResponse
	 */
	@RequestMapping(value="/ivrDepositoPorPlaca", method = RequestMethod.GET)
	public ResponseEntity<DepositoVO> obtenerNumDepositoPorPlaca(@RequestParam(name = "placa",defaultValue="null") 
													String placa)throws NotFoundHttpResponse,OKHttpResponse{
		
		RespuestaVO respuestaVO=ivrDepositoService.ivrObtenerDepositoIdPorPlaca(placa);
		String codigo=AUTOR_APP+respuestaVO.getCodigoHttp()+NUMERO_SERVICIO_02;
		DepositoVO depositoVO=respuestaVO.getDepositoVO();
		
		if(depositoVO == null)
			throw new NotFoundHttpResponse(respuestaVO.getDescripcion(),codigo,depositoVO);
		else
			throw new OKHttpResponse(respuestaVO.getDescripcion(),codigo,depositoVO);
	}
	
	
	/**
	 * @name   servicio 03
	 * @author DanielUnitis
	 * @param infraccion
	 * @return
	 * @throws NotFoundHttpResponse
	 * @throws OKHttpResponse
	 */
	@RequestMapping(value="/ivrDepositoPorInfraccion", method = RequestMethod.GET)
	public ResponseEntity<DepositoVO> obtenerNumDepositoPorInfraccion(@RequestParam(name = "infraccion",defaultValue="null") 
													String infraccion) throws NotFoundHttpResponse,OKHttpResponse{
	
		RespuestaVO respuestaVO=ivrDepositoService.ivrObtenerDepositoIdPorInfraccion(infraccion);
		DepositoVO depositoVO=respuestaVO.getDepositoVO();
		
		String codigo=AUTOR_APP+respuestaVO.getCodigoHttp()+NUMERO_SERVICIO_03;
		
		if(depositoVO == null)
			throw new NotFoundHttpResponse(respuestaVO.getDescripcion(),codigo,depositoVO);
		else
			throw new OKHttpResponse(respuestaVO.getDescripcion(),codigo,depositoVO);	
	}
}
