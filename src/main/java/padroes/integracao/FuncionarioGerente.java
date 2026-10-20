package padroes.integracao;

// Padrão Chain of Responsability
public class FuncionarioGerente extends Funcionario {

    public FuncionarioGerente(Funcionario superior) {
        super(500.0, superior);
    }

    public String getCargo() {
        return "Gerente";
    }
}
