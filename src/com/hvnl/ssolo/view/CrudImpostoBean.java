/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudImpostoFacade;
import com.hvnl.ssolo.model.Imposto;

/**
 * Bean do caso de uso cadastrar {@link Imposto}.
 * @author vinicius
 */
public class CrudImpostoBean extends CrudBeanGenerico<Imposto, CrudImpostoFacade> {
	
	/** {@inheritDoc} */
    @Override
    protected String getNavegacaoInicial() {
        return Outcome.CRUD_IMPOSTO;
    }
    
    /** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
