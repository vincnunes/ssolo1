/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.PerfilBusiness;
import com.hvnl.ssolo.facade.CrudPerfilFacade;
import com.hvnl.ssolo.model.Perfil;

/**
 * Implementacao da fachada do caso de uso Manter {@link Perfil}.
 * @author vinicius
 */
@Component("crudPerfilFacade")
public class CrudPerfilFacadeImpl extends CrudFacadeGenerico<Perfil, PerfilBusiness> 
		implements CrudPerfilFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("perfilBusiness") PerfilBusiness business) {
        super.setBusiness(business);
    }
	
}
