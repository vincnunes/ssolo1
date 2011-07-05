/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.TransportadoraBusiness;
import com.hvnl.ssolo.dao.TransportadoraDao;
import com.hvnl.ssolo.model.Transportadora;

/**
 * Implementacao do business de {@link Transportadora}.
 * @author vinicius
 */
@Component("transportadoraBusiness")
public class TransportadoraBusinessImpl extends BusinessGenerico<Transportadora, TransportadoraDao>
		implements TransportadoraBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("transportadoraDao") TransportadoraDao dao) {
        super.setDao(dao);
    }
    
}
