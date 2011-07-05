package com.hvnl.ssolo.facade;

public interface LoginFacade {
	/**
	 * Logar no sistema.
	 * @param usuario
	 * @param senha
	 * @return true se usuario e senha existirem.
	 */
	boolean logar(String usuario, String senha);
	
}
