package padroes.integracao;

// Padrão State
public class PedidoEstadoEmSeparacao extends PedidoEstado {

    private PedidoEstadoEmSeparacao() {};
    private static PedidoEstadoEmSeparacao instance = new PedidoEstadoEmSeparacao();
    public static PedidoEstadoEmSeparacao getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em separação";
    }

    public boolean despachar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoDespachado.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}