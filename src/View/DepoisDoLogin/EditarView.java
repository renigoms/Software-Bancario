package View.DepoisDoLogin;

import Controller.DadosController;
import Controller.EventosController;
import Controller.EventosPosLoginController;
import Model.BaseDeDadosModel;
import Model.ClienteModel;
import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class EditarView {
    private static JPanel painelConta;
    private static ClienteModel cliente;

    private static JLabel imagem,mensagem,tituloLabel;

    static JLabel nomeLabel;
    static JLabel cpfLabel;
    static JLabel emailLabel;
    static JLabel enderecoLabel;
    static JLabel telefoneLabel;

    static SistemaBancoView telaSistema;

    static String[] nome;

    public static JTextField nomeText;
    public static JTextField emailText;
    public static JTextField enderecoText;

    public static JFormattedTextField cpfText;
    public static JFormattedTextField telefoneText;

    public static JButton contaButton, mudarSenhaButton;

    public static JPanel getPainelConta(LayoutManager layout, int x, int y, ClienteModel cli, SistemaBancoView sistema) throws ParseException {
        cliente = cli;
        telaSistema = sistema;
        setPainelConta(layout, x, y);
        return painelConta;
    }

    private static void setPainelConta(LayoutManager layout, int x, int y) throws ParseException {
        UtilidadesView utilidadesView = new UtilidadesView();
        painelConta = utilidadesView.getPainel(layout, x, y);

        //        ICONE
        imagem = new JLabel(new ImageIcon("1802328v3.png"));
        imagem.setBounds(20,0,195,72);
        painelConta.add(imagem);
//            LABELS
        tituloLabel = utilidadesView.getLabels("Banco Renan", Color.BLACK,110,15,280,50);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 32));
        painelConta.add(tituloLabel);
        mensagem = utilidadesView.getLabels("Atualize Seus Dados Aqui ",Color.DARK_GRAY,110,38,280,50);
        mensagem.setFont(new Font("Serif",Font.ITALIC, 16));
        painelConta.add(mensagem);
//      UM PEQUENO AVISO
        JLabel aviso = utilidadesView.getLabels("<html><center>O campo que ficar vazio <br> não será alterado.<center></html>",
                Color.red,110,80, 280,50);
        painelConta.add(aviso);

        //        LABELS2

        nome = new String[]{"Nome ", "Cpf ", "Telefone ", "Email ", "Endereço "};
        for (int nomear = 0 ; nomear < 1; nomear++){
//           NOME
            nomeLabel = utilidadesView. getLabels(nome[nomear], null, 50, 125,90,50);
            nomeLabel.setFont(new Font("Serif",Font.PLAIN, 20));
            painelConta.add(nomeLabel);
//            CPF
            cpfLabel = utilidadesView. getLabels(nome[nomear+1], null, 65,175,90,50);
            cpfLabel.setFont(new Font("Serif",Font.PLAIN, 20));
            painelConta.add(cpfLabel);
//            TELEFONE
            telefoneLabel = utilidadesView. getLabels(nome[nomear+2], null, 25,330,90,35);
            telefoneLabel.setFont(new Font("Serif",Font.PLAIN, 20));
            painelConta.add(telefoneLabel);
//            EMAIL
            emailLabel = utilidadesView. getLabels(nome[nomear+3], null, 45,285,90,39);
            emailLabel.setFont(new Font("Serif",Font.PLAIN, 20));
            painelConta.add(emailLabel);
//            ENDEREÇO
            enderecoLabel = utilidadesView. getLabels(nome[nomear+4], null, 20,225,80,50);
            enderecoLabel.setFont(new Font("Serif",Font.PLAIN, 20));
            painelConta.add(enderecoLabel);

            //        Barras de Textos/ inputs
//        TEXTFIELDS
//        NOME
            nomeText = utilidadesView.getTextField(20, 110,140,200,25);
            nomeText.setFont(new Font("Arial", Font.BOLD, 12));
            painelConta.add(nomeText);


//        EMAIL
            emailText = utilidadesView.getTextField(20,110,291,200,25);
            emailText.setFont(new Font("Arial", Font.BOLD, 12));
            painelConta.add(emailText);


//        ENDEREÇO
            enderecoText = utilidadesView.getTextField(20,110,240,200,25);
            enderecoText.setFont(new Font("Arial", Font.BOLD, 12));
            painelConta.add(enderecoText);

//      FORMATTER TEXT
//        CPF
            cpfText = utilidadesView.getTexto("###.###.###-##", 20, 110,188,200,25);
            cpfText.setFont(new Font("Arial", Font.BOLD, 12));
            painelConta.add(cpfText);


//        TELEFONE
            telefoneText = utilidadesView.getTexto("(##)#####-####", 20, 110,335,200,25);
            telefoneText.setFont(new Font("Arial", Font.BOLD, 12));
            painelConta.add(telefoneText);
        }

        //        BOTÃO ATUALIZAR

        contaButton = new JButton("Atualizar dados");
        contaButton.setBounds(110,375,190,35);
        contaButton.addMouseListener(new EventosController(contaButton).eventosMouse());
        contaButton.addFocusListener(new EventosPosLoginController(contaButton).focusEventos());
        contaButton.addKeyListener(new DepositarView.EventosKey());
        contaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                NOME
                String nome;
                if (nomeText.getText().equals("")){
                    nome = cliente.getNome();
                }else{
                    nome = nomeText.getText();
                }
//            CPF
                String cpf;
                if (cpfText.getText().equals("   .   .   -  ")){
                    cpf = cliente.getCpf();
                }else{
                    cpf = cpfText.getText();
                }
//            TELEFONE
                String telefone;
                if(telefoneText.getText().equals("(  )     -    ")){
                    telefone = cliente.getTelefone();
                }else{
                    telefone = telefoneText.getText();
                }
//            EMAIL
                String email;
                if (emailText.getText().equals("")){
                    email = cliente.getEmail();
                }else{
                    email = emailText.getText();
                }
//                Endereço
                String endereco;
                if (enderecoText.getText().equals(""))
                    endereco = cliente.getendereco();
                else
                    endereco = enderecoText.getText();

                ClienteModel clienteDadosAlterados = new ClienteModel(nome, cpf, email, telefone, endereco);

                DadosController.atualizarInformacoes(cliente, clienteDadosAlterados);

                JOptionPane.showMessageDialog(null, "Informações recadastradas com sucesso");

                telaSistema.dispose();
                try {
                    new SistemaBancoView(cliente);
                } catch (FileNotFoundException | ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        painelConta.add(contaButton);

//      BOTÃO MUDAR A SENHA

        mudarSenhaButton = new JButton("Mudar Senha");
        mudarSenhaButton.setBounds(110,420,190,35);
        mudarSenhaButton.addMouseListener(new EventosController(mudarSenhaButton).eventosMouse());
        mudarSenhaButton.addFocusListener(new EventosPosLoginController(mudarSenhaButton).focusEventos());
        mudarSenhaButton.addKeyListener(new DepositarView.EventosKey());
//        AÇÃO DO BOTÃO
        mudarSenhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passWord, confirmarPassWord;

                passWord = JOptionPane.showInputDialog(null, "Qual a nova senha ?");
                confirmarPassWord = JOptionPane.showInputDialog(null, "Confirme a nova senha.");

                if (passWord.equals(confirmarPassWord)) {
                    DadosController.mudarSenha(confirmarPassWord, cliente);
                    JOptionPane.showMessageDialog(null, "Senha mudada com sucesso.",
                            "Informação", JOptionPane.INFORMATION_MESSAGE);
                }else
                    JOptionPane.showMessageDialog(null, "A senha não pode ser alterada, pois" +
                            "a confirmação é diferente.", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            }
        });
        painelConta.add(mudarSenhaButton);
    }


}
