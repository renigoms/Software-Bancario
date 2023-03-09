package View.TelasDeCadastroELogin;

import Controller.EventosController;
import Controller.EventosPosLoginController;
import Model.Eventos.EventosMouse;
import Model.EventosPosLogin.FocusEventos;
import View.TelaView;
import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class CadastrarCliente extends TelaView {

    JLabel nomeLabel,cpfLabel, emailLabel, enderecoLabel,telefoneLabel, imagem, tituloLabel,mensagem;
    public JLabel campVazio;
    public JTextField nomeText,emailText, enderecoText;
    public JFormattedTextField cpfText, telefoneText;
    public JButton salvarButton, cancelarButton;
    UtilidadesView caixaDeFerramentas;
    String[] nome;

    public CadastrarCliente() throws ParseException {
//        ESTRUTURA
        setSize(511,511);
        setTitle("Cadastro de Cliente");
//        CAIXA DE CÓDIGOS PRONTOS
        caixaDeFerramentas = new UtilidadesView();
//        Painel1
        setPainel1(null, 511,82);
//        ICONE
        imagem = new JLabel(new ImageIcon("1802328v3.png"));
        imagem.setBounds(35,0,195,72);
        getPainel1().add(imagem);
//            LABELS
        tituloLabel = caixaDeFerramentas.getLabels("Banco Renan",Color.BLACK,168,15,280,50);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 32));
        getPainel1().add(tituloLabel);
        mensagem = caixaDeFerramentas.getLabels("Seu dinheiro rende mais com a gente.",Color.DARK_GRAY,150,38,280,50);
        mensagem.setFont(new Font("Serif",Font.ITALIC, 16));
        getPainel1().add(mensagem);

//        Painel2
        setPainel2(null, 511,50);
//        LABELS
        nome = new String[]{"Nome ", "Cpf ", "Telefone ", "Email ", "Endereço "};
        for (int nomear = 0 ; nomear < 1; nomear++){
//           NOME
            nomeLabel = caixaDeFerramentas. getLabels(nome[nomear], null, 45, 10,90,50);
            nomeLabel.setFont(new Font("Serif",Font.PLAIN, 20));
//            CPF
            cpfLabel = caixaDeFerramentas. getLabels(nome[nomear+1], null, 62,65,90,50);
            cpfLabel.setFont(new Font("Serif",Font.PLAIN, 20));
//            TELEFONE
            telefoneLabel = caixaDeFerramentas. getLabels(nome[nomear+2], null, 21,225,90,35);
            telefoneLabel.setFont(new Font("Serif",Font.PLAIN, 20));
//            EMAIL
            emailLabel = caixaDeFerramentas. getLabels(nome[nomear+3], null, 45,170,90,39);
            emailLabel.setFont(new Font("Serif",Font.PLAIN, 20));
//            ENDEREÇO
            enderecoLabel = caixaDeFerramentas. getLabels(nome[nomear+4], null, 17,115,90,50);
            enderecoLabel.setFont(new Font("Serif",Font.PLAIN, 20));
        }

//        Barras de Textos/ inputs
//        TEXTFIELDS
//        NOME
        nomeText = caixaDeFerramentas.getTextField(20, 105,25,320,25);
        nomeText.addKeyListener(new EventosController(null,this,null).eventoCliente());
//        EMAIL
        emailText = caixaDeFerramentas.getTextField(20,105,181,320,25);
        emailText.addKeyListener(new EventosController(null,this,null).eventoCliente());
//        ENDEREÇO
        enderecoText = caixaDeFerramentas.getTextField(20,105,130,320,25);
        enderecoText.addKeyListener(new EventosController(null,this,null).eventoCliente());
//      FORMATTER TEXT
//        CPF
        cpfText = caixaDeFerramentas.getTexto("###.###.###-##", 20, 105,78,320,25);
        cpfText.addKeyListener(new EventosController(null,this,null).eventoCliente());
//        TELEFONE
        telefoneText = caixaDeFerramentas.getTexto("(##)#####-####", 20, 105,231,320,25);
        telefoneText.addKeyListener(new EventosController(null,this,null).eventoCliente());

//        ADIÇOES
        getPainel2().add(nomeLabel);
        getPainel2().add(nomeText);
        getPainel2().add(cpfLabel);
        getPainel2().add(cpfText);
        getPainel2().add(enderecoLabel);
        getPainel2().add(enderecoText);
        getPainel2().add(emailLabel);
        getPainel2().add(emailText);
        getPainel2().add(telefoneLabel);
        getPainel2().add(telefoneText);
        //        MENSAGEM DE CAMPO VAZIO
        campVazio = caixaDeFerramentas.getLabels("Campos vazios detectados!", Color.RED, false,
                105, 250, 290,50);
        campVazio.setFont(new Font("Serif",Font.PLAIN, 22));
        getPainel2().add(campVazio);

//        Painel3

        setPainel3(new FlowLayout(), 511,70);
//        espasamento
        JLabel teste = new JLabel("      ");
        getPainel3().add(teste);
//        botoes

        cancelarButton = new JButton("Cancelar");
        cancelarButton.setPreferredSize(new Dimension(140,30));
        cancelarButton.addActionListener(new EventosController(null, this, null).eventoCliente());
        cancelarButton.addKeyListener(new EventosController(null,this,null).eventoCliente());
        cancelarButton.addFocusListener(new EventosPosLoginController(cancelarButton).focusEventos());
        cancelarButton.addMouseListener(new EventosController(cancelarButton).eventosMouse());
        getPainel3().add(cancelarButton);
        salvarButton = new JButton("Próximo");
        salvarButton.setPreferredSize(new Dimension(140,30));
        salvarButton.addActionListener(new EventosController(null, this, null).eventoCliente());
        salvarButton.addKeyListener(new EventosController(null,this,null).eventoCliente());
        salvarButton.addFocusListener(new EventosPosLoginController(salvarButton).focusEventos());
        salvarButton.addMouseListener(new EventosController(salvarButton).eventosMouse());
        getPainel3().add(salvarButton);
//      SHOW
        setVisible(true);




    }



}
