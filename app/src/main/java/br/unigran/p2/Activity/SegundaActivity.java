package br.unigran.p2.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

import br.unigran.p2.Adapter.ClientesAdapter;
import br.unigran.p2.Adapter.EncomendasAdapter;
import br.unigran.p2.Adapter.FloresAdapter;
import br.unigran.p2.Entidades.Clientes;
import br.unigran.p2.Entidades.Encomendas;
import br.unigran.p2.Entidades.Flores;
import br.unigran.p2.Fragment.CadastroClientes;
import br.unigran.p2.Fragment.CadastroEncomendas;
import br.unigran.p2.Fragment.CadastroFlores;
import br.unigran.p2.Fragment.Listagem;
import br.unigran.p2.R;

public class SegundaActivity extends AppCompatActivity {
    Fragment fragmento;
    RecyclerView recyclerView;
    Listagem listagem;

    ClientesAdapter clientesAdapter;
    FloresAdapter floresAdapter;
    EncomendasAdapter encomendasAdapter;
    private String acao;
    LinearLayoutManager linearLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        getSupportActionBar().setElevation(0);
        listagem=new Listagem();
        acao=getIntent().getStringExtra("fragmento");
        fragmento=criaFragmento(acao);

        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();//cria transacao
        transaction.add(R.id.idFrame,listagem);//add fragmento
        transaction.commit();//valida a adição
        findViewById(R.id.idLista);

    }

    public Fragment criaFragmento(String nome){
        switch (nome){
            case "Flores":
                fragmento=new CadastroFlores();

                break;
            case "Clientes":
                fragmento=new CadastroClientes();
                break;
            case "Encomendas":
                fragmento=new CadastroEncomendas();
                break;
        }
        return fragmento;
    }
    public void segundaTela(View view){
        getSupportFragmentManager().beginTransaction().//cria transacao
                replace(R.id.idFrame,fragmento)//add fragmento
                .commit();//valida a adição
    }
    public void primeiraTela(View view){
        getSupportFragmentManager().beginTransaction().//cria transacao
                replace(R.id.idFrame,listagem)//add fragmento
                .commit();//valida a adição
        switch (acao){
            case "Flores":
                
                break;
            case "Clientes":

                break;
            case "Encomendas":

                break;

        }
        listagem.atualizaAdapter();
    }
}