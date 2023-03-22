package View.DepoisDoLogin;

import Controller.EventosController;
import Controller.EventosPosLoginController;
import Model.ClienteModel;
import Model.Utilidadesv2;
import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

public class ExtratoView {

    private static JPanel painelExtrato;

    //    VARIÁVEIS DA LOGO
    static  JLabel imagemLabel, mensagemlabel, tituloLabel;
    // VARIÁVEIS DE SISTEMA
    static  SistemaBancoView sistemaPrincipal;
    static ClienteModel cliente;

    static JButton gerarExtrato;
//    VARIAVEIS DA ÁREA DO TEXTO

    static  JTextArea areaDeTexto;

    public static JPanel getPainelExtrato(LayoutManager layout, int x, int y, SistemaBancoView sistemPrincipal,
                                          ClienteModel getCliente) {
        cliente = getCliente;
        sistemaPrincipal = sistemPrincipal;

        setPainelExtrato(layout, x, y);
        return painelExtrato;
    }

    public static void adicionarTexto(String texto){
        areaDeTexto.append(texto+"\n");
    }

    private static void setPainelExtrato(LayoutManager layout, int x, int y) {
//        CORPO DO PAINEL
        UtilidadesView caixaDeFerramentas = new UtilidadesView();
        painelExtrato = caixaDeFerramentas.getPainel(layout, x, y);

//        COMPONENTES DO PAINEL

//        LOGO: IMAGEM
        imagemLabel = new JLabel(new ImageIcon("1802328v3.png"));
        imagemLabel.setBounds(20,0,195,72);
        painelExtrato.add(imagemLabel);

//        LOGO: TITULO

        tituloLabel = caixaDeFerramentas.getLabels("Banco Renan", Color.BLACK,110,15,280,50);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 32));
        painelExtrato.add(tituloLabel);

//        LOGO: MENSAGEM

        mensagemlabel = caixaDeFerramentas.getLabels("Extrato.",Color.DARK_GRAY,110,38,280,50);
        mensagemlabel.setFont(new Font("Serif",Font.ITALIC, 16));
        painelExtrato.add(mensagemlabel);

//        ÁREA DE TEXTO
        areaDeTexto = new JTextArea();
        areaDeTexto.setBounds(20,110,290,320);
//        ADICIONAR NA ÁREA DE TEXTO
        BufferedReader BR = Utilidadesv2.lerArquivos("arquiDeExtratos.txt");
        while (true){
            try {
                if (!BR.ready()) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String linha = null;
            try {
                linha = BR.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            adicionarTexto(linha);

        }

        painelExtrato.add(areaDeTexto);

        //            BOTÃO GERAR EXTRATO
        gerarExtrato = new JButton("Gerar Extrato");
        gerarExtrato.addMouseListener(new EventosController(gerarExtrato).eventosMouse());
        gerarExtrato.addFocusListener(new EventosPosLoginController(gerarExtrato).focusEventos());
        gerarExtrato.setBounds(80,438,171,30);
        gerarExtrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Apatir daqui você não pode mais fazer " +
                        "saque, trasações ou depositos. Quer continuar ?") == JOptionPane.YES_NO_OPTION){

                    try {
//                            fecha o arquivo
                        sistemaPrincipal.primeBW.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    sistemaPrincipal.dispose();
                    try {
                        new SistemaBancoView(sistemaPrincipal.clienteModel, sistemaPrincipal.primeBW);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        painelExtrato.add(gerarExtrato);


    }
}
