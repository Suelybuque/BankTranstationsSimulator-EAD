import java.io.*;
public class Validacoes 
{
	private BufferedReader br;
	public Validacoes()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	public long validarLong (long a, long b, String c)
	{
		BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
		long x=0;
		do
		{
			System.out.println(" " +c);
			try
			{
				x = Long.parseLong(k.readLine());
			}
			
			catch (NumberFormatException s)
			{
				System.out.println("O valor introduzido nao é um inteiro!");
			}
			catch (IOException kk)
			{
				//k.getMessage();
				kk.printStackTrace();
			}
			
			if (x<a || x>b)
			{
				System.out.println("Numero inteiro invalido! /nTente Novamente.");
			}
		}while (x<a || x>b);
		return x;
	}
	
	
	public int validarInt (String c)
	{
		BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
		int x=0;
		do
		{
			System.out.println(" " +c);
			try
			{
				x = Integer.parseInt(k.readLine());
			}
			
			catch (NumberFormatException s)
			{
				System.out.println("O valor introduzido nao é um inteiro!");
			}
			catch (IOException kk)
			{
				//k.getMessage();
				kk.printStackTrace();
			}
			
			if (x<0)
			{
				System.out.println("Numero inteiro invalido! /nTente Novamente.");
			}
		}while (x<0);
		return x;
	}
	
	public float validarFloat (String c)
	{
		BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
		float x=0;
		do
		{
			System.out.println(" " +c);
			try
			{
				x = Float.parseFloat(k.readLine());
			}
			
			catch (NumberFormatException s)
			{
				System.out.println("O valor introduzido nao é um inteiro!");
			}
			catch (IOException kk)
			{
				//k.getMessage();
				kk.printStackTrace();
			}
			
			if (x<0)
			{
				System.out.println("Numero inteiro invalido! /nTente Novamente.");
			}
		}while (x<0);
		return x;
	}
	
	public String validarString (String a, String b, String c, String d, String l)
	{
		BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
		String x=null;
		do
		{
			System.out.println(l);
			try
			{
				k.readLine();
			}

			catch (IOException kk)
			{
				//k.getMessage();
				kk.printStackTrace();
			}
			
			if (!x.equalsIgnoreCase(a) && !x.equalsIgnoreCase(b) && !x.equalsIgnoreCase(c) && !x.equalsIgnoreCase(d))
			{
				System.out.println("Invalido! /nTente Novamente.");
			}
		}while (!x.equalsIgnoreCase(a) && !x.equalsIgnoreCase(b) && !x.equalsIgnoreCase(c) && !x.equalsIgnoreCase(d));
		return x;
	}
	public String validarString (String a, String b, String c, String d, String e, String l)
	{
		BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
		String x=null;
		do
		{
			System.out.println(l);
			try
			{
				k.readLine();
			}

			catch (IOException kk)
			{
				//k.getMessage();
				kk.printStackTrace();
			}
			
			if (!x.equalsIgnoreCase(a) && !x.equalsIgnoreCase(b) && !x.equalsIgnoreCase(c) && !x.equalsIgnoreCase(d) && !x.equalsIgnoreCase(e))
			{
				System.out.println("Invalido! /nTente Novamente.");
			}
		}while (!x.equalsIgnoreCase(a) && !x.equalsIgnoreCase(b) && !x.equalsIgnoreCase(c) && !x.equalsIgnoreCase(d) && !x.equalsIgnoreCase(e));
		return x;
	}
	
	public String validarString (String a, String b, String l)
	{
		BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
		String x=null;
		do
		{
			System.out.println(l);
			try
			{
				k.readLine();
			}

			catch (IOException kk)
			{
				//k.getMessage();
				kk.printStackTrace();
			}
			
			if (!x.equalsIgnoreCase(a) && !x.equalsIgnoreCase(b) )
			{
				System.out.println("Invalido! /nTente Novamente.");
			}
		}while (!x.equalsIgnoreCase(a) && !x.equalsIgnoreCase(b) );
		return x;
	}
	
	public String validarString (String c)
	{
		BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
		String x=null;
		do
		{
			System.out.println(" " +c);
			try
			{
				k.readLine();
			}

			catch (IOException kk)
			{
				//k.getMessage();
				kk.printStackTrace();
			}
			
			if (x.length()<2)
			{
				System.out.println("Invalido! /nO nome devera ter pelo menos duas letras. /nTente Novamente.");
			}
		}while (x.length()<2);
		return x;
	}

}
