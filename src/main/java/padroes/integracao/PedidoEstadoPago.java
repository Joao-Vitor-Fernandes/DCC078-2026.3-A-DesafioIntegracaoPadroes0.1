package padroes.integracao;

// Padrão State
public class PedidoEstadoPago extends PedidoEstado {

    private PedidoEstadoPago() {};
    private static PedidoEstadoPago instance = new PedidoEstadoPago();
    public static PedidoEstadoPago getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pago";
    }

    public boolean separar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmSeparacao.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}