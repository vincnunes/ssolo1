/*
 * 24/02/2011
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ArteBusiness;
import com.hvnl.ssolo.facade.CrudArteFacade;
import com.hvnl.ssolo.model.Arte;

/**
 * Implementacao da fachada do caso de uso Manter {@link Arte}.
 * @author heber
 */
@Component("crudArteFacade")
public class CrudArteFacadeImpl extends CrudFacadeGenerico<Arte, ArteBusiness>
    implements CrudArteFacade {

    /** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("arteBusiness") ArteBusiness business) {
        super.setBusiness(business);
    }
    
}
