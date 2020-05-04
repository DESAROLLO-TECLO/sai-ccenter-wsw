package mx.com.teclo.sai.ccenter.ws.persistencia.hibernate.dao.depostio;

import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.RespuestaDepositoVO;

public interface DepositoDAO {
	
	public RespuestaDepositoVO obtenerDepositoIdPorPlacaImpresaNull(String placa);
	
	public RespuestaDepositoVO obtenerDepositoIdPorPlacaImpresaNotNull(String placa);
	
	public RespuestaDepositoVO obtenerDepositoIdPorInfraccionImpresaNull(String infraccion);
	
	public RespuestaDepositoVO obtenerDepositoIdPorInfraccionImpresaNotNull(String infraccion);

}
