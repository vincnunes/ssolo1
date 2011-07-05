/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ImpostoBusiness;
import com.hvnl.ssolo.facade.CrudImpostoFacade;
import com.hvnl.ssolo.model.Imposto;

/**
 * Implementacao da fachada do caso de uso Manter {@link Imposto}.
 * @author vinicius
 */
@Component("crudImpostoFacade")
public class CrudImpostoFacadeImpl extends CrudFacadeGenerico<Imposto, ImpostoBusiness> 
		implements CrudImpostoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("impostoBusiness") ImpostoBusiness business) {
        super.setBusiness(business);
    }

}
