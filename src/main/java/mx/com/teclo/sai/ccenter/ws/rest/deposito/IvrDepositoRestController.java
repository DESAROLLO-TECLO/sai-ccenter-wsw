package mx.com.teclo.sai.ccenter.ws.rest.deposito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.teclo.arquitectura.ortogonales.responsehttp.BadRequestHttpResponse;
import mx.com.teclo.sai.ccenter.ws.negocio.service.deposito.IvrDepositoService;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.DepositoVO;

@RestController
public class IvrDepositoRestController {
	
	@Autowired
	private IvrDepositoService ivrDepositoService;
	
	/**
	 * @name servicio 02
	 * @author DanielUnitis
	 * @param placa String
	 * @return Long
	 * @throws BadRequestHttpResponse 
	 */
	@RequestMapping(value="/ivrDepositoPorPlaca", method = RequestMethod.GET)
	public ResponseEntity<Long> obtenerNumDepositoPorPlaca(
			@RequestParam(name = "placa",defaultValue="null") String placa)
					throws BadRequestHttpResponse{
		
		DepositoVO depositoVO = ivrDepositoService.ivrObtenerDepositoIdPorPlaca(placa);
		
		if(depositoVO == null) {
			return new ResponseEntity<Long>(0L, HttpStatus.NOT_FOUND);
			//throw new OKHttpResponse(HttpStatus.OK.toString(), 0);
		}else {
			return new ResponseEntity<Long>(depositoVO.getNumeroDeposito(), HttpStatus.OK);
			//throw new OKHttpResponse(HttpStatus.OK.toString(), depositoVO.getNumeroDeposito());
		}
	}
	
	
	/**
	 * @name   servicio 03
	 * @author DanielUnitis
	 * @param infraccion String
	 * @return Long
	 * @throws BadRequestHttpResponse 
	 */
	@RequestMapping(value="/ivrDepositoPorInfraccion", method = RequestMethod.GET)
	public ResponseEntity<Long> obtenerNumDepositoPorInfraccion(
			@RequestParam(name = "infraccion",defaultValue="null") String infraccion) 
					throws BadRequestHttpResponse{
	
		DepositoVO depositoVO= ivrDepositoService.ivrObtenerDepositoIdPorInfraccion(infraccion);
				
		if(depositoVO == null)
			return new ResponseEntity<Long>(0L, HttpStatus.NOT_FOUND);
			//throw new OKHttpResponse(HttpStatus.OK.toString(), 0);
		else
			return new ResponseEntity<Long>(depositoVO.getNumeroDeposito(), HttpStatus.OK);
			//throw new OKHttpResponse(HttpStatus.OK.toString(), depositoVO.getNumeroDeposito());
	}
}
