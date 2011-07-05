/**
 *
 */
package com.hvnl.ssolo.view;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.hvnl.ssolo.facade.CrudAgenciaPublicitariaFacade;
import com.hvnl.ssolo.model.AgenciaPublicitaria;

/**
 * Bean do caso de uso cadastrar {@link AgenciaPublicitaria}.
 * @author vinicius
 */
public class AlterarSituacaoAgenciaBean extends CrudBeanGenerico<AgenciaPublicitaria, CrudAgenciaPublicitariaFacade> {

    /**
     * Lista de situações.
     */
    private List<SelectItem> status;

    public List<SelectItem> getStatus() {
        if (status == null) {
            status = ordena(gerarListaSelectItem(getCrudFacade().listarStatus()));
        }

        return status;
    }

    /** {@inheritDoc} */
    @Override
    public String iniciar() {
        AgenciaPublicitaria selecionado = getSelecionado();
        String retorno = super.iniciar();
        setSelecionado(selecionado);
        return retorno;
    }

    /** {@inheritDoc} */
    @Override
    protected String getNavegacaoInicial() {
        return Outcome.ALTERAR_AGENCIA_SITUACAO;
    }
    
    public String consultar() {
		iniciar();
    	return Outcome.AGENCIA_LISTAR;
    }
    
    /** {@inheritDoc} */
    @Override
    public String salvar() {
        getSelecionado().getSituacao().setDataAtualizacao(new Date());
        return super.salvar();
    }
}
