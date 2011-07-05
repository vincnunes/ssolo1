/**
 * 
 */
package com.hvnl.ssolo.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.hvnl.ssolo.facade.CrudTransportadoraFacade;
import com.hvnl.ssolo.model.Contato;
import com.hvnl.ssolo.model.DadosEmpresa;
import com.hvnl.ssolo.model.Endereco;
import com.hvnl.ssolo.model.Estado;
import com.hvnl.ssolo.model.Transportadora;

/**
 * Bean do caso de uso cadastrar {@link Transportadora}.
 * @author vinicius
 */
public class CrudTransportadoraBean extends CrudBeanGenerico<Transportadora, CrudTransportadoraFacade> {
	/**
     * Lista de atividades.
     */
    private List<SelectItem> atividades;

    /**
     * Lista de cidades.
     */
    private List<SelectItem> cidades;

    /**
     * Lista de estados.
     */
    private List<SelectItem> estados;

    /**
     * Lista de vendedores.
     */
    private List<SelectItem> vendedores;

    /**
     * Lista de situações.
     */
    private List<SelectItem> status;

    /**
     * Estado do endereco do cliente.
     */
    private Estado estado;
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    /** {@inheritDoc} */
    @Override
    public Transportadora getSelecionado() {
    	Transportadora selecionado = super.getSelecionado();
        return selecionado;
    }

    @Override
    protected Transportadora getNewModel() {
    	Transportadora transportadora = super.getNewModel();

    	DadosEmpresa dados = new DadosEmpresa();
    	Endereco endereco = new Endereco();
    	/* Código da cidade de Fortaleza */
    	endereco.setCidade(getCrudFacade().getCidade(new Long(59)));
        dados.setEndereco(endereco);
        dados.setContatos(new ArrayList<Contato>());
        transportadora.setDados(dados);
        /* Código do estado do Ceará */
        setEstado(getCrudFacade().getEstado(new Long(6)));
        
        return transportadora;
    }
    
    public void buscarEndereco() {
    	getCepOnLine().getCep(getSelecionado().getDados().getEndereco());
    	estado = getSelecionado().getDados().getEndereco().getCidade().getEstado();
    }
    
    public List<SelectItem> getVendedores() {
        if (vendedores == null) {
            vendedores = ordena(gerarListaSelectItem(
                    getCrudFacade().listarVendedores()));
        }

        return vendedores;
    }
    
    public List<SelectItem> getTiposPessoa() {
        return ordena(gerarListaSelectItem(getCrudFacade().listarTipoPessoa()));
    }

    public List<SelectItem> getStatus() {
        if (status == null) {
            status = ordena(gerarListaSelectItem(getCrudFacade().listarStatus()));
        }

        return status;
    }

    public List<SelectItem> getAtividades() {
        if (atividades == null) {
            atividades = ordena(gerarListaSelectItem(
                    getCrudFacade().listarAtividades()));
        }

        return atividades;
    }

    public List<SelectItem> getCidades() {
        if (estado != null) {
            cidades = ordena(gerarListaSelectItem(
                    getCrudFacade().listarCidades(estado)));
        } else {
            cidades = new ArrayList<SelectItem>();
        }

        return cidades;
    }

    public List<SelectItem> getEstados() {
        if (estados == null) {
            estados = ordena(gerarListaSelectItem(getCrudFacade().listarEstados()));
        }

        return estados;
    }
    
    /**
	 * Adiciona um contato.
	 */
	public void adicionarContato() {
	    getSelecionado().getDados().getContatos().add(new Contato());
	}
	
	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_TRANSPORTADORA;
	}
	
	public String consultar() {
		iniciar();
    	return Outcome.TRANSPORTADORA_LISTAR;
    }
}
