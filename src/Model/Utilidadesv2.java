package Model;

import javax.swing.*;
import java.awt.*;

public class Utilidadesv2 {


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
