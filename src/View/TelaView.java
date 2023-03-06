package View;



import javax.swing.*;
import java.awt.*;

public abstract class TelaView extends JFrame {
    private JPanel painel1, painel2, painel3;
    public TelaView(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(500, 100);
        setLayout(new BorderLayout());



    }

    public void setPainel1(LayoutManager layout, int x, int y) {
        UtilidadesView utilidadesView = new UtilidadesView();
        this.painel1 = utilidadesView.getPainel(layout, x, y);
        add(painel1, BorderLayout.NORTH);
    }
    public void setPainel1_0(LayoutManager layout, int x, int y) {
        UtilidadesView utilidadesView = new UtilidadesView();
        this.painel1 = utilidadesView.getPainel(layout, x, y);
        add(painel1, BorderLayout.WEST);
    }

    public JPanel getPainel1() {
        return painel1;
    }

    public void setPainel2(LayoutManager layout, int x, int y) {
        UtilidadesView utilidadesView = new UtilidadesView();
        this.painel2 = utilidadesView.getPainel(layout, x, y);
        add(painel2, BorderLayout.CENTER);
    }

    public JPanel getPainel2() {
        return painel2;
    }

    public void setPainel3(LayoutManager layout, int x, int y) {
        UtilidadesView utilidadesView = new UtilidadesView();
        painel3 = utilidadesView.getPainel(layout, x, y);
        add(painel3, BorderLayout.SOUTH);
    }
    public void setPainel3_0(LayoutManager layout, int x, int y) {
        UtilidadesView utilidadesView = new UtilidadesView();
        painel3 = utilidadesView.getPainel(layout, x, y);
        add(painel3, BorderLayout.EAST);
    }

    public JPanel getPainel3() {
        return painel3;
    }
}
