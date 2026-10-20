package padroes.integracao;

// Padrão Decorator
public class VendaLivro implements Venda {

    private String titulo;
    private double preco;

    public VendaLivro(String titulo, double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        this.titulo = titulo;
        this.preco = preco;
    }

    public double getValor() {
        return preco;
    }

    public String getDescricao() {
        return titulo;
    }
}