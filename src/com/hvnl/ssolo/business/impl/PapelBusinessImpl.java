/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.PapelBusiness;
import com.hvnl.ssolo.dao.PapelDao;
import com.hvnl.ssolo.model.Papel;

/**
 * Implementacao do business de {@link Papel}.
 * @author vinicius
 */
@Component("papelBusiness")
public class PapelBusinessImpl extends BusinessGenerico<Papel, PapelDao> 
		implements PapelBusiness {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("papelDao") PapelDao dao) {
        super.setDao(dao);
    }
	
}
