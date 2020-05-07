package mx.com.teclo.sai.ccenter.ws.negocio.service.infraccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.teclo.arquitectura.ortogonales.responsehttp.BadRequestHttpResponse;
import mx.com.teclo.sai.ccenter.ws.persistencia.hibernate.dao.infraccion.InfraccionDAO;
import mx.com.teclo.sai.ccenter.ws.util.enums.Mensajes;

@Service
public class IvrInfraccionServiceImpl implements IvrInfraccionService{

	@Autowired
	private InfraccionDAO infraccionDAO;
	
	
	@Transactional
	public Integer obtenerNumeroInfraccionesPorPlaca(String placa) throws BadRequestHttpResponse{
		Integer valorConsulta=null;
		
		if(placa.equals("null") || placa==null){
			throw new BadRequestHttpResponse(Mensajes.MSJ_BAD_REQUEST.getProcesoId(), "TCL40001", "");
		}else{
			valorConsulta=infraccionDAO.obtenerNumeroInfraccionesPorPlaca(placa);	
		}
		
		return valorConsulta;
	}
}
