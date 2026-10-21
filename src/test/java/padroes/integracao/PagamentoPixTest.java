package padroes.integracao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoPixTest {

    @Test
    void deveRetornarNome() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Pix");
        assertEquals("Pix", pagamento.getNome());
    }

    @Test
    void deveCalcularValorFinal() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Pix");
        assertEquals(95.0, pagamento.calcularValorFinal(100.0), 0.01);
    }

    @Test
    void deveProcessarPagamentoComObservacao() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Pix");
        assertEquals("Pix aprovado: R$ 95.0 (5% de desconto)", pagamento.processar(100.0));
    }

    @Test
    void naoDeveProcessarValorIgualEMenorQueZero() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Pix");
        try {
            pagamento.processar(0.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor inválido", e.getMessage());
        }
    }
}
