/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.GrampoBusiness;
import com.hvnl.ssolo.dao.GrampoDao;
import com.hvnl.ssolo.model.Grampo;

/**
 * Implementacao do business de {@link Grampo}.
 * @author vinicius
 */
@Component("grampoBusiness")
public class GrampoBusinessImpl extends BusinessGenerico<Grampo, GrampoDao>
		implements GrampoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("grampoDao") GrampoDao dao) {
        super.setDao(dao);
    }
    
}
