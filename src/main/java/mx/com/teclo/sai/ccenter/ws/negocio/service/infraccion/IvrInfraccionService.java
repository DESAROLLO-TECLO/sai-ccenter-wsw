package mx.com.teclo.sai.ccenter.ws.negocio.service.infraccion;

import mx.com.teclo.arquitectura.ortogonales.responsehttp.BadRequestHttpResponse;

public interface IvrInfraccionService {
	
	
	Integer obtenerNumeroInfraccionesPorPlaca(String placa) throws BadRequestHttpResponse;

}
