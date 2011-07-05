/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.LombadaBusiness;
import com.hvnl.ssolo.dao.LombadaDao;
import com.hvnl.ssolo.model.Lombada;

/**
 * Implementacao do business de {@link Lombada}.
 * @author vinicius
 */
@Component("lombadaBusiness")
public class LombadaBusinessImpl extends BusinessGenerico<Lombada, LombadaDao>
		implements LombadaBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("lombadaDao") LombadaDao dao) {
        super.setDao(dao);
    }
    
}
