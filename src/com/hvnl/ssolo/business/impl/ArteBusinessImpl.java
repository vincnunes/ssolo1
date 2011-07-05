/*
 * 24/02/2011
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.ArteBusiness;
import com.hvnl.ssolo.dao.ArteDao;
import com.hvnl.ssolo.model.Arte;

/**
 * Implementacao do business de {@link Arte}.
 * @author heber
 */
@Component("arteBusiness")
public class ArteBusinessImpl extends BusinessGenerico<Arte, ArteDao>
    implements ArteBusiness {


    /** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("arteDao") ArteDao dao) {
        super.setDao(dao);
    }
}
