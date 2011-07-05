/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ContatoBusiness;
import com.hvnl.ssolo.facade.CrudContatoFacade;
import com.hvnl.ssolo.model.Contato;

/**
 * Implementacao da fachada do caso de uso Manter {@link Contato}.
 * @author vinicius
 */
@Component("crudContatoFacade")
public class CrudContatoFacadeImpl extends CrudFacadeGenerico<Contato, ContatoBusiness> 
	implements CrudContatoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("contatoBusiness") ContatoBusiness business) {
        super.setBusiness(business);
    }
	
    
}
