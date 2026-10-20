package padroes.integracao;

// Padrão Chain of Responsability
public class Estorno {

    private int numeroPedido;
    private double valor;

    public Estorno(int numeroPedido, double valor) {
        this.numeroPedido = numeroPedido;
        this.valor = valor;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public double getValor() {
        return valor;
    }
}
