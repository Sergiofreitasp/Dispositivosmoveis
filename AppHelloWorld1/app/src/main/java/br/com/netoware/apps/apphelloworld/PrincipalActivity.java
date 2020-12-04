package br.com.netoware.apps.apphelloworld;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TintTypedArray;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_principal);
    }


    public void abrirDiscador(View v) {

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Glaucio Rocha");
        cliente.setCpf("010.992.887-87");
        cliente.setTelefone("988599834");


        Intent it = new Intent(this, MainActivity.class);
        it.putExtra("cliente1", cliente);
        it.putExtra("nome", "Glaucio Rocha");


        startActivityForResult(it, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10) {

            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getStringExtra("numeroDiscado"), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Erro ao obter numero", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == 11) {

            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Erro ao obter contado cadastrado", Toast.LENGTH_SHORT).show();
            }

        }

    }

    public void obterContato(View v) {

        Intent it = new Intent();

        startActivityForResult(it, 11);
    }
}