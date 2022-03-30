package com.jlcb;

import com.jlcb.model.Cliente;
import com.jlcb.service.AtivacaoClienteService;

public class Main {

	public static void main(String[] args) {
		Cliente joao = new Cliente("João", "joao@xyz.com", "34997641278");
		Cliente maria = new Cliente("Maria", "maria@xyz", "1188745689");
		
		AtivacaoClienteService ativacaoClienteService = new AtivacaoClienteService();
		ativacaoClienteService.ativar(joao);
		ativacaoClienteService.ativar(maria);
	}
	
}