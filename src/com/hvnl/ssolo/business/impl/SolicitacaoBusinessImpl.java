/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.SolicitacaoBusiness;
import com.hvnl.ssolo.dao.SolicitacaoDao;
import com.hvnl.ssolo.model.Solicitacao;

/**
 * Implementacao do business de {@link Solicitacao}.
 * @author vinicius
 */
@Component("solicitacaoBusiness")
public class SolicitacaoBusinessImpl extends BusinessGenerico<Solicitacao, SolicitacaoDao>
		implements SolicitacaoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("solicitacaoDao") SolicitacaoDao dao) {
        super.setDao(dao);
    }
    
}
