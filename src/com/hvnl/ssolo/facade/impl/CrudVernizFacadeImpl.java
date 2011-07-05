/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.VernizBusiness;
import com.hvnl.ssolo.facade.CrudVernizFacade;
import com.hvnl.ssolo.model.Verniz;

/**
 * Implementacao da fachada do caso de uso Manter {@link Verniz}.
 * @author vinicius
 */
@Component("crudVernizFacade")
public class CrudVernizFacadeImpl extends CrudFacadeGenerico<Verniz, VernizBusiness> 
		implements CrudVernizFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("vernizBusiness") VernizBusiness business) {
        super.setBusiness(business);
    }
	
}
