package br.unigran.p2.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.unigran.p2.Adapter.EncomendasAdapter;
import br.unigran.p2.Entidades.Encomendas;
import br.unigran.p2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Listagem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Listagem extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List dados;
    RecyclerView recycleView;
    LinearLayoutManager linearLayoutManager;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EncomendasAdapter encomendasAdapter;
    ArrayList listagem;
    DatabaseReference databaseReference;

    public Listagem() {
        // Required empty public constructor
        dados = new LinkedList();
    }

    public List getDados() {
        return dados;
    }

    public void atualizaAdapter() {
        encomendasAdapter.notifyDataSetChanged();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment listagem.
     */
    // TODO: Rename and change types and number of parameters
    public static Listagem newInstance(String param1, String param2) {
        Listagem fragment = new Listagem();
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
        View view = inflater.inflate(R.layout.fragment_listagem, container, false);

        recycleView = view.findViewById(R.id.idLista);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        recycleView.setLayoutManager(linearLayoutManager);

        databaseReference = FirebaseDatabase.getInstance().getReference("encomendas");
        listagem = new ArrayList<>();
        encomendasAdapter = new EncomendasAdapter(view.getContext(), listagem);
        recycleView.setAdapter(encomendasAdapter);

        Query query = databaseReference.orderByChild("nome");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("Firebase",snapshot.getValue().toString());
                for (DataSnapshot item : snapshot.getChildren()){
                    Encomendas encomendas = item.getValue(Encomendas.class);
                    listagem.add(encomendas);
                    Log.i("Firebase",encomendas.nomeCliente);
                    Log.i("Firebase",encomendas.tipoFlor);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    return view;
    }
}