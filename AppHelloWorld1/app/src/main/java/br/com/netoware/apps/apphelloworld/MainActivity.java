package br.com.netoware.apps.apphelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumeroTelefone;
    private Button btnNumero2;
    private String numeroDiscado = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumeroTelefone = findViewById(R.id.edtNumeroTelefone);
        btnNumero2 = findViewById(R.id.btnNumero2);
        ImageView imagem = findViewById(R.id.image1);
        //Intent it = getIntent();

        //Cliente cliente = (Cliente) it.getSerializableExtra("cliente1");

        //edtNumeroTelefone.setText(cliente.getTelefone());

    }


    public void apagarNumeros(View v) {

        edtNumeroTelefone.setText("");
    }

    public void discar(View v) {

        if (!edtNumeroTelefone.getText().toString().equals("")) {

            Uri uri = Uri.parse("tel:" + edtNumeroTelefone.getText().toString());
            Intent it = new Intent(Intent.ACTION_CALL, uri);
            numeroDiscado = edtNumeroTelefone.getText().toString();
            startActivity(it);

            Chamadas chamada = new Chamadas();
            chamada.setTelefone(edtNumeroTelefone.getText().toString());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            Calendar data = Calendar.getInstance();
            chamada.setData(data.getTime().toString());

            ChamadaDAO chamadadao = new ChamadaDAO(this);
            if (chamadadao.add(chamada)) {
                Log.d("Discador", "Chamada inserida");
            }


            
        } else
            Toast.makeText(this, "Por favor informe o nº a ser discado.", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void numeroDigitado(View v) throws IOException {

        ProgressDialog pd = null;

       switch (v.getId()) {

           case R.id.btnNumero1:
               edtNumeroTelefone.setText(edtNumeroTelefone.getText().toString() + "1");
               break;

           case R.id.btnNumero2:
               edtNumeroTelefone.setText(edtNumeroTelefone.getText().toString() + "2");
               break;

           case R.id.btnNumero3:
               edtNumeroTelefone.setText(edtNumeroTelefone.getText().toString() + "3");
               break;

           case R.id.btnNumero4:
               edtNumeroTelefone.setText(edtNumeroTelefone.getText().toString() + "4");
               break;

           case R.id.btnNumero5:
               edtNumeroTelefone.setText(edtNumeroTelefone.getText().toString() + "5");
               break;

           case R.id.btnNumero6:
               edtNumeroTelefone.setText(edtNumeroTelefone.getText().toString() + "6");
               break;

           case R.id.btnNumero7:
               edtNumeroTelefone.setText(edtNumeroTelefone.getText().toString() + "7");
               break;

           case R.id.btnNumero8:
               edtNumeroTelefone.setText(edtNumeroTelefone.getText().toString() + "8");
               break;

           case R.id.btnNumero9:
               edtNumeroTelefone.setText(edtNumeroTelefone.getText().toString() + "9");
               break;

           case R.id.btnZero:
               edtNumeroTelefone.setText(edtNumeroTelefone.getText().toString() + "0");
               break;

           case R.id.btnAsterisco:
               edtNumeroTelefone.setText(edtNumeroTelefone.getText().toString() + "*");
               break;

           case R.id.btnJogoDaVelha:

               edtNumeroTelefone.setText(edtNumeroTelefone.getText().toString() + "#");
               break;

           default: break;
       }

    }

}
