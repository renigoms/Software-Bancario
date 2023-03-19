package Model;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.constant.Constable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilidadesv2 {

//    ESCREVER ARQUIVO
    public static BufferedWriter abrirAquivo(String nomeDoArquivo)  {
        BufferedWriter escreverArqui = null;
        try {
            escreverArqui = new BufferedWriter(new FileWriter(nomeDoArquivo));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return escreverArqui;
    }

//    LER ARQUIVO

    public static BufferedReader lerArquivos(String arquivo){
        BufferedReader BR = null;
        try {
            BR = new BufferedReader(new FileReader(arquivo));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return  BR;
    }

//    TRABALHANDO COM DATAS E HORAS
    
    public static Constable formatarDataEOUHora(String formatacao){
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern(formatacao);
        LocalDateTime dateTime = LocalDateTime.now();
        return formatar.format(dateTime);
    }

//    MUDA AS BORDAS DE UM CAMPO DOS TIPOS JTEXTFIELD, JFORMATTEDTEXTFIELD OU JPASSWORDFIRLD
    public static void mudarBordas(JFormattedTextField campo, Color cor1, Color cor2){
        if (campo.getText().equals("   .   .   -  ") || campo.getText().equals("(  )     -    ")){
            campo.setBorder(BorderFactory.createLineBorder(cor1));
        }else{
            campo.setBorder(BorderFactory.createLineBorder(cor2));
        }
    }
    public static void mudarBordas(JTextField campo, Color cor1, Color cor2){
        if (campo.getText().equals("")){
            campo.setBorder(BorderFactory.createLineBorder(cor1));
        }else{
            campo.setBorder(BorderFactory.createLineBorder(cor2));
        }
    }
    public static void mudarBordas(JPasswordField campo,String text, Color cor1, Color cor2){
        if (campo.getText().equals("")){
            campo.setBorder(BorderFactory.createLineBorder(cor1));
        }else{
            campo.setBorder(BorderFactory.createLineBorder(cor2));
        }
    }
    /*
       PASSA O FOCA ENTRE CAMPOS DOS TIPOS JTEXTFIELD, JFORMATTEDTEXTFIELD OU JPASSWORDFIRLD
       E ENTRE JBUTT0NS
     */
    public static void  passarFocu(JTextField campoComFoco, JTextField campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JTextField campoComFoco, JFormattedTextField campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JFormattedTextField campoComFoco, JTextField campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JFormattedTextField campoComFoco, JPasswordField campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JPasswordField campoComFoco, JFormattedTextField campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JFormattedTextField campoComFoco, JFormattedTextField campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JFormattedTextField campoComFoco, JButton campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JButton campoComFoco, JFormattedTextField campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JButton campoComFoco, JTextField campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JButton campoComFoco, JPasswordField campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JPasswordField campoComFoco, JButton campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JTextField campoComFoco, JButton campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JButton campoComFoco, JButton campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JComboBox campoComFoco, JTextField campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
    public static void  passarFocu(JTextField campoComFoco, JComboBox  campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.requestFocus();
        }
    }
//    DAR UM CLICK
    public static void  darUmCLick(JButton campoComFoco, JButton campoSemFoco){
        if (campoComFoco.isFocusOwner()){
            campoSemFoco.doClick();
        }
    }
}
