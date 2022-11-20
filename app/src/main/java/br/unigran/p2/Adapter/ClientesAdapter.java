package br.unigran.p2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.unigran.p2.Entidades.Clientes;
import br.unigran.p2.R;

public class ClientesAdapter extends RecyclerView.Adapter<ClientesAdapter.ClientesHolder> {

    List<Clientes> dados;

    public ClientesAdapter(List<Clientes> dados) {
        this.dados = dados;
    }
    @NonNull
    @Override
    public ClientesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.linha_cliente,parent,false);
        return new ClientesHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ClientesHolder clientesHolder, int position) {
        clientesHolder.nome.setText(dados.get(position).getNome());
        clientesHolder.uf.setText(dados.get(position).getUf());
        clientesHolder.cidade.setText(dados.get(position).getCidade());
        clientesHolder.rua.setText(dados.get(position).getRua());
        clientesHolder.numero.setText(dados.get(position).getNumero());
    }
    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ClientesHolder extends RecyclerView.ViewHolder {
        public TextView nome;
        public TextView uf;
        public TextView cidade;
        public TextView rua;
        public TextView numero;
        public Button editar;


        public ClientesHolder(@NonNull View itemView) {
            super(itemView);
            nome =itemView.findViewById(R.id.idNome);
            uf =itemView.findViewById(R.id.idUF);
            cidade =itemView.findViewById(R.id.idCidade);
            rua =itemView.findViewById(R.id.idRua);
            numero =itemView.findViewById(R.id.idNumero);
            editar =itemView.findViewById(R.id.idEditar);
        }
    }
}
