/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.PlastificacaoBusiness;
import com.hvnl.ssolo.facade.CrudPlastificacaoFacade;
import com.hvnl.ssolo.model.Plastificacao;

/**
 * Implementacao da fachada do caso de uso Manter {@link Plastificacao}.
 * @author vinicius
 */
@Component("crudPlastificacaoFacade")
public class CrudPlastificacaoFacadeImpl extends CrudFacadeGenerico<Plastificacao, 
		PlastificacaoBusiness> implements CrudPlastificacaoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("plastificacaoBusiness") PlastificacaoBusiness business) {
        super.setBusiness(business);
    }
	
}
