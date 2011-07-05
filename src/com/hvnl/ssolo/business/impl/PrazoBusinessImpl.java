/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.PrazoBusiness;
import com.hvnl.ssolo.dao.PrazoDao;
import com.hvnl.ssolo.model.Prazo;

/**
 * Implementacao do business de {@link Prazo}.
 * @author vinicius
 */
@Component("prazoBusiness")
public class PrazoBusinessImpl extends BusinessGenerico<Prazo, PrazoDao>
		implements PrazoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("prazoDao") PrazoDao dao) {
        super.setDao(dao);
    }
    
}
