package com.hvnl.ssolo.model;

import javax.persistence.Entity;

/**
 * Representa um Banco.
 * @author heber
 */
@Entity
public class Banco extends Model {
	
	/**
	 * Código de representação nacional do Banco.
	 */
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return getCodigo() + " - " + getNome();
	}
}

