/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.ContaDao;
import com.hvnl.ssolo.model.Conta;

/**
 * Implementacao do DAO de {@link Conta}.
 * @author vinicius
 */
@Component("contaDao")
public class ContaDaoImpl extends HibernateDaoGenerico<Conta> implements ContaDao {

}
