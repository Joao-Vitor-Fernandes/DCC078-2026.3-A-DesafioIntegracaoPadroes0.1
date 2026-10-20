package padroes.integracao;

// Padrão Decorator
public class MarcadorPaginaPresente extends VendaDecorator {

    public MarcadorPaginaPresente(Venda venda) {
        super(venda);
    }

    public double getAcrescimo(double valorBase) {
        return 6.0;
    }

    public String getNomeAdicional() {
        return "Marcador de página de presente";
    }
}
