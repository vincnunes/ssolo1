/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ImpostoBusiness;
import com.hvnl.ssolo.dao.ImpostoDao;
import com.hvnl.ssolo.model.Imposto;

/**
 * Implementacao do business de {@link Imposto}.
 * @author vinicius
 */
@Component("impostoBusiness")
public class ImpostoBusinessImpl extends BusinessGenerico<Imposto, ImpostoDao> 
		implements ImpostoBusiness {

	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("impostoDao") ImpostoDao dao) {
        super.setDao(dao);
    }
}