/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.PapelBusiness;
import com.hvnl.ssolo.facade.CrudPapelFacade;
import com.hvnl.ssolo.model.Papel;

/**
 * Implementacao da fachada do caso de uso Manter {@link Papel}.
 * @author vinicius
 */
@Component("crudPapelFacade")
public class CrudPapelFacadeImpl extends CrudFacadeGenerico<Papel, PapelBusiness> 
		implements CrudPapelFacade {

	 /** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("papelBusiness") PapelBusiness business) {
        super.setBusiness(business);
    }

}
