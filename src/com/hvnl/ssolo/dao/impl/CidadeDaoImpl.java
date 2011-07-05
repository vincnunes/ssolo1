/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.CidadeDao;
import com.hvnl.ssolo.model.Cidade;

/**
 * Implementacao do DAO de {@link Cidade}.
 * @author vinicius
 */
@Component("cidadeDao")
public class CidadeDaoImpl extends HibernateDaoGenerico<Cidade> implements
		CidadeDao {

}
