/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.DestinoBusiness;
import com.hvnl.ssolo.facade.CrudDestinoFacade;
import com.hvnl.ssolo.model.Destino;

/**
 * Implementacao da fachada do caso de uso Manter {@link Destino}.
 * @author vinicius
 */
@Component("crudDestinoFacade")
public class CrudDestinoFacadeImpl extends CrudFacadeGenerico<Destino, DestinoBusiness>
		implements CrudDestinoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("destinoBusiness") DestinoBusiness business) {
        super.setBusiness(business);
    }
	
}
