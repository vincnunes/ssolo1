/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.FuroBusiness;
import com.hvnl.ssolo.facade.CrudFuroFacade;
import com.hvnl.ssolo.model.Furo;

/**
 * Implementacao da fachada do caso de uso Manter {@link Furo}.
 * @author vinicius
 */
@Component("crudFuroFacade")
public class CrudFuroFacadeImpl extends CrudFacadeGenerico<Furo, FuroBusiness> 
		implements CrudFuroFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("furoBusiness") FuroBusiness business) {
        super.setBusiness(business);
    }
	
}
