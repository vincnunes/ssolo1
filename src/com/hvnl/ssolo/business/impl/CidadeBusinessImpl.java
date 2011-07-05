/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.CidadeBusiness;
import com.hvnl.ssolo.dao.CidadeDao;
import com.hvnl.ssolo.model.Cidade;

/**
 * Implementacao do business de {@link Cidade}.
 * @author vinicius
 */
@Component("cidadeBusiness")
public class CidadeBusinessImpl extends BusinessGenerico<Cidade, CidadeDao>
		implements CidadeBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("cidadeDao") CidadeDao dao) {
        super.setDao(dao);
    }
    
}
