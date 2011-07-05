/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.CidadeBusiness;
import com.hvnl.ssolo.facade.CrudCidadeFacade;
import com.hvnl.ssolo.model.Cidade;

/**
 * Implementacao da fachada do caso de uso Manter {@link Cidade}.
 * @author vinicius
 */
@Component("crudCidadeFacade")
public class CrudCidadeFacadeImpl extends
		CrudFacadeGenerico<Cidade, CidadeBusiness> implements CrudCidadeFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("cidadeBusiness") CidadeBusiness business) {
        super.setBusiness(business);
    }
    
}
