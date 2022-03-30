Problema 1:
   - A classe de serviço AtivacaoClienteService tem que ativar um cliente e também deve notificar via e-mail que o cadastro dele está ativo, para isso
     criaremos um método void ativar(), porém, esse método não deve implementar a lógica de envio do e-mail, pois, dessa forma estaríamos perdendo a 
     responsabilidade única, com isso a classe terá muitas responsabilidades e não vai somente ativar o cliente como também trabalhará com servidor de e-mail, etc...
     
     A solução para separar as responsabilidades será criar uma nova classe chamada NotificadorEmail que ficará dentro do pacote notificacao. Dentro dessa classe, 
     teremos um método void noitificar() passando o cliente e a mensagem como parâmetro, e chamaremos esse método dentro do método ativar() do AtivacaoClienteService.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Problema 2:
   - O cliente solicitou que agora gostaria de notificar todos os clientes por SMS, a solução prática e errônea seria criar uma nova classe chamada NotificadorSMS e
     substutir todas as implementação de NotificadorEmail, porém, imagina essa substutição em centenas, milhares de classe, além disso podemos ter uma complexidade
     na instanciação dessa implementação e as vezes temos que passar parâmetros no construtor. Bom de qualquer forma vamos estar tocando em classe que já estavam
     testadas, estamos mexendo em coisas no projeto inteiro para alterar a implementação de um notificador, e é claro que dando um replace substituindo a implementação
     "antiga" vai funcionar, porém, se caso o cliente queira voltar a notificar por e-mail, teremos que refazer esse mesmo processo toda vez, pois, temos um acoplamento
     muito grande da implementação do notificador com as classes de negocio AtivacaoCliente e EmissaoNotaFiscal.

     A solução será diminuir o acoplamento e para isso criaremos uma interface chamada Notificador dentro do pacote notificacao. Essa interface terá um método 
     void notificar(Cliente cliente, String mensagem) que recebe o cliente e a mensagem como parâmentro. Após isso, as classes NotificadorEmail e NotificadorSMS 
     implementará a interface Notificador, ou seja, estamos usando o conceito de polimorfismo que é a capacidade que um objeto tem de ser visto de diferentes formas. 
     Para fazermos o uso de polimorfismo, dentro da classe AtivacaoClienteService e EmissaoNotaFiscalService, ao invés de instanciar o NotificadorEmail 
     exatamente dentro do serviço, vamos definir um atributo do tipo Notificador (a interface em si) chamado notificador e onde estava chamando notificadorEmail.notificar
     iremos usar nosso atributo notificador chamando o método notificar (que ficaria notificador.notificar(...)). Além disso, precisamos informar qual o tipo de 
     notificador vamos utilizar, para isso vamos receber no construtor o Notificador passando para o nosso atributo notificador. Então para usar as classes 
     AtivacaoClienteService e EmissaoNotaFiscalService, elas só funcionará se quem quiser usar ela passar a dependência que é um Notificador, ou seja, o Notificador se
     tornou um dependência de AtivacaoClienteService e EmissaoNotaFiscalService. Então o que fizemos foi que, agora AtivacaoClienteService e EmissaoNotaFiscalService
     elas não dependem mais da implementação se é E-mail, SMS, etc... Elas simplesmente seguem o contrato da interface Notificador, e agora dentro dos services não
     precisamos saber se é por E-mail ou SMS, só precisamos saber que é preciso notificar, quem decide como é essa notificação, é algo de fora, a gente inverte o 
     controle e ai entra o conceito inversão de controle (IoC), veja que antes como era feita a notifcação, esse controle estava dentro do service e que decide é 
     na chamada do construtor do mesmo. ficou baseada no contrato
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   
