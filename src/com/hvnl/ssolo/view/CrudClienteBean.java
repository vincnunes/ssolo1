/**
 *
 */
package com.hvnl.ssolo.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.hvnl.ssolo.exception.FacadeException;
import com.hvnl.ssolo.facade.CrudClienteFacade;
import com.hvnl.ssolo.model.AgenciaPublicitaria;
import com.hvnl.ssolo.model.Cliente;
import com.hvnl.ssolo.model.Cliente.Pessoa;
import com.hvnl.ssolo.model.Cliente.TipoAssociado;
import com.hvnl.ssolo.model.Contato;
import com.hvnl.ssolo.model.DadosEmpresa;
import com.hvnl.ssolo.model.Endereco;
import com.hvnl.ssolo.model.Estado;
import com.hvnl.ssolo.model.Situacao;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.model.Usuario.PERFIL;
import com.hvnl.ssolo.util.Constants;

/**
 * Bean do caso de uso cadastrar {@link Cliente}.
 * @author vinicius
 */
@SuppressWarnings("serial")
public class CrudClienteBean extends CrudBeanGenerico<Cliente, CrudClienteFacade> {
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
     * Lista de transportadoras.
     */
    private List<SelectItem> transportadoras;

    /**
     * Possiveis associados.
     */
    private List<Cliente> associados = new ArrayList<Cliente>();

    /**
     * Lista de Agências Publicitárias.
     */
    private List<SelectItem> agencias;

	/**
     * Estado do endereco do cliente.
     */
    private Estado estado;
    
    /**
     * Contato da tabela.
     */
    private Contato contato;
    
    /**
     * Agência Publicitária a qual o Cliente é associado.
     */
    private AgenciaPublicitaria agencia;

    /** {@inheritDoc} */
    @Override
    public String iniciar() {
        try {
        	Cliente cliente = new Cliente();
        	cliente.setVendedor(getVendedor());
        	for (Cliente cli : getCrudFacade().filtrar(cliente)) {
        		if (cli.getAgenciaAssociada() == null && cli.getAssociado() == null) {
    				associados.add(cli);
    			}
        	}
        } catch (FacadeException e) {
            e.printStackTrace();
        }
        return super.iniciar();
    }

    public Cliente.Pessoa getClientePessoa() {
    	return Cliente.Pessoa.FISICA;
    }

    public Boolean getPessoaFisica() {
    	if (getSelecionado().getPessoa() != null) {
   			return getSelecionado().getPessoa().compareTo(Pessoa.FISICA) == 0;
    	}
    	return false;
    }

    public Boolean getPessoaJuridica() {
    	if (getSelecionado().getPessoa() == null) {
    		return false;
    	} else {
    		return getSelecionado().getPessoa().compareTo(Pessoa.JURIDICA) == 0;
    	}
    }

    /** {@inheritDoc} */
    @Override
    public Cliente getSelecionado() {
        Cliente selecionado = super.getSelecionado();
        return selecionado;
    }

    @Override
    protected Cliente getNewModel() {
        Cliente cliente = super.getNewModel();
        DadosEmpresa dados = new DadosEmpresa();
        dados.setContatos(new ArrayList<Contato>());
        Endereco endereco = new Endereco();
        endereco.setCidade(getCrudFacade().getCidade(Constants.CIDADE_PADRAO));
        dados.setEndereco(endereco);
        cliente.setDados(dados);
        Situacao situacao = new Situacao();
        situacao.setStatus(getCrudFacade().getStatus(Constants.STATUS_ATIVO));
        situacao.setMotivo(Constants.MENSAGEM_STATUS_ATIVO);
        situacao.setDataAtualizacao(new Date());
        cliente.setSituacao(situacao);
        setEstado(getCrudFacade().getEstado(Constants.ESTADO_PADRAO));

        return cliente;
    }

    public void setAssociado(Cliente cliente) {
        if (cliente == null) {
            return;
        }
        getSelecionado().getAssociados().add(cliente);
        cliente.setAssociado(getSelecionado());
        cliente.setAgenciaAssociada(null);
    }

    public void setExcluirAssociado(Cliente cliente) {
    	getSelecionado().getAssociados().remove(cliente);
    	cliente.setAssociado(null);
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
        		Cliente cliente = new Cliente();
        		if (getVendedor().getPerfil().compareTo(PERFIL.VENDEDOR) == 0) {
            		cliente.setVendedor(getVendedor());
            	} else if (getSelecionado().getVendedor() != null) {
            		cliente.setVendedor(getSelecionado().getVendedor());
            	}
        		
        		associados = getCrudFacade().filtrar(cliente);
        	} catch (FacadeException e) {
				e.printStackTrace();
			}
        }
        
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        for (Cliente associado : associados) {
            if (!associado.equals(getSelecionado()) &&
                    !getSelecionado().getAssociados().contains(associado)) {
                clientes.add(associado);
            }
        }
        
        for (Cliente associado : associados) {
            if (!associado.equals(getSelecionado()) &&
                    !getSelecionado().getAssociados().contains(associado)) {
                itens.add(new SelectItem(associado, associado.getNome()));
            }
        }

        return itens;
    }

    /**
	 * Testar se o usuário logado é administrador.
	 * @return verdadeiro se for administrador.
	 */
	public Boolean getAdministrador() {
		int resultado = getVendedor().getPerfil().compareTo(PERFIL.ADMINISTRADOR);

		return resultado == 0 ? true : false;
	}

    public Usuario getVendedor() {
    	return getCrudFacade().listarVendedor();
    }

    public List<SelectItem> getVendedores() {
        vendedores = ordena(gerarListaSelectItem(
                getCrudFacade().listarVendedores()));

        return vendedores;
    }

    public List<SelectItem> getTiposPessoa() {
        return ordena(gerarListaSelectItem(getCrudFacade().listarTipoPessoa()));
    }

    public List<SelectItem> getTiposAssociado() {
        return ordena(gerarListaSelectItem(getCrudFacade().listarTipoAssociado()));
    }

    public List<SelectItem> getTransportadoras() {
        transportadoras = ordena(gerarListaSelectItem(
                getCrudFacade().listarTransportadoras()));

        return transportadoras;
    }

    public List<SelectItem> getStatus() {
        status = ordena(gerarListaSelectItem(getCrudFacade().listarStatus()));

        return status;
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

    public List<SelectItem> getAgencias() {
        if (agencias == null) {
            agencias = ordena(gerarListaSelectItem(getCrudFacade().listarAgencias()));
        }

        return agencias;
    }

    public Boolean getViewCliente() {

    	if (getSelecionado().getTipoAssociado() != null &&
    			getSelecionado().getTipoAssociado().compareTo(TipoAssociado.CLIENTE) == 0) {
    		return true;
    	}

    	return false;
    }

    public Boolean getViewAgencia() {

    	if (getSelecionado().getTipoAssociado() != null &&
    			getSelecionado().getTipoAssociado().compareTo(TipoAssociado.AGENCIA) == 0) {
    		return true;
    	}

    	return false;
    }

    public void buscarEndereco() {
    	getCepOnLine().getCep(getSelecionado().getDados().getEndereco());
    	estado = getSelecionado().getDados().getEndereco().getCidade().getEstado();
    }

    @Override
    public String salvar() {
    	getSelecionado().setAgenciaAssociada(getAgencia());
    	if (getVendedor().getPerfil().compareTo(PERFIL.VENDEDOR) == 0) {
    		getSelecionado().setVendedor(getVendedor());
    	}
    	
    	Cliente cliente = getSelecionado();
    	
    	super.salvar();
    	
    	if (getAgencia() != null) {
    		AgenciaPublicitaria agencia = getAgencia();
    		agencia.getAssociados().add(cliente);
    		getCrudFacade().atulizarAgencia(agencia);
    	}
    	
    	return Outcome.CRUD_SALVAR;
    }

    /**
	 * Excluir contato.
	 * @param contato
	 */
	public void setExcluirContato(Contato contato) {
		getSelecionado().getDados().getContatos().remove(contato);
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
        return Outcome.CRUD_CLIENTE;
    }

    public String consultar() {
    	iniciar();
    	return Outcome.CLIENTE_LISTAR;
    }

    public String orcamento() {
    	return Outcome.ALTERAR_CLIENTE_SITUACAO;
    }

    public String consultaNovo() {
    	return iniciar();
    }
    
    public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

	public AgenciaPublicitaria getAgencia() {
		return agencia;
	}

	public void setAgencia(AgenciaPublicitaria agencia) {
		this.agencia = agencia;
	}
    
}
