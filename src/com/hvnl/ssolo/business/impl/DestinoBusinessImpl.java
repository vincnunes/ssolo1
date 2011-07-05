/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.DestinoBusiness;
import com.hvnl.ssolo.dao.DestinoDao;
import com.hvnl.ssolo.model.Destino;

/**
 * Implementacao do business de {@link Destino}.
 * @author vinicius
 */
@Component("destinoBusiness")
public class DestinoBusinessImpl extends BusinessGenerico<Destino, DestinoDao>
		implements DestinoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("destinoDao") DestinoDao dao) {
        super.setDao(dao);
    }
    
}
