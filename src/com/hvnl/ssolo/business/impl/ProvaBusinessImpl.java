/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ProvaBusiness;
import com.hvnl.ssolo.dao.ProvaDao;
import com.hvnl.ssolo.model.Prova;

/**
 * Implementacao do business de {@link Prova}.
 * @author vinicius
 */
@Component("provaBusiness")
public class ProvaBusinessImpl extends BusinessGenerico<Prova, ProvaDao>
		implements ProvaBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("provaDao") ProvaDao dao) {
        super.setDao(dao);
    }
    
}
