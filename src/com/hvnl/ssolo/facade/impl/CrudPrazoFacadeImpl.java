/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.PrazoBusiness;
import com.hvnl.ssolo.facade.CrudPrazoFacade;
import com.hvnl.ssolo.model.Prazo;

/**
 * Implementacao da fachada do caso de uso Manter {@link Prazo}.
 * @author vinicius
 */
@Component("crudPrazoFacade")
public class CrudPrazoFacadeImpl extends CrudFacadeGenerico<Prazo, PrazoBusiness> 
		implements CrudPrazoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("prazoBusiness") PrazoBusiness business) {
        super.setBusiness(business);
    }
	
}
