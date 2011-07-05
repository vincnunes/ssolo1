/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.CorteBusiness;
import com.hvnl.ssolo.facade.CrudCorteFacade;
import com.hvnl.ssolo.model.Corte;

/**
 * Implementacao da fachada do caso de uso Manter {@link Corte}.
 * @author vinicius
 */
@Component("crudCorteFacade")
public class CrudCorteFacadeImpl extends CrudFacadeGenerico<Corte, CorteBusiness> 
		implements CrudCorteFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("corteBusiness") CorteBusiness business) {
        super.setBusiness(business);
    }
	
}
