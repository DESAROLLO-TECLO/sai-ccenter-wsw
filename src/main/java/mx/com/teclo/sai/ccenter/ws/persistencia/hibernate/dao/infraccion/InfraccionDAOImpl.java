package mx.com.teclo.sai.ccenter.ws.persistencia.hibernate.dao.infraccion;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.teclo.sai.ccenter.ws.persistencia.dao.comun.BaseDaoHibernate;
import mx.com.teclo.sai.ccenter.ws.persistencia.hibernate.dto.infraccion.VinfraccionesDTO;

@Repository
public class InfraccionDAOImpl extends BaseDaoHibernate<VinfraccionesDTO> implements InfraccionDAO{
	
	/**
     * {@inheritDoc}
     */
    @Override
    public Integer obtenerNumeroInfraccionesPorPlaca(String placa) {
    	Integer numInfracciones=null;
    	
    				Criteria c= getCurrentSession().createCriteria(VinfraccionesDTO.class)
    		        .add(Restrictions.eq("placa", placa))
    		        .add(Restrictions.eq("infracPagada", "N"));
    				numInfracciones=c.list().size();
    	
		return numInfracciones;
    }
    

}
