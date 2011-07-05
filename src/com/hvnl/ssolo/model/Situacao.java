/**
 * 
 */
package com.hvnl.ssolo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entidade que representa uma Situação de qualquer entidade.
 * @author vinicius
 */
@Entity
public class Situacao extends Model {
	/**
	 * Status que define a Situação do Model.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	private Status status;
	
	/**
	 * Data de atualização do status do Model.
	 */
	private Date dataAtualizacao;
	
	/**
	 * Texto explicativo do status atual.
	 */
	private String motivo;

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
