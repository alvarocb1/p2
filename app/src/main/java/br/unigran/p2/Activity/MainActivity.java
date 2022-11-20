package br.unigran.p2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.unigran.p2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void segundaTela(View view){
        switch (view.getId()){
            case R.id.idFlores:
                startActivity(new Intent(this,SegundaActivity.class)
                        .putExtra("fragmento", "Flores"));
                break;
            case R.id.idClientes:
                startActivity(new Intent(this,SegundaActivity.class).
                        putExtra("fragmento", "Cliente"));
                break;
            case R.id.idEncomendas:
                startActivity(new Intent(this,SegundaActivity.class).
                        putExtra("fragmento", "Encomendas"));
                break;
        }

    }
    public void sair(View view){
        finish();
    }
}