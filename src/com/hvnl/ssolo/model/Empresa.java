package com.hvnl.ssolo.model;

import java.util.Date;

import javax.persistence.Entity;

/**
 * Empresa que presta o servico (DONO DO SISTEMA).
 * @author heber
 */
@Entity
public class Empresa extends DadosEmpresa {

    /**
     * Site da empresa.
     */
	private String site;

	/**
	 * Numero da junta comercial.
	 */
	private String juntaComercial;

	/**
	 * Data da fundacao.
	 */
	private Date dataFundacao;

	/**
	 * Observacoes.
	 */
	private String observacao;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getJuntaComercial() {
        return juntaComercial;
    }

    public void setJuntaComercial(String juntaComercial) {
        this.juntaComercial = juntaComercial;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}

