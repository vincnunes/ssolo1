/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.EmpresaBusiness;
import com.hvnl.ssolo.facade.CrudEmpresaFacade;
import com.hvnl.ssolo.model.Empresa;

/**
 * Implementacao da fachada do caso de uso Manter {@link Empresa}.
 * @author vinicius
 */
@Component("crudEmpresaFacade")
public class CrudEmpresaFacadeImpl extends CrudFacadeGenerico<Empresa, EmpresaBusiness> 
		implements CrudEmpresaFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("empresaBusiness") EmpresaBusiness business) {
        super.setBusiness(business);
    }
	
}
