package Model.Eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventosMouse extends MouseAdapter {

    private JButton botaoUsado;

    public EventosMouse(JButton botaoUsado) {
        this.botaoUsado = botaoUsado;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (botaoUsado.equals(source)) {
            botaoUsado.setForeground(Color.RED);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if (botaoUsado.equals(source)) {
            botaoUsado.setForeground(Color.black);
        }
    }
}
