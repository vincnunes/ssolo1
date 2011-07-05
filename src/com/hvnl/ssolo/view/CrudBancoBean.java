/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudBancoFacade;
import com.hvnl.ssolo.model.Banco;

/**
 * Bean do caso de uso cadastrar {@link Banco}.
 * @author vinicius
 */
public class CrudBancoBean extends CrudBeanGenerico<Banco, CrudBancoFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_BANCO;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
