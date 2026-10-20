package padroes.integracao;

// Padrão Factory Method
public class PagamentoFactory {

    public static IPagamento obterPagamento(String pagamento) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("padroes.integracao.Pagamento" + pagamento);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Pagamento inexistente");
        }
        if (!(objeto instanceof IPagamento)) {
            throw new IllegalArgumentException("Pagamento inválido");
        }
        return (IPagamento) objeto;
    }
}
