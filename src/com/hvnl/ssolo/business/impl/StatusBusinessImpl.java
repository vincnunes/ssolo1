/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.StatusBusiness;
import com.hvnl.ssolo.dao.StatusDao;
import com.hvnl.ssolo.model.Status;

/**
 * Implementacao do business de {@link Status}.
 * @author vinicius
 */
@Component("statusBusiness")
public class StatusBusinessImpl extends BusinessGenerico<Status, StatusDao>
		implements StatusBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("statusDao") StatusDao dao) {
        super.setDao(dao);
    }
    
}
