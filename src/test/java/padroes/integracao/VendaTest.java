package padroes.integracao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendaTest {

    @Test
    void deveRetornarValorVendaLivro() {
        Venda venda = new VendaLivro("Título 1", 100.0);

        assertEquals(100.0, venda.getValor(), 0.01);
    }

    @Test
    void deveRetornarValorVendaComEmbalagemPresente() {
        Venda venda = new EmbalagemPresente(new VendaLivro("Título 1", 100.0));

        assertEquals(108.0, venda.getValor(), 0.01);
    }

    @Test
    void deveRetornarValorVendaComCartaoPresente() {
        Venda venda = new CartaoPresente(new VendaLivro("Título 1", 100.0));

        assertEquals(103.5, venda.getValor(), 0.01);
    }

    @Test
    void deveRetornarValorVendaComMarcadorPaginaPresente() {
        Venda venda = new MarcadorPaginaPresente(new VendaLivro("Título 1", 100.0));

        assertEquals(106.0, venda.getValor(), 0.01);
    }

    @Test
    void deveRetornarValorVendaComEmbalagemMaisCartao() {
        Venda venda = new EmbalagemPresente(new CartaoPresente(new VendaLivro("Título 1", 100.0)));

        assertEquals(111.5, venda.getValor(), 0.01);
    }

    @Test
    void deveRetornarValorVendaComEmbalagemMaisMarcador() {
        Venda venda = new EmbalagemPresente(new MarcadorPaginaPresente(new VendaLivro("Título 1", 100.0)));

        assertEquals(114.0, venda.getValor(), 0.01);
    }

    @Test
    void deveRetornarValorVendaComCartaoMaisMarcador() {
        Venda venda = new CartaoPresente(new MarcadorPaginaPresente(new VendaLivro("Título 1", 100.0)));

        assertEquals(109.5, venda.getValor(), 0.01);
    }

    @Test
    void deveRetornarValorVendaComEmbalagemMaisCartaoMaisMarcador() {
        Venda venda = new EmbalagemPresente(new CartaoPresente(new MarcadorPaginaPresente(new VendaLivro("Título 1", 100.0))));

        assertEquals(117.5, venda.getValor(), 0.01);
    }

    @Test
    void deveRetornarDescricaoVendaLivro() {
        Venda venda = new VendaLivro("Título 1", 100.0);

        assertEquals("Título 1", venda.getDescricao());
    }

    @Test
    void deveRetornarDescricaoVendaComEmbalagemPresente() {
        Venda venda = new EmbalagemPresente(new VendaLivro("Título 1", 100.0));

        assertEquals("Título 1 + Embalagem de presente", venda.getDescricao());
    }

    @Test
    void deveRetornarDescricaoVendaComCartaoPresente() {
        Venda venda = new CartaoPresente(new VendaLivro("Título 1", 100.0));

        assertEquals("Título 1 + Cartão de presente", venda.getDescricao());
    }

    @Test
    void deveRetornarDescricaoVendaComMarcadorPaginaPresente() {
        Venda venda = new MarcadorPaginaPresente(new VendaLivro("Título 1", 100.0));

        assertEquals("Título 1 + Marcador de página de presente", venda.getDescricao());
    }

    @Test
    void deveRetornarDescricaoVendaComEmbalagemMaisCartao() {
        Venda venda = new EmbalagemPresente(new CartaoPresente(new VendaLivro("Título 1", 100.0)));

        assertEquals("Título 1 + Cartão de presente + Embalagem de presente", venda.getDescricao());
    }

    @Test
    void deveRetornarDescricaoVendaComCartaoMaisEmbalagem() {
        Venda venda = new CartaoPresente(new EmbalagemPresente(new VendaLivro("Título 1", 100.0)));

        assertEquals("Título 1 + Embalagem de presente + Cartão de presente", venda.getDescricao());
    }

    @Test
    void deveRetornarDescricaoVendaComEmbalagemMaisCartaoMaisMarcador() {
        Venda venda = new EmbalagemPresente(new CartaoPresente(new MarcadorPaginaPresente(new VendaLivro("Título 1", 100.0))));

        assertEquals("Título 1 + Marcador de página de presente + Cartão de presente + Embalagem de presente", venda.getDescricao());
    }

    @Test
    void naoDeveCriarVendaLivroComPrecoIgualEMenorQueZero() {
        try {
            Venda venda = new VendaLivro("Título 1", 0.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Preço inválido", e.getMessage());
        }
    }
}
