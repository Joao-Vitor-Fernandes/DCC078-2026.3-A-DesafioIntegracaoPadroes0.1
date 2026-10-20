package padroes.integracao;

// Padrão Decorator
public class CartaoPresente extends VendaDecorator {

    public CartaoPresente(Venda venda) {
        super(venda);
    }

    public double getAcrescimo(double valorBase) {
        return 3.5;
    }

    public String getNomeAdicional() {
        return "Cartão de presente";
    }
}
