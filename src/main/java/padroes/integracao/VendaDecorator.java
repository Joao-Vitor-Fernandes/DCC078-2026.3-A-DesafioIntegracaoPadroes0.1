package padroes.integracao;

// Padrão Decorator
public abstract class VendaDecorator implements Venda {

    private Venda venda;

    protected VendaDecorator(Venda venda) {
        this.venda = venda;
    }

    public Venda getVenda() {
        return venda;
    }

    public abstract double getAcrescimo(double valorBase);

    public abstract String getNomeAdicional();

    public double getValor() {
        double valorBase = this.venda.getValor();
        return valorBase + this.getAcrescimo(valorBase);
    }

    public String getDescricao() {
        return this.venda.getDescricao() + " + " + this.getNomeAdicional();
    }
}