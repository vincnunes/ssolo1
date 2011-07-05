/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.PagamentoBusiness;
import com.hvnl.ssolo.facade.CrudPagamentoFacade;
import com.hvnl.ssolo.model.Pagamento;

/**
 * Implementacao da fachada do caso de uso Manter {@link Pagamento}.
 * @author vinicius
 */
@Component("crudPagamentoFacade")
public class CrudPagamentoFacadeImpl extends CrudFacadeGenerico<Pagamento, PagamentoBusiness> 
		implements CrudPagamentoFacade {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("pagamentoBusiness") PagamentoBusiness business) {
        super.setBusiness(business);
    }
	
}
