import Controller.ClienteController;
import Controller.DadosController;
import Model.ClienteModel;
import Model.ContaModel;
import View.DepoisDoLogin.ExibirConta;
import View.DepoisDoLogin.SistemaBancoView;
import View.TelasDeCadastroELogin.CadastrarConta;
import View.TelasDeCadastroELogin.FazerLoginView;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        ContaModel conta = new ContaModel(
        "31311", "78877", "sfsdfds", 1.0);
        ClienteController cliente = new ClienteController(
                "dfsfs","111.111.111-11", "665223", "5564560", "dgdfg"
        );
        cliente.getCliente().setconta(conta);
        new FazerLoginView();
        DadosController.crearBase();
        DadosController.adcionarCliente(
                cliente
        );

    }
}