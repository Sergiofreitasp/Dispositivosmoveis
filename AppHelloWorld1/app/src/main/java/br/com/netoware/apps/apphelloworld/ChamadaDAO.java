package br.com.netoware.apps.apphelloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class ChamadaDAO extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "br.com.netoware.app.discador";
    private static final int VERSAO = 1;
    private static final String NOME_TABELA = "chamada";

    public ChamadaDAO(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL = "create table if not exists chamada(_id INTEGER PRIMARY KEY AUTOINCREMENT, telefone text, data text)";
        sqLiteDatabase.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean add(Chamadas chamada){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("telefone", chamada.getTelefone());
        dados.put("data", chamada.getData());

        try{
            db.insert(NOME_TABELA, "", dados);
        }catch (Exception e){
            Log.e("discador", "Erro para colocar na tabela" + NOME_TABELA);
            return false;
        }
        return true;
    }

    public boolean remover(int id){
        SQLiteDatabase db = getWritableDatabase();
        try{
            db.delete(NOME_TABELA, "_id = ?", new String[]{String.valueOf(id)});
        }catch (Exception e){
            Log.e("discador", "Erro para remover na tabela" + NOME_TABELA);
            return false;
        }
        return true;
    }

    public boolean update(Chamadas chamada){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("telefone", chamada.getTelefone());
        dados.put("data", chamada.getData());

        try{
            db.update(NOME_TABELA, dados, "_id=?", new String[]{String.valueOf(chamada.getId())});
        }catch (Exception e){
            Log.e("discador", "Erro para atualizar na tabela" + NOME_TABELA);
            return false;
        }
        return true;
    }

    public boolean removeAll(){
        SQLiteDatabase db = getWritableDatabase();
        try{
            db.delete(NOME_TABELA, "", new String[]{});
        }catch (Exception e){
            Log.e("discador", "Erro para remover na tabela" + NOME_TABELA);
            return false;
        }
        return true;
    }

    public Cursor listAll(){
        SQLiteDatabase db = getReadableDatabase();

        Cursor Listachamas = null;
        try{
            Listachamas = db.query(NOME_TABELA, new String[]{}, "", new String[]{}, "", "", "_id desc");
        }catch (Exception e){
            Log.e("discador", "Erro ao buscar todos na tabela" + NOME_TABELA);
            return null;
        }
        return null;
    }
}
