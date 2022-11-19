package br.unigran.p2.Entidades;

public class Encomendas {
    private int id;
    private float valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", valor=" + valor +
                '}';
    }
}
