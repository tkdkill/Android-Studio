package pt.sysdeveloper.carteiradeclientes.database;

/**
 * Created by António - Local on 18/02/2018.
 */

public class ScriptDDL {

    public static String getCreateTableClitentes(){
        StringBuilder sql = new StringBuilder();

            sql.append(" CREATE TABLE CLIENTES (                               ");
            sql.append(" CODIGO   INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL, ");
            sql.append(" NOME     VARCHAR (250) NOT NULL DEFAULT (''),         ");
            sql.append(" ENDERECO VARCHAR (250) NOT NULL DEFAULT (''),         ");
            sql.append(" EMAIL    VARCHAR (200) NOT NULL DEFAULT (''),         ");
            sql.append(" TELEFONE VARCHAR (20)  NOT NULL DEFAULT (''))         ");

            return sql.toString();
    }
}
