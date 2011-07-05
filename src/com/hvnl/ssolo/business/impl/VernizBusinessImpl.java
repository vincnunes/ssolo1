/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.VernizBusiness;
import com.hvnl.ssolo.dao.VernizDao;
import com.hvnl.ssolo.model.Verniz;

/**
 * Implementacao do business de {@link Verniz}.
 * @author vinicius
 */
@Component("vernizBusiness")
public class VernizBusinessImpl extends BusinessGenerico<Verniz, VernizDao>
		implements VernizBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("vernizDao") VernizDao dao) {
        super.setDao(dao);
    }
    
}
