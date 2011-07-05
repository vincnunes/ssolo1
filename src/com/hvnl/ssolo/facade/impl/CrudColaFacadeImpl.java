/*
 * 25/02/2011
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ColaBusiness;
import com.hvnl.ssolo.facade.CrudColaFacade;
import com.hvnl.ssolo.model.Cola;

/**
 * Implementacao da fachada do caso de uso manter {@link Cola}.
 * @author heber
 */
@Component("crudColaFacade")
public class CrudColaFacadeImpl extends CrudFacadeGenerico<Cola, ColaBusiness>
    implements CrudColaFacade {

    /** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("colaBusiness") ColaBusiness business) {
        super.setBusiness(business);
    }
}
