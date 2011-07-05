/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ImpressaoBusiness;
import com.hvnl.ssolo.dao.ImpressaoDao;
import com.hvnl.ssolo.model.Impressao;

/**
 * Implementacao do business de {@link Impressao}.
 * @author vinicius
 */
@Component("impressaoBusiness")
public class ImpressaoBusinessImpl extends BusinessGenerico<Impressao, ImpressaoDao>
		implements ImpressaoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("impressaoDao") ImpressaoDao dao) {
        super.setDao(dao);
    }
    
}
