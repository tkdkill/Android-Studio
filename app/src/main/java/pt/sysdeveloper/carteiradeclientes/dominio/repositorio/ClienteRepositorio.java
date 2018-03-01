package pt.sysdeveloper.carteiradeclientes.dominio.repositorio;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import pt.sysdeveloper.carteiradeclientes.dominio.entidades.Cliente;

/**
 * Created by António - Local on 01/03/2018.
 */

public class ClienteRepositorio {

    private SQLiteDatabase conexao;

    public ClienteRepositorio(SQLiteDatabase conexao) {
        this.conexao = conexao;
    }

    public void inserir(Cliente cliente){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOME", cliente.nome);
        contentValues.put("ENDERECO", cliente.endereco);
        contentValues.put("EMAIL", cliente.email);
        contentValues.put("TELEFONE", cliente.telefone);

        conexao.insertOrThrow("CLIENTES", null, contentValues);

    }

    public void excluir(int codigo){

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(codigo);

        conexao.delete("CLIENTES", "CODIGO = ?", parametros );
    }

    public void alterar(Cliente  cliente){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOME", cliente.nome);
        contentValues.put("ENDERECO", cliente.endereco);
        contentValues.put("EMAIL", cliente.email);
        contentValues.put("TELEFONE", cliente.telefone);

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(cliente.codigo);

        conexao.update("CLIENTES", contentValues, "CODIGO = ?", parametros );

    }

    public List<Cliente> buscarTodos(){
        return null;
    }

    public Cliente buscarCliente(int codigo){
        return null;
    }
}
