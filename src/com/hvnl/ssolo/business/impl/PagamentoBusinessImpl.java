/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.PagamentoBusiness;
import com.hvnl.ssolo.dao.PagamentoDao;
import com.hvnl.ssolo.model.Pagamento;

/**
 * Implementacao do business de {@link Pagamento}.
 * @author vinicius
 */
@Component("pagamentoBusiness")
public class PagamentoBusinessImpl extends BusinessGenerico<Pagamento, PagamentoDao>
		implements PagamentoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("pagamentoDao") PagamentoDao dao) {
        super.setDao(dao);
    }
    
}
