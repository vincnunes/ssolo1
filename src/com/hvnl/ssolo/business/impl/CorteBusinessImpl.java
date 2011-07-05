/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.CorteBusiness;
import com.hvnl.ssolo.dao.CorteDao;
import com.hvnl.ssolo.model.Corte;

/**
 * Implementacao do business de {@link Corte}.
 * @author vinicius
 */
@Component("corteBusiness")
public class CorteBusinessImpl extends BusinessGenerico<Corte, CorteDao>
		implements CorteBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("corteDao") CorteDao dao) {
        super.setDao(dao);
    }
    
}
