/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.BancoDao;
import com.hvnl.ssolo.model.Banco;

/**
 * Implementacao do DAO de {@link Banco}.
 * @author vinicius
 */
@Component("bancoDao")
public class BancoDaoImpl extends HibernateDaoGenerico<Banco> implements
		BancoDao {

}
