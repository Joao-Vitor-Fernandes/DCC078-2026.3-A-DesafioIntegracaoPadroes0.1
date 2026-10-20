package padroes.integracao;

// Padrão Decorator
public class EmbalagemPresente extends VendaDecorator {

    public EmbalagemPresente(Venda venda) {
        super(venda);
    }

    public double getAcrescimo(double valorBase) {
        return 8.0;
    }

    public String getNomeAdicional() {
        return "Embalagem de presente";
    }
}