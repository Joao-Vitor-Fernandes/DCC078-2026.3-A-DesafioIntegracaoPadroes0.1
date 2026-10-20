package padroes.integracao;

// Padrão Factory Method
public interface IPagamento {
    String getNome();
    double calcularValorFinal(double valor);
}
