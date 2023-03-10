package Model.EventosPosLogin;

import Model.Utilidadesv2;
import View.DepoisDoLogin.ExibirInformacoes;
import View.DepoisDoLogin.RemoverUsuario;
import View.DepoisDoLogin.SacarView;
import View.DepoisDoLogin.SistemaBancoView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEventos extends KeyAdapter {
    SistemaBancoView telaSistema;

    public KeyEventos(SistemaBancoView telaSistema) {
        this.telaSistema = telaSistema;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            Utilidadesv2.darUmCLick(telaSistema.transferirButton, telaSistema.transferirButton);
            Utilidadesv2.darUmCLick(telaSistema.sacarButton, telaSistema.sacarButton);
            Utilidadesv2.darUmCLick(telaSistema.sairButtton, telaSistema.sairButtton);
            Utilidadesv2.darUmCLick(telaSistema.extratoButton, telaSistema.extratoButton);
            Utilidadesv2.darUmCLick(telaSistema.exibirDadosButton, telaSistema.exibirDadosButton);
            Utilidadesv2.darUmCLick(telaSistema.adicionarButton, telaSistema.adicionarButton);
            Utilidadesv2.darUmCLick(telaSistema.removerButton, telaSistema.removerButton);
            Utilidadesv2.darUmCLick(telaSistema.atualizarButton, telaSistema.atualizarButton);
        }
        if (e.getKeyCode() ==  KeyEvent.VK_DOWN){
            Utilidadesv2.passarFocu(telaSistema.atualizarButton, telaSistema.removerButton);
            Utilidadesv2.passarFocu(telaSistema.removerButton, telaSistema.adicionarButton);
            Utilidadesv2.passarFocu(telaSistema.adicionarButton, telaSistema.exibirDadosButton);
            Utilidadesv2.passarFocu(telaSistema.exibirDadosButton, telaSistema.transferirButton);
            Utilidadesv2.passarFocu(telaSistema.transferirButton, telaSistema.extratoButton);
            Utilidadesv2.passarFocu(telaSistema.extratoButton, telaSistema.sacarButton);
            Utilidadesv2.passarFocu(telaSistema.sacarButton, telaSistema.sairButtton);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            Utilidadesv2.passarFocu(telaSistema.sairButtton, telaSistema.sacarButton);
            Utilidadesv2.passarFocu(telaSistema.sacarButton, telaSistema.extratoButton);
            Utilidadesv2.passarFocu(telaSistema.extratoButton, telaSistema.transferirButton);
            Utilidadesv2.passarFocu(telaSistema.transferirButton, telaSistema.exibirDadosButton);
            Utilidadesv2.passarFocu(telaSistema.exibirDadosButton, telaSistema.adicionarButton);
            Utilidadesv2.passarFocu(telaSistema.adicionarButton, telaSistema.removerButton);
            Utilidadesv2.passarFocu(telaSistema.removerButton, telaSistema.atualizarButton);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            Utilidadesv2.passarFocu(telaSistema.removerButton, RemoverUsuario.cancelarButton);
            Utilidadesv2.passarFocu(telaSistema.exibirDadosButton, ExibirInformacoes.contaButton);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            Utilidadesv2.passarFocu(telaSistema.sacarButton, RemoverUsuario.simButton);
            Utilidadesv2.passarFocu(telaSistema.sacarButton, SacarView.saldoText);


        }
    }
}
