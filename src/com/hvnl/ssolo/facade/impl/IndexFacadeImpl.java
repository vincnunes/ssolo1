/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.AgenciaPublicitariaBusiness;
import com.hvnl.ssolo.business.ClienteBusiness;
import com.hvnl.ssolo.business.UsuarioLogadoBusiness;
import com.hvnl.ssolo.exception.BusinessException;
import com.hvnl.ssolo.facade.IndexFacade;
import com.hvnl.ssolo.model.AgenciaPublicitaria;
import com.hvnl.ssolo.model.Cliente;
import com.hvnl.ssolo.model.Usuario.PERFIL;

/**
 * Implementacao do facade da página inicial.
 * @author vinicius
 */
@Component("indexFacade")
public class IndexFacadeImpl implements IndexFacade {
	private UsuarioLogadoBusiness usuarioLogadoBusiness;
	
	private ClienteBusiness clienteBusiness;
	
	private AgenciaPublicitariaBusiness agenciaBusiness;
	
	@Override
	public List<Cliente> listarClientesInadimplentes() {
		try {
			Cliente cliente = new Cliente();
			cliente.setVendedor(usuarioLogadoBusiness.getUsuarioLogado());

			List<Cliente> clientes = new ArrayList<Cliente>();
			List<Cliente> inadimplentes = new ArrayList<Cliente>();
			if (cliente.getVendedor().getPerfil().compareTo(PERFIL.ADMINISTRADOR) == 1) {
				clientes = clienteBusiness.listar();
				
				for (Cliente cli : clientes) {
					if (cli.getSituacao().getStatus().getNome().equals("Inadimplente")) {
						inadimplentes.add(cli);
					}
				}
				
				return inadimplentes;
			} else {
				clientes = clienteBusiness.listar(cliente);
				
				for (Cliente cli : clientes) {
					if (cli.getSituacao().getStatus().getNome().equals("Inadimplente")) {
						inadimplentes.add(cli);
					}
				}
				
				return inadimplentes;				
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<AgenciaPublicitaria> listarAgenciasInadimplentes() {
		try {
			AgenciaPublicitaria agencia = new AgenciaPublicitaria();
			agencia.setVendedor(usuarioLogadoBusiness.getUsuarioLogado());
			List<AgenciaPublicitaria> agencias = new ArrayList<AgenciaPublicitaria>();
			List<AgenciaPublicitaria> inadimplentes = new ArrayList<AgenciaPublicitaria>();
			if (agencia.getVendedor().getPerfil().compareTo(PERFIL.ADMINISTRADOR) == 1) {
				agencias = agenciaBusiness.listar();
				
				for (AgenciaPublicitaria age : agencias) {
					if (age.getSituacao().getStatus().getNome().equals("Inadimplente")) {
						inadimplentes.add(age);
					}
				}
				
				return inadimplentes;
			} else {
				agencias = agenciaBusiness.listar(agencia);
				
				for (AgenciaPublicitaria age : agencias) {
					if (age.getSituacao().getStatus().getNome().equals("Inadimplente")) {
						inadimplentes.add(age);
					}
				}
				
				return inadimplentes;				
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Autowired
	public void setUsuarioLogadoBusiness(@Qualifier("usuarioLogadoBusiness")UsuarioLogadoBusiness usuarioLogadoBusiness) {
		this.usuarioLogadoBusiness = usuarioLogadoBusiness;
	}
	
	@Autowired
	public void setClienteBusiness(@Qualifier("clienteBusiness")ClienteBusiness clienteBusiness) {
		this.clienteBusiness = clienteBusiness;
	}
	
	@Autowired
	public void setAgenciaBusiness(@Qualifier("agenciaPublicitariaBusiness")AgenciaPublicitariaBusiness agenciaBusiness) {
		this.agenciaBusiness = agenciaBusiness;
	}
}
