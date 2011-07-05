/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.PerfilBusiness;
import com.hvnl.ssolo.dao.PerfilDao;
import com.hvnl.ssolo.model.Perfil;

/**
 * Implementacao do business de {@link Perfil}.
 * @author vinicius
 */
@Component("perfilBusiness")
public class PerfilBusinessImpl extends BusinessGenerico<Perfil, PerfilDao>
		implements PerfilBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("perfilDao") PerfilDao dao) {
        super.setDao(dao);
    }
    
}
