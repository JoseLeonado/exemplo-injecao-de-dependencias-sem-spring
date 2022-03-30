Exemplo 1:
   - A classe de serviço AtivacaoClienteService tem que ativar um cliente e também deve notificar via e-mail que o cadastro dele está ativo, para isso
     criaremos um método void ativar(), porém, esse método não deve implementar a lógica de envio do e-mail, pois, dessa forma estaríamos perdendo a 
     responsabilidade única, com isso a classe terá muitas responsabilidades e não vai somente ativar o cliente como também trabalhará com servidor de e-mail, etc...
     
     A solução será criar uma nova classe chamada NotificadorEmail que ficará dentro do pacote notificacao. Dentro dessa classe, teremos o método void noitificar()
     passando o cliente e a mensagem como parâmetro e chamaremos esse método dentro do método ativar() do AtivacaoClienteService.
