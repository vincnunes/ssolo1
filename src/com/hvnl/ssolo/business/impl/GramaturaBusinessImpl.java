/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.GramaturaBusiness;
import com.hvnl.ssolo.dao.GramaturaDao;
import com.hvnl.ssolo.model.Gramatura;

/**
 * Implementacao do business de {@link Gramatura}.
 * @author vinicius
 */
@Component("gramaturaBusiness")
public class GramaturaBusinessImpl extends BusinessGenerico<Gramatura, GramaturaDao>
		implements GramaturaBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("gramaturaDao") GramaturaDao dao) {
        super.setDao(dao);
    }
    
}
