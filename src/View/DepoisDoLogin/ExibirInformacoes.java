package View.DepoisDoLogin;

import Model.ClienteModel;
import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class ExibirInformacoes {
    private static JPanel painelExibirInformacoes;
    private static  JLabel imagem,mensagem,tituloLabel;

    static JLabel nomeLabel;
    static JLabel cpfLabel;
    static JLabel emailLabel;
    static JLabel enderecoLabel;
    static JLabel telefoneLabel;

    static String[] nome;

    public static JTextField nomeText;
    public static JTextField emailText;
    public static JTextField enderecoText;

    public static JFormattedTextField cpfText;
    public static JFormattedTextField telefoneText;

    public static JButton contaButton;

    public static ClienteModel clienteModel;

    public static SistemaBancoView telaSistema;

    public static JPanel getPainelExibirInformacoes(LayoutManager layout, int x, int y,ClienteModel cl) throws ParseException {
        clienteModel = cl;
        setPainelExibirInformacoes(layout, x, y);
        return painelExibirInformacoes;
    }

    public static JPanel getPainelExibirInformacoes(LayoutManager layout, int x, int y,ClienteModel cl, SistemaBancoView system) throws ParseException {
        clienteModel = cl;
        telaSistema = system;
        setPainelExibirInformacoes(layout, x, y);
        return painelExibirInformacoes;
    }



    public static void setPainelExibirInformacoes(LayoutManager layout, int x, int y) throws ParseException {
        UtilidadesView utilidadesView = new UtilidadesView();
        painelExibirInformacoes = utilidadesView.getPainel(layout, x, y);

        //        ICONE
        imagem = new JLabel(new ImageIcon("1802328v3.png"));
        imagem.setBounds(20,0,195,72);
        painelExibirInformacoes.add(imagem);
//            LABELS
        tituloLabel = utilidadesView.getLabels("Banco Renan",Color.BLACK,110,15,280,50);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 32));
        painelExibirInformacoes.add(tituloLabel);
        mensagem = utilidadesView.getLabels("Informações do Cliente.",Color.DARK_GRAY,110,38,280,50);
        mensagem.setFont(new Font("Serif",Font.ITALIC, 16));
        painelExibirInformacoes.add(mensagem);

//        LABELS

        nome = new String[]{"Nome ", "Cpf ", "Telefone ", "Email ", "Endereço "};
        for (int nomear = 0 ; nomear < 1; nomear++){
//           NOME
            nomeLabel = utilidadesView. getLabels(nome[nomear], null, 50, 105,90,50);
            nomeLabel.setFont(new Font("Serif",Font.PLAIN, 20));
//            CPF
            cpfLabel = utilidadesView. getLabels(nome[nomear+1], null, 65,155,90,50);
            cpfLabel.setFont(new Font("Serif",Font.PLAIN, 20));
//            TELEFONE
            telefoneLabel = utilidadesView. getLabels(nome[nomear+2], null, 25,310,90,35);
            telefoneLabel.setFont(new Font("Serif",Font.PLAIN, 20));
//            EMAIL
            emailLabel = utilidadesView. getLabels(nome[nomear+3], null, 45,265,90,39);
            emailLabel.setFont(new Font("Serif",Font.PLAIN, 20));
//            ENDEREÇO
            enderecoLabel = utilidadesView. getLabels(nome[nomear+4], null, 20,205,80,50);
            enderecoLabel.setFont(new Font("Serif",Font.PLAIN, 20));
        }

//        Barras de Textos/ inputs
//        TEXTFIELDS
//        NOME
        nomeText = utilidadesView.getTextField(20, 110,120,200,25);
        nomeText.setFont(new Font("Arial", Font.BOLD, 12));
        nomeText.setEditable(false);
        //        getnome
        nomeText.setText(clienteModel.getNome());

//        EMAIL
        emailText = utilidadesView.getTextField(20,110,271,200,25);
        emailText.setFont(new Font("Arial", Font.BOLD, 12));
        emailText.setEditable(false);
//        getEmail
        emailText.setText(clienteModel.getEmail());

//        ENDEREÇO
        enderecoText = utilidadesView.getTextField(20,110,220,200,25);
        enderecoText.setFont(new Font("Arial", Font.BOLD, 12));
        enderecoText.setEditable(false);
//        getEndereco
        enderecoText.setText(clienteModel.getendereco());
//      FORMATTER TEXT
//        CPF
        cpfText = utilidadesView.getTexto("###.###.###-##", 20, 110,168,200,25);
        cpfText.setFont(new Font("Arial", Font.BOLD, 12));
        cpfText.setEditable(false);
//        getCpf
        cpfText.setText(clienteModel.getCpf());

//        TELEFONE
        telefoneText = utilidadesView.getTexto("(##)#####-####", 20, 110,315,200,25);
        telefoneText.setFont(new Font("Arial", Font.BOLD, 12));
        telefoneText.setEditable(false);
//        getTelefone
        telefoneText.setText(clienteModel.getTelefone());

//        BOTÃO CONTA

        contaButton = new JButton("Informações da Conta");
        contaButton.setBounds(110,370,190,35);
        contaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c1 = (CardLayout) telaSistema.cardMenstre.getLayout();
                c1.show(telaSistema.cardMenstre, "exibirConta");

            }
        });

//        ADICIONANDO COMPONENTES

        painelExibirInformacoes.add(nomeLabel);
        painelExibirInformacoes.add(nomeText);
        painelExibirInformacoes.add(cpfLabel);
        painelExibirInformacoes.add(cpfText);
        painelExibirInformacoes.add(enderecoLabel);
        painelExibirInformacoes.add(enderecoText);
        painelExibirInformacoes.add(emailLabel);
        painelExibirInformacoes.add(emailText);
        painelExibirInformacoes.add(telefoneLabel);
        painelExibirInformacoes.add(telefoneText);
        painelExibirInformacoes.add(contaButton);

    }
}
