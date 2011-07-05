/*
 * 07/07/2009
 */
package com.hvnl.ssolo.view;

import java.io.Serializable;

/**
 * Modelo que todo Bean deve implementar.
 * @author heber
 */
public interface Bean extends Serializable {
	
    /**
     * Método que será invocado para inicializar um bean.
     * @return navegação do bean
     */
    String iniciar();
}
