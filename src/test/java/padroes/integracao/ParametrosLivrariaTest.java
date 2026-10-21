package padroes.integracao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParametrosLivrariaTest {

    @Test
    public void deveRetornarNomeLoja() {
        ParametrosLivraria.getInstance().setNomeLoja("Livraria 1");
        assertEquals("Livraria 1", ParametrosLivraria.getInstance().getNomeLoja());
    }

    @Test
    public void deveRetornarAtendenteLogado() {
        ParametrosLivraria.getInstance().setAtendenteLogado("Atendente 1");
        assertEquals("Atendente 1", ParametrosLivraria.getInstance().getAtendenteLogado());
    }

}