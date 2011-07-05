/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.SolicitacaoDestinoBusiness;
import com.hvnl.ssolo.dao.SolicitacaoDestinoDao;
import com.hvnl.ssolo.model.SolicitacaoDestino;

/**
 * Implementacao do business de {@link SolicitacaoDestino}.
 * @author vinicius
 */
@Component("solicitacaoDestinoBusiness")
public class SolicitacaoDestinoBusinessImpl extends BusinessGenerico<SolicitacaoDestino, SolicitacaoDestinoDao>
		implements SolicitacaoDestinoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("solicitacaoDestinoDao") SolicitacaoDestinoDao dao) {
        super.setDao(dao);
    }
    
}
