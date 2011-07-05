/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.PaginaBusiness;
import com.hvnl.ssolo.facade.CrudPaginaFacade;
import com.hvnl.ssolo.model.Pagina;

/**
 * Implementacao da fachada do caso de uso Manter {@link Pagina}.
 * @author vinicius
 */
@Component("crudPaginaFacade")
public class CrudPaginaFacadeImpl extends CrudFacadeGenerico<Pagina, PaginaBusiness> 
		implements CrudPaginaFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("paginaBusiness") PaginaBusiness business) {
        super.setBusiness(business);
    }
	
}
