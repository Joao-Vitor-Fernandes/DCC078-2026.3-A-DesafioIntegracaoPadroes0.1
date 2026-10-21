package padroes.integracao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PagamentoCartaoTest {

    @Test
    void deveRetornarNome() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Cartao");
        assertEquals("Cartão", pagamento.getNome());
    }

    @Test
    void deveCalcularValorFinal() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Cartao");
        assertEquals(100.0, pagamento.calcularValorFinal(100.0), 0.01);
    }

    @Test
    void deveProcessarPagamentoSemObservacao() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Cartao");
        assertEquals("Cartão aprovado: R$ 100.0", pagamento.processar(100.0));
    }

    @Test
    void naoDeveProcessarValorIgualEMenorQueZero() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Cartao");
        try {
            pagamento.processar(0.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor inválido", e.getMessage());
        }
    }
}
