/*
 * 25/02/2011
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.ColaDao;
import com.hvnl.ssolo.model.Cola;

/**
 * Implementacao do DAO para {@link Cola}.
 * @author heber
 */
@Component("colaDao")
public class ColaDaoImpl extends HibernateDaoGenerico<Cola> implements ColaDao {

}
