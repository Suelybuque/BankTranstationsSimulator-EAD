import  java.io.*;
import java.util.StringTokenizer;


public class TodasCont {

    ContaBancaria [] cb;
    int cont;

    public TodasCont (){
        cb= new ContaBancaria[20];
        cont=0;
    }

    public void readFile(){

        String linha;
        StringTokenizer str;
        int pin, conta;
        float salBan, salDisp;
        String titular;

        try{
            FileReader fr= new FileReader("Dados.txt");
            BufferedReader br=  new BufferedReader(fr);
            linha = br.readLine();

            while (linha!=null){
                str= new StringTokenizer(linha, ";");
                pin= Integer.parseInt(str.nextToken());
                conta=Integer.parseInt(str.nextToken());
                salBan = Float.parseFloat(str.nextToken());
                salDisp=  Float.parseFloat(str.nextToken());
                titular= str.nextToken();

                cont++;
                linha = br.readLine();;
            }
            br.close();
        }catch (FileNotFoundException fn){
            System.out.println("Ficheiro nao encontrado");
        }
        catch (NumberFormatException| IOException nio){
            System.out.println(nio.getMessage());
        }


    }
}
