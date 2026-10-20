package padroes.integracao;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// Padrão Observer
public class Cliente implements Observer {

    private String nome;
    private ArrayList<String> notificacoes = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void acompanhar(Pedido pedido) {
        pedido.addObserver(this);
    }

    public String getUltimaNotificacao() {
        if (notificacoes.isEmpty()) {
            return null;
        }
        return notificacoes.get(notificacoes.size() - 1);
    }

    public ArrayList<String> getNotificacoes() {
        return notificacoes;
    }

    public void update(Observable pedido, Object novoEstado) {
        String loja = ParametrosLivraria.getInstance().getNomeLoja();
        notificacoes.add("[" + loja + "] " + this.nome + ", " + pedido + " agora está: " + novoEstado);
    }
}