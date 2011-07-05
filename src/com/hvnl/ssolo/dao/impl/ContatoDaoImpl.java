/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.ContatoDao;
import com.hvnl.ssolo.model.Contato;

/**
 * Implementacao do DAO de {@link Contato}.
 * @author vinicius
 */
@Component("contatoDao")
public class ContatoDaoImpl extends HibernateDaoGenerico<Contato> implements
		ContatoDao {

}
