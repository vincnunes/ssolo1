/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudPerfilFacade;
import com.hvnl.ssolo.model.Perfil;

/**
 * Bean do caso de uso cadastrar {@link Perfil}.
 * @author vinicius
 */
public class CrudPerfilBean extends CrudBeanGenerico<Perfil, CrudPerfilFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_PERFIL;
	}

	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
