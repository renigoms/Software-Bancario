package View.DepoisDoLogin;

import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;

public class PainelLogo {
    static JLabel imagem;
    static JLabel tituloLabel;
    static JLabel mensagem;
    private static JPanel painelLogo;

    public static JPanel getPainelLogo(LayoutManager layout, int x, int y) {
        setPainelLogo(layout, x, y);
        return painelLogo;
    }

    private static void setPainelLogo(LayoutManager layout, int x, int y) {
        UtilidadesView utilidadesView = new UtilidadesView();
        painelLogo = utilidadesView.getPainel(layout, x, y);
        //        ICONE
        imagem = new JLabel(new ImageIcon("1802328v2.png"));
        imagem.setBounds(95,110,195,168);
        painelLogo.add(imagem);
//        CAIXA DE FERRAMENTAS
        //            LABELS
        tituloLabel = utilidadesView.getLabels("Banco Renan", Color.BLACK,40,237,280,50);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 40));
        painelLogo.add(tituloLabel);
        mensagem = utilidadesView.getLabels("Seu dinheiro rende mais com a gente.",Color.DARK_GRAY,20,278,380,50);
        mensagem.setFont(new Font("Serif",Font.ITALIC, 20));
        painelLogo.add(mensagem);
    }
}
