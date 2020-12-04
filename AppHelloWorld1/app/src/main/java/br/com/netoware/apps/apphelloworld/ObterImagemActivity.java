package br.com.netoware.apps.apphelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;

public class ObterImagemActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private ProgressDialog pd = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obter_imagem);

    }


    public void realizarDownload(View v) {

        pd = ProgressDialog.show(this, "Aguarde ...", "Realizando o Download da Imagem");

        new Thread() {

            @Override
            public void run() {
                super.run();
                Util util = new Util();

                try {
                    Log.e("teste", "Iniciando Download");
                    final Bitmap img = util.baixarImagem("https://lembrancachique.cdn.plataformaneo.com.br/produto/multifotos/hd/20190204154147_5879994121_DZ.png");
                    Log.e("teste", "Finalizando Download");

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ImageView imagem1 = findViewById(R.id.imgInternet);
                            imagem1.setImageBitmap(img);
                            pd.dismiss();
                        }
                    });

                } catch (IOException e) {
                    Log.d("teste", "erro ao baixar a imagem");
                }
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        handler.removeCallbacks(null);
    }
}