/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ContaBusiness;
import com.hvnl.ssolo.dao.ContaDao;
import com.hvnl.ssolo.model.Conta;

/**
 * Implementacao do business de {@link Conta}.
 * @author vinicius
 */
@Component("contaBusiness")
public class ContaBusinessImpl extends BusinessGenerico<Conta, ContaDao> 
		implements ContaBusiness {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("contaDao") ContaDao dao) {
        super.setDao(dao);
    }
    
}
