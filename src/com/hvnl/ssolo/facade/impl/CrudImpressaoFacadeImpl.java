/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ImpressaoBusiness;
import com.hvnl.ssolo.facade.CrudImpressaoFacade;
import com.hvnl.ssolo.model.Impressao;

/**
 * Implementacao da fachada do caso de uso Manter {@link Impressao}.
 * @author vinicius
 */
@Component("crudImpressaoFacade")
public class CrudImpressaoFacadeImpl extends CrudFacadeGenerico<Impressao, ImpressaoBusiness>
		implements CrudImpressaoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("impressaoBusiness") ImpressaoBusiness business) {
        super.setBusiness(business);
    }
	
}
