package padroes.integracao;

// Padrão State
public class PedidoEstadoDespachado extends PedidoEstado {

    private PedidoEstadoDespachado() {};
    private static PedidoEstadoDespachado instance = new PedidoEstadoDespachado();
    public static PedidoEstadoDespachado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Despachado";
    }

    public boolean concluir(Pedido pedido) {
        pedido.setEstado(PedidoEstadoConcluido.getInstance());
        return true;
    }
}