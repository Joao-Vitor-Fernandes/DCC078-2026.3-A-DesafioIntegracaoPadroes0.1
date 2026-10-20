package padroes.integracao;

// Padrão State
public class PedidoEstadoConcluido extends PedidoEstado {

    private PedidoEstadoConcluido() {};
    private static PedidoEstadoConcluido instance = new PedidoEstadoConcluido();
    public static PedidoEstadoConcluido getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Concluído";
    }
}
