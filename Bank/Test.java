/*public class Test {
	private float saldo;
	private int opcao;
	private Validacoes val;
	private Visualizacoes vis;
	private Abertura a;
	private Levantamento levantamento;
	private Deposito deposito;

	public Test() {
		val = new Validacoes();
		vis = new Visualizacoes();
		a = new Abertura();
		levantamento = new Levantamento();
		deposito = new Deposito();

		//saldo = a.abertura();

		do {
			do {
				vis.opcoes();
				opcao = val.validarInt("Escolha uma opção: ", "As opções devem ser entre 1 e 4", 1, 4);
				switch (opcao) {
					case 1:
						saldo = levantamento.levantamento(saldo);
						break;
					case 2:
						saldo = deposito.deposito(saldo);
						break;
					case 3:
						vis.saldo(saldo);
						break;
				}
			} while (opcao <= 1 || opcao > 3);
		} while (opcao != 4);
		vis.agradecimentos();
	}
}*/
