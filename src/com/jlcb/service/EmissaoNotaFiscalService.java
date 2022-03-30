package com.jlcb.service;

import com.jlcb.model.Cliente;
import com.jlcb.model.Produto;
import com.jlcb.notificaco.NotificadorEmail;

public class EmissaoNotaFiscalService {

	public void emitir(Cliente cliente, Produto produto) {
		// TODO colocaria a implementação da nota fiscal aqui...
		NotificadorEmail notificadorEmail = new NotificadorEmail();
		notificadorEmail.notificar(cliente, "Nota fiscal do produto " + produto.getNome() + " foi emitida!" );
	}
	
}
