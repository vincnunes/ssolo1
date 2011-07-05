/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ContaBusiness;
import com.hvnl.ssolo.facade.CrudContaFacade;
import com.hvnl.ssolo.model.Conta;

/**
 * Implementacao da fachada do caso de uso Manter {@link Conta}.
 * @author vinicius
 */
@Component("crudContaFacade")
public class CrudContaFacadeImpl extends CrudFacadeGenerico<Conta, ContaBusiness> 
		implements CrudContaFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("contaBusiness") ContaBusiness business) {
        super.setBusiness(business);
    }
	
}
