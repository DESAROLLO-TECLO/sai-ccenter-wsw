package mx.com.teclo.sai.ccenter.ws.negocio.service.deposito;

import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.RespuestaVO;

public interface IvrDepositoService{
	
	public RespuestaVO ivrObtenerDepositoIdPorPlaca(String placa);
	
	public RespuestaVO ivrObtenerDepositoIdPorInfraccion(String infraccion);

}
