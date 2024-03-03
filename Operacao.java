import java.text.DecimalFormat;

public class Operacao {
    private String opcao;
    private long numeroConta;
    private int codigo;
    private float saldoActual;
    private DecimalFormat mt;

    public Operacao(long numeroConta, int codigo, float saldoActual, String opcao) {
        this.numeroConta = numeroConta;
        this.codigo = codigo;
        this.saldoActual = saldoActual;
        this.opcao = opcao;
        mt = new DecimalFormat("###,###,###.00 Mt");
    }

    public int getCodigo() {
        return codigo;
    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public float getSaldoActual() {
        return saldoActual;
    }

    @Override
    public String toString() {
        return "Operacao [opcao=" + opcao + ", numeroConta=" + numeroConta + ", codigo=" + codigo + ", saldoActual="
                + mt.format(saldoActual) + "]";
    }
}