/**
 *
 */
package com.hvnl.ssolo.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.hvnl.ssolo.exception.FacadeException;
import com.hvnl.ssolo.facade.CrudAgenciaPublicitariaFacade;
import com.hvnl.ssolo.model.AgenciaPublicitaria;
import com.hvnl.ssolo.model.Cliente;
import com.hvnl.ssolo.model.Cliente.TipoAssociado;
import com.hvnl.ssolo.model.Conta;
import com.hvnl.ssolo.model.Contato;
import com.hvnl.ssolo.model.DadosEmpresa;
import com.hvnl.ssolo.model.Endereco;
import com.hvnl.ssolo.model.Estado;
import com.hvnl.ssolo.model.Situacao;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.model.Usuario.PERFIL;
import com.hvnl.ssolo.util.Constants;

/**
 * Bean do caso de uso cadastrar {@link AgenciaPublicitaria}.
 * @author vinicius
 */
public class CrudAgenciaPublicitariaBean extends CrudBeanGenerico<AgenciaPublicitaria, CrudAgenciaPublicitariaFacade> {
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
     * Lista de situações.
     */
    private List<SelectItem> bancos;

    /**
     * Possiveis associados.
     */
    private List<Cliente> associados = new ArrayList<Cliente>();

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

    @Override
    public String iniciar() {
    	try {
    		if (!getAdministrador()) {
    			getSelecionado().setVendedor(getVendedor());
    		}
    		
    		for (Cliente cliente : getCrudFacade().listarClientes()) {
    			if (cliente.getAgenciaAssociada() == null) {
    				associados.add(cliente);
    			}
    		}
        } catch (FacadeException e) {
            e.printStackTrace();
        }
    	return super.iniciar();
    }

    /** {@inheritDoc} */
    @Override
    public AgenciaPublicitaria getSelecionado() {
        AgenciaPublicitaria selecionado = super.getSelecionado();
        return selecionado;
    }

    @Override
    protected AgenciaPublicitaria getNewModel() {
        AgenciaPublicitaria agencia = super.getNewModel();
        DadosEmpresa dados = new DadosEmpresa();
        Endereco endereco = new Endereco();
        /* Código da cidade de Fortaleza */
        endereco.setCidade(getCrudFacade().getCidade(Constants.CIDADE_PADRAO));
        dados.setEndereco(endereco);
        dados.setContatos(new ArrayList<Contato>());
        agencia.setDados(dados);
        Conta conta = new Conta();
        agencia.setConta(conta);
        Situacao situacao = new Situacao();
        situacao.setStatus(getCrudFacade().getStatus(Constants.STATUS_ATIVO));
        situacao.setMotivo(Constants.MENSAGEM_STATUS_ATIVO);
        situacao.setDataAtualizacao(new Date());
        situacao.setDataCadastro(new Date());
        agencia.setSituacao(situacao);
        /* Código do estado do Ceará */
        setEstado(getCrudFacade().getEstado(Constants.ESTADO_PADRAO));
        
        return agencia;
    }

    public void buscarEndereco() {
    	getCepOnLine().getCep(getSelecionado().getDados().getEndereco());
    	estado = getSelecionado().getDados().getEndereco().getCidade().getEstado();
    }

    /**
	 * Testar se o usuário logado é administrador.
	 * @return verdadeiro se for administrador.
	 */
	public Boolean getAdministrador() {
		int resultado = getVendedor().getPerfil().compareTo(PERFIL.ADMINISTRADOR);

		return resultado == 0 ? true : false;
	}
    
    public List<SelectItem> getVendedores() {
        vendedores = ordena(gerarListaSelectItem(
                getCrudFacade().listarVendedores()));

        return vendedores;
    }

    public List<SelectItem> getTiposPessoa() {
        return ordena(gerarListaSelectItem(getCrudFacade().listarTipoPessoa()));
    }

    public List<SelectItem> getStatus() {
        status = ordena(gerarListaSelectItem(getCrudFacade().listarStatus()));

        return status;
    }

    public List<SelectItem> getBancos() {
        bancos = ordena(gerarListaSelectItem(getCrudFacade().listarBancos()));

        return bancos;
    }

    public List<SelectItem> getAtividades() {
        atividades = ordena(gerarListaSelectItem(
                getCrudFacade().listarAtividades()));

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

    public void setAssociado(Cliente cliente) {
        if (cliente == null) {
            return;
        }
        getSelecionado().getAssociados().add(cliente);
        cliente.setAgenciaAssociada(getSelecionado());
        cliente.setAssociado(null);
    }

    public void setExcluirAssociado(Cliente cliente) {
        getSelecionado().getAssociados().remove(cliente);
        cliente.setAgenciaAssociada(null);
    }

    public Cliente getAssociado() {
        return null;
    }

    /**
     * Lista os associados nao associados ainda.
     * @return lista
     */
    public List<SelectItem> getAssociados() {
        List<SelectItem> itens = new ArrayList<SelectItem>();
        
        if (associados.isEmpty()) {
        	try {
        		associados = getCrudFacade().listarClientes();
        	} catch (FacadeException e) {
        		
				e.printStackTrace();
			}
        }
        
        for (Cliente associado : associados) {
            if (!getSelecionado().getAssociados().contains(associado)) {
            	if (associado.getAgenciaAssociada() == null) {
            		itens.add(new SelectItem(associado, associado.getNome()));
            	}
            }
        }
        return itens;
    }

    @Override
    public String salvar() {
    	if (getVendedor().getPerfil().compareTo(PERFIL.VENDEDOR) == 0) {
    		getSelecionado().setVendedor(getVendedor());
    	}
    	
    	AgenciaPublicitaria agencia = getSelecionado();
    	
    	super.salvar();
    	
    	for (Cliente associado : agencia.getAssociados()) {
    		associado.setTipoAssociado(TipoAssociado.AGENCIA);
    		associado.setAgenciaAssociada(agencia);
    		getCrudFacade().atualizarCliente(associado);
    	}
    	
    	return Outcome.CRUD_SALVAR;
    }

    public Usuario getVendedor() {
    	return getCrudFacade().listarVendedor();
    }

	/* Navegação do bean */
	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_AGENCA_PUBLICITARIA;
	}

	public String orcamento() {
		return Outcome.ALTERAR_AGENCIA_SITUACAO;
	}

	public String consultar() {
		iniciar();
    	return Outcome.AGENCIA_LISTAR;
    }

	public String consultaNovo() {
		return iniciar();
	}
}
