
public class Menu 
{
	// Encapsulamento das classes
	private float saldo;
	private int opcao;
	private Validacoes val;
	private Visualizacoes vis;
	private Abertura a;
	public Menu()
	{
		// Chamada das classes
		val = new Validacoes();
		vis = new Visualizacoes();
		a = new Abertura();
		
		// Atualizacao do saldo com base no metodo
		saldo += a.abertura();
		
		//  Ciclo de repeticao que permite navegar entre as opcoes
		do
		{
			int continuar;
			//  Ciclo que permite navegar entre as Sub opcoes
			do
			{
				vis.opcoes();
				opcao = val.validarInt("Escolha uma opcao : ", "As opcoes devem ser entre 1 a 4", 1, 4);
				// Switch para cada opcao escolhida
				switch(opcao)
				{
				// Case 1 - TRANSFERENCIA
				case 1 : 
					float x;
					int op;
					String titular;
					String nib;
					// Ciclo de repeticao para as Sub opcoes de transferencia(Titular ou Nib)
					do
					{
						op = val.validarInt("Opcao de transferencia :\n1 - Titular\n2 - NIB","Erro! As opcoes devem ser entre 1 e 2", 1, 2);
						switch(op)
						{
							case 1 :
								do
								{
									titular = val.validarString("Titular da conta que deseja transferir ?\n=> ", "Erro ! Deve ter mais que 5 caracteres", "aaa aa");
								}while(titular.length() <= 5);
								break;
							case 2 :
								do
								{
									nib = val.validarString("Digite o NIB : ", "Erro! O NIB deve ter 21 digitos", "000000000000000000000");
								}while(nib.length() > 21);
								break;
						}
						
					}while(op < 1 || op > 2);
					// Ciclo de repeticao para validar o valor a transferir de modo eficiente
					do
					{
						x = val.validarFloat("Valor que deseja Transferir?\nNB: Valor deve ser superior a 0 e Inferior ou igual ao saldo", "Erro ! Valor deve ser superior a 0", 0);
						if((a.getSaldo() - x) < 0)
							vis.erroLevantamento();
						saldo -= x;
					}while((a.getSaldo() - x) < 0);
					vis.transferencia();
					break;
				case 2 : 
					// Case 2 - LEVANTAMENTO
					float y;
					// Ciclo de repeticao para validar o valor a levantar de modo eficiente
					do
					{
						y = val.validarFloat("Valor que deseja levantar?\nNB: Valor deve ser superior a 0 e Inferior ou igual ao saldo", "Erro ! Valor deve ser superior a 0", 0);
						if(a.getSaldo() - y > 0)
							vis.erroLevantamento();
							saldo -= y;
					}while(a.getSaldo() - y > 0);
					vis.levantamento();
					break;
				case 3 :
					// Case 3 - DEPOSITO
						float valor;
						// Ciclo de repeticao para validar o valor a depositar de modo eficiente
						do
						{
							valor = val.validarFloat("Insira o valor de deposito\nNB : Valor deve ser maior que 0\n=> ", "Valor deve ser maior que 0 !", 0);
							vis.deposito();
							if(valor < 0)
								System.out.println("Erro! O valor deve ser maior que 0");
						}while(valor < 0);
						saldo += valor;
						break;
				case 4 :
					// Case 4 - VISUALIZAR SALDO
						vis.saldo(saldo);
						break;
				}
				continuar = val.validarInt("Deseja continuar? 1 - Sim / 2 - Nao", "Deve escolher entre 1 e 2", 1, 2);
			}while(continuar == 1);
		}while(opcao <= 1 || opcao > 4);
		vis.agradecimentos();
	}
}
