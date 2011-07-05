/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.PaginaBusiness;
import com.hvnl.ssolo.dao.PaginaDao;
import com.hvnl.ssolo.model.Pagina;

/**
 * Implementacao do business de {@link Pagina}.
 * @author vinicius
 */
@Component("paginaBusiness")
public class PaginaBusinessImpl extends BusinessGenerico<Pagina, PaginaDao>
		implements PaginaBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("paginaDao") PaginaDao dao) {
        super.setDao(dao);
    }
    
}
