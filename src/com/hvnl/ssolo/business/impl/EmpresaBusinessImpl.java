/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.EmpresaBusiness;
import com.hvnl.ssolo.dao.EmpresaDao;
import com.hvnl.ssolo.model.Empresa;

/**
 * Implementacao do business de {@link Empresa}.
 * @author vinicius
 */
@Component("empresaBusiness")
public class EmpresaBusinessImpl extends BusinessGenerico<Empresa, EmpresaDao>
		implements EmpresaBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("empresaDao") EmpresaDao dao) {
        super.setDao(dao);
    }
    
}
