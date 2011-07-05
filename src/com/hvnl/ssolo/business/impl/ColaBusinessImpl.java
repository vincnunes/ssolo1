/*
 * 25/02/2011
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ColaBusiness;
import com.hvnl.ssolo.dao.ColaDao;
import com.hvnl.ssolo.model.Cola;

/**
 * Implementacao do business de {@link Cola}.
 * @author heber
 */
@Component("colaBusiness")
public class ColaBusinessImpl extends BusinessGenerico<Cola, ColaDao>
    	implements ColaBusiness {


    /** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("colaDao") ColaDao dao) {
        super.setDao(dao);
    }
}
