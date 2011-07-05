/*
 * 24/02/2011
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudArteFacade;
import com.hvnl.ssolo.model.Arte;

/**
 * Bean do caso de uso cadastrar {@link Arte}.
 * @author heber
 */
public class CrudArteBean extends CrudBeanGenerico<Arte, CrudArteFacade> {

    /** {@inheritDoc} */
    @Override
    protected String getNavegacaoInicial() {
        return Outcome.CRUD_ARTE;
    }
    
    /** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
