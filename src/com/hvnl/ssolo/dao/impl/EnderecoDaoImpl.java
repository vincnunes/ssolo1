/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.EnderecoDao;
import com.hvnl.ssolo.model.Endereco;

/**
 * Implementacao do DAO de {@link Endereco}.
 * @author vinicius
 */
@Component("enderecoDao")
public class EnderecoDaoImpl extends HibernateDaoGenerico<Endereco> implements
		EnderecoDao {

}
