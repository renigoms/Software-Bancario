package Model.EventosPosLogin;

import View.DepoisDoLogin.SistemaBancoView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FocusEventos extends FocusAdapter {
    SistemaBancoView telaSistema;
    JButton button;

    public FocusEventos(SistemaBancoView telaSistema, JButton button) {
        this.telaSistema = telaSistema;
        this.button = button;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == button){
            button.setForeground(Color.RED);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == button){
            button.setForeground(Color.DARK_GRAY);
        }
    }
}
