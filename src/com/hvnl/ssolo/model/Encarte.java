package com.hvnl.ssolo.model;

import javax.persistence.Entity;

/**
 * Representa uma Capa.
 * @author vinicius
 */
@Entity
public class Encarte extends Model {
	
	/**
	 * Quantidade cabeçalhos no encarte.
	 */
	private Integer quantidade;
	
	/**
	 * Cor do cabeçalho no encarte.
	 */
	private String cor;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}

