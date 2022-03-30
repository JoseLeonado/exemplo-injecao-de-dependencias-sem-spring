package com.jlcb.service;

import com.jlcb.model.Cliente;
import com.jlcb.notificaco.NotificadorEmail;

public class AtivacaoClienteService {

	public void ativar(Cliente cliente) {
		cliente.ativar();
		NotificadorEmail notificadorEmail = new NotificadorEmail();
		notificadorEmail.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
	
}