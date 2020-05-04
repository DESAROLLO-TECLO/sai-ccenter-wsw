package mx.com.teclo.sai.ccenter.ws.negocio.service.deposito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.teclo.sai.ccenter.ws.persistencia.hibernate.dao.depostio.DepositoDAO;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.DepositoVO;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.RespuestaDepositoVO;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.RespuestaVO;
import mx.com.teclo.sai.ccenter.ws.util.enums.Codigos;
import mx.com.teclo.sai.ccenter.ws.util.enums.Mensajes;

@Service
public class IvrDepositoServiceImpl implements IvrDepositoService{

	@Autowired
	private DepositoDAO depositoDAO;
	
	@Override
	@Transactional
	public RespuestaVO ivrObtenerDepositoIdPorPlaca(String placa) {
		
		RespuestaDepositoVO depIdopc1;
		RespuestaDepositoVO depIdopc2;
		RespuestaVO respuestaVO = new RespuestaVO();
		DepositoVO depositoVO=null;
	
		if(placa.equals("null") || placa==null){
			respuestaVO.setCodigoHttp(Codigos.BAD_REQUEST.getProcesoId());
			respuestaVO.setDescripcion("El parametro placa es nulo");
		}else{
			depositoVO=new DepositoVO();
			depIdopc1= depositoDAO.obtenerDepositoIdPorPlacaImpresaNull(placa);
			depIdopc2=depositoDAO.obtenerDepositoIdPorPlacaImpresaNotNull(placa);
			
			if(depIdopc1 != null && depIdopc2 == null)
				depositoVO.setNumeroDeposito(depIdopc1.getNumeroDeposito());
				
			if(depIdopc1 == null && depIdopc2 != null)
				depositoVO.setNumeroDeposito(depIdopc2.getNumeroDeposito());
			
			if(depositoVO.getNumeroDeposito() == null){
				depositoVO=null;
				respuestaVO.setCodigoHttp(Codigos.NOT_DATA_FOUND.getProcesoId());
				respuestaVO.setDescripcion(Mensajes.MSJ_NOT_DATA_FOUND.getProcesoId());
			}else{
				respuestaVO.setCodigoHttp(Codigos.SUCCESS.getProcesoId());
				respuestaVO.setDescripcion(Mensajes.MSJ_SUCCESS.getProcesoId());
			}
		}
		respuestaVO.setDepositoVO(depositoVO);
				
		return respuestaVO;
	}

	@Override
	@Transactional
	public RespuestaVO ivrObtenerDepositoIdPorInfraccion(String infraccion) {
		
		RespuestaDepositoVO depIdopc1;
		RespuestaDepositoVO depIdopc2;
		RespuestaVO respuestaVO = new RespuestaVO();
		DepositoVO depositoVO=null;
		
		if(infraccion.equals("null") || infraccion==null){
			respuestaVO.setCodigoHttp(Codigos.BAD_REQUEST.getProcesoId());
			respuestaVO.setDescripcion("El parametro infraccion es nulo");
		}else{
			depositoVO=new DepositoVO();
			depIdopc1=depositoDAO.obtenerDepositoIdPorInfraccionImpresaNull(infraccion);
			depIdopc2=depositoDAO.obtenerDepositoIdPorInfraccionImpresaNotNull(infraccion);
			
			if(depIdopc1!=null && depIdopc2==null){
				depositoVO.setNumeroDeposito(depIdopc1.getNumeroDeposito());
				respuestaVO.setIdRegistro(depIdopc1.getIdRegistro());
			}
			
			if(depIdopc1==null && depIdopc2!=null){
				depositoVO.setNumeroDeposito(depIdopc2.getNumeroDeposito());
				respuestaVO.setIdRegistro(depIdopc2.getIdRegistro());
			}
			
			if(depositoVO.getNumeroDeposito()==null){
				
				depositoVO=null;
				respuestaVO.setIdRegistro("0");
				respuestaVO.setCodigoHttp(Codigos.NOT_DATA_FOUND.getProcesoId());
				respuestaVO.setDescripcion(Mensajes.MSJ_NOT_DATA_FOUND.getProcesoId());
				
			}else{
				respuestaVO.setCodigoHttp(Codigos.SUCCESS.getProcesoId());
				respuestaVO.setDescripcion(Mensajes.MSJ_SUCCESS.getProcesoId());
				
			}
			
		}
		
		respuestaVO.setDepositoVO(depositoVO);
		
		return respuestaVO;
	}

}
