/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.CapaBusiness;
import com.hvnl.ssolo.dao.CapaDao;
import com.hvnl.ssolo.model.Capa;

/**
 * Implementacao do business de {@link Capa}.
 * @author vinicius
 */
@Component("capaBusiness")
public class CapaBusinessImpl extends BusinessGenerico<Capa, CapaDao>
		implements CapaBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("capaDao") CapaDao dao) {
        super.setDao(dao);
    }
    
}
