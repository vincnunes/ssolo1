/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.LombadaBusiness;
import com.hvnl.ssolo.facade.CrudLombadaFacade;
import com.hvnl.ssolo.model.Lombada;

/**
 * Implementacao da fachada do caso de uso Manter {@link Lombada}.
 * @author vinicius
 */
@Component("crudLombadaFacade")
public class CrudLombadaFacadeImpl extends CrudFacadeGenerico<Lombada, LombadaBusiness> 
		implements CrudLombadaFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("lombadaBusiness") LombadaBusiness business) {
        super.setBusiness(business);
    }
	
}
