package padroes.integracao;

// Padrão Factory Method + Template Method
public class PagamentoCheque {

    public String getNome() {
        return "Cheque";
    }

    public double calcularValorFinal(double valor) {
        return valor;
    }
}
