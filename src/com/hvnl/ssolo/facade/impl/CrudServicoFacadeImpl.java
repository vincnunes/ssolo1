/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ServicoBusiness;
import com.hvnl.ssolo.facade.CrudServicoFacade;
import com.hvnl.ssolo.model.Servico;

/**
 * Implementacao da fachada do caso de uso Manter {@link Servico}.
 * @author vinicius
 */
@Component("crudServicoFacade")
public class CrudServicoFacadeImpl extends CrudFacadeGenerico<Servico, ServicoBusiness> 
		implements CrudServicoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("servicoBusiness") ServicoBusiness business) {
        super.setBusiness(business);
    }
	
}
