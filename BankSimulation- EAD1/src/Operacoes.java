import java.io.*;
public class Operacoes {

    private int opcao;
    Visualizacoes vis;
    BufferedReader br;
    public Operacoes(){ vis= new Visualizacoes();
    br= new BufferedReader(new InputStreamReader(System.in));
    }

    private void levantamento(ContaBancaria[] array){
        opcao= opcao(vis.montanteLevantamento() );

        //if(opcao)
    }

    public int opcao(String str){
        int opcao=0;
        try{
            System.out.println(str);
            opcao= Integer.parseInt(br.readLine());
        }catch (NumberFormatException|IOException nb){
            System.out.println(nb.getMessage());
        }
          return opcao;
    }
}
