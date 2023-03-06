package Controller;

import Model.ClienteModel;

public class ClienteController {
    private ClienteModel cliente;

    public ClienteController(String nome, String cpf, String email, String telefone, String endereco) {
        setCliente(new ClienteModel(nome,cpf,email,telefone, endereco));
    }
    public ClienteController(){
        setCliente(new ClienteModel());
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    private void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
}
