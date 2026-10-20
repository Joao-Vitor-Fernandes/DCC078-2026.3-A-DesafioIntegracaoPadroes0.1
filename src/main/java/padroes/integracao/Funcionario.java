package padroes.integracao;

// Padrão Chain of Responsability
public abstract class Funcionario {

    private double limite;
    private Funcionario superior;

    protected Funcionario(double limite, Funcionario superior) {
        this.limite = limite;
        this.superior = superior;
    }

    public abstract String getCargo();

    public double getLimite() {
        return limite;
    }

    public Funcionario getSuperior() {
        return superior;
    }

    public void setSuperior(Funcionario superior) {
        this.superior = superior;
    }

    public String aprovar(Estorno estorno) {
        if (estorno == null || estorno.getValor() <= 0) {
            return "Estorno inválido";
        }
        if (estorno.getValor() <= limite) {
            return getCargo();
        }
        if (superior != null) {
            return superior.aprovar(estorno);
        }
        return "Sem autorização para aprovar";
    }
}
