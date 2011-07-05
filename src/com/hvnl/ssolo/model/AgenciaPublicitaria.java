package com.hvnl.ssolo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
 * Entidade de Agencia Publicitaria.
 * @author heber
 */
@Entity
public class AgenciaPublicitaria extends Model {

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
     * Banco a qual esta agencia pertence.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Conta conta;

    /**
     * Situação da Agência.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Situacao situacao;

	/**
	 * Percentual de ganho da venda.
	 */
	private Double bv;

	/**
     * Associados.
     */
    @OneToMany(targetEntity = Cliente.class, cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Cliente> associados = new ArrayList<Cliente>();
	
	/**
	 * Locais de entrega.
	 */
	@OneToMany(targetEntity = Endereco.class, cascade = CascadeType.ALL)
    @JoinTable(name = "AgenciaEndereco",
			joinColumns = @JoinColumn(name = "agenciapublicitaria_id"),
			inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<Endereco> locaisEntrega;

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Double getBv() {
        return bv;
    }

    public void setBv(Double bv) {
        this.bv = bv;
    }

    public List<Endereco> getLocaisEntrega() {
        return locaisEntrega;
    }

    public void setLocaisEntrega(List<Endereco> locaisEntrega) {
        this.locaisEntrega = locaisEntrega;
    }

    public DadosEmpresa getDados() {
		return dados;
	}

	public void setDados(DadosEmpresa dados) {
		this.dados = dados;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public List<Cliente> getAssociados() {
		return associados;
	}

	public void setAssociados(List<Cliente> associados) {
		this.associados = associados;
	}
}