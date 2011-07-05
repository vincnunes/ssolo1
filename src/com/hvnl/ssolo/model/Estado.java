/*
 * 24/02/2011
 */
package com.hvnl.ssolo.model;

import javax.persistence.Entity;

/**
 * Estado.
 * @author heber
 */
@Entity
public class Estado extends Model {

    /**
     * Sigla do estado.
     */
    private String sigla;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
