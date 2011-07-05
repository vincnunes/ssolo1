/*
 * 04/08/2009
 */
package com.hvnl.ssolo.validation;

import com.hvnl.ssolo.model.Model;

/**
 * Classe que representa uma mensagem de validação de CPF, ou CNPJ, inválida.
 * @param <M> BaseModel a ser lidado
 * @author heber
 */
public class CpfCnpjInvalidoMensagem<M extends Model> extends ValidacaoMensagem {

    /**
     * Número inválido.
     */
    private final String cpfCnpj;

    /**
     * Informa se é um CPF.
     */
    private final Boolean cpf;

    /**
     * Dono do valor.
     */
    private final M model;

    /**
     * Construtor.
     * @param cpfCnpj número inválido
     * @param model modelo que possui o número
     * @param isCpf informa se o valor é um CPF
     */
    public CpfCnpjInvalidoMensagem(String cpfCnpj, M model, Boolean isCpf) {
        super("");
        this.cpfCnpj = cpfCnpj;
        this.model = model;
        this.cpf = isCpf;
    }

    public Boolean isCpf() {
        return cpf;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public M getModel() {
        return model;
    }
}
