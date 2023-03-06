package Model.Eventos;

import View.TelasDeCadastroELogin.CadastrarConta;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.SecureRandom;

public class EventosWindows extends WindowAdapter {
    private CadastrarConta conta;

    public EventosWindows(CadastrarConta conta) {
        this.conta = conta;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        int num = new SecureRandom().nextInt(100000, 999999);
        conta.numContaText.setText(String.valueOf(num));
        int num2 = new SecureRandom().nextInt(10000, 99999);
        conta.numAgenciaText.setText(String.valueOf(num2));
        conta.tipoBox.requestFocus();
    }
}
