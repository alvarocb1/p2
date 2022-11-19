package br.unigran.p2.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.unigran.p2.Entidades.Clientes;
import br.unigran.p2.Entidades.Flores;
import br.unigran.p2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroClientes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroClientes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btn;
    EditText nome;
    EditText uf;
    EditText cidade;
    EditText rua;
    EditText numero;
    DatabaseReference databaseReference;

    public CadastroClientes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cadastro_flores.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroClientes newInstance(String param1, String param2) {
        CadastroClientes fragment = new CadastroClientes();
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
        View view= inflater.inflate(R.layout.fragment_cadastro_clientes, container, false);
        btn=view.findViewById(R.id.idSalvarCliente);
        nome= view.findViewById(R.id.idNomeCliente);
        uf= view.findViewById(R.id.idUfCliente);
        cidade= view.findViewById(R.id.idCidadeCliente);
        rua= view.findViewById(R.id.idRuaCliente);
        numero= view.findViewById(R.id.idNumeroCliente);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        return view;
    }

    private void salvar() {
        Clientes c = new Clientes();
        c.nome=nome.getText().toString();
        c.uf=uf.getText().toString();
        c.cidade=cidade.getText().toString();
        c.rua=rua.getText().toString();
        c.numero=numero.getText().toString();

        DatabaseReference flores = databaseReference.child("clientes");
        flores.push().setValue(c);
        Toast.makeText(getContext(),"Salvo",Toast.LENGTH_SHORT).show();
    }
}