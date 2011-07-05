/*
 * 03/08/2009
 */
package com.hvnl.ssolo.validation;

import java.lang.reflect.Field;

import com.hvnl.ssolo.model.Model;

/**
 * Exceção para campos que não podem ser nulos.
 * @author heber
 *
 */
public class CannotBeNullMensagem extends ValidacaoMensagem {

    /**
     * Campo avaliado.
     */
    private final Field campo;

    /**
     * Objeto lido.
     */
    private final Model object;

    /**
     * Construtor.
     * @param campo campo avaliado
     * @param object objeto que foi lido
     */
    public CannotBeNullMensagem(Field campo, Model object) {
        super("");
        this.campo = campo;
        this.object = object;
    }

    public Field getCampo() {
        return campo;
    }

    public Model getObject() {
        return object;
    }
}
