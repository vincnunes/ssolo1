/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ServicoBusiness;
import com.hvnl.ssolo.dao.ServicoDao;
import com.hvnl.ssolo.model.Servico;

/**
 * Implementacao do business de {@link Servico}.
 * @author vinicius
 */
@Component("servicoBusiness")
public class ServicoBusinessImpl extends BusinessGenerico<Servico, ServicoDao>
		implements ServicoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("servicoDao") ServicoDao dao) {
        super.setDao(dao);
    }
    
}
