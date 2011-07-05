/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.CapaBusiness;
import com.hvnl.ssolo.facade.CrudCapaFacade;
import com.hvnl.ssolo.model.Capa;

/**
 * Implementacao da fachada do caso de uso Manter {@link Capa}.
 * @author vinicius
 */
@Component("crudCapaFacade")
public class CrudCapaFacadeImpl extends CrudFacadeGenerico<Capa, CapaBusiness> 
		implements CrudCapaFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("capaBusiness") CapaBusiness business) {
        super.setBusiness(business);
    }
	
}
