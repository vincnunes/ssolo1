/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.DobraBusiness;
import com.hvnl.ssolo.facade.CrudDobraFacade;
import com.hvnl.ssolo.model.Dobra;

/**
 * Implementacao da fachada do caso de uso Manter {@link Dobra}.
 * @author vinicius
 */
@Component("crudDobraFacade")
public class CrudDobraFacadeImpl extends CrudFacadeGenerico<Dobra, DobraBusiness> 
		implements CrudDobraFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("dobraBusiness") DobraBusiness business) {
        super.setBusiness(business);
    }
	
    
}
