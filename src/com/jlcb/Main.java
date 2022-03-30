package com.jlcb;

import java.math.BigDecimal;

import com.jlcb.model.Cliente;
import com.jlcb.model.Produto;
import com.jlcb.notificaco.Notificador;
import com.jlcb.notificaco.NotificadorEmail;
import com.jlcb.notificaco.NotificadorSMS;
import com.jlcb.service.AtivacaoClienteService;
import com.jlcb.service.EmissaoNotaFiscalService;

public class Main {

	public static void main(String[] args) {
		Cliente joao = new Cliente("João", "joao@xyz.com", "34997324785");

		Notificador notificadorEmail = new NotificadorEmail();

		AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService(notificadorEmail);
		ativacaoCliente.ativar(joao);

		Produto produto = new Produto("Notebook", BigDecimal.valueOf(2500));

		Notificador notificadorSMS = new NotificadorSMS();
		EmissaoNotaFiscalService emissaoNotaFiscal = new EmissaoNotaFiscalService(notificadorSMS);
		emissaoNotaFiscal.emitir(joao, produto);
	}

}