/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.BancoBusiness;
import com.hvnl.ssolo.dao.BancoDao;
import com.hvnl.ssolo.model.Banco;

/**
 * Implementacao do business de {@link Banco}.
 * @author vinicius
 */
@Component("bancoBusiness")
public class BancoBusinessImpl extends BusinessGenerico<Banco, BancoDao>
		implements BancoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("bancoDao") BancoDao dao) {
        super.setDao(dao);
    }
    
}
