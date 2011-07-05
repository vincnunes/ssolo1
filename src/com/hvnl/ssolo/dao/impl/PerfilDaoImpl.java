/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.PerfilDao;
import com.hvnl.ssolo.model.Perfil;

/**
 * Implementacao do DAO de {@link Perfil}.
 * @author vinicius
 */
@Component("perfilDao")
public class PerfilDaoImpl extends HibernateDaoGenerico<Perfil> implements
		PerfilDao {

}
