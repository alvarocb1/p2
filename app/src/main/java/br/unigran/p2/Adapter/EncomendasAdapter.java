package br.unigran.p2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.unigran.p2.Entidades.Encomendas;
import br.unigran.p2.R;

public class EncomendasAdapter extends RecyclerView.Adapter<EncomendasAdapter.EncomendasHolder>{
    List<Encomendas> dados;

    public EncomendasAdapter(Context context, List<Encomendas> dados) {
        this.dados = dados;
    }

    public EncomendasAdapter(List dados) {
    }

    @NonNull
    @Override
    public EncomendasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.linha_encomendas,parent,false);
        return new EncomendasHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull EncomendasHolder encomendasHolder, int position) {
        encomendasHolder.quantidade.setText(dados.get(position).getQuantidade());
        encomendasHolder.valor.setText((int) dados.get(position).getValor());
    }
    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class EncomendasHolder extends RecyclerView.ViewHolder {
        public TextView quantidade;
        public TextView valor;
        public Button editar;


        public EncomendasHolder(@NonNull View itemView) {
            super(itemView);
            quantidade =itemView.findViewById(R.id.idQuantidade);
            valor =itemView.findViewById(R.id.idValor);
            editar =itemView.findViewById(R.id.idEditar);
        }
    }
}
