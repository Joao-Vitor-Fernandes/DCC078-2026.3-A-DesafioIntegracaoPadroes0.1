package padroes.integracao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Pedido pedido;
    Funcionario atendente;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido(1, new VendaLivro("Título 1", 100.0));
        FuncionarioDiretor diretor = new FuncionarioDiretor(null);
        FuncionarioGerente gerente = new FuncionarioGerente(diretor);
        atendente = new FuncionarioAtendente(gerente);
    }

    // Pedido novo

    @Test
    public void deveIniciarPedidoAguardandoPagamento() {
        assertEquals(PedidoEstadoAguardandoPagamento.getInstance(), pedido.getEstado());
        assertEquals("Aguardando pagamento", pedido.getNomeEstado());
    }

    // Pedido aguardando pagamento

    @Test
    public void devePagarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertTrue(pedido.pagar("Pix"));
        assertEquals(PedidoEstadoPago.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveSepararPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.separar());
    }

    @Test
    public void naoDeveDespacharPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.despachar());
    }

    @Test
    public void naoDeveConcluirPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.concluir());
    }

    @Test
    public void deveCancelarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido pago

    @Test
    public void naoDevePagarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertFalse(pedido.pagar("Pix"));
    }

    @Test
    public void deveSepararPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertTrue(pedido.separar());
        assertEquals(PedidoEstadoEmSeparacao.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveDespacharPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertFalse(pedido.despachar());
    }

    @Test
    public void naoDeveConcluirPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertFalse(pedido.concluir());
    }

    @Test
    public void deveCancelarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido em separação

    @Test
    public void naoDevePagarPedidoEmSeparacao() {
        pedido.setEstado(PedidoEstadoEmSeparacao.getInstance());
        assertFalse(pedido.pagar("Pix"));
    }

    @Test
    public void naoDeveSepararPedidoEmSeparacao() {
        pedido.setEstado(PedidoEstadoEmSeparacao.getInstance());
        assertFalse(pedido.separar());
    }

    @Test
    public void deveDespacharPedidoEmSeparacao() {
        pedido.setEstado(PedidoEstadoEmSeparacao.getInstance());
        assertTrue(pedido.despachar());
        assertEquals(PedidoEstadoDespachado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveConcluirPedidoEmSeparacao() {
        pedido.setEstado(PedidoEstadoEmSeparacao.getInstance());
        assertFalse(pedido.concluir());
    }

    @Test
    public void deveCancelarPedidoEmSeparacao() {
        pedido.setEstado(PedidoEstadoEmSeparacao.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido despachado

    @Test
    public void naoDevePagarPedidoDespachado() {
        pedido.setEstado(PedidoEstadoDespachado.getInstance());
        assertFalse(pedido.pagar("Pix"));
    }

    @Test
    public void naoDeveSepararPedidoDespachado() {
        pedido.setEstado(PedidoEstadoDespachado.getInstance());
        assertFalse(pedido.separar());
    }

    @Test
    public void naoDeveDespacharPedidoDespachado() {
        pedido.setEstado(PedidoEstadoDespachado.getInstance());
        assertFalse(pedido.despachar());
    }

    @Test
    public void deveConcluirPedidoDespachado() {
        pedido.setEstado(PedidoEstadoDespachado.getInstance());
        assertTrue(pedido.concluir());
        assertEquals(PedidoEstadoConcluido.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveCancelarPedidoDespachado() {
        pedido.setEstado(PedidoEstadoDespachado.getInstance());
        assertFalse(pedido.cancelar());
    }

    // Pedido concluído

    @Test
    public void naoDevePagarPedidoConcluido() {
        pedido.setEstado(PedidoEstadoConcluido.getInstance());
        assertFalse(pedido.pagar("Pix"));
    }

    @Test
    public void naoDeveSepararPedidoConcluido() {
        pedido.setEstado(PedidoEstadoConcluido.getInstance());
        assertFalse(pedido.separar());
    }

    @Test
    public void naoDeveDespacharPedidoConcluido() {
        pedido.setEstado(PedidoEstadoConcluido.getInstance());
        assertFalse(pedido.despachar());
    }

    @Test
    public void naoDeveConcluirPedidoConcluido() {
        pedido.setEstado(PedidoEstadoConcluido.getInstance());
        assertFalse(pedido.concluir());
    }

    @Test
    public void naoDeveCancelarPedidoConcluido() {
        pedido.setEstado(PedidoEstadoConcluido.getInstance());
        assertFalse(pedido.cancelar());
    }

    // Pedido cancelado

    @Test
    public void naoDevePagarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.pagar("Pix"));
    }

    @Test
    public void naoDeveSepararPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.separar());
    }

    @Test
    public void naoDeveDespacharPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.despachar());
    }

    @Test
    public void naoDeveConcluirPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.concluir());
    }

    @Test
    public void naoDeveCancelarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.cancelar());
    }

    // Extra

    @Test
    public void deveRetornarValorDaVendaAntesDoPagamento() {
        assertEquals(100.0, pedido.getValorTotal(), 0.01);
        assertEquals(0.0, pedido.getValorPago(), 0.01);
    }

    @Test
    public void deveRetornarValorPagoDeVendaComAdicionais() {
        Pedido pedidoPresente = new Pedido(2, new EmbalagemPresente(new CartaoPresente(new VendaLivro("Título 1", 100.0))));
        pedidoPresente.pagar("Pix");
        assertEquals(105.925, pedidoPresente.getValorPago(), 0.01);
    }

    @Test
    public void deveEstornarPedidoCanceladoComAprovacaoDoAtendente() {
        pedido.pagar("Pix");
        pedido.cancelar();
        assertEquals("Atendente", pedido.solicitarEstorno(atendente));
    }

    @Test
    public void naoDeveEstornarPedidoCanceladoAntesDoPagamento() {
        pedido.cancelar();
        assertEquals("Estorno inválido", pedido.solicitarEstorno(atendente));
    }

    @Test
    public void naoDevePermitirEstornoDePedidoPago() {
        pedido.pagar("Pix");
        assertEquals("Estorno não permitido: pedido Pago", pedido.solicitarEstorno(atendente));
    }
}
