/**
 *
 */
package com.hvnl.ssolo.view;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.hvnl.ssolo.facade.CrudClienteFacade;
import com.hvnl.ssolo.model.Cliente;

/**
 * Bean do caso de uso cadastrar {@link Cliente}.
 * @author vinicius
 */
public class AlterarSituacaoClienteBean extends CrudBeanGenerico<Cliente, CrudClienteFacade> {

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
        Cliente selecionado = getSelecionado();
        String retorno = super.iniciar();
        setSelecionado(selecionado);
        return retorno;
    }

    /** {@inheritDoc} */
    @Override
    protected String getNavegacaoInicial() {
        return Outcome.ALTERAR_CLIENTE_SITUACAO;
    }

    /** {@inheritDoc} */
    @Override
    public String salvar() {
        getSelecionado().getSituacao().setDataAtualizacao(new Date());
        return super.salvar();
    }
}
