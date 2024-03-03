import java.io.*;
import java.util.StringTokenizer;
public class TodasOperacoes 
{
	private Operacao [] ope;
	private int cont;


	public TodasOperacoes()
	{
		ope = new Operacao[100];
		cont = 0;
	}
	//Metodo para ler do ficheiro
	public void lerFicheiro(String Operacoes)
	{
		StringTokenizer umaCadeia;
		String umalinha=";";
		long numeroConta;
		int codigo;
		float saldoActual ;

		try
		{
			FileReader fr = new FileReader("Operacoes.txt");
			BufferedReader x = new BufferedReader(fr);
			umalinha = x.readLine();
			while(umalinha!=null)
			{
				umaCadeia = new StringTokenizer(umalinha,";");
				numeroConta = Long.parseLong(umaCadeia.nextToken());
				codigo = Integer.parseInt(umaCadeia.nextToken());
				saldoActual = Float.parseFloat(umaCadeia.nextToken());
				ope[cont++] = new Operacao(numeroConta, codigo, saldoActual);

				umalinha = x.readLine();
			}
			x.close();
		}
        catch(FileNotFoundException kk)
		{
			System.out.println(kk.getMessage());
		}
        catch(NumberFormatException kj)
		{
			System.out.println(kj.getMessage());
		}
        catch(IOException sj)
		{
			System.out.println(sj);
		}
		System.out.println("\nFicheiro Lido Com Sucesso!");
	}
}
