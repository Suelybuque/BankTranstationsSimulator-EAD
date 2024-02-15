public class Visualizacoes {
    public Visualizacoes(){}

    public void infoConta(){
        System.out.println("Numero de conta: *********** \nTitular: Kelly Severide");
    }
    public String menu(){
        String str= "1.Levantamento \n2.Transferencia" +
                " \n3.Deposito \n4.Consulta de saldo";
        return str;
    }
    public String montante(){
        String str= "1.200             5.3000  \n2.500              6.4000 \n3.1000             7.5000 \n4. 2000             8.Outros Montantes";
        return str;
    }


}
