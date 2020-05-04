package mx.com.teclo.sai.ccenter.ws.negocio.service.infraccion;

import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.RespuestaVO;

public interface IvrInfraccionService {
	
	
	public RespuestaVO obtenerNumeroInfraccionesPorPlaca(String placa);

}
