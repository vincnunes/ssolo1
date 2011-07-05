/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.SolicitacaoPapelBusiness;
import com.hvnl.ssolo.model.SolicitacaoPapel;

/**
 * Implementacao da fachada do caso de uso Manter {@link SolicitacaoPapel}.
 * @author vinicius
 */
@Component("crudSolicitacaoPapelFacade")
public class CrudSolicitacaoPapelFacadeImpl extends CrudFacadeGenerico<SolicitacaoPapel, SolicitacaoPapelBusiness> {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("solicitacaoPapelBusiness") SolicitacaoPapelBusiness business) {
        super.setBusiness(business);
    }
	
}
