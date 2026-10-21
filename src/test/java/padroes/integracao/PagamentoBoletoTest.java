package padroes.integracao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoBoletoTest {

    @Test
    void deveRetornarNome() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Boleto");
        assertEquals("Boleto", pagamento.getNome());
    }

    @Test
    void deveCalcularValorFinal() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Boleto");
        assertEquals(103.5, pagamento.calcularValorFinal(100.0), 0.01);
    }

    @Test
    void deveProcessarPagamentoComObservacao() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Boleto");
        assertEquals("Boleto aprovado: R$ 103.5 (compensação em até 3 dias úteis)", pagamento.processar(100.0));
    }

    @Test
    void naoDeveProcessarValorIgualEMenorQueZero() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Boleto");
        try {
            pagamento.processar(0.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor inválido", e.getMessage());
        }
    }
}
