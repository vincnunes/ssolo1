/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.EnderecoBusiness;
import com.hvnl.ssolo.facade.CrudEnderecoFacade;
import com.hvnl.ssolo.model.Endereco;

/**
 * Implementacao da fachada do caso de uso Manter {@link Endereco}.
 * @author vinicius
 */
@Component("crudEnderecoFacade")
public class CrudEnderecoFacadeImpl extends CrudFacadeGenerico<Endereco, EnderecoBusiness>
		implements CrudEnderecoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("enderecoBusiness") EnderecoBusiness business) {
        super.setBusiness(business);
    }
	
}
