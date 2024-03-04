//Algorithm complexitity O(1)
public class Usuario 
{
	private String titular;
	private int numero_de_conta;
	private int pin;
	public Usuario(String x, int y, int z)
	{
		titular = x;
		numero_de_conta = y;
		pin = z;
	}
	public String getTitular()
	{
		return titular;
	}
	public int getNumeroConta()
	{
		return numero_de_conta;
	}
	public int getPin()
	{
		return pin;
	}
	public String toString()
	{
		return "Titular : "+titular+" | "+" Numero de conta : "+numero_de_conta+" | "+" Pin : "+pin;
	}
}
