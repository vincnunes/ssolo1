/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.FuroBusiness;
import com.hvnl.ssolo.dao.FuroDao;
import com.hvnl.ssolo.model.Furo;

/**
 * Implementacao do business de {@link Furo}.
 * @author vinicius
 */
@Component("furoBusiness")
public class FuroBusinessImpl extends BusinessGenerico<Furo, FuroDao>
		implements FuroBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("furoDao") FuroDao dao) {
        super.setDao(dao);
    }
    
}
