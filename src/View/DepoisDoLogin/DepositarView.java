package View.DepoisDoLogin;

import Controller.EventosPosLoginController;
import Model.ClienteModel;
import Model.Utilidadesv2;
import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

public class DepositarView {
    private static JPanel painelDepositar;

    static SistemaBancoView sistemaPrincipal;
    static ClienteModel cliente;

    static JLabel controlSaldoLabel, saldoLabel;

    public static JButton depositarButton;

    public static JTextField saldoText;

    public static SistemaBancoView telaSistema;

    static String dispSaldo;

    // VARIÁVEIS DA LOG0TIPO
   static JLabel imagem, tituloLabel, mensagemLabel;

    public static JPanel getPainelDepositar(LayoutManager layout, int x, int y, SistemaBancoView sistemBase,
                                            ClienteModel pegarCliente) {
        cliente = pegarCliente;
        sistemaPrincipal = sistemBase;
        setPainelDepositar(layout, x, y);
        return painelDepositar;
    }

    private static void setPainelDepositar(LayoutManager layout, int x, int y) {
        //  CONSTRUÇÃO INICIAL
        UtilidadesView caixaDeFerramentas = new UtilidadesView();
        painelDepositar = caixaDeFerramentas.getPainel(layout, x, y);
        painelDepositar.addMouseListener(new EventosMouse());

        // LOGO PADRÃO DO BANCO
        // IMAGEM
        imagem = new JLabel(new ImageIcon("1802328v3.png"));
        imagem.setBounds(20,0,195,72);
        painelDepositar.add(imagem);
        // TITULO
        tituloLabel = caixaDeFerramentas.getLabels("Banco Renan", Color.BLACK,110,15,280,50);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 32));
        painelDepositar.add(tituloLabel);
        // MENSAGEM
        mensagemLabel = caixaDeFerramentas.getLabels("Fazer Deposito.",Color.DARK_GRAY,110,38,280,50);
        mensagemLabel.setFont(new Font("Serif",Font.ITALIC, 16));
        painelDepositar.add(mensagemLabel);

//       MENSAGEM DE CONTROLE DE SALDO

        dispSaldo = "<html>Saldo disponível para ser sacado:<br><center>R$ %s</center></html>".formatted(cliente.getconta().getSaldo());
        controlSaldoLabel = caixaDeFerramentas.getLabels(dispSaldo, Color.blue, 50,80,250,100);
        controlSaldoLabel.setFont(new Font("Dialog",Font.BOLD, 14));
        painelDepositar.add(controlSaldoLabel);

//        ÁREA DE INPUTS
        saldoLabel = caixaDeFerramentas.getLabels("Valor", null,105,160,90,90);
        saldoLabel.setFont(new Font("Serif", Font.PLAIN, 23));
        painelDepositar.add(saldoLabel);
        saldoText = caixaDeFerramentas.getTextField(5,165,195,90,25);
        saldoText.addKeyListener(new EventosKey());
        saldoText.addMouseListener(new EventosMouse());
        painelDepositar.add(saldoText);

//        BOTÃO SACAR

        depositarButton = new JButton("Depositar");
        depositarButton.setBounds(130,265,100,30);
        depositarButton.setFont(new Font("Serif", Font.BOLD, 16));
        depositarButton.addFocusListener(new EventosPosLoginController(depositarButton).focusEventos());
        depositarButton.addKeyListener(new EventosKey());
        depositarButton.addMouseListener(new EventosMouse());
        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (saldoText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Você não disse o quanto quer depositar!", "Aviso"
                            , JOptionPane.WARNING_MESSAGE);
                }else{
                    double saldoConvert = Double.parseDouble(saldoText.getText());
                    cliente.getconta().depositar(saldoConvert);
                    JOptionPane.showMessageDialog(null, "O valor de R$ %s foi depositado com sucesso."
                            .formatted(saldoText.getText()), "Informação",JOptionPane.INFORMATION_MESSAGE);
                    sistemaPrincipal.dispose();
                    try {
                        new SistemaBancoView(cliente, sistemaPrincipal.primeBW);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }

                }

            }
        });
//        AÇÃO SHOW
        painelDepositar.add(depositarButton);
//         IMAGEM DECORATIVA
        JLabel imagemDePorquinho = new JLabel(new ImageIcon("download.png"));
        imagemDePorquinho.setBounds(115, 330, 120, 120);
        painelDepositar.add(imagemDePorquinho);
    }

//    TRATAMENTO DE EVENTO DAS AÇÕES DO TECLADO

    public static class EventosKey extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                Utilidadesv2.darUmCLick(depositarButton, depositarButton);
                Utilidadesv2.passarFocu(saldoText, depositarButton);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP){
                Utilidadesv2.passarFocu(depositarButton, saldoText);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN){
                Utilidadesv2.passarFocu(saldoText, depositarButton);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                Utilidadesv2.passarFocu(depositarButton, sistemaPrincipal.adicionarButton);
            }
        }
    }

//    EVENTOS COM O MOUSE

    public static class EventosMouse extends MouseAdapter{
        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == painelDepositar){
                saldoText.requestFocus();
            }
            if (e.getSource() == depositarButton){
                depositarButton.setForeground(Color.black);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == depositarButton){
                depositarButton.setForeground(Color.RED);
            }
        }
    }
}
