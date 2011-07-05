package com.hvnl.ssolo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entidade que representa um cliente.
 * @author heber
 */
@Entity
public class Cliente extends Model {

    /**
     * Tipo de pessoa do cliente.
     */
    @Enumerated(EnumType.STRING)
	private Pessoa pessoa;
    
    @Enumerated(EnumType.STRING)
    private TipoAssociado tipoAssociado;

	/**
	 * Atividade/Ramo do cliente.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	private Atividade atividade;
	/**
	 * Vendedor que atende o cliente.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	private Usuario vendedor;

	/**
	 * Dados gerais.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private DadosEmpresa dados;

	/**
	 * Situação do Cliente.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private Situacao situacao;

	/**
	 * Transportadora padrão.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
	public Transportadora transportadora;

	/**
	 * Locais para entrega.
	 */
	@OneToMany(targetEntity = Endereco.class, cascade = CascadeType.ALL)
    @JoinTable(name = "ClienteEndereco",
			joinColumns = @JoinColumn(name = "cliente_id"),
			inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<Endereco> locaisEntrega;

	/**
	 * Destinos.
	 */
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<Destino> destinos;

	/**
     * Associados.
     */
    @OneToMany(mappedBy = "associado", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Cliente> associados = new ArrayList<Cliente>();

    /**
     * Cliente ao qual ele está associado.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    public Cliente associado;
    
    /**
     * Agência ao qual ele está associado.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    public AgenciaPublicitaria agenciaAssociada;

	/**
	 * Tipo de Pessoa do cliente.
	 * @author heber
	 */
	public enum Pessoa {
	    /** Pessoa Fisica. */
	    FISICA,
	    /** Juridica. */
	    JURIDICA;
	}
	
	/**
	 * Tipo de Associado do cliente.
	 * @author vinicius
	 */
	public enum TipoAssociado {
	    /** Associado a um Cliente. */
	    CLIENTE,
	    /** Associado a uma Agência. */
	    AGENCIA;
	}

	/**
	 * Nome do contato de compras do cliente.
	 */
	public String contatoCompras;

	/**
	 * Nome do contato financeiro do cliente.
	 */
	public String contatoFinanceiro;

	/**
	 * Diretor.
	 */
	public String diretor;

	/**
	 * Referência.
	 */
	public String referencia;

	/**
	 * Distância do cliente.
	 */
	public String distancia;

	/**
	 * Observação a respeito do cliente.
	 */
	public String observacao;

	/**
	 * Definição de retenção de ISS.
	 */
	public Boolean reterIss;

	/**
	 * Definição de retenção de PIS.
	 */
	public Boolean reterPis;

	/**
	 * Definição de retenção de COFINS.
	 */
	public Boolean reterCofins;

	/**
	 * Definição de retenção de CSSL.
	 */
	public Boolean reterCssl;

	/**
	 * Definição de retenção de ICMS.
	 */
	public Boolean reterIcms;

	/**
	 * Definição de retenção de Imposto de Renda.
	 */
	public Boolean reterIr;

	/**
	 * Unitária com máximo de 2 casas.
	 */
	public Boolean unitaria;

	public AgenciaPublicitaria getAgenciaAssociada() {
		return agenciaAssociada;
	}

	public void setAgenciaAssociada(AgenciaPublicitaria agenciaAssociada) {
		this.agenciaAssociada = agenciaAssociada;
	}
	
	public List<Cliente> getAssociados() {
	    return associados;
	}

	public void setAssociados(List<Cliente> associados) {
	    this.associados = associados;
	}

	public Cliente getAssociado() {
	    return associado;
	}

	public void setAssociado(Cliente associado) {
	    this.associado = associado;
	}

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public DadosEmpresa getDados() {
        return dados;
    }

    public void setDados(DadosEmpresa dados) {
        this.dados = dados;
    }

    public List<Endereco> getLocaisEntrega() {
        return locaisEntrega;
    }

    public void setLocaisEntrega(List<Endereco> locaisEntrega) {
        this.locaisEntrega = locaisEntrega;
    }

    public List<Destino> getDestinos() {
        return destinos;
    }

    public void setDestinos(List<Destino> destinos) {
        this.destinos = destinos;
    }

    public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public String getContatoCompras() {
		return contatoCompras;
	}

	public void setContatoCompras(String contatoCompras) {
		this.contatoCompras = contatoCompras;
	}

	public String getContatoFinanceiro() {
		return contatoFinanceiro;
	}

	public void setContatoFinanceiro(String contatoFinanceiro) {
		this.contatoFinanceiro = contatoFinanceiro;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getReterIss() {
		return reterIss;
	}

	public void setReterIss(Boolean reterIss) {
		this.reterIss = reterIss;
	}

	public Boolean getReterPis() {
		return reterPis;
	}

	public void setReterPis(Boolean reterPis) {
		this.reterPis = reterPis;
	}

	public Boolean getReterCofins() {
		return reterCofins;
	}

	public void setReterCofins(Boolean reterCofins) {
		this.reterCofins = reterCofins;
	}

	public Boolean getReterCssl() {
		return reterCssl;
	}

	public void setReterCssl(Boolean reterCssl) {
		this.reterCssl = reterCssl;
	}

	public Boolean getReterIcms() {
		return reterIcms;
	}

	public void setReterIcms(Boolean reterIcms) {
		this.reterIcms = reterIcms;
	}

	public Boolean getReterIr() {
		return reterIr;
	}

	public void setReterIr(Boolean reterIr) {
		this.reterIr = reterIr;
	}

	public Boolean getUnitaria() {
		return unitaria;
	}

	public void setUnitaria(Boolean unitaria) {
		this.unitaria = unitaria;
	}
	
	public TipoAssociado getTipoAssociado() {
		return tipoAssociado;
	}

	public void setTipoAssociado(TipoAssociado tipoAssociado) {
		this.tipoAssociado = tipoAssociado;
	}

}