/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.SolicitacaoLocalEntregaBusiness;
import com.hvnl.ssolo.dao.SolicitacaoLocalEntregaDao;
import com.hvnl.ssolo.model.SolicitacaoLocalEntrega;

/**
 * Implementacao do business de {@link SolicitacaoLocalEntrega}.
 * @author vinicius
 */
@Component("solicitacaoLocalEntregaBusiness")
public class SolicitacaoLocalEntregaBusinessImpl extends BusinessGenerico<SolicitacaoLocalEntrega, SolicitacaoLocalEntregaDao>
		implements SolicitacaoLocalEntregaBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("solicitacaoLocalEntregaDao") SolicitacaoLocalEntregaDao dao) {
        super.setDao(dao);
    }
    
}
