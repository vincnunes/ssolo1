package com.hvnl.ssolo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entidade Usuario.
 * @author heber
 */
@Entity
public class Usuario extends Model {

    /**
     * Situacao atual do usuario.
     */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private Situacao situacao;
	
	/**
	 * Endereco do usuario.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private Endereco endereco;

	/**
	 * Login do usuario.
	 */
	private String login;

	/**
	 * Senha do usuario.
	 */
	private String senha;

	/**
	 * CPF do usuario.
	 */
	private String cpf;

	/**
	 * RG do usuario.
	 */
	private String rg;
	
	/**
	 * Email do usuario.
	 */
	private String email;
	
	/**
	 * Data de nascimento do usuario.
	 */
	private Date dataNascimento;

	/**
	 * Telefone do usuario.
	 */
	private String telefone;

	/**
	 * Celular do usuario.
	 */
	private String celular;

	/**
	 * Data de admissão do usuario.
	 */
	private Date dataAdmissao;

	@Enumerated(EnumType.STRING)
	private PERFIL perfil;

	/**
	 * Enum para delimitar o perfil do usuario.
	 * @author heber
	 */
	public enum PERFIL {
	    ADMINISTRADOR,
	    FINANCEIRO,
	    ORCAMENTO,
	    VENDEDOR
	}

    public Situacao getSituacao() {
        return situacao;
    }
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
    public void setPerfil(PERFIL perfil) {
        this.perfil = perfil;
    }
    public PERFIL getPerfil() {
        return perfil;
    }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
