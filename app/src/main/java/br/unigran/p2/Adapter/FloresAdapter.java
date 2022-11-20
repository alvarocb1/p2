package br.unigran.p2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.unigran.p2.Entidades.Flores;
import br.unigran.p2.R;

public class FloresAdapter extends RecyclerView.Adapter<FloresAdapter.FloresHolder> {

    List<Flores> dados;

    public FloresAdapter(List<Flores> dados) {
        this.dados = dados;
    }
    @NonNull
    @Override
    public FloresHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.linha_flores,parent,false);
        return new FloresHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull FloresHolder floresHolder, int position) {
        floresHolder.tipo.setText(dados.get(position).getTipo());

    }
    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class FloresHolder extends RecyclerView.ViewHolder {
        public TextView tipo;
        public Button editar;


        public FloresHolder(@NonNull View itemView) {
            super(itemView);
            tipo =itemView.findViewById(R.id.idTipo);
            editar =itemView.findViewById(R.id.idEditar);
        }
    }
}
