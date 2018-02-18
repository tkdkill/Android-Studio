package pt.sysdeveloper.carteiradeclientes;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class ActCadCliente extends AppCompatActivity {
    /*Componentes*/
    private EditText edtNome;
    private EditText edtEndereco;
    private EditText edtEmail;
    private EditText edtTelefone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cad_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtNome     = (EditText)findViewById(R.id.edtNome);
        edtEndereco = (EditText)findViewById(R.id.edtEndereco);
        edtEmail    = (EditText)findViewById(R.id.edtEmail);
        edtTelefone = (EditText)findViewById(R.id.edtTelefone);
    }

    private void validaCampos(){

        boolean res = false;

        String nome     = edtNome.getText().toString();
        String endereco = edtEndereco.getText().toString();
        String email    = edtEmail.getText().toString();
        String telefone = edtTelefone.getText().toString();

        if(res = isCampoVazio(nome)){
            edtNome.requestFocus();
        }else if(res = isCampoVazio(endereco)){
            edtEndereco.requestFocus();
        }else if(res = !isEmailValido(email)){
            edtEmail.requestFocus();
        }else if(res = !isTelefoneValido(telefone)){
            edtTelefone.requestFocus();
        }

        if(res){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_aviso);
            dlg.setTitle(R.string.message_campos_invalidos_brancos);
            dlg.setNeutralButton(R.string.lbl_ok, null);
            dlg.show();
        }
    }

    // método que verifica se os campos estão vazios
    private boolean isCampoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

    //Método verifica se o email é válido
    private boolean isEmailValido(String email){
        boolean resultado = (!isCampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        return resultado;
    }
    //Método verifica se o telefone é válido
    private boolean isTelefoneValido(String telefone){
        boolean resultado = (!isCampoVazio(telefone) && Patterns.PHONE.matcher(telefone).matches());
        return resultado;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_card_cliente, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /*subescrever método*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.action_ok:
                validaCampos();
                //Toast.makeText(this, "Botão OK Selecionado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_cancelar:
                //Toast.makeText(this, "Botão CANCELAR Selecionado", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
