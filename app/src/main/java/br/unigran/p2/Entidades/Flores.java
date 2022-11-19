package br.unigran.p2.Entidades;

public class Flores {
    private int id;
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Flores{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
