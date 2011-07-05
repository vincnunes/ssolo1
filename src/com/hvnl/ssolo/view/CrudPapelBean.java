/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudPapelFacade;
import com.hvnl.ssolo.model.Papel;

/**
 * Bean do caso de uso cadastrar {@link Papel}.
 * @author vinicius
 */
public class CrudPapelBean extends CrudBeanGenerico<Papel, CrudPapelFacade> {

	/** {@inheritDoc} */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_PAPEL;
	}
    
	/** {@inheritDoc} */
	@Override
	public String iniciar() {
		String retorno = super.iniciar();
		super.filtrar();
		return retorno;
	}
    
}
