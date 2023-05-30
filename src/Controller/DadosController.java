package Controller;

import Model.BaseDeDadosModel;
import Model.ClienteModel;

public class DadosController {


    public static void crearBase() {
        BaseDeDadosModel.criarBase();
    }
    public static void adcionarCliente(ClienteController cliente){
        BaseDeDadosModel.adicionarCliente(cliente);
    }
    public  static  ClienteModel buscar(String cpf){
        return BaseDeDadosModel.buscarClientePorCpf(cpf,0);
    }
    public static boolean removerUsuario(ClienteModel cliente){
        return BaseDeDadosModel.removerCliente(cliente);
    }
    public static boolean atualizarInformacoes(ClienteModel clienteAntigo, ClienteModel clienteNovo){
        return BaseDeDadosModel.atualizar(clienteAntigo, clienteNovo);
    }

    public static boolean mudarSenha(String novaSenha, ClienteModel cliente){
        return BaseDeDadosModel.mudarSenha(cliente, novaSenha);
    }
}
