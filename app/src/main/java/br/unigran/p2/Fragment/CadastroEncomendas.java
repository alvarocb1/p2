package br.unigran.p2.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.unigran.p2.Entidades.Encomendas;
import br.unigran.p2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroEncomendas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroEncomendas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btn;
    Spinner user;
    Spinner product;
    EditText valor;
    EditText quantidade;
    List <String> tipos;
    List <String> nomes;

    DatabaseReference databaseReference;

    public CadastroEncomendas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cadastro_encomendas.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroEncomendas newInstance(String param1, String param2) {
        CadastroEncomendas fragment = new CadastroEncomendas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cadastro_encomendas, container, false);
        btn=view.findViewById(R.id.idSalvarEncomendas);
        valor= view.findViewById(R.id.idValor);
        quantidade=view.findViewById(R.id.idQuantidade);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        product=view.findViewById(R.id.idSpinnerFlores);
        tipos= new ArrayList();
        databaseReference.child("flores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String spinnerTipos = snapshot.child("tipos").getValue(String.class);
                tipos.add(spinnerTipos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        user=view.findViewById(R.id.idSpinnerCliente);
        nomes= new ArrayList();
        databaseReference.child("clientes").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String spinnerNomes = snapshot.child("nome").getValue(String.class);
                tipos.add(spinnerNomes);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }

    private void salvar() {
        Encomendas e = new Encomendas();
        e.valor= Float.parseFloat(valor.getText().toString());
        e.quantidade= Integer.parseInt(quantidade.getText().toString());
        e.nomeCliente=user.getSelectedItem().toString();
        e.tipoFlor=product.getSelectedItem().toString();
        DatabaseReference encomendas = databaseReference.child("encomendas");
        encomendas.push().setValue(e);
        Toast.makeText(getContext(),"Salvo",Toast.LENGTH_SHORT).show();
    }
}