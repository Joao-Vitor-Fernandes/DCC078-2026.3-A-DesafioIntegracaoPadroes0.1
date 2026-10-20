package padroes.integracao;

// Padrão Chain of Responsability
public class FuncionarioAtendente extends Funcionario {

    public FuncionarioAtendente(Funcionario superior) {
        super(200.0, superior);
    }

    public String getCargo() {
        return "Atendente";
    }
}
