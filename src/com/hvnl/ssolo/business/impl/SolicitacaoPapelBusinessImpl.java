/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.SolicitacaoPapelBusiness;
import com.hvnl.ssolo.dao.SolicitacaoPapelDao;
import com.hvnl.ssolo.model.SolicitacaoPapel;

/**
 * Implementacao do business de {@link SolicitacaoPapel}.
 * @author vinicius
 */
@Component("solicitacaoPapelBusiness")
public class SolicitacaoPapelBusinessImpl extends BusinessGenerico<SolicitacaoPapel, SolicitacaoPapelDao>
		implements SolicitacaoPapelBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("solicitacaoPapelDao") SolicitacaoPapelDao dao) {
        super.setDao(dao);
    }
    
}
