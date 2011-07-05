/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ClienteBusiness;
import com.hvnl.ssolo.dao.ClienteDao;
import com.hvnl.ssolo.model.Cliente;

/**
 * Implementacao do business de {@link Cliente}.
 * @author vinicius
 */
@Component("clienteBusiness")
public class ClienteBusinessImpl extends BusinessGenerico<Cliente, ClienteDao>
		implements ClienteBusiness {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("clienteDao") ClienteDao dao) {
        super.setDao(dao);
    }
	
}
