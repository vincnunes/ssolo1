/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.EmpresaDao;
import com.hvnl.ssolo.model.Empresa;

/**
 * Implementacao do DAO de {@link Empresa}.
 * @author vinicius
 */
@Component("empresaDao")
public class EmpresaDaoImpl extends HibernateDaoGenerico<Empresa> implements
		EmpresaDao {

}
