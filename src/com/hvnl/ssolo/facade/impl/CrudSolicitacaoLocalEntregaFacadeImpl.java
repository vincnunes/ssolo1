/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.SolicitacaoLocalEntregaBusiness;
import com.hvnl.ssolo.model.SolicitacaoLocalEntrega;

/**
 * Implementacao da fachada do caso de uso Manter {@link SolicitacaoLocalEntrega}.
 * @author vinicius
 */
@Component("crudSolicitacaoLocalEntregaFacade")
public class CrudSolicitacaoLocalEntregaFacadeImpl extends CrudFacadeGenerico<SolicitacaoLocalEntrega, SolicitacaoLocalEntregaBusiness> {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("solicitacaoLocalEntregaBusiness") SolicitacaoLocalEntregaBusiness business) {
        super.setBusiness(business);
    }
	
}
