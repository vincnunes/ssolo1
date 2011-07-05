package com.hvnl.ssolo.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.UsuarioDao;
import com.hvnl.ssolo.exception.DaoException;
import com.hvnl.ssolo.model.Usuario;
/**
 * implemetacao de dao Usuario.
 * @author Ferreira
 *
 */
@Component("usuarioDao")
public class UsuarioDaoimpl extends HibernateDaoGenerico<Usuario> implements
        UsuarioDao {

    /** {@inheritDoc} */
    public Usuario getUsuario(String login, String senha) {

        HibernateCriteriaFinder<Usuario> action =
            new HibernateCriteriaFinder<Usuario>(getModelClass(), null, new String[] {});

        try {
            action.addCriterion(Restrictions.eq("login", login));
            action.addCriterion(Restrictions.eq("senha", senha));

            List<Usuario> usuarios = listar(action);

            if (!usuarios.isEmpty()) {
                return usuarios.get(0);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return null;
    }

}
