/*
 * 24/02/2011
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.ArteDao;
import com.hvnl.ssolo.model.Arte;

/**
 * Implementacao do DAO de Arte.
 * @author heber
 */
@Component("arteDao")
public class ArteDaoImpl extends HibernateDaoGenerico<Arte> implements ArteDao {

}
