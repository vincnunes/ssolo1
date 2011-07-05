/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.AtividadeBusiness;
import com.hvnl.ssolo.facade.CrudAtividadeFacade;
import com.hvnl.ssolo.model.Atividade;

/**
 * Implementacao da fachada do caso de uso Manter {@link Atividade}.
 * @author vinicius
 */
@Component("crudAtividadeFacade")
public class CrudAtividadeFacadeImpl extends
		CrudFacadeGenerico<Atividade, AtividadeBusiness> implements
		CrudAtividadeFacade {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("atividadeBusiness") AtividadeBusiness business) {
        super.setBusiness(business);
    }
}
