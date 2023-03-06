package View.DepoisDoLogin;

import Controller.DadosController;
import Model.ClienteModel;
import Model.Utilidadesv2;
import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

public class RemoverUsuario{
    private static JPanel painelRemover;

    private static JLabel imagem,mensagem,tituloLabel, querRemover;

    public static ClienteModel cliente;

    public static JButton simButton, cancelarButton;

    public static SistemaBancoView sistemaBancoView;



    public static JPanel getPainelRemover(LayoutManager layout, int x, int y, ClienteModel cli, SistemaBancoView telaSitema) throws ParseException {
        cliente = cli;
        setPainelRemover(layout, x, y);
        sistemaBancoView = telaSitema;
        return painelRemover;
    }
    //        EVENTO KEYADAPTER
    static class EventoKeyRemover extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                Utilidadesv2.darUmCLick(simButton,simButton);
                Utilidadesv2.darUmCLick(cancelarButton,cancelarButton);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                Utilidadesv2.passarFocu(cancelarButton, simButton);
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                Utilidadesv2.passarFocu(simButton, cancelarButton);
            }
        }
    }

    private static void setPainelRemover(LayoutManager layout, int x, int y) throws ParseException {
        UtilidadesView utilidadesView = new UtilidadesView();
        painelRemover = utilidadesView.getPainel(layout, x, y);

        //        ICONE
        imagem = new JLabel(new ImageIcon("1802328v3.png"));
        imagem.setBounds(20,0,195,72);
        painelRemover.add(imagem);
//            LABELS
        tituloLabel = utilidadesView.getLabels("Banco Renan", Color.BLACK,110,15,280,50);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 32));
        painelRemover.add(tituloLabel);
        mensagem = utilidadesView.getLabels("Remover Usuário.",Color.DARK_GRAY,110,38,280,50);
        mensagem.setFont(new Font("Serif",Font.ITALIC, 16));
        painelRemover.add(mensagem);
        querRemover = utilidadesView.getLabels("Quer remover essa conta ?", Color.BLACK,30,160,300,50);
        querRemover.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));
        painelRemover.add(querRemover);
//        JBUTTONS
        simButton = new JButton("Excluir");
        simButton.setBounds(170,220,90,30);
//        TRATAMENTO DE EVENTO
        simButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senha = JOptionPane.showInputDialog(null,"Confirme sua senha","Validação", JOptionPane.INFORMATION_MESSAGE);
                if (cliente.getSenha().equals(senha)){
                    DadosController.removerUsuario(cliente);
                    JOptionPane.showMessageDialog(null, "Conta  e usuário(a) removidos com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    sistemaBancoView.dispose();

                }else{
                    if (!(senha == null))
                        JOptionPane.showMessageDialog(null, "SENHA ERRADA!!", "AVISO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        simButton.addKeyListener(new EventoKeyRemover());
        painelRemover.add(simButton);
        cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(70,220,90,30);
        //        TRATAMENTO DE EVENTO
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c1 = (CardLayout) sistemaBancoView.cardMenstre.getLayout();
                c1.show(sistemaBancoView.cardMenstre, "logo");
            }
        });
        cancelarButton.addKeyListener(new EventoKeyRemover());
        painelRemover.add(cancelarButton);




    }
}
