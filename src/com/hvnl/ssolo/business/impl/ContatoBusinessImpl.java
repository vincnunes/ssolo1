/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ContatoBusiness;
import com.hvnl.ssolo.dao.ContatoDao;
import com.hvnl.ssolo.model.Contato;

/**
 * Implementacao do business de {@link Contato}.
 * @author vinicius
 */
@Component("contatoBusiness")
public class ContatoBusinessImpl extends BusinessGenerico<Contato, ContatoDao>
		implements ContatoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("contatoDao") ContatoDao dao) {
        super.setDao(dao);
    }
    
}
