package com.hvnl.ssolo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entidade que representa um Contato de uma empresa.
 * @author heber
 */
@Entity
public class Contato extends Model {

    /**
     * A quem o contato pertence.
     */
	@ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private DadosEmpresa dadosEmpresa;

	/**
	 * Aniversario do contato.
	 */
	private Date aniversario;

	/**
     * Telefone de contato.
     */
    private String telefone;

    /**
     * Fax de contato.
     */
    private String fax;

    /**
     * Celular para contato.
     */
    private String celular;

    /**
     * Email para contato.
     */
    private String email;

	/**
	 * Cargo do contato na empresa.
	 */
	private String cargo;

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public DadosEmpresa getDadosEmpresa() {
		return dadosEmpresa;
	}

	public void setDadosEmpresa(DadosEmpresa dadosEmpresa) {
		this.dadosEmpresa = dadosEmpresa;
	}

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}