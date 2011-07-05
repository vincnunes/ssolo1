/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.OrcamentoBusiness;
import com.hvnl.ssolo.dao.OrcamentoDao;
import com.hvnl.ssolo.model.Orcamento;

/**
 * Implementacao do business de {@link Orcamento}.
 * @author vinicius
 */
@Component("orcamentoBusiness")
public class OrcamentoBusinessImpl extends BusinessGenerico<Orcamento, OrcamentoDao>
		implements OrcamentoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("orcamentoDao") OrcamentoDao dao) {
        super.setDao(dao);
    }
    
}
