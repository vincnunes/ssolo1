/**
 * 
 */
package com.hvnl.ssolo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Lista de papéis solicitados para o serviço.
 * @author vinicius
 */
@Entity
public class PapelGramatura extends Model {
	
	/**
     * Papel solicitado.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	private Papel papel;
    
	/**
     * Gramatura do Papel solicitado.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	private Gramatura gramatura;
    
    /**
     * Solicitacao.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	private Solicitacao solicitacao;
    
    public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public Gramatura getGramatura() {
		return gramatura;
	}

	public void setGramatura(Gramatura gramatura) {
		this.gramatura = gramatura;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	@Override
	public String toString() {
		return (papel != null ? papel.toString() + " - " : "")
				+ (gramatura != null ? gramatura.toString() : "");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PapelGramatura) {
			PapelGramatura pg = (PapelGramatura) obj;
			return equals(pg.papel, papel) && equals(pg.gramatura, gramatura);
		}
		return false;
	}
}
