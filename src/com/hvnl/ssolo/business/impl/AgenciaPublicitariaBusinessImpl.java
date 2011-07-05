/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.AgenciaPublicitariaBusiness;
import com.hvnl.ssolo.dao.AgenciaPublicitariaDao;
import com.hvnl.ssolo.model.AgenciaPublicitaria;

/**
 * Implementacao do business de {@link AgenciaPublicitaria}.
 * @author vinicius
 */
@Component("agenciaPublicitariaBusiness")
public class AgenciaPublicitariaBusinessImpl extends BusinessGenerico<AgenciaPublicitaria, AgenciaPublicitariaDao>
		implements AgenciaPublicitariaBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("agenciaPublicitariaDao") AgenciaPublicitariaDao dao) {
        super.setDao(dao);
    }
    
}
