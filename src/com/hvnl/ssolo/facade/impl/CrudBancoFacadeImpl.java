/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.BancoBusiness;
import com.hvnl.ssolo.facade.CrudBancoFacade;
import com.hvnl.ssolo.model.Banco;

/**
 * Implementacao da fachada do caso de uso Manter {@link Banco}.
 * @author vinicius
 */
@Component("crudBancoFacade")
public class CrudBancoFacadeImpl extends CrudFacadeGenerico<Banco, BancoBusiness> 
		implements CrudBancoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("bancoBusiness") BancoBusiness business) {
        super.setBusiness(business);
    }
	
}
