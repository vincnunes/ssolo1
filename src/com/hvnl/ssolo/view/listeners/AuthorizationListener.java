package com.hvnl.ssolo.view.listeners;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import com.hvnl.ssolo.util.Constants;

public class AuthorizationListener implements PhaseListener {

	public void afterPhase(PhaseEvent event) {

		FacesContext facesContext = event.getFacesContext();
		String currentPage = facesContext.getViewRoot().getViewId();

		boolean isLoginPage = (currentPage.lastIndexOf("login.jspx") > -1);
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		Object currentUser = session.getAttribute(Constants.USUARIO_LOGADO_DO_SISTEMA);

		if (!isLoginPage && currentUser == null) {
			NavigationHandler nh = facesContext.getApplication()
					.getNavigationHandler();
			nh.handleNavigation(facesContext, null, "loginPage");
		}
	}

	public void beforePhase(PhaseEvent event) {
	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
