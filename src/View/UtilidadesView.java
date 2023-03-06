package View;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class UtilidadesView {
    private JPanel painel;
    private JLabel labels;
    private  JTextField textField;
    private  JFormattedTextField texto;
    private MaskFormatter formatacao;

    public JPanel getPainel(LayoutManager layout, int x, int y) {
        painel = new JPanel(layout);
        painel.setBackground(Color.LIGHT_GRAY);
        painel.setPreferredSize(new Dimension(x,y));
        return painel;
    }

    public JLabel getLabels(String nome, Color corFonte,int x,int y,int width,int heigth) {
        labels = new JLabel(nome);
        labels.setFont(new Font("Serif",Font.PLAIN, 14));
        labels.setBounds(x,y,width,heigth);
        if (corFonte == null) {
            labels.setForeground(Color.BLACK);
        } else {
            labels.setForeground(corFonte);
        }

        return labels;
    }
    public JLabel getLabels(String nome, Color corFonte,boolean ativacao,int x,int y,int width,int heigth) {
        labels = new JLabel(nome);
        labels.setFont(new Font("Serif",Font.PLAIN, 14));
        labels.setBounds(x,y,width,heigth);
        labels.setVisible(ativacao);
        if (corFonte == null) {
            labels.setForeground(Color.BLACK);
        } else {
            labels.setForeground(corFonte);
        }

        return labels;
    }
    public JLabel getLabels(String nome, Color corFonte) {
        labels = new JLabel(nome);
        labels.setFont(new Font("Serif",Font.PLAIN, 14));
        if (corFonte == null) {
            labels.setForeground(Color.BLACK);
        } else {
            labels.setForeground(corFonte);
        }

        return labels;
    }
    public JLabel getLabels(String nome, Color corFonte, boolean ativacao) {
        labels = new JLabel(nome);
        labels.setFont(new Font("Serif",Font.PLAIN, 14));
        labels.setVisible(ativacao);
        if (corFonte == null) {
            labels.setForeground(Color.BLACK);
        } else {
            labels.setForeground(corFonte);
        }

        return labels;
    }

    public JTextField getTextField(int colunas) {
        textField = new JTextField(colunas);
        return textField;
    }
    public JTextField getTextField(int colunas, int x , int y, int width, int height) {
        textField = new JTextField(colunas);
        textField.setBounds(x,y,width, height);
        return textField;
    }

    public JFormattedTextField getTexto(String formatacao, int colunas) throws ParseException {

        texto = new JFormattedTextField(new MaskFormatter(formatacao));
        texto.setColumns(colunas);
        return texto;
    }

    public JFormattedTextField getTexto(String formatacao, int colunas, int x , int y, int width, int height) throws ParseException {
        texto = new JFormattedTextField(new MaskFormatter(formatacao));
        texto.setColumns(colunas);
        texto.setBounds(x,y,width, height);
        return texto;
    }
}
