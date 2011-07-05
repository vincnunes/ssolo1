package com.hvnl.ssolo.business.impl;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.UsuarioLogadoBusiness;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.util.Constants;

@Component("usuarioLogadoBusiness")
public class UsuarioLogadoBusinessImpl implements UsuarioLogadoBusiness {

	/**{@inheritDoc}*/
    public Usuario getUsuarioLogado() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context == null) {
            return null;
        }
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        return (Usuario) session.getAttribute(Constants.USUARIO_LOGADO_DO_SISTEMA);
    }

}
