/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ProvaBusiness;
import com.hvnl.ssolo.facade.CrudProvaFacade;
import com.hvnl.ssolo.model.Prova;

/**
 * Implementacao da fachada do caso de uso Manter {@link Prova}.
 * @author vinicius
 */
@Component("crudProvaFacade")
public class CrudProvaFacadeImpl extends CrudFacadeGenerico<Prova, ProvaBusiness> 
		implements CrudProvaFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("provaBusiness") ProvaBusiness business) {
        super.setBusiness(business);
    }
	
}
