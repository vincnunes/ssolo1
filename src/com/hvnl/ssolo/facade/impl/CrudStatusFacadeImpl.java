/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.StatusBusiness;
import com.hvnl.ssolo.facade.CrudStatusFacade;
import com.hvnl.ssolo.model.Status;

/**
 * Implementacao da fachada do caso de uso Manter {@link Status}.
 * @author vinicius
 */
@Component("crudStatusFacade")
public class CrudStatusFacadeImpl extends CrudFacadeGenerico<Status, StatusBusiness>
		implements CrudStatusFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("statusBusiness") StatusBusiness business) {
        super.setBusiness(business);
    }
	
}
