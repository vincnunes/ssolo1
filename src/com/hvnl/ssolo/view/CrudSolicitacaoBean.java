/**
 *
 */
package com.hvnl.ssolo.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.mail.EmailException;

import com.hvnl.ssolo.exception.FacadeException;
import com.hvnl.ssolo.facade.CrudSolicitacaoFacade;
import com.hvnl.ssolo.model.AgenciaPublicitaria;
import com.hvnl.ssolo.model.Arte;
import com.hvnl.ssolo.model.Capa;
import com.hvnl.ssolo.model.Cliente;
import com.hvnl.ssolo.model.Cola;
import com.hvnl.ssolo.model.Corte;
import com.hvnl.ssolo.model.Destino;
import com.hvnl.ssolo.model.Dobra;
import com.hvnl.ssolo.model.Encarte;
import com.hvnl.ssolo.model.Frete;
import com.hvnl.ssolo.model.Furo;
import com.hvnl.ssolo.model.Gramatura;
import com.hvnl.ssolo.model.Grampo;
import com.hvnl.ssolo.model.Imposto;
import com.hvnl.ssolo.model.Impressao;
import com.hvnl.ssolo.model.Livro;
import com.hvnl.ssolo.model.Lombada;
import com.hvnl.ssolo.model.Pagamento;
import com.hvnl.ssolo.model.Pagina;
import com.hvnl.ssolo.model.Papel;
import com.hvnl.ssolo.model.PapelGramatura;
import com.hvnl.ssolo.model.Plastificacao;
import com.hvnl.ssolo.model.Prazo;
import com.hvnl.ssolo.model.Prova;
import com.hvnl.ssolo.model.Rotulo;
import com.hvnl.ssolo.model.Servico;
import com.hvnl.ssolo.model.Solicitacao;
import com.hvnl.ssolo.model.SolicitacaoLocalEntrega;
import com.hvnl.ssolo.model.Status;
import com.hvnl.ssolo.model.Transportadora;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.model.Usuario.PERFIL;
import com.hvnl.ssolo.model.Verniz;

/**
 * Bean do caso de uso cadastrar {@link Solicitacao}.
 * @author vinicius
 */
public class CrudSolicitacaoBean extends CrudBeanGenerico<Solicitacao, CrudSolicitacaoFacade> {

	private List<AgenciaPublicitaria> agenciasPublicitarias;

	private List<Arte> artes;

	private List<Capa> capas;

	private List<Cliente> clientes;

	private List<Cola> colas;

	private List<Corte> cortes;

	private List<Destino> destinos;

	private List<Dobra> dobras;

	private List<Frete> fretes;

	private List<Furo> furos;

	private List<Gramatura> gramaturas;

	private List<Grampo> grampos;

	private List<Imposto> impostos;

	private List<Impressao> impressoes;

	private List<Lombada> lombadas;

	private List<Pagina> paginas;

	private List<Pagamento> pagamentos;

	private List<Papel> papeis;

	private List<Plastificacao> plastificacoes;

	private List<Prazo> prazos;

	private List<Prova> provas;

	private List<Servico> servicos;

	private List<Status> status;

	private List<Transportadora> transportadoras;

	private List<Usuario> vendedores;

	private List<Verniz> vernizes;

//    private SolicitacaoLocalEntrega localEntrega;

    private Double bv;

    private Date dataCadastro;

    private Date dataFinalizacao;

    /**
     * Associado selecionado de uma lista para ser adicionada ao local de entrega.
     * @see #adicionarAssociado()
     */
    private Cliente associado;

	@Override
	public String iniciar() {
		agenciasPublicitarias = getCrudFacade().listarAgenciaPublicitaria();
		artes = getCrudFacade().listarArte();
		capas = getCrudFacade().listarCapa();
		clientes = getCrudFacade().listarCliente();
		colas = getCrudFacade().listarCola();
		cortes = getCrudFacade().listarCorte();
		destinos = getCrudFacade().listarDestino();
		dobras = getCrudFacade().listarDobra();
		fretes = getCrudFacade().listarFrete();
		furos = getCrudFacade().listarFuro();
		gramaturas = getCrudFacade().listarGramatura();
		grampos = getCrudFacade().listarGrampo();
		impostos = getCrudFacade().listarImposto();
		impressoes = getCrudFacade().listarImpressao();
		lombadas = getCrudFacade().listarLombada();
		paginas = getCrudFacade().listarPagina();
		pagamentos = getCrudFacade().listarPagamento();
		papeis = getCrudFacade().listarPapel();
		plastificacoes = getCrudFacade().listarPlastificacao();
		prazos = getCrudFacade().listarPrazo();
		provas = getCrudFacade().listarProva();
		servicos = getCrudFacade().listarServico();
		status = getCrudFacade().listarStatus();
		transportadoras = getCrudFacade().listarTransportadora();
		vendedores = getCrudFacade().listarVendedores();
		vernizes = getCrudFacade().listarVerniz();

		return super.iniciar();
	}

	/**
	 *
	 * @return solicitacao
	 */
	@Override
	protected Solicitacao getNewModel() {
		Solicitacao solicitacao = super.getNewModel();
		Encarte encarte = new Encarte();
		solicitacao.setEncarte(encarte);
		Livro livro = new Livro();
		solicitacao.setLivro(livro);
		Rotulo rotulo = new Rotulo();
		solicitacao.setRotulo(rotulo);

		if (solicitacao.getAgencia() != null) {
			solicitacao.setBv(solicitacao.getAgencia().getBv());
		}

		return solicitacao;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_SOLICITACAO;
	}

	public String consultar() {
    	iniciar();
    	return Outcome.SOLICITACAO_LISTAR;
    }

	public String consultaNovo() {
    	iniciar();
    	return Outcome.CRUD_SOLICITACAO;
    }

	/**
	 * Lista de {@link AgenciaPublicitaria}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getAgenciasPublicitarias() {
		return ordena(gerarListaSelectItem(agenciasPublicitarias));
	}

	/**
	 * Lista de {@link Arte}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getArtes() {
		return ordena(gerarListaSelectItem(artes));
	}

	/**
	 * Lista de {@link Capa}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getCapas() {
		return ordena(gerarListaSelectItem(capas));
	}

	/**
	 * Lista de {@link Cliente}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getClientes() {
		return ordena(gerarListaSelectItem(clientes));
	}

	/**
	 * Lista de {@link Cola}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getColas() {
		return ordena(gerarListaSelectItem(colas));
	}

	/**
	 * Lista de {@link Corte}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getCortes() {
		return ordena(gerarListaSelectItem(cortes));
	}

	/**
	 * Lista de {@link Destino}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getDestinos() {
		return ordena(gerarListaSelectItem(destinos));
	}

	/**
	 * Lista de {@link Dobra}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getDobras() {
		return ordena(gerarListaSelectItem(dobras));
	}

	/**
	 * Lista de {@link Frete}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getFretes() {
		return ordena(gerarListaSelectItem(fretes));
	}

	/**
	 * Lista de {@link Furo}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getFuros() {
		return ordena(gerarListaSelectItem(furos));
	}

	/**
	 * Lista de {@link Gramatura}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getGramaturas() {
		return ordena(gerarListaSelectItem(gramaturas));
	}

	/**
	 * Lista de {@link Grampo}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getGrampos() {
		return ordena(gerarListaSelectItem(grampos));
	}

	/**
	 * Lista de {@link Imposto}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getImpostos() {
		return ordena(gerarListaSelectItem(impostos));
	}

	/**
	 * Lista de {@link Impressao}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getImpressoes() {
		return ordena(gerarListaSelectItem(impressoes));
	}

	/**
	 * Lista de {@link Lombada}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getLombadas() {
		return ordena(gerarListaSelectItem(lombadas));
	}

	/**
	 * Lista de {@link Pagina}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getPaginas() {
		return ordena(gerarListaSelectItem(paginas));
	}

	/**
	 * Lista de {@link Pagamento}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getPagamentos() {
		return ordena(gerarListaSelectItem(pagamentos));
	}

	/**
	 * Lista de {@link Papel}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getPapeis() {
		return ordena(gerarListaSelectItem(papeis));
	}

	/**
	 * Lista de {@link Plastificacao}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getPlastificacoes() {
		return ordena(gerarListaSelectItem(plastificacoes));
	}

	/**
	 * Lista de {@link Prazo}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getPrazos() {
		return ordena(gerarListaSelectItem(prazos));
	}

	/**
	 * Lista de {@link Prova}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getProvas() {
		return ordena(gerarListaSelectItem(provas));
	}

	/**
	 * Lista de {@link Servico}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getServicos() {
		return ordena(gerarListaSelectItem(servicos));
	}

	/**
	 * Lista de {@link Status}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getStatus() {
		return ordena(gerarListaSelectItem(status));
	}

	/**
	 * Lista de {@link Transportadora}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getTransportadoras() {
		return ordena(gerarListaSelectItem(transportadoras));
	}

	/**
	 * Lista de {@link Usuario}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getVendedores() {
		return ordena(gerarListaSelectItem(vendedores));
	}

	/**
	 * Lista de {@link Verniz}.
	 * @return list<SelectItem>
	 */
	public List<SelectItem> getVernizes() {
		return ordena(gerarListaSelectItem(vernizes));
	}

	/**
	 * Excluir item de papelGramatura da solicitacao.
	 * @param papelGramatura
	 */
	public void setExcluirPapelGramatura(PapelGramatura papelGramatura) {
		getSelecionado().getPapel().remove(papelGramatura);
	}

	/**
	 * Excluir localEntrega da solicitacao.
	 * @param solicitacaoLocalEntrega
	 */
	public void setExcluirEndereco(SolicitacaoLocalEntrega sle) {
		getSelecionado().getLocaisEntrega().remove(sle);
	}

	/**
	 * Lista de solicitacões finalizadas.
	 * @return
	 */
	public List<Solicitacao> getFinalizados() {
		return getCrudFacade().listarFinalizados();
	}

	/**
	 * Testar tipo de servico Livro.
	 * @return verdadeiro se o serviço for livro.
	 */
	public Boolean getServicoLivro() {
		if(getSelecionado().getServico() != null) {
			return getSelecionado().getServico().getNome().equals("Livro");
		}

		return false;
	}

	/**
	 * Testar tipo de servico Encarte.
	 * @return verdadeiro se o serviço for encarte.
	 */
	public Boolean getServicoEncarte() {
		if(getSelecionado().getServico() != null) {
			return getSelecionado().getServico().getNome().equals("Encarte");
		}

		return false;
	}
	
	/**
	 * Testar tipo de servico Encarte.
	 * @return verdadeiro se o serviço for encarte.
	 */
	public Boolean getServicoRotulo() {
		if(getSelecionado().getServico() != null) {
			return getSelecionado().getServico().getNome().equals("Rótulo");
		}

		return false;
	}

	/**
	 *
	 * @return usuarioLogado
	 */
	public Usuario getVendedor() {
		return getCrudFacade().listarVendedor();
	}

	/**
	 * Testar se o usuário logado é administrador.
	 * @return verdadeiro se for administrador.
	 */
	public Boolean getAdministrador() {
		int resultado = getVendedor().getPerfil().compareTo(PERFIL.ADMINISTRADOR);

		return resultado == 0 ? true : false;
	}

	@Override
	public String salvar() {
		getSelecionado().setVendedor(getVendedor());
		getSelecionado().setBv(bv);
		if (getSelecionado().getDataCadastro() == null) {
			getSelecionado().setDataCadastro(new Date());
		}

		return super.salvar();
	}

	/**
     * Salva o registro selecionado.
     * @return navegação
     * @see CrudBeanGenerico#selecionado
     */
    public String finalizar() {
    	Solicitacao selecionado = getSelecionado();
        String retorno = super.salvar();
        setSelecionado(selecionado);
        if (Outcome.ERROR.equals(retorno)) {
            return retorno;
        }

        try {
            getCrudFacade().finalizar(getSelecionado());
        } catch (FacadeException e) {
            tratarFacadeException(e);
        } catch (EmailException e) {
            tratarException(e);
        }

        return Outcome.SUCCESS;
    }

    /**
     * Gera o relatorio PDF.
     */
    public void relatorioPDF(List<Solicitacao> registros, Hashtable<Object, Object> parameters) {
        super.relatorioPDF(registros, parameters);
    }

    /**
     * Gera relatorio do registro selecionado.
     */
    public void relatorioRegistro() {
    	List<Solicitacao> registro = new ArrayList<Solicitacao>();
    	registro.add(getSelecionado());
    	
    	Hashtable<Object, Object> parameters = new Hashtable<Object, Object>();
    	
		relatorioPDF(registro, parameters);
	}

    @Override
    public void relatorio() {
    	filtrar();
    	super.relatorio();
    }

    /**
     * Lista de estados brasileiros.
     * @return
     */
    public List<SelectItem> getEstados() {
        return ordena(gerarListaSelectItem(getCrudFacade().listarEstados()));
    }

	/**
	 * Método utilizado para adicionar a configuração dos papéis
	 * a serem utilizados no serviço solicitado.
	 */
	public void adicionarPapelGramatura() {
		PapelGramatura pg = new PapelGramatura();
		pg.setSolicitacao(getSelecionado());
		getSelecionado().getPapel().add(pg);
	}

//	public void setLocalEntrega(SolicitacaoLocalEntrega localEntrega) {
//	    this.localEntrega = localEntrega;
//	}

	public Double getBv() {
		if (getSelecionado().getAgencia() != null) {
			bv = getSelecionado().getAgencia().getBv();
		}
		return bv;
	}

	public void setBv(Double bv) {
		this.bv = bv;
	}

	public Date getDataCadastro() {
		if (getSelecionado().getDataCadastro() != null) {
			dataCadastro = getSelecionado().getDataCadastro();
		} else {
			dataCadastro = new Date();
		}

		return dataCadastro;
	}

	/**
	 * Lista os associados que ainda nao foram selecionados.
	 * @return associados ainda disponiveis
	 */
	public List<SelectItem> getAssociados() {
	    List<Cliente> clientes = new ArrayList<Cliente>();
	    for (SolicitacaoLocalEntrega local : getSelecionado().getLocaisEntrega()) {
            clientes.add(local.getAssociado());
        }

	    List<SelectItem> associados = new ArrayList<SelectItem>();
	    if (getSelecionado().getCliente() != null) {
	        for (Cliente associado : getSelecionado().getCliente().getAssociados()) {
	            if (!clientes.contains(associado)) {
	                associados.add(new SelectItem(associado, associado.getNome()));
	            }
	        }
	    } else if (getSelecionado().getAgencia() != null) {
    	    for (Cliente associado : getSelecionado().getAgencia().getAssociados()) {
    	        if (!clientes.contains(associado)) {
    	            associados.add(new SelectItem(associado, associado.getNome()));
    	        }
    	    }
	    }

	    return associados;
	}

	/**
	 * Zera a lista de locais de entrega.
	 */
	public void atualizarAssociadosCliente() {
	    atualizarAssociados();
	    getSelecionado().setAgencia(null);
	}

	public void atualizarAssociadosAgencia() {
	    atualizarAssociados();
	    getSelecionado().setCliente(null);
	}

	public void atualizarAssociados() {
	    for (SolicitacaoLocalEntrega local : getSelecionado().getLocaisEntrega()) {
            local.setSolicitacao(null);
        }
	    getSelecionado().setLocaisEntrega(new ArrayList<SolicitacaoLocalEntrega>());
	}

	/**
	 * Adiciona o associado ao local de entrega.
	 */
	public void adicionarAssociado() {
	    if (this.associado != null) {
	        SolicitacaoLocalEntrega local = new SolicitacaoLocalEntrega();
	        local.setSolicitacao(getSelecionado());
	        local.setAssociado(this.associado);
	        local.setQuantidade(0);
	        getSelecionado().getLocaisEntrega().add(local);
	        this.associado = null;
	    }
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataFinalizacao() {
		if (getSelecionado().getDataFinalizacao() != null) {
			dataFinalizacao = getSelecionado().getDataFinalizacao();
		}
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

    public void setAssociado(Cliente associado) {
        this.associado = associado;
    }

    public Cliente getAssociado() {
        return associado;
    }
}
