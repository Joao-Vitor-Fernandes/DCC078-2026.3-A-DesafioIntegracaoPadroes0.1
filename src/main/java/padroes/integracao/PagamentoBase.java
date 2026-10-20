package padroes.integracao;

// Padrão Template Method
public abstract class PagamentoBase implements IPagamento {

    public abstract String getNome();

    public abstract double calcularValorFinal(double valor);

    protected String getObservacao() {
        return "";
    }

    public final String processar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        return getNome() + " aprovado: R$ " + this.calcularValorFinal(valor) + getObservacao();
    }
}