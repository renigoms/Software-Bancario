package View.DepoisDoLogin;

import Controller.EventosController;
import Model.ClienteModel;
import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class ExibirConta {

    private static JPanel painelConta;

    private static JLabel imagem,mensagem,tituloLabel, numContaLabel,
    numAgenciaLabel, tipoLabel, saldoLabel;

    private static String[] nomes;

    public static JFormattedTextField numContaText, numAgenciaText;

    public static ClienteModel cliente;

    public static JTextField saldoText, tipoText;



    public static JPanel getPainelConta(LayoutManager layout, int x, int y,ClienteModel cli) throws ParseException {
        cliente = cli;
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
        mensagem = utilidadesView.getLabels("Informações da Conta.",Color.DARK_GRAY,110,38,280,50);
        mensagem.setFont(new Font("Serif",Font.ITALIC, 16));
        painelConta.add(mensagem);

//        LABELS : ATRIBUIÇÃO DE NOMES

        nomes = new String[]{"Número da Conta", "Número da Agência", "Tipo de Conta", "Saldo"};
        for (int i = 0; i < 1; i++){
            numContaLabel = utilidadesView.getLabels(nomes[i], null, 45,97,150,90);
            numContaLabel.setFont(new Font("Serif",Font.CENTER_BASELINE, 18));
            numAgenciaLabel = utilidadesView.getLabels(nomes[i+1], null,30,147,190,90);
            numAgenciaLabel.setFont(new Font("Serif",Font.CENTER_BASELINE, 18));
            tipoLabel = utilidadesView.getLabels(nomes[i+2], null,75,197,150,90);
            tipoLabel.setFont(new Font("Serif",Font.CENTER_BASELINE, 18));
            saldoLabel = utilidadesView.getLabels(nomes[i+3], null,145,247,90,90);
            saldoLabel.setFont(new Font("Serif",Font.CENTER_BASELINE, 18));
        }
//        ÁREAS DE INPUTS
        numContaText = utilidadesView.getTexto("#####-#",12, 200,130,120,30);
        numContaText.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        numContaText.setEditable(false);
        numContaText.setText(cliente.getconta().getNumeroDaConta());
        numAgenciaText = utilidadesView.getTexto("####-#", 12, 200,180,120,30);
        numAgenciaText.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        numAgenciaText.setEditable(false);
        numAgenciaText.setText(cliente.getconta().getNumeroDaAgencia());
        saldoText = utilidadesView.getTextField(12,200,280,120,30);
        saldoText.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        saldoText.setEditable(false);
        saldoText.setText("R$ "+String.valueOf(cliente.getconta().getSaldo()));
        tipoText = utilidadesView.getTextField(12,200,230,120,30);
        tipoText.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        tipoText.setEditable(false);
        tipoText.setText(cliente.getconta().getTipo());

//        IMAGEM DE TESTE
        JLabel imagemDecorativaMoedas = new JLabel(new ImageIcon("3945455-moedas-dinheiro-dolares-dinheiro-icone-gratis-vetor.png"));
        imagemDecorativaMoedas.setBounds(5, 10,355,430);

        //        ADIÇÕES
        painelConta.add(numContaLabel);
        painelConta.add(numContaText);
        painelConta.add(numAgenciaLabel);
        painelConta.add(numAgenciaText);
        painelConta.add(tipoLabel);
        painelConta.add(tipoText);
        painelConta.add(saldoLabel);
        painelConta.add(saldoText);
        painelConta.add(imagemDecorativaMoedas);




    }
}
