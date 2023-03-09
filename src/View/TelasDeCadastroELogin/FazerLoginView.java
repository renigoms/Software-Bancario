package View.TelasDeCadastroELogin;

import Controller.DadosController;
import Controller.EventosController;

import Controller.EventosPosLoginController;
import Model.BaseDeDadosModel;
import View.TelaView;
import View.UtilidadesView;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;


public class FazerLoginView extends TelaView {
//    Atributos
    public JFormattedTextField loginText;
    public JPasswordField senhaText;
    JLabel loginLabel,senhaLabel, tituloLabel, imagem, mensagem;
    public JLabel campVazio;
    public JButton entrarButton, sairButton,cadastrarButton;
    UtilidadesView sintoBatmam;




    public FazerLoginView() throws ParseException {
//      ESTRUTURA
        setSize(370,280);
        setTitle("Login");
//        Abrir Base
        DadosController.crearBase();
        sintoBatmam = new UtilidadesView();
//        getPainel2()
        setPainel2(null, 350,100);

//        COMPONENTES DO getPainel2()

//        LABELS

        loginLabel = sintoBatmam.getLabels("Login ",null,78,10,45,20);
        loginLabel.setFont(new Font("Serif",Font.PLAIN, 16));
        senhaLabel = sintoBatmam.getLabels("Senha ",null,76 ,52,45,20);
        senhaLabel.setFont(new Font("Serif",Font.PLAIN, 16));


        //        TEXTfIELD
        loginText = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        loginText.requestFocus();
        loginText.addKeyListener(new EventosController(this, null, null).eventoLogin());
        loginText.addMouseListener(new EventosMouse());
        loginText.setColumns(30);
        loginText.setBounds(120,8,160,25);

        senhaText = new JPasswordField(10);
        senhaText.setBounds(120,50,160,25);
        senhaText.addKeyListener(new EventosController(this, null, null).eventoLogin());
//        ADIÇÕES
        getPainel2().add(loginLabel);
        getPainel2().add(loginText);
        getPainel2().add(senhaLabel);
        getPainel2().add(senhaText);
//        MENSAGEM DE CAMPO VAZIO
        campVazio = sintoBatmam.getLabels("Campos vazios detectados.", Color.RED, false,
                120, 15, 190,50);
        getPainel2().add(campVazio);

//        getPainel1()
        setPainel1(null, 511,82);
//        ICONE
        imagem = new JLabel(new ImageIcon("1802328v3.png"));
        imagem.setBounds(20,0,195,72);
        getPainel1().add(imagem);
//            LABELS
        tituloLabel = sintoBatmam.getLabels("Banco Renan",Color.BLACK,110,15,280,50);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 32));
        getPainel1().add(tituloLabel);
        mensagem = sintoBatmam.getLabels("Seu dinheiro rende mais com a gente.",Color.DARK_GRAY,90,38,280,50);
        mensagem.setFont(new Font("Serif",Font.ITALIC, 16));
        getPainel1().add(mensagem);



//        getPainel3()
        setPainel3(new FlowLayout(), 200,50);
        sairButton = new JButton("Sair");
        sairButton.addMouseListener(new EventosMouse());
        sairButton.setForeground(Color.black);
        sairButton.addActionListener(new EventosController(this, null, null).eventoLogin());
        sairButton.addMouseListener(new EventosController(sairButton).eventosMouse());
        sairButton.addKeyListener(new EventosController(this, null, null).eventoLogin());
        sairButton.addFocusListener(new EventosPosLoginController(sairButton).focusEventos());
        getPainel3().add(sairButton);
        cadastrarButton = new JButton("Criar nova conta");
        cadastrarButton.setForeground(Color.black);
        cadastrarButton.addMouseListener(new EventosMouse());
        cadastrarButton.addKeyListener(new EventosController(this, null, null).eventoLogin());
        cadastrarButton.addMouseListener(new EventosController(cadastrarButton).eventosMouse());
        cadastrarButton.addActionListener(new EventosController(this, null, null).eventoLogin());
        cadastrarButton.addFocusListener(new EventosPosLoginController(cadastrarButton).focusEventos());
        getPainel3().add(cadastrarButton);

        entrarButton = new JButton("Entrar");
        entrarButton.setForeground(Color.black);
        entrarButton.addKeyListener(new EventosController(this, null, null).eventoLogin());
        entrarButton.addActionListener(new EventosController(this, null, null).eventoLogin());
        entrarButton.addFocusListener(new EventosPosLoginController(entrarButton).focusEventos());
        entrarButton.addMouseListener(new EventosController(entrarButton).eventosMouse());
        getPainel3().add(entrarButton);
        setVisible(true);
    }

    private class EventosMouse extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == loginText){
                loginText.requestFocus();
            }
        }


    }
}
