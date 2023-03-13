package Model.EventosPosLogin;

import View.DepoisDoLogin.RemoverUsuario;
import View.DepoisDoLogin.SistemaBancoView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionsEventos implements ActionListener {
    SistemaBancoView telaSistema;



    public ActionsEventos(SistemaBancoView telaSistema) {
        this.telaSistema = telaSistema;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        BOTÃO SAIR
        if (e.getSource() ==  telaSistema.sairButtton){
            telaSistema.dispose();
        }
//        BOTÃO EXIBIR
        if (e.getSource() == telaSistema.exibirDadosButton){
            CardLayout c1 = (CardLayout) telaSistema.cardMenstre.getLayout();
            c1.show(telaSistema.cardMenstre, "exibirInfo");

        }
//        BOTÃO REMOVER

        if (e.getSource() == telaSistema.removerButton){
            CardLayout c1 = (CardLayout) telaSistema.cardMenstre.getLayout();
            c1.show(telaSistema.cardMenstre, "remover");
            RemoverUsuario.simButton.requestFocus();
        }

//        BOTÃO SACAR

        if(e.getSource() == telaSistema.sacarButton){
            CardLayout c1 = (CardLayout) telaSistema.cardMenstre.getLayout();
            c1.show(telaSistema.cardMenstre, "sacar");
        }

//        BOTÃO DEPOSITAR

        if (e.getSource() == telaSistema.adicionarButton){
            CardLayout c1 = (CardLayout) telaSistema.cardMenstre.getLayout();
            c1.show(telaSistema.cardMenstre, "depositar");
        }


    }
}
