package padroes.integracao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    Pedido pedido;

    @BeforeEach
    void setUp() {
        ParametrosLivraria.getInstance().setNomeLoja("Livraria Teste");
        pedido = new Pedido(1, new VendaLivro("Título 1", 100.0));
    }

    @Test
    void deveNotificarUmCliente() {
        Cliente cliente = new Cliente("Ana");
        cliente.acompanhar(pedido);
        pedido.pagar("Pix");
        assertEquals("[Livraria Teste] Ana, Pedido #1 agora está: Pago", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarACadaMudancaDeEstado() {
        Cliente cliente = new Cliente("Ana");
        cliente.acompanhar(pedido);
        pedido.pagar("Pix");
        assertEquals("[Livraria Teste] Ana, Pedido #1 agora está: Pago", cliente.getUltimaNotificacao());
        pedido.separar();
        assertEquals("[Livraria Teste] Ana, Pedido #1 agora está: Em separação", cliente.getUltimaNotificacao());
        pedido.despachar();
        assertEquals("[Livraria Teste] Ana, Pedido #1 agora está: Despachado", cliente.getUltimaNotificacao());
        pedido.concluir();
        assertEquals("[Livraria Teste] Ana, Pedido #1 agora está: Concluído", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarCancelamento() {
        Cliente cliente = new Cliente("Ana");
        cliente.acompanhar(pedido);
        pedido.cancelar();
        assertEquals("[Livraria Teste] Ana, Pedido #1 agora está: Cancelado", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Cliente cliente1 = new Cliente("Ana");
        Cliente cliente2 = new Cliente("Bruno");
        cliente1.acompanhar(pedido);
        cliente2.acompanhar(pedido);
        pedido.pagar("Pix");
        assertEquals("[Livraria Teste] Ana, Pedido #1 agora está: Pago", cliente1.getUltimaNotificacao());
        assertEquals("[Livraria Teste] Bruno, Pedido #1 agora está: Pago", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Cliente cliente = new Cliente("Ana");
        pedido.pagar("Pix");
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteDoPedido1() {
        Pedido pedido2 = new Pedido(2, new VendaLivro("Título 2", 80.0));
        Cliente cliente1 = new Cliente("Ana");
        Cliente cliente2 = new Cliente("Bruno");
        cliente1.acompanhar(pedido);
        cliente2.acompanhar(pedido2);
        pedido.pagar("Pix");
        assertEquals("[Livraria Teste] Ana, Pedido #1 agora está: Pago", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}
