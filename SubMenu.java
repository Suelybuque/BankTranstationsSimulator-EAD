public class SubMenu {
    private Validacoes val;
    private Menu mn;
    private Operacao ope;
    private float saldo;

    public SubMenu() {
        val = new Validacoes();
        mn = new Menu();
        ope = new Operacao(0, 0, 0, null);
    }

    public String pergunta() {
        String op = "";

        do {
            op = val.validarString("Sim", "Nao", "Deseja Realizar uma outra operacao?(Sim ou Nao) : ");
            switch (op) {
                case "Sim":
                    mn.menu();
                    break;
                case "Nao":
                    System.out.print("\nObrigado por ter usado nosso programa!\n\n BANCO AKSL");
                    break;
            }
        } while (!op.equals("Sim") && !op.equals("Nao"));
        return op;
    }

    public String banco() {
        String op = "", n = "", t = "";
        boolean passou = true;
        do {
            op = val.validarString("Sim", "Nao", "Deseja Realizar uma transferencia para uma conta bancaria movel?(Sim ou Nao) : ");
            passou = true;
            switch (op) {
                case "Sim":
                    float u = val.validarFloat("Introduz o montante a Transferir:");

                    if (passou && u < ope.getSaldoActual()) {
                        t = val.validarString("Introduz o contacto:");
                        do {
                            n = val.validarString("Introduz o NIB:");
                        } while (n.length() == 16);

                        // Perform subtraction
                        saldo -= Float.parseFloat(n);

                        System.out.println("Transferencia efectuada com sucesso!");
                        pergunta();
                    } else {
                        System.out.println("Erro\nTente Novamente.");
                    }
                    break;

                case "Nao":
                    float v = val.validarFloat("Introduz o montante a Transferir:");

                    if (passou && v < ope.getSaldoActual()) {
                        n = val.validarString("Introduz o NIB:");
                        do {
                            t = val.validarString("Introduz o contacto:");
                        } while (t.length() == 9);

                        // Perform subtraction
                        saldo -= Float.parseFloat(n);

                        System.out.println("Transferencia efectuada com sucesso!");
                        pergunta();
                    } else {
                        System.out.println("Erro\nTente Novamente.");
                    }
                    break;
            }
        } while (!op.equals("Sim") && !op.equals("Nao"));
        return op;
    }
}