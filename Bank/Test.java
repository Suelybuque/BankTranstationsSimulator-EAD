
public class Test 
{
	private float saldo;
	private int opcao;
	private Validacoes val;
	private Visualizacoes vis;
	private Abertura a;
	public Test()
	{
		val = new Validacoes();
		vis = new Visualizacoes();
		a = new Abertura();
		
		saldo += a.abertura();
		
		do
		{
			int continuar;
			do
			{
				vis.opcoes();
				opcao = val.validarInt("Escolha uma opcao : ", "As opcoes devem ser entre 1 a 4", 1, 4);
				switch(opcao)
				{
				case 1 : 
					float x;
					int op;
					String titular;
					String nib;
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
					do
					{
						x = val.validarFloat("Valor que deseja Transferir?\nNB: Valor deve ser superior a 0 e Inferior ou igual ao saldo", "Erro ! Valor deve ser superior a 0", 0);
						if(x - a.getSaldo() > 0)
							vis.erroLevantamento();
					}while(x - a.getSaldo() > 0);
					vis.transferencia();
					saldo -= x;
					break;
				case 2 : 
					float y;
					do
					{
						y = val.validarFloat("Valor que deseja levantar?\nNB: Valor deve ser superior a 0 e Inferior ou igual ao saldo", "Erro ! Valor deve ser superior a 0", 0);
						if(y - a.getSaldo() > 0)
							vis.erroLevantamento();
					}while(y - a.getSaldo() > 0);
					vis.levantamento();
					saldo -= y;
					break;
				case 3 :
						float valor;
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
						vis.saldo(saldo);
						break;
				}
				continuar = val.validarInt("Deseja continuar? 1 - Sim / 2 - Nao", "Deve escolher entre 1 e 2", 1, 2);
			}while(continuar == 1);
		}while(opcao <= 1 || opcao > 4);
		vis.agradecimentos();
	}
}
