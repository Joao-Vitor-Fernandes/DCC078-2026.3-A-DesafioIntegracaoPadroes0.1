package padroes.integracao;

// Padrão Factory Method + Template Method
public class PagamentoPix extends PagamentoBase {

    public String getNome() {
        return "Pix";
    }

    public double calcularValorFinal(double valor) {
        return valor * 0.95;
    }

    @Override
    protected String getObservacao() {
        return " (5% de desconto)";
    }
}