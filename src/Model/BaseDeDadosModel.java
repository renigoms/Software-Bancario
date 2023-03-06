package Model;

import Controller.ClienteController;
import Controller.ContaController;

import java.util.ArrayList;

public class BaseDeDadosModel {

    private static ArrayList<ClienteModel> DadosDoBanco;

    public static void criarBase() {
        DadosDoBanco = new ArrayList<>();

    }

    public static void adicionarCliente(ClienteController cliente) {
        DadosDoBanco.add(cliente.getCliente());

    }

    private static ClienteModel percorrerBanco(ArrayList<ClienteModel> bdBanco, int cont) {
        if (bdBanco.size() != 0 && bdBanco.size() > cont) {
            if (bdBanco.get(cont) != null) {
                return ((ClienteModel) bdBanco.get(cont));
            }
        }
        return null;
    }

    public static ClienteModel buscarClientePorConta(ContaController conta, int cont){
        ClienteModel contaCli = percorrerBanco(DadosDoBanco, cont);
        if (contaCli == null)
            return null;
        if (contaCli.getconta().equals(conta)){
            return contaCli;
        }
        cont++;
        return buscarClientePorConta(conta, cont);
    }

        public static ClienteModel buscarClientePorCpf (String cpf,int cont) {
            ClienteModel cli = percorrerBanco(DadosDoBanco, cont);
            if (cli == null){
                return null;
            }
            if (cli.getCpf().equals(cpf)) {
                return cli;

            }
            cont++;
            return buscarClientePorCpf(cpf, cont);
        }




    public static boolean removerCliente(ClienteModel cliente){
        return DadosDoBanco.remove(cliente);
    }
//    public  static void atualizar(ClienteModel antigo, ClienteModel novo){}



}

