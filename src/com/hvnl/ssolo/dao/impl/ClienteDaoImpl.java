/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.ClienteDao;
import com.hvnl.ssolo.model.Cliente;

/**
 * Implementacao do DAO de {@link Cliente}.
 * @author vinicius
 */
@Component("clienteDao")
public class ClienteDaoImpl extends HibernateDaoGenerico<Cliente> implements ClienteDao {


}
