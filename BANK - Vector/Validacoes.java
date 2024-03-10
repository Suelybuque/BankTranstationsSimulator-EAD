//Algorithm complexity O(1)

import java.io.*;
public class Validacoes 
{
	private BufferedReader br;
	public Validacoes()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	public String validarString(String a, String b, String c)
	{
		String x = " ";
		do
		{
			try
			{
				System.out.println(a);
				x = br.readLine();
			}
			catch(IOException j)
			{
				System.out.println(j.getMessage());
			}
			if(x.length() < c.length())
				System.out.println(b);
		}while(x.length() < c.length());
		return x;
	}
	public int validarInt(String a, String b, int c, int d)
	{
		int x = 0;
		do
		{
			try
			{
				System.out.println(a);
				x = Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException j)
			{
				System.out.println(j.getMessage());
			}
			catch(IOException k)
			{
				System.out.println(k.getMessage());
			}
			if(x < c || x > d)
				System.out.println(b);
		}while(x < c || x > d);
		return x;
	}
	public float validarFloat(/*String a, String b, */String s, int c)
	{
		float x = 0;
		do
		{
			try
			{
				//System.out.println(a);
				x = Float.parseFloat(br.readLine());
			}
			catch(NumberFormatException j)
			{
				System.out.println(j.getMessage());
			}
			catch(IOException k)
			{
				System.out.println(k.getMessage());
			}
			//if(x < c)
				//System.out.println(b);
		}while(x < c);
		return x;
	}
}
