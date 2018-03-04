package pt.sysdeveloper.carteiradeclientes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pt.sysdeveloper.carteiradeclientes.dominio.entidades.Cliente;

/**
 * Created by António - Local on 04/03/2018.
 */

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolderCliente> {

    private List<Cliente> dados;

    public ClienteAdapter(List<Cliente> dados) {
        this.dados = dados;
    }

    @Override
    public ClienteAdapter.ViewHolderCliente onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ClienteAdapter.ViewHolderCliente holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHolderCliente extends RecyclerView.ViewHolder{

        public TextView txtNome;
        public TextView txtTelefone;

        public ViewHolderCliente(View itemView){
            super(itemView);
            txtNome     = (TextView) itemView.findViewById(R.id.textNome);
            txtTelefone = (TextView) itemView.findViewById(R.id.edtTelefone);
        }
    }
}
