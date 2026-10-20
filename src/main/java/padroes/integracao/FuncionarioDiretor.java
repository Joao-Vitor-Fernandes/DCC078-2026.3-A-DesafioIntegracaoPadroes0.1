package padroes.integracao;

// Padrão Chain of Responsability
public class FuncionarioDiretor extends Funcionario {

    public FuncionarioDiretor(Funcionario superior) {
        super(2000.0, superior);
    }

    public String getCargo() {
        return "Diretor";
    }
}
