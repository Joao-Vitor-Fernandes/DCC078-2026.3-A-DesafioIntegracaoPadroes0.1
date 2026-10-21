package padroes.integracao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoFactoryTest {

    @Test
    void deveRetornarExcecaoParaPagamentoInexistente() {
        try {
            IPagamento pagamento = PagamentoFactory.obterPagamento("Dinheiro");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pagamento inexistente", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaPagamentoInvalido() {
        try {
            IPagamento pagamento = PagamentoFactory.obterPagamento("Cheque");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pagamento inválido", e.getMessage());
        }
    }
}
