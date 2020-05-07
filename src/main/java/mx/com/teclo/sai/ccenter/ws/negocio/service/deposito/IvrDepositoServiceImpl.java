package mx.com.teclo.sai.ccenter.ws.negocio.service.deposito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.teclo.arquitectura.ortogonales.responsehttp.BadRequestHttpResponse;
import mx.com.teclo.sai.ccenter.ws.persistencia.hibernate.dao.depostio.DepositoDAO;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.DepositoVO;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.RespuestaDepositoVO;
import mx.com.teclo.sai.ccenter.ws.util.enums.Mensajes;

@Service
public class IvrDepositoServiceImpl implements IvrDepositoService{

	@Autowired
	private DepositoDAO depositoDAO;
	
	@Override
	@Transactional
	public DepositoVO ivrObtenerDepositoIdPorPlaca(String placa) throws BadRequestHttpResponse {
		
		RespuestaDepositoVO depIdopc1;
		RespuestaDepositoVO depIdopc2;
		DepositoVO depositoVO=null;
	
		if(placa.equals("null") || placa==null){
			throw new BadRequestHttpResponse(Mensajes.MSJ_BAD_REQUEST.getProcesoId(), "TCL40001", "");
		}else{
			depositoVO=new DepositoVO();
			depIdopc1= depositoDAO.obtenerDepositoIdPorPlacaImpresaNull(placa);
			depIdopc2=depositoDAO.obtenerDepositoIdPorPlacaImpresaNotNull(placa);
			
			if(depIdopc1 != null && depIdopc2 == null) {
				depositoVO.setNumeroDeposito(depIdopc1.getNumeroDeposito());
			}
				
			if(depIdopc1 == null && depIdopc2 != null) {
				depositoVO.setNumeroDeposito(depIdopc2.getNumeroDeposito());
			}
		}
					
		return depositoVO;
	}

	@Override
	@Transactional
	public DepositoVO ivrObtenerDepositoIdPorInfraccion(String infraccion) throws BadRequestHttpResponse {
		
		RespuestaDepositoVO depIdopc1;
		RespuestaDepositoVO depIdopc2;
		DepositoVO depositoVO=null;
		
		if(infraccion.equals("null") || infraccion==null){
			throw new BadRequestHttpResponse(Mensajes.MSJ_BAD_REQUEST.getProcesoId(), "TCL40001", "");
		}else{
			depositoVO=new DepositoVO();
			depIdopc1=depositoDAO.obtenerDepositoIdPorInfraccionImpresaNull(infraccion);
			depIdopc2=depositoDAO.obtenerDepositoIdPorInfraccionImpresaNotNull(infraccion);
			
			if(depIdopc1!=null && depIdopc2==null){
				depositoVO.setNumeroDeposito(depIdopc1.getNumeroDeposito());
			}
			
			if(depIdopc1==null && depIdopc2!=null){
				depositoVO.setNumeroDeposito(depIdopc2.getNumeroDeposito());
			}			
		}
		
		return depositoVO;
	}

}
