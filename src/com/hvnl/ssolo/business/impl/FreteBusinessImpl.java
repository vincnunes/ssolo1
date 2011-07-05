/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.FreteBusiness;
import com.hvnl.ssolo.dao.FreteDao;
import com.hvnl.ssolo.model.Frete;

/**
 * Implementacao do business de {@link Frete}.
 * @author vinicius
 */
@Component("freteBusiness")
public class FreteBusinessImpl extends BusinessGenerico<Frete, FreteDao>
		implements FreteBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("freteDao") FreteDao dao) {
        super.setDao(dao);
    }
    
}
