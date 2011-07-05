/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.PlastificacaoBusiness;
import com.hvnl.ssolo.dao.PlastificacaoDao;
import com.hvnl.ssolo.model.Plastificacao;

/**
 * Implementacao do business de {@link Plastificacao}.
 * @author vinicius
 */
@Component("plastificacaoBusiness")
public class PlastificacaoBusinessImpl extends BusinessGenerico<Plastificacao, PlastificacaoDao>
		implements PlastificacaoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("plastificacaoDao") PlastificacaoDao dao) {
        super.setDao(dao);
    }
    
}
