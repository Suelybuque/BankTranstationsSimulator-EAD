//Algorithm complexity O(1)

import java.text.DecimalFormat;
public class Visualizacoes 
{
	private DecimalFormat mt;
	public Visualizacoes()
	{
		mt = new DecimalFormat("###,###,###.00 Mzn");
	}
	public void agradecimentos()
	{
		System.out.println("Obrigado, tenha um bom dia !");
	}
	public String saldo(float valor)
	{String str= "Saldo: "+ mt.format(valor);

		 return str;
	}
	public void deposito()
	{
		System.out.println("Deposito efetuado com sucesso!");
	}
	public void transferencia()
	{
		System.out.println("Transferencia efetuada com sucesso!");
	}
	public void levantamento()
	{
		System.out.println("Levantamento efetuado!");
	}
	public void erroLevantamento()
	{
		System.out.println("Saldo insuficiente!");
	}
	public void abertura()
	{
		System.out.println("Montante adicionado com sucesso !");
	}
	public void opcoes()
	{
		System.out.println("=====================");
		System.out.println("1. Transferencia");
		System.out.println("2. Levantamento");
		System.out.println("3. Deposito");
		System.out.println("4. Consulta de Saldo");
		System.out.println("=====================");
		
	}
	
}
