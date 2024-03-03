public class Menu
{
	private TodasOperacoes tod;
	private Validacoes val;
	private SubMenu sub;
	private Operacao ope;
	private float saldo;
	public Menu()
	{
		tod = new TodasOperacoes();
		val = new Validacoes();
		sub = new SubMenu();
		ope = new Operacao(0, 0, 0, null);
	}

	//Menu
	public String menu()
	{
		String op = "";
		saldo += ope.getSaldoActual();
		boolean passou = true;
	
		do
		{
		    op = val.validarString("Deposito", "Levantamento","Saldo","Transferencia", "Terminar","Introduz uma opcao:(Deposito, Levantamento, Saldo, Transferencia, Terminar):" );
			switch(op)
			{
				case "Deposito": //perguntar o montante
				                 int x = val.validarInt("Introduz o montante a Depositar:");
				                 passou = true;
				                 if(passou = true)
				                 {
				                	 saldo += x;
				                	 sub.pergunta();
				                 }
				                 else
				                 {
				                	 System.out.println("Erro\nTente Novamente.");
				                 }
				                 break;
				                 
				case "Levantamento":// perguntar o montante
	                                // deve ser maior que o saldo
	                                //deseja continuar?
	                             float u = val.validarFloat("Introduz o montante a Levantar:");
	                             passou = true;
	                             if(passou = true && u<ope.getSaldoActual())
	                             {
	                            	 saldo -= u;
	                	             sub.pergunta();
	                             }
	                             else
	                             {
	                	             System.out.println("Erro\nTente Novamente.");
	                	         }
	                                
				break;
				case "Saldo": System.out.println(ope.getSaldoActual());
				              passou = true;
	                          if(passou = true)
	                          {
	                	          sub.pergunta();
	                          }
	                          else
	                          {
	                	          System.out.println("Erro\nTente Novamente.");
	                	      }
				break;
				case "Transferencia": // interbancaria ou para outro banco 
	                                  // perguntar o montante
                                      // deve ser maior que o saldo
                                      // deseja continuar?
					                  sub.banco();
	                                  

				                      
				break;
				
				case "Terminar": System.out.print("\nObrigado por ter usado nosso programa!\n\n BANCO AKSL");
				break;

			}
		}while(op!="Deposito" && op!="Levantamento" && op!="Saldo" && op!="Transferencia" && op!="Terminar" );
		return op;
	}
}