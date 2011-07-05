/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.EstadoBusiness;
import com.hvnl.ssolo.dao.EstadoDao;
import com.hvnl.ssolo.model.Estado;

/**
 * Implementacao do business de {@link Estado}.
 * @author vinicius
 */
@Component("estadoBusiness")
public class EstadoBusinessImpl extends BusinessGenerico<Estado, EstadoDao>
		implements EstadoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("estadoDao") EstadoDao dao) {
        super.setDao(dao);
    }
    
}
