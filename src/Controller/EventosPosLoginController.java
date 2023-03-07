package Controller;

import Model.EventosPosLogin.ActionsEventos;
import Model.EventosPosLogin.FocusEventos;
import Model.EventosPosLogin.KeyEventos;
import View.DepoisDoLogin.RemoverUsuario;
import View.DepoisDoLogin.SistemaBancoView;

import javax.swing.*;

public class EventosPosLoginController {
    SistemaBancoView telaSistema;
    RemoverUsuario telaRemover;
    JButton button;

    public EventosPosLoginController(SistemaBancoView telaSistema) {
        this.telaSistema = telaSistema;
    }

    public EventosPosLoginController(SistemaBancoView telaSistema, JButton button) {
        this.telaSistema = telaSistema;
        this.button = button;
    }

    public EventosPosLoginController(JButton button) {
        this.button = button;
    }

    public KeyEventos keyEventos(){
        return new KeyEventos(telaSistema);
    }

    public FocusEventos focusEventos(){
        return new FocusEventos( button);
    }

    public ActionsEventos actionsEventos(){
        return new ActionsEventos(telaSistema);
    }
}
