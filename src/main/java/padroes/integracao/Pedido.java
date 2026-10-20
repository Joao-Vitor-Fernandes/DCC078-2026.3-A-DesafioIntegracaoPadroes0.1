package padroes.integracao;

import java.util.Observable;

// Padrão State + Padrão Observer
public class Pedido extends Observable {

    private int numero;
    private Venda venda;
    private PedidoEstado estado;
    private IPagamento pagamento;
    private double valorPago;

    public Pedido(int numero, Venda venda) {
        this.numero = numero;
        this.venda = venda;
        this.estado = PedidoEstadoAguardandoPagamento.getInstance();
    }

    public boolean pagar(String formaPagamento) {
        IPagamento novoPagamento = PagamentoFactory.obterPagamento(formaPagamento);
        return estado.pagar(this, novoPagamento);
    }

    public boolean separar() {
        return estado.separar(this);
    }

    public boolean despachar() {
        return estado.despachar(this);
    }

    public boolean concluir() {
        return estado.concluir(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public String solicitarEstorno(Funcionario funcionario) {
        if (!estado.permiteEstorno()) {
            return "Estorno não permitido: pedido " + estado.getEstado();
        }
        return funcionario.aprovar(new Estorno(numero, valorPago));
    }

    void setEstado(PedidoEstado novoEstado) {
        this.estado = novoEstado;
        setChanged();
        notifyObservers(novoEstado.getEstado());
    }

    void registrarPagamento(IPagamento novoPagamento) {
        this.pagamento = novoPagamento;
        this.valorPago = novoPagamento.calcularValorFinal(venda.getValor());
    }

    public int getNumero() {
        return numero;
    }

    public Venda getVenda() {
        return venda;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public IPagamento getPagamento() {
        return pagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public double getValorTotal() {
        if (pagamento == null) {
            return venda.getValor();
        }
        return valorPago;
    }

    @Override
    public String toString() {
        return "Pedido #" + numero;
    }
}