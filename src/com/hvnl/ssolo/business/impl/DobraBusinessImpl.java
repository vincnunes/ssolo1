/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.DobraBusiness;
import com.hvnl.ssolo.dao.DobraDao;
import com.hvnl.ssolo.model.Dobra;

/**
 * Implementacao do business de {@link Dobra}.
 * @author vinicius
 */
@Component("dobraBusiness")
public class DobraBusinessImpl extends BusinessGenerico<Dobra, DobraDao>
		implements DobraBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("dobraDao") DobraDao dao) {
        super.setDao(dao);
    }
    
}
