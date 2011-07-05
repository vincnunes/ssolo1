/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudGramaturaFacade;
import com.hvnl.ssolo.model.Gramatura;

/**
 * Bean do caso de uso cadastrar {@link Gramatura}.
 * @author vinicius
 */
public class CrudGramaturaBean extends CrudBeanGenerico<Gramatura, CrudGramaturaFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_GRAMATURA;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
    
}
