import java.io.*;
public class Deposito 
{
	private Validacoes val;
	private Visualizacoes vis;
	public Deposito()
	{
		val = new Validacoes();
		vis = new Visualizacoes();
	}
	public float deposito()
	{
		float valor;
		valor = val.validarFloat("Insira o valor inicial para abertura de conta\nNB : Valor deve ser maior que 0\n=> ", "Valor deve ser maior que 0 !", 0);
		vis.deposito();
		System.out.println("Valor : "+valor);
		return valor;
	}
}
