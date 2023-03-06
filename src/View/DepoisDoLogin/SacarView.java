package View.DepoisDoLogin;

import Model.ClienteModel;
import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;

public class SacarView {

    public static JPanel painelSacar;

    static String dispSaldo;

    static  JLabel imagem, tituloLabel, mensagem, saldoLabel, dispSaldoLabel;

    static JTextField saldoText;

    static JButton sacarButton;

    static ClienteModel cliente;

    public static JPanel getPainelSacar(LayoutManager layout,int x, int y, ClienteModel cli) {
        cliente = cli;
        setPainelSacar(layout,x,y);
        return painelSacar;
    }

    private static void setPainelSacar(LayoutManager layout,int x, int y) {
        UtilidadesView utilidades = new UtilidadesView();
        painelSacar = utilidades.getPainel(layout,x,y);

//        Logo

        imagem = new JLabel(new ImageIcon("1802328v3.png"));
        imagem.setBounds(20,0,195,72);
        painelSacar.add(imagem);

        //        SALDO DISPONÍVEL PARA SAQUE

        dispSaldo = "Saldo disponível para ser sacado: R$"+ '\t' + cliente.getconta().getSaldo();
        dispSaldoLabel = utilidades.getLabels(dispSaldo, Color.blue, 50,110,250,25);
        dispSaldoLabel.setFont(new Font("Serif",Font.BOLD, 16));
        painelSacar.add(dispSaldoLabel);


        //            LABELS
//        TÍTULO
        tituloLabel = utilidades.getLabels("Banco Renan", Color.BLACK,110,15,280,50);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 32));
        painelSacar.add(tituloLabel);
        mensagem = utilidades.getLabels("Sacar Saldo.",Color.DARK_GRAY,110,38,280,50);
        mensagem.setFont(new Font("Serif",Font.ITALIC, 16));
        painelSacar.add(mensagem);
//      ÁREA DE INPUTS
        saldoLabel = utilidades.getLabels("Saldo", null,80,175,90,90);
        saldoLabel.setFont(new Font("Serif", Font.PLAIN, 23));
        painelSacar.add(saldoLabel);
        saldoText = utilidades.getTextField(5,150,210,90,25);
        painelSacar.add(saldoText);

//        BOTÃO SACAR

        sacarButton = new JButton("Sacar");
        sacarButton.setBounds(105,250,100,30);
        sacarButton.setFont(new Font("Serif", Font.BOLD, 16));
        painelSacar.add(sacarButton);






    }
}
