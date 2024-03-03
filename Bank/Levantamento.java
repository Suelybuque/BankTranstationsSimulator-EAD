import javax.swing.*;

/*public class Levantamento
{
	private Abertura a;
	private Validacoes val;
	private Visualizacoes vis;
	public Levantamento()
	{
		a = new Abertura();
		val = new Validacoes();
		vis = new Visualizacoes();
	}
}*/
public class Levantamento {
	private Abertura a;
	private Validacoes val;
	private Visualizacoes vis;

	public Levantamento() {
		a = new Abertura();
		val = new Validacoes();
		vis = new Visualizacoes();
	}

	public float levantamento(float saldo,float valor) {
		//float valor = val.validarFloat(/*JOptionPane.showInputDialog("Insira o valor que deseja levantar: \nValor inválido. Por favor, insira um valor válido."),*/ JOptionPane.showInputDialog("Insira o valor inicial para abertura de conta \nValor deve ser maior que 0 !"), 0);
		valor = val.validarFloat( " ",100);
		if (saldo >= valor) {
			saldo -= valor;
			//vis.levantamento();
		} else {
			vis.erroLevantamento();
		}
		return saldo;
	}
}
