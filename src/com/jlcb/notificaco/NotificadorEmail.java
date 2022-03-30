package com.jlcb.notificaco;

import com.jlcb.model.Cliente;

public class NotificadorEmail implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s atavés do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
	}

}