package br.com.netoware.apps.apphelloworld;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.Nullable;

public class MenuOpcoes extends ListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] dados = new String[] {"Discar", "Últimas Chamadas", "Limpar Histórico", "Sair"};
        int arqLayout = android.R.layout.simple_list_item_1;
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, arqLayout, dados);

        setListAdapter(adaptador);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch (position) {
            
            case 0:
                Intent it = new Intent(this, MainActivity.class);
                startActivity(it);
                break;
                
            case 1:
                Intent it2 = new Intent(this, UltimasChamadasActivity.class);
                startActivity(it2);

                break;
                
            case 2:
                Toast.makeText(this, "Opção indisponível", Toast.LENGTH_SHORT).show();
                break;
                
            case 3:
                finish();
                break;
                
            default:

                Toast.makeText(this, "Opção Inválida!", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
