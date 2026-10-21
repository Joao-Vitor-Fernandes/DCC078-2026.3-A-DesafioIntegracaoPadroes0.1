package padroes.integracao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    FuncionarioDiretor diretor;
    FuncionarioGerente gerente;
    FuncionarioAtendente atendente;

    @BeforeEach
    void setUp() {
        diretor = new FuncionarioDiretor(null);
        gerente = new FuncionarioGerente(diretor);
        atendente = new FuncionarioAtendente(gerente);
    }

    @Test
    void DeveRetornarEstornoInvalidoParaValorIgualOuMenorQueZero() {
        assertEquals("Estorno inválido", atendente.aprovar(new Estorno(1, 0.0)));
    }

    @Test
    void DeveRetornarAtendenteParaEstornoDentroDoLimite() {
        assertEquals("Atendente", atendente.aprovar(new Estorno(1, 50.0)));
    }

    @Test
    void DeveRetornarGerenteParaEstornoAcimaDoLimiteDoAtendente() {
        assertEquals("Gerente", atendente.aprovar(new Estorno(1, 300.0)));
    }

    @Test
    void DeveRetornarDiretorParaEstornoAcimaDoLimiteDoGerente() {
        assertEquals("Diretor", atendente.aprovar(new Estorno(1, 1200.0)));
    }

    @Test
    void DeveRetornarSemAutorizacaoParaEstornoAcimaDoLimiteDoDiretor() {
        assertEquals("Sem autorização para aprovar", atendente.aprovar(new Estorno(1, 2500.0)));
    }

    @Test
    void deveRetornarAtendenteParaEstornoDe200() {
        assertEquals("Atendente", atendente.aprovar(new Estorno(1, 200.0)));
    }

    @Test
    void deveRetornarGerenteParaEstornoDe500() {
        assertEquals("Gerente", atendente.aprovar(new Estorno(1, 500.0)));
    }

    @Test
    void deveRetornarDiretorParaEstornoDe2000() {
        assertEquals("Diretor", atendente.aprovar(new Estorno(1, 2000.0)));
    }

    @Test
    void deveRetornarSemAutorizacaoParaEstornoDe2000ComUmCentavo() {
        assertEquals("Sem autorização para aprovar", atendente.aprovar(new Estorno(1, 2000.01)));
    }
}
