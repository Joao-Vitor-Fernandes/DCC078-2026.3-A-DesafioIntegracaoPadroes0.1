package padroes.integracao;

// Padrão Factory Method + Template Method
public class PagamentoBoleto extends PagamentoBase{

    public String getNome() {
        return "Boleto";
    }

    public double calcularValorFinal(double valor) {
        return valor + 3.50;
    }

    @Override
    protected String getObservacao() {
        return " (compensação em até 3 dias úteis)";
    }
}
