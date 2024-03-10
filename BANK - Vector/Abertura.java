import javax.swing.*;
//Algorithm complexitity O(1)
public class Abertura {
	private float valor;
	private Validacoes val;
	private Visualizacoes vis;

	public Abertura() {
		val = new Validacoes();
		vis = new Visualizacoes();
	}

	public float abertura() {
		valor = val.validarFloat( " ",0);
		//vis.abertura();
		return valor;
	}

	public float getSaldo() {
		return valor;
	}

	public void setSaldo(float novoSaldo) {
		valor = novoSaldo;
	}
}

