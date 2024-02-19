import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        Visualizacoes vis= new Visualizacoes();
        //dialog box
        int menu= Integer.parseInt(JOptionPane.showInputDialog( " Selecione uma opcao: \n"+vis.menu()));

        int levantamentoMontante= Integer.parseInt(JOptionPane.showInputDialog( " Selecione uma opcao: \n"+vis.montanteLevantamento()));
        //display message
        JOptionPane.showMessageDialog(null, "Opcao "+levantamentoMontante);


    }
}