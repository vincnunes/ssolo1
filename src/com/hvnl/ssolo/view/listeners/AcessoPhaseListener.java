/*
 * 14/08/2009
 */
package com.hvnl.ssolo.view.listeners;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Controla os acessos às páginas.
 * @author heber
 *
 */
public class AcessoPhaseListener implements PhaseListener {

    /**
     * Serial UID.
     */
    private static final long serialVersionUID = 5855348996567225075L;

    /**{@inheritDoc}*/
    public void afterPhase(PhaseEvent event) {
        String url = event.getFacesContext().getViewRoot().getViewId();
        System.out.println(url);
    }

    /**{@inheritDoc}*/
    public void beforePhase(PhaseEvent event) {
        /*String url = event.getFacesContext().getViewRoot().getViewId();
        System.out.println(url);*/
    }

    /**{@inheritDoc}*/
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
