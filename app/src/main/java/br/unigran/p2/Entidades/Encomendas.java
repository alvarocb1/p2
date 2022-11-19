package br.unigran.p2.Entidades;

public class Encomendas {
    private int id;
    private int quantidade;
    private float valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Encomendas{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }
}
