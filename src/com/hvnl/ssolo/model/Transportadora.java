package com.hvnl.ssolo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Transportadora que realiza entregas.
 * @author heber
 */
@Entity
public class Transportadora extends Model {
	
	/**
	 * Situação cadastral da transportadora.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private Situacao situacao;
	
	/**
	 * Dados gerais.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private DadosEmpresa dados;

	/**
	 * Observações de entrega da transportadora.
	 */
	private String observacao;
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public DadosEmpresa getDados() {
		return dados;
	}

	public void setDados(DadosEmpresa dados) {
		this.dados = dados;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
}
