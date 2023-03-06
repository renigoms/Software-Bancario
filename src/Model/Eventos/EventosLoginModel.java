package Model.Eventos;

import Controller.DadosController;
import Model.ClienteModel;
import Model.Utilidadesv2;
import View.DepoisDoLogin.SistemaBancoView;
import View.TelasDeCadastroELogin.CadastrarCliente;
import View.TelasDeCadastroELogin.FazerLoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import static java.awt.Color.LIGHT_GRAY;
import static java.awt.Color.RED;

public class EventosLoginModel extends KeyAdapter implements ActionListener {
    private final FazerLoginView telaLogin;

    public EventosLoginModel(FazerLoginView telaLogin) {
        this.telaLogin = telaLogin;

    }



    @Override
    public void keyPressed(KeyEvent e) {
//        AÇÕES COM O BOTAO ENTER
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            Utilidadesv2.passarFocu(telaLogin.loginText, telaLogin.senhaText);
            Utilidadesv2.passarFocu(telaLogin.senhaText, telaLogin.entrarButton);
            Utilidadesv2.darUmCLick(telaLogin.entrarButton, telaLogin.entrarButton);
            Utilidadesv2.darUmCLick(telaLogin.cadastrarButton, telaLogin.cadastrarButton);
            Utilidadesv2.darUmCLick(telaLogin.sairButton, telaLogin.sairButton);

        }
//        AÇÕES COM O CURSOR DIREITO
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            Utilidadesv2.passarFocu(telaLogin.loginText, telaLogin.senhaText);
            Utilidadesv2.passarFocu(telaLogin.senhaText, telaLogin.sairButton);
            Utilidadesv2.passarFocu(telaLogin.sairButton, telaLogin.cadastrarButton);
            Utilidadesv2.passarFocu(telaLogin.cadastrarButton, telaLogin.entrarButton);

        }
        //        AÇÕES COM O CURSOR ESQUERDO
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            Utilidadesv2.passarFocu(telaLogin.senhaText, telaLogin.loginText);
            Utilidadesv2.passarFocu(telaLogin.sairButton, telaLogin.senhaText);
            Utilidadesv2.passarFocu(telaLogin.cadastrarButton, telaLogin.sairButton);
            Utilidadesv2.passarFocu(telaLogin.entrarButton, telaLogin.cadastrarButton);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        ENTRAR
        if (e.getSource() == telaLogin.entrarButton){
//            VERIFICADOR DE CAMPO VAZIO
//            Exibe a seguinte mensagem se algum dos campos estiver vazio
           telaLogin.campVazio.setVisible(
                   telaLogin.loginText.getText().equals("   .   .   -  ") || telaLogin.senhaText.getText().equals("")
           );
//           Mudar a cor da borda caso um dos camppos abaixo esteja vazia
//            CAMPO LOGIN
            Utilidadesv2.mudarBordas(telaLogin.loginText, RED, LIGHT_GRAY);
//            CAMPO SENHA
            Utilidadesv2.mudarBordas(telaLogin.senhaText, RED,LIGHT_GRAY);
//            LIBERA O ACESSO SE NENHUM CAMPO ESTIVER VAZIO
            if(!telaLogin.campVazio.isVisible()){
//                JOptionPane.showMessageDialog(null,"#SEMCAMPOSVAZIOS");
//                VERIFICADOR DE LOGIN POR CPF
                if(DadosController.buscar(telaLogin.loginText.getText()) != null){
                    ClienteModel cliente = DadosController.buscar(telaLogin.loginText.getText());
                    if (cliente.getSenha() == null){
                        cliente.setSenha(telaLogin.senhaText.getText());
                        JOptionPane.showMessageDialog(null,"Sua senha foi definida e " +
                                "seu cadastro foi confirmado.", "Bem vindo(a)", 1);
                        try {
                            new SistemaBancoView(cliente);
                        } catch (ParseException ex) {
                            throw new RuntimeException(ex);
                        }
                        telaLogin.loginText.setText("");
                        telaLogin.senhaText.setText("");
                    }else{
                        if (cliente.getSenha().equals(telaLogin.senhaText.getText())){
                            JOptionPane.showMessageDialog(null,"seu cadastro foi confirmado.", "Bem vindo(a), de volta", 1);
                            try {
                                new SistemaBancoView(cliente);
                            } catch (ParseException ex) {
                                throw new RuntimeException(ex);
                            }
                            telaLogin.loginText.setText("");
                            telaLogin.senhaText.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null, "Senha incorreta!!", "AVISO", JOptionPane.WARNING_MESSAGE);
                        }
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado ou não cadastrado(a)");
                }
                telaLogin.loginText.setText("");
                telaLogin.senhaText.setText("");
            }
        }
//        NOVO CADASTRO
        if (telaLogin.cadastrarButton.equals(e.getSource())) {
            try {
                new CadastrarCliente();
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }
//        SAIR
        if (e.getSource() == telaLogin.sairButton) {
            System.exit(0);

        }

    }
}
