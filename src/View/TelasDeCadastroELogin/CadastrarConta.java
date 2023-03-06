package View.TelasDeCadastroELogin;

import Controller.ClienteController;
import Controller.EventosController;
import View.TelaView;
import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class CadastrarConta extends TelaView {
    JLabel imagem;
    JLabel tituloLabel;
    JLabel mensagem;
    JLabel numContaLabel;
    JLabel numAgenciaLabel;
    JLabel tipoLabel;
    public JLabel saldoVazio;
    JLabel saldoLabel;
    public JFormattedTextField numContaText, numAgenciaText;
    public JComboBox <String> tipoBox;
    public JTextField saldoText;
    String[] nomes, tipos;
    UtilidadesView caixaDeFerramentas;
    public JButton salvarButton,cancelarButton;

    private ClienteController cliente;
    private CadastrarCliente telaCliente;
    public CadastrarConta(ClienteController cliente, CadastrarCliente telaCliente) throws ParseException {
        this.cliente = cliente;
        this.telaCliente = telaCliente;
//        DEFINIÇÕES
        setTitle("Cadastro da Conta");
        setSize(440,280);
        addWindowListener(new EventosController(null,null,this).windowsEventos());

//        PAINEL1
        setPainel1(null, 400,88);
        //        ICONE
        imagem = new JLabel(new ImageIcon("1802328v3.png"));
        imagem.setBounds(20,0,195,72);
        getPainel1().add(imagem);
//        CAIXA DE FERRAMENTAS
        caixaDeFerramentas = new UtilidadesView();
        //            LABELS
        tituloLabel = caixaDeFerramentas.getLabels("Banco Renan", Color.BLACK,120,15,280,50);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 32));
        getPainel1().add(tituloLabel);
        mensagem = caixaDeFerramentas.getLabels("Seu dinheiro rende mais com a gente.",Color.DARK_GRAY,105,38,280,50);
        mensagem.setFont(new Font("Serif",Font.ITALIC, 16));
        getPainel1().add(mensagem);
//        PAINEL2
        setPainel2(new FlowLayout(), 400, 200);
//        LABELS
        nomes = new String[]{"Número da Conta", "Número da Agência", "Tipo de Conta", "Saldo Inicial"};
        for (int i = 0; i < 1; i++){
            numContaLabel = caixaDeFerramentas.getLabels(nomes[i], null);
            numAgenciaLabel = caixaDeFerramentas.getLabels(nomes[i+1], null);
            tipoLabel = caixaDeFerramentas.getLabels(nomes[i+2], null);
            saldoLabel = caixaDeFerramentas.getLabels(nomes[i+3], null);
        }
//        ÁREAS DE INPUTS
        numContaText = caixaDeFerramentas.getTexto("#####-#",5);
        numContaText.setEditable(false);
//        numContaText.addKeyListener(new EventosController(null,null,this).eventoConta());
        numAgenciaText = caixaDeFerramentas.getTexto("####-#", 5);
        numAgenciaText.setEditable(false);
//        numAgenciaText.addKeyListener(new EventosController(null,null,this).eventoConta());
        saldoText = caixaDeFerramentas.getTextField(10);
        saldoText.addKeyListener(new EventosController(null,null,this).eventoConta());
//        tipoBox
        tipos = new String[]{"Corrente", "Poupança"};
        tipoBox = new JComboBox<>(tipos);
        tipoBox.addKeyListener(new EventosController(null,null,this).eventoConta());
//        ADIÇÕES
        getPainel2().add(numContaLabel);
        getPainel2().add(numContaText);
        getPainel2().add(numAgenciaLabel);
        getPainel2().add(numAgenciaText);
        getPainel2().add(tipoLabel);
        getPainel2().add(tipoBox);
        getPainel2().add(saldoLabel);
        getPainel2().add(saldoText);
        saldoVazio = caixaDeFerramentas.getLabels("É necessário um saldo inicial para abrir uma conta!",
                Color.RED, false);
        getPainel2().add(saldoVazio);

//        PAINEL3
        setPainel3(new FlowLayout(), 511,70);
//        espasamento
        JLabel espasamento = new JLabel("      ");
        getPainel3().add(espasamento);
//        botoes

        cancelarButton = new JButton("Cancelar");
        cancelarButton.setPreferredSize(new Dimension(140,30));
        cancelarButton.addActionListener(new EventosController(null, null, this).eventoConta());
        cancelarButton.addKeyListener(new EventosController(null,null,this).eventoConta());
        getPainel3().add(cancelarButton);
        salvarButton = new JButton("Salvar");
        salvarButton.setPreferredSize(new Dimension(140,30));
        salvarButton.addActionListener(new EventosController(null, telaCliente, this,cliente).eventoConta());
        salvarButton.addKeyListener(new EventosController(null,null,this).eventoConta());
        getPainel3().add(salvarButton);
//      SHOW
        setVisible(true);
    }
}
