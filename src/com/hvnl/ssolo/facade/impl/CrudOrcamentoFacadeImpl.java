/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.OrcamentoBusiness;
import com.hvnl.ssolo.facade.CrudOrcamentoFacade;
import com.hvnl.ssolo.model.Orcamento;

/**
 * Implementacao da fachada do caso de uso Manter {@link Orcamento}.
 * @author vinicius
 */
@Component("crudOrcamentoFacade")
public class CrudOrcamentoFacadeImpl extends CrudFacadeGenerico<Orcamento, OrcamentoBusiness> 
		implements CrudOrcamentoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("orcamentoBusiness") OrcamentoBusiness business) {
        super.setBusiness(business);
    }
	
}
