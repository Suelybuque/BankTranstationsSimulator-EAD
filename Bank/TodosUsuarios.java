import java.io.*;
import java.util.StringTokenizer;
public class TodosUsuarios 
{
	private Usuario [] usuario;
	private int cont;
	public TodosUsuarios()
	{
		usuario = new Usuario[100];
		cont = 0;
	}
	public void lerDoFicheiro(String User)
	{
		StringTokenizer str;
		String UmaLinha = " ", titular; int numero_de_conta, pin;
		
		try
		{
			FileReader fr = new FileReader(User);
			BufferedReader br = new BufferedReader(fr);
			UmaLinha = br.readLine();
			while(UmaLinha != null)
			{
				str = new StringTokenizer(UmaLinha," ");
				//System.out.println(UmaLinha);
				titular = str.nextToken();
				numero_de_conta = Integer.parseInt(str.nextToken());
				pin = Integer.parseInt(str.nextToken());
				usuario[cont] = new Usuario(titular, numero_de_conta, pin);
				cont++;
				UmaLinha = br.readLine();
			}
			br.close();
			//System.out.println("Ficheiro Lido com sucesso !");
			
		}
		catch(FileNotFoundException k)
		{
			System.out.println("Ficheiro nao foi encontrado !");
		}
		catch(NumberFormatException l)
		{
			System.out.println(l.getMessage());
		}
		catch(IOException j)
		{
			System.out.println(j.getMessage());
		}
	}
	
}
