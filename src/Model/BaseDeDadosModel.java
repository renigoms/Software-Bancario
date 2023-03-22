package Model;

import Controller.ClienteController;
import Controller.ContaController;
import Controller.DadosController;

import java.util.ArrayList;

public class BaseDeDadosModel {

    private static ArrayList<ClienteModel> DadosDoBanco;

    public static void criarBase() {
        DadosDoBanco = new ArrayList<>();
        inicializacaoTeste();

    }

    private static void inicializacaoTeste(){
        // CRIAR CONTA
        ContaController conta = new ContaController("12345-6", "1234-5", "Poupança",
                1000.0);
        // CRIAR CLIENTE
        ClienteController cliente = new ClienteController("TesteDePrograma", "111.111.111-11", "teste.doPrograma@teste.com",
                "(99)99999-9999", "Rua testando esse a aplicação.");
        cliente.getCliente().setconta(conta.getConta());
//        ADICIONANDO A BASE
        DadosController.adcionarCliente(cliente);
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

    public static boolean transferir(ClienteModel conta1, ClienteModel conta2, double valor){
        return conta1.getconta().sacar(valor) && conta2.getconta().depositar(valor);

    }
//    public  static void atualizar(ClienteModel antigo, ClienteModel novo){}



}

