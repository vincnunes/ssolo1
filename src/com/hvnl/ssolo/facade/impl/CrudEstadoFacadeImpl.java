/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.EstadoBusiness;
import com.hvnl.ssolo.facade.CrudEstadoFacade;
import com.hvnl.ssolo.model.Estado;

/**
 * Implementacao da fachada do caso de uso Manter {@link Estado}.
 * @author vinicius
 */
@Component("crudEstadoFacade")
public class CrudEstadoFacadeImpl extends CrudFacadeGenerico<Estado, EstadoBusiness> 
		implements CrudEstadoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("estadoBusiness") EstadoBusiness business) {
        super.setBusiness(business);
    }
	
}
