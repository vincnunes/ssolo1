/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.StatusDao;
import com.hvnl.ssolo.model.Status;

/**
 * Implementacao do DAO de {@link Status}.
 * @author vinicius
 */
@Component("statusDao")
public class StatusDaoImpl extends HibernateDaoGenerico<Status> implements
		StatusDao {

}
