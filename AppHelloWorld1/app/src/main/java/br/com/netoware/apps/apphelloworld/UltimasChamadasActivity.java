package br.com.netoware.apps.apphelloworld;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.Nullable;

public class UltimasChamadasActivity extends ListActivity {

    private Button bntExcluir;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        String[] colunasBanco = new String[]{"telefone", "data"};
        int[] camposLayout = new int[]{R.id.txtTelefone, R.id.txtDataHora};
        ChamadaDAO chamadaDAO = new ChamadaDAO(this);
        Cursor ultimasChamadas = chamadaDAO.listAll();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_ultimas_chamadas, ultimasChamadas, colunasBanco, camposLayout, 0);
        setListAdapter(adapter);
        /*ArrayList<HashMap<String, String>> dados = new ArrayList<>();

        HashMap<String, String> dados1 = new HashMap<>();
        dados1.put("nome", "Glaucio Rocha");
        dados1.put("telefone", "98859-9834");
        dados1.put("datahora", "23/10/2020 08:59:34");

        HashMap<String, String> dados2 = new HashMap<>();
        dados2.put("nome", "Jose da Silva");
        dados2.put("telefone", "73737-3733");
        dados2.put("datahora", "15/10/2020 08:59:34");

        HashMap<String, String> dados3 = new HashMap<>();
        dados3.put("nome", "Abmael");
        dados3.put("telefone", "78878-9834");
        dados3.put("datahora", "01/11/2020 18:39:34");

        dados.add(dados1);
        dados.add(dados2);
        dados.add(dados3);

        String[] chaves = new String[] {"nome", "telefone", "datahora"};
        int[] nome_campos = new int[] {R.id.txtNome, R.id.txtTelefone, R.id.txtDataHora};


        SimpleAdapter adaptador = new SimpleAdapter(this, dados, R.layout.activity_ultimas_chamadas, chaves, nome_campos);

        setListAdapter(adaptador);*/

    }

    public void removerRegistro(){
        bntExcluir = findViewById(R.id.bttexcluirRegistro);
    }
}
