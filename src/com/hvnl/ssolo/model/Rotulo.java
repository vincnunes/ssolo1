package com.hvnl.ssolo.model;

import javax.persistence.Entity;

/**
 * Representa uma Capa.
 * @author vinicius
 */
@Entity
public class Rotulo extends Model {
	/**
	 * Medida da base do rótulo.
	 */
	private String base;
	
	/**
	 * Medida da altura do rótulo.
	 */
	private String altura;
	
	/**
	 * Cor utilizada no rótulo.
	 */
	private String cor;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}

