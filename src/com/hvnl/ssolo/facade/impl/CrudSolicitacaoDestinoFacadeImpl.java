/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.SolicitacaoDestinoBusiness;
import com.hvnl.ssolo.facade.CrudSolicitacaoDestinoFacade;
import com.hvnl.ssolo.model.SolicitacaoDestino;

/**
 * Implementacao da fachada do caso de uso Manter {@link SolicitacaoDestino}.
 * @author vinicius
 */
@Component("crudSolicitacaoDestinoFacade")
public class CrudSolicitacaoDestinoFacadeImpl extends CrudFacadeGenerico<SolicitacaoDestino, 
		SolicitacaoDestinoBusiness> implements CrudSolicitacaoDestinoFacade {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("solicitacaoDestinoBusiness") SolicitacaoDestinoBusiness business) {
        super.setBusiness(business);
    }
	
}
