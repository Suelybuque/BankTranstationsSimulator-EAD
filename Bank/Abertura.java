public class Abertura 
{
	private float valor;
	private Validacoes val;
	private Visualizacoes vis;
	public Abertura()
	{
		val = new Validacoes();
		vis = new Visualizacoes();
	}
	public float abertura()
	{
		valor = val.validarFloat("Insira o valor inicial para abertura de conta\nNB : Valor deve ser maior que 0\n=> ", "Valor deve ser maior que 0 !", 0);
		vis.abertura();
		System.out.println("Valor : "+valor);
		return valor;
	}
	public float getSaldo()
	{
		return valor;
	}
}
