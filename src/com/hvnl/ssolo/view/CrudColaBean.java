/*
 * 24/02/2011
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudColaFacade;
import com.hvnl.ssolo.model.Cola;

/**
 * Bean do caso de uso cadastrar {@link Cola}.
 * @author heber
 */
public class CrudColaBean extends CrudBeanGenerico<Cola, CrudColaFacade> {

    /** {@inheritDoc} */
    @Override
    protected String getNavegacaoInicial() {
        return Outcome.CRUD_COLA;
    }

    /** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }

}
