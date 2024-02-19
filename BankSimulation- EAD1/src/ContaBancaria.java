import java.io.*;

public class ContaBancaria {

    private int numConta, pin;
    private String titular;
    private float salBan, salDisp;

    public ContaBancaria(int numConta, int pin, String titular, float salBan, float salDisp){
        this.numConta= numConta;
        this.pin=pin;
        this.titular= titular;
        this.salBan= salBan;
        this.salDisp= salDisp;
    }

    public int getNumConta() {
        return numConta;
    }

    public int getPin() {
        return pin;
    }

    public String getTitular() {
        return titular;
    }

    public float getSalBan() {
        return salBan;
    }

    public float getSalDisp() {
        return salDisp;
    }
}
