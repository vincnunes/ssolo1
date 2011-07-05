/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.AtividadeBusiness;
import com.hvnl.ssolo.dao.AtividadeDao;
import com.hvnl.ssolo.model.Atividade;

/**
 * Implementacao do business de {@link Atividade}.
 * @author vinicius
 */
@Component("atividadeBusiness")
public class AtividadeBusinessImpl extends BusinessGenerico<Atividade, AtividadeDao> 
		implements AtividadeBusiness {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("atividadeDao") AtividadeDao dao) {
        super.setDao(dao);
    }
}
