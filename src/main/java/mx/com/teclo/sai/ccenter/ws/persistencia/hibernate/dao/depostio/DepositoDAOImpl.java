package mx.com.teclo.sai.ccenter.ws.persistencia.hibernate.dao.depostio;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.teclo.sai.ccenter.ws.persistencia.dao.comun.BaseDaoHibernate;
import mx.com.teclo.sai.ccenter.ws.persistencia.hibernate.dto.infraccion.InfraccionDTO;
import mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta.RespuestaDepositoVO;

@Repository
public class DepositoDAOImpl extends BaseDaoHibernate<InfraccionDTO> implements DepositoDAO{

	@Override
	public RespuestaDepositoVO obtenerDepositoIdPorPlacaImpresaNull(String placa) {
		
		RespuestaDepositoVO respuestaDepositoVO = null;
		Object [] obj=null;
		String hql =  
			     "select i.depId as numeroDeposito,i.infraccNum as idRegistro  from InfraccionDTO i,DepositosDTO d WHERE d.depId=i.depId  AND i.infraccImpresa is null"
			     + "  AND i.infraccNum in (select ingr.infracNum from IngresosDTO ingr WHERE ingr.ingrStatus='A')"
			     + " AND i.infraccPlaca=:placa";
	
		
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("placa", placa);
			
			if(query.uniqueResult()!=null){
				obj=(Object[]) query.uniqueResult();
				respuestaDepositoVO= new RespuestaDepositoVO();
				
				for(int i=0; i < obj.length; i++){
					if(obj[i] instanceof Long) {
						respuestaDepositoVO.setNumeroDeposito((Long)obj[i]);
					}else{
						respuestaDepositoVO.setIdRegistro((String)obj[i]);
					}
				}
			}
			
		return respuestaDepositoVO;
	}

	@Override
	public RespuestaDepositoVO obtenerDepositoIdPorPlacaImpresaNotNull(String placa) {
		
		RespuestaDepositoVO respuestaDepositoVO =  null;
		Object [] obj=null;
		String hql =  
			     "select i.depId as numeroDeposito,i.infraccNum as idRegistro from InfraccionDTO i,DepositosDTO d WHERE d.depId=i.depId  AND i.infraccImpresa is not null"
			     + "  AND i.infraccNum in (select ingr.infracNum from IngresosDTO ingr WHERE ingr.ingrStatus='A')"
			     + " AND i.infraccPlaca= :placa";
		
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("placa", placa);
			
			if(query.uniqueResult()!=null){
				obj=(Object[]) query.uniqueResult();
				respuestaDepositoVO= new RespuestaDepositoVO();
				
				for(int i=0; i < obj.length; i++){
					if(obj[i] instanceof Long) {
						respuestaDepositoVO.setNumeroDeposito((Long)obj[i]);
					}else{
						respuestaDepositoVO.setIdRegistro((String)obj[i]);
					}
				}
			}
		
		return respuestaDepositoVO;
	}
	
	
	@Override
	public RespuestaDepositoVO obtenerDepositoIdPorInfraccionImpresaNull(String infraccion) {
		
		RespuestaDepositoVO respuestaDepositoVO =  null;
		Object [] obj=null;
		String hql =  
			     "select i.depId as numeroDeposito,i.infraccNum as idRegistro from InfraccionDTO i,DepositosDTO d WHERE d.depId=i.depId  AND i.infraccImpresa is null"
			     + "  AND i.infraccNum in (select ingr.infracNum from IngresosDTO ingr WHERE ingr.ingrStatus='A')"
			     + "  AND i.infraccNum= :infraccion";
	
		
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("infraccion", infraccion);
			
			if(query.uniqueResult()!=null){
				obj=(Object[]) query.uniqueResult();
				respuestaDepositoVO= new RespuestaDepositoVO();
				
				for(int i=0; i < obj.length; i++){
					if(obj[i] instanceof Long) {
						respuestaDepositoVO.setNumeroDeposito((Long)obj[i]);
					}else{
						respuestaDepositoVO.setIdRegistro((String)obj[i]);
					}
				}
			}
		
		return respuestaDepositoVO;
	}

	@Override
	public RespuestaDepositoVO obtenerDepositoIdPorInfraccionImpresaNotNull(String infraccion) {
		
		RespuestaDepositoVO respuestaDepositoVO = null;
		Object [] obj=null;
		String hql =  
			     "select i.depId as numeroDeposito, i.infraccNum as idRegistro from InfraccionDTO i,DepositosDTO d WHERE d.depId=i.depId  AND i.infraccImpresa is not null"
			     + "  AND i.infraccNum in (select ingr.infracNum from IngresosDTO ingr WHERE ingr.ingrStatus='A')"
			     + " AND i.infraccNum= :infraccion";
		
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("infraccion", infraccion);
			
			if(query.uniqueResult()!=null){
				obj=(Object[]) query.uniqueResult();
				respuestaDepositoVO= new RespuestaDepositoVO();
				
				for(int i=0; i < obj.length; i++){
					if(obj[i] instanceof Long) {
						respuestaDepositoVO.setNumeroDeposito((Long)obj[i]);
					}else{
						respuestaDepositoVO.setIdRegistro((String)obj[i]);
					}
				}
			}
			
		return respuestaDepositoVO;
	}
	

}
