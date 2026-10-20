package padroes.integracao;

// Padrão Singleton
public class ParametrosLivraria {

    private ParametrosLivraria() {};
    private static ParametrosLivraria instance = new ParametrosLivraria();
    public static ParametrosLivraria getInstance() {
        return instance;
    }

    private String nomeLoja;
    private String atendenteLogado;

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getAtendenteLogado() {
        return atendenteLogado;
    }

    public void setAtendenteLogado(String atendenteLogado) {
        this.atendenteLogado = atendenteLogado;
    }
}
