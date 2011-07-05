package com.hvnl.ssolo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Solicitacao, objeto principal, de um produto ou servico.
 * @author heber
 */
@Entity
public class Solicitacao extends Model {

    /**
     * Vendedor que atende o cliente.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Usuario vendedor;

    /**
     * Cliente da solicitacao.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Cliente cliente;

    /**
     * Agencia publicitaria intermediaria.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private AgenciaPublicitaria agencia;

    /**
     * Transportadora dos produtos.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Transportadora transportadora;

    /**
     * Servico que sera feito.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Servico servico;

    /**
     * Tipo de plastificacao.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Plastificacao plastificacao;

    /**
     * Tipo de impressao.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Impressao impressao;

    /**
     * Tipo de arte.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Arte arte;

    /**
     * Tipo de prova.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Prova prova;

    /**
     * Tipo de dobra.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Dobra dobra;

    /**
     * Tipo de grampo.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Grampo grampo;

    /**
     * Tipo de cola.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Cola cola;

    /**
     * Tipo de corte.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Corte corte;

    /**
     * Tipo de verniz.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Verniz verniz;

    /**
     * Tipo de furo.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Furo furo;

    /**
     * Tipo de frete.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Frete frete;

    /**
     * Forma de pagamento.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Pagamento pagamento;

    /**
     * Prazo para pagamento.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Prazo prazo;

    /**
     * Imposto a se pagar.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Imposto imposto;

    /**
     * Status da solicitacao.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Status status;

    /**
     * Quantidade de paginas.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Pagina paginas;

    /**
     * Detalhes de Livro.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Livro livro;

    /**
     * Detalhes do serviço de Encarte.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Encarte encarte;

    /**
     * Detalhes do rótulo do serviço de Encarte.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Rotulo rotulo;

    /**
     * Papeis que serao utilizados.
     */
    @OneToMany(mappedBy = "solicitacao", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PapelGramatura> papel = new ArrayList<PapelGramatura>();

    /**
     * Locais para entrega.
     */
    @OneToMany(mappedBy = "solicitacao", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<SolicitacaoLocalEntrega> locaisEntrega = new ArrayList<SolicitacaoLocalEntrega>();

    /**
     * Cor do serviço.
     */
    private String cor;

	/**
     * Data da entrega.
     */
    private Date dataEntrega;

    /**
     * Quantidade de entrega.
     */
    private Integer quantidadeEntrega;

	/**
     * Data da finalizacao da solicitacao.
     */
    private Date dataFinalizacao;

    /**
     * Data da finalizacao da solicitacao.
     */
    private Boolean finalizado;

    /**
     * Observacoes sobre a solicitacao.
     */
    private String observacao;

    /**
     * Percentual de ganho da venda na Solicitação.
     */
    private Double bv;

    /**
     * Quantidade de servicos.
     */
    private Integer quantidade;

    /**
     * Quantidade de vias.
     */
    private Integer vias;

    /**
     * Observacoes para o formato.
     */
    private String formatoAberto;

    /**
     * Observacoes para o formato.
     */
    private String formatoFechado;

    /**
     * Data inicial para pesquisa de periodos.
     */
    private transient Date dataCadastroInicial;

    /**
     * Data final para pesquisa de periodos.
     */
    private transient Date dataCadastroFinal;

    /**
     * Data inicial para pesquisa de periodos.
     */
    private transient Date dataFinalizacaoInicial;

    /**
     * Data final para pesquisa de periodos.
     */
    private transient Date dataFinalizacaoFinal;

    public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

    public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Encarte getEncarte() {
		return encarte;
	}

	public void setEncarte(Encarte encarte) {
		this.encarte = encarte;
	}

	public Rotulo getRotulo() {
		return rotulo;
	}

	public void setRotulo(Rotulo rotulo) {
		this.rotulo = rotulo;
	}

	public Integer getQuantidadeEntrega() {
		return quantidadeEntrega;
	}

	public void setQuantidadeEntrega(Integer quantidadeEntrega) {
		this.quantidadeEntrega = quantidadeEntrega;
	}

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (this.cliente == null || !this.cliente.equals(cliente))
            this.cliente = cliente;
    }

    public AgenciaPublicitaria getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaPublicitaria agencia) {
        this.agencia = agencia;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Pagina getPaginas() {
        return paginas;
    }

    public void setPaginas(Pagina paginas) {
        this.paginas = paginas;
    }

    public Integer getVias() {
        return vias;
    }

    public void setVias(Integer vias) {
        this.vias = vias;
    }

    public String getFormatoAberto() {
        return formatoAberto;
    }

    public void setFormatoAberto(String formatoAberto) {
        this.formatoAberto = formatoAberto;
    }

    public String getFormatoFechado() {
        return formatoFechado;
    }

    public void setFormatoFechado(String formatoFechado) {
        this.formatoFechado = formatoFechado;
    }

    public Plastificacao getPlastificacao() {
        return plastificacao;
    }

    public void setPlastificacao(Plastificacao plastificacao) {
        this.plastificacao = plastificacao;
    }

    public Impressao getImpressao() {
        return impressao;
    }

    public void setImpressao(Impressao impressao) {
        this.impressao = impressao;
    }

    public Arte getArte() {
        return arte;
    }

    public void setArte(Arte arte) {
        this.arte = arte;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public Date getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Date dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public Dobra getDobra() {
        return dobra;
    }

    public void setDobra(Dobra dobra) {
        this.dobra = dobra;
    }

    public Grampo getGrampo() {
        return grampo;
    }

    public void setGrampo(Grampo grampo) {
        this.grampo = grampo;
    }

    public Cola getCola() {
        return cola;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }

    public Corte getCorte() {
        return corte;
    }

    public void setCorte(Corte corte) {
        this.corte = corte;
    }

    public Verniz getVerniz() {
        return verniz;
    }

    public void setVerniz(Verniz verniz) {
        this.verniz = verniz;
    }

    public Furo getFuro() {
        return furo;
    }

    public void setFuro(Furo furo) {
        this.furo = furo;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Prazo getPrazo() {
        return prazo;
    }

    public void setPrazo(Prazo prazo) {
        this.prazo = prazo;
    }

    public Imposto getImposto() {
        return imposto;
    }

    public void setImposto(Imposto imposto) {
        this.imposto = imposto;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<PapelGramatura> getPapel() {
        return papel;
    }

    public void setPapel(List<PapelGramatura> papel) {
        this.papel = papel;
    }

    public List<SolicitacaoLocalEntrega> getLocaisEntrega() {
        return locaisEntrega;
    }

    public void setLocaisEntrega(List<SolicitacaoLocalEntrega> locaisEntrega) {
        this.locaisEntrega = locaisEntrega;
    }

    public Double getBv() {
        return bv;
    }

    public void setBv(Double bv) {
        this.bv = bv;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Date getDataCadastroInicial() {
        return dataCadastroInicial;
    }

    public void setDataCadastroInicial(Date dataCadastroInicial) {
        this.dataCadastroInicial = dataCadastroInicial;
    }

    public Date getDataCadastroFinal() {
        return dataCadastroFinal;
    }

    public void setDataCadastroFinal(Date dataCadastroFinal) {
        this.dataCadastroFinal = dataCadastroFinal;
    }

    public Date getDataFinalizacaoInicial() {
        return dataFinalizacaoInicial;
    }

    public void setDataFinalizacaoInicial(Date dataFinalizacaoInicial) {
        this.dataFinalizacaoInicial = dataFinalizacaoInicial;
    }

    public Date getDataFinalizacaoFinal() {
        return dataFinalizacaoFinal;
    }

    public void setDataFinalizacaoFinal(Date dataFinalizacaoFinal) {
        this.dataFinalizacaoFinal = dataFinalizacaoFinal;
    }
}
