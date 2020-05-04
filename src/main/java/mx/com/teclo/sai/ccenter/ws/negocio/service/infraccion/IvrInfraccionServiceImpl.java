package mx.com.teclo.sai.ccenter.ws.negocio.service.infraccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.teclo.sai.ccenter.ws.persistencia.hibernate.dao.infraccion.InfraccionDAO;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.InfraccionesVO;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.RespuestaVO;
import mx.com.teclo.sai.ccenter.ws.util.enums.Codigos;
import mx.com.teclo.sai.ccenter.ws.util.enums.Mensajes;

@Service
public class IvrInfraccionServiceImpl implements IvrInfraccionService{

	@Autowired
	private InfraccionDAO infraccionDAO;
	
	
	@Transactional
	public RespuestaVO obtenerNumeroInfraccionesPorPlaca(String placa){
		
		Integer valorConsulta;
		InfraccionesVO infracciones=null;
		RespuestaVO respuestaVO = new RespuestaVO();
		
		if(placa.equals("null") || placa==null){
			
			respuestaVO.setCodigoHttp(Codigos.BAD_REQUEST.getProcesoId());
			respuestaVO.setDescripcion("El parametro placa es nulo");
			
		}else{
			
			valorConsulta= infraccionDAO.obtenerNumeroInfraccionesPorPlaca(placa);
			
			if(valorConsulta != 0){
				
				infracciones=new InfraccionesVO();
				infracciones.setNumeroInfracciones(valorConsulta);
				respuestaVO.setCodigoHttp(Codigos.SUCCESS.getProcesoId());
				respuestaVO.setDescripcion(Mensajes.MSJ_SUCCESS.getProcesoId());
				
			}else{
				
				respuestaVO.setCodigoHttp(Codigos.NOT_DATA_FOUND.getProcesoId());
				respuestaVO.setDescripcion(Mensajes.MSJ_NOT_DATA_FOUND.getProcesoId());
				
			}
		}
		respuestaVO.setInfraccionesVO(infracciones);
		
		return respuestaVO;
	}
	
}
