package mx.com.teclo.sai.ccenter.ws.negocio.service.deposito;

import mx.com.teclo.arquitectura.ortogonales.responsehttp.BadRequestHttpResponse;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.DepositoVO;

public interface IvrDepositoService{
	
	DepositoVO ivrObtenerDepositoIdPorPlaca(String placa) throws BadRequestHttpResponse;
	
	DepositoVO ivrObtenerDepositoIdPorInfraccion(String infraccion) throws BadRequestHttpResponse;

}
