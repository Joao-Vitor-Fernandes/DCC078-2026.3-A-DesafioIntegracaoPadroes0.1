package padroes.integracao;

// Padrão State
public abstract class PedidoEstado {

    public abstract String getEstado();

    public boolean pagar(Pedido pedido, IPagamento pagamento) {
        return false;
    }

    public boolean separar(Pedido pedido) {
        return false;
    }

    public boolean despachar(Pedido pedido) {
        return false;
    }

    public boolean concluir(Pedido pedido) {
        return false;
    }

    public boolean cancelar(Pedido pedido) {
        return false;
    }

    public boolean permiteEstorno() {
        return false;
    }
}