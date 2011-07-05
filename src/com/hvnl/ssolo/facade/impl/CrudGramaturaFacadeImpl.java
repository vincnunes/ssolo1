/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.GramaturaBusiness;
import com.hvnl.ssolo.facade.CrudGramaturaFacade;
import com.hvnl.ssolo.model.Gramatura;

/**
 * Implementacao da fachada do caso de uso Manter {@link Gramatura}.
 * @author vinicius
 */
@Component("crudGramaturaFacade")
public class CrudGramaturaFacadeImpl extends CrudFacadeGenerico<Gramatura, GramaturaBusiness> 
		implements CrudGramaturaFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("gramaturaBusiness") GramaturaBusiness business) {
        super.setBusiness(business);
    }
	
}
