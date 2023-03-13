package View.DepoisDoLogin;

import Controller.EventosPosLoginController;
import Model.ClienteModel;
import Model.Utilidadesv2;
import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

public class SacarView {

    public static SistemaBancoView telaSistema;

    private static JPanel painelSacar;

    static String dispSaldo;

    static  JLabel imagem, tituloLabel, mensagem, saldoLabel, dispSaldoLabel, imagemDecorativa;

    public static JTextField saldoText;

    public static JButton sacarButton;

    static ClienteModel cliente;

    public static JPanel getPainelSacar(LayoutManager layout,int x, int y, ClienteModel cli, SistemaBancoView sistema) {
        telaSistema = sistema;
        cliente = cli;
        setPainelSacar(layout,x,y);
        return painelSacar;
    }

    private static void setPainelSacar(LayoutManager layout, int x, int y) {
        UtilidadesView utilidades = new UtilidadesView();
        painelSacar = utilidades.getPainel(layout,x,y);
        painelSacar.addMouseListener(new MouseEventos());

//        Logo

        imagem = new JLabel(new ImageIcon("1802328v3.png"));
        imagem.setBounds(20,0,195,72);
        painelSacar.add(imagem);

        //        SALDO DISPONÍVEL PARA SAQUE

        dispSaldo = "<html>Saldo disponível para ser sacado:<br><center>R$ %s</center></html>".formatted(cliente.getconta().getSaldo());
        dispSaldoLabel = utilidades.getLabels(dispSaldo, Color.blue, 50,80,250,100);
        dispSaldoLabel.setFont(new Font("Dialog",Font.BOLD, 14));
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
        saldoLabel = utilidades.getLabels("Saldo", null,105,160,90,90);
        saldoLabel.setFont(new Font("Serif", Font.PLAIN, 23));
        painelSacar.add(saldoLabel);
        saldoText = utilidades.getTextField(5,165,195,90,25);
        saldoText.addKeyListener(new KeyEventos());
        painelSacar.add(saldoText);

//        BOTÃO SACAR

        sacarButton = new JButton("Sacar");
        sacarButton.setBounds(130,265,100,30);
        sacarButton.setFont(new Font("Serif", Font.BOLD, 16));
        sacarButton.addKeyListener(new KeyEventos());
        sacarButton.addMouseListener(new MouseEventos());
        sacarButton.addFocusListener(new EventosPosLoginController(sacarButton).focusEventos());
        sacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (saldoText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Você não disse o quanto quer sacar!", "Aviso"
                    , JOptionPane.WARNING_MESSAGE);
                }else{
                    Double saldoConvert = Double.parseDouble(saldoText.getText());
                    if(cliente.getconta().sacar(saldoConvert)){
                        JOptionPane.showMessageDialog(null, "O valor de R$ %s foi sacado com sucesso."
                                .formatted(saldoText.getText()), "Informação",JOptionPane.INFORMATION_MESSAGE);
                        telaSistema.dispose();
                        try {
                            new SistemaBancoView(cliente);
                        } catch (ParseException ex) {
                            throw new RuntimeException(ex);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Você não possui esse valor em sua conta!!", "ATENÇÃO",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }

            }
        });
        painelSacar.add(sacarButton);

        //        IMAGEM DECORATIVA DE DINHEIRO
        imagemDecorativa = new JLabel(new ImageIcon("2534191.png"));
        imagemDecorativa.setBounds(70,340,165,120);
        painelSacar.add(imagemDecorativa);
    }
    private static class KeyEventos extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                Utilidadesv2.passarFocu(saldoText, sacarButton);
                Utilidadesv2.darUmCLick(sacarButton,sacarButton);
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN){
                Utilidadesv2.passarFocu(saldoText,sacarButton);

            }
            if (e.getKeyCode() == KeyEvent.VK_UP){
                Utilidadesv2.passarFocu(sacarButton,saldoText);
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                Utilidadesv2.passarFocu(sacarButton, telaSistema.sacarButton);
            }

        }
    }

    private static class MouseEventos extends MouseAdapter {
        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == painelSacar){
                saldoText.requestFocus();
            }
            if (e.getSource() == sacarButton){
                sacarButton.setForeground(Color.black);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == sacarButton){
                sacarButton.setForeground(Color.RED);
            }
        }
    }
}
