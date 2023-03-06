package Controller;

import Model.ContaModel;

public class ContaController {

    private ContaModel conta;

    public ContaController(String numeroDaConta, String numeroDaAgencia, String tipo, double saldo) {
       setConta(new ContaModel(numeroDaConta,numeroDaAgencia,tipo,saldo));
    }

    public ContaModel getConta() {
        return conta;
    }

    private void setConta(ContaModel conta) {
        this.conta = conta;
    }
}
