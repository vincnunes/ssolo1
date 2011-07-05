/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.GrampoBusiness;
import com.hvnl.ssolo.facade.CrudGrampoFacade;
import com.hvnl.ssolo.model.Grampo;

/**
 * Implementacao da fachada do caso de uso Manter {@link Grampo}.
 * @author vinicius
 */
@Component("crudGrampoFacade")
public class CrudGrampoFacadeImpl extends CrudFacadeGenerico<Grampo, GrampoBusiness> 
		implements CrudGrampoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("grampoBusiness") GrampoBusiness business) {
        super.setBusiness(business);
    }
	
}
