package Controller;

import View.TelasDeCadastroELogin.FazerLoginView;

import javax.swing.*;
import java.text.ParseException;

public class AppController {
    public static void iniciarApp(){
        try{
            new FazerLoginView();
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro inesperado.", "Erro!!", JOptionPane.WARNING_MESSAGE);
            System.err.println("Ocorreu um erro inesperado.");
        }

    }
}
