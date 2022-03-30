package com.jlcb.service;

import com.jlcb.model.Cliente;
import com.jlcb.model.Produto;
import com.jlcb.notificaco.Notificador;

public class EmissaoNotaFiscalService {
	
	private Notificador notificador;
	
	public EmissaoNotaFiscalService(Notificador notificador) {
		this.notificador = notificador;
	}

	public void emitir(Cliente cliente, Produto produto) {
		// TODO colocaria a implementação da nota fiscal aqui...
		notificador.notificar(cliente, "Nota fiscal do produto " + produto.getNome() + " foi emitida!" );
	}
	
}
