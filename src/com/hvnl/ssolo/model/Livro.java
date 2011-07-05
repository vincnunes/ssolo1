package com.hvnl.ssolo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Representa uma Capa.
 * @author vinicius
 */
@Entity
public class Livro extends Model {
	/**
	 * Capa.
	 */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	private Capa capa;
    
    /**
	 * Cor.
	 */
	private String cor;
    
    /**
     * Gramatura.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	private Gramatura gramatura;
    
    /**
     * Papel.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	private Papel papel;
    
    /**
     * Lombada.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	private Lombada lombada;
    
    public Capa getCapa() {
		return capa;
	}

	public void setCapa(Capa capa) {
		this.capa = capa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Gramatura getGramatura() {
		return gramatura;
	}

	public void setGramatura(Gramatura gramatura) {
		this.gramatura = gramatura;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public Lombada getLombada() {
		return lombada;
	}

	public void setLombada(Lombada lombada) {
		this.lombada = lombada;
	}

}
