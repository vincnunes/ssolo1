/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.FreteBusiness;
import com.hvnl.ssolo.facade.CrudFreteFacade;
import com.hvnl.ssolo.model.Frete;

/**
 * Implementacao da fachada do caso de uso Manter {@link Frete}.
 * @author vinicius
 */
@Component("crudFreteFacade")
public class CrudFreteFacadeImpl extends CrudFacadeGenerico<Frete, FreteBusiness> 
			implements CrudFreteFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("freteBusiness") FreteBusiness business) {
        super.setBusiness(business);
    }
	
}
