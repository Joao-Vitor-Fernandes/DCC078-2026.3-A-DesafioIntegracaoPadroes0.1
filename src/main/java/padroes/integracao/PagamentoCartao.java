package padroes.integracao;

// Padrão Factory Method + Template Method
public class PagamentoCartao extends PagamentoBase {

    public String getNome() {
        return "Cartão";
    }

    public double calcularValorFinal(double valor) {
        return valor;
    }
}
