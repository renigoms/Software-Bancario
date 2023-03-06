package Model.Eventos;

import Controller.ClienteController;
import Model.Utilidadesv2;
import View.TelasDeCadastroELogin.CadastrarCliente;
import View.TelasDeCadastroELogin.CadastrarConta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

public class EventosCadastrarClienteModel extends KeyAdapter implements ActionListener {
    private final CadastrarCliente telaCliente;

    public EventosCadastrarClienteModel(CadastrarCliente tela) {
        this.telaCliente = tela;
    }
// Eventos KeyListener
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            Utilidadesv2.passarFocu(telaCliente.nomeText, telaCliente.cpfText);
            Utilidadesv2.passarFocu(telaCliente.cpfText, telaCliente.enderecoText);
            Utilidadesv2.passarFocu(telaCliente.enderecoText, telaCliente.emailText);
            Utilidadesv2.passarFocu(telaCliente.emailText, telaCliente.telefoneText);
            Utilidadesv2.passarFocu(telaCliente.telefoneText, telaCliente.salvarButton);
            Utilidadesv2.darUmCLick(telaCliente.salvarButton, telaCliente.salvarButton);
            Utilidadesv2.darUmCLick(telaCliente.cancelarButton, telaCliente.cancelarButton);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            Utilidadesv2.passarFocu(telaCliente.nomeText, telaCliente.cpfText);
            Utilidadesv2.passarFocu(telaCliente.cpfText, telaCliente.enderecoText);
            Utilidadesv2.passarFocu(telaCliente.enderecoText, telaCliente.emailText);
            Utilidadesv2.passarFocu(telaCliente.emailText, telaCliente.telefoneText);
            Utilidadesv2.passarFocu(telaCliente.telefoneText, telaCliente.cancelarButton);
            Utilidadesv2.passarFocu(telaCliente.cancelarButton, telaCliente.salvarButton);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            Utilidadesv2.passarFocu(telaCliente.cpfText, telaCliente.nomeText);
            Utilidadesv2.passarFocu(telaCliente.enderecoText, telaCliente.cpfText);
            Utilidadesv2.passarFocu(telaCliente.emailText, telaCliente.enderecoText);
            Utilidadesv2.passarFocu(telaCliente.telefoneText, telaCliente.emailText);
            Utilidadesv2.passarFocu(telaCliente.cancelarButton, telaCliente.telefoneText);
            Utilidadesv2.passarFocu(telaCliente.salvarButton, telaCliente.cancelarButton);
        }
    }
//   Eventos ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCliente.cancelarButton) {
            telaCliente.setVisible(false);
        }

        if(e.getSource() == telaCliente.salvarButton){
//            VISIBILIDADE DA MENSAGEM DE CAMPO VAZIO
            telaCliente.campVazio.setVisible(
                    telaCliente.nomeText.getText().equals("")||
                    telaCliente.cpfText.getText().equals("   .   .   -  ")||
                    telaCliente.enderecoText.getText().equals("")||
                    telaCliente.emailText.getText().equals("")||
                    telaCliente.telefoneText.getText().equals("(  )     -    ")
                    );
//            MUDAR COR DOS CAMPOS
            Utilidadesv2.mudarBordas(telaCliente.nomeText, Color.RED, Color.LIGHT_GRAY);
            Utilidadesv2.mudarBordas(telaCliente.cpfText, Color.RED, Color.LIGHT_GRAY);
            Utilidadesv2.mudarBordas(telaCliente.enderecoText, Color.RED, Color.LIGHT_GRAY);
            Utilidadesv2.mudarBordas(telaCliente.emailText, Color.RED, Color.LIGHT_GRAY);
            Utilidadesv2.mudarBordas(telaCliente.telefoneText, Color.RED, Color.LIGHT_GRAY);
//            VERIFICAÇÃO DE CAMPOS
            if (!telaCliente.campVazio.isVisible()){

                ClienteController cliente = new ClienteController(
                        telaCliente.nomeText.getText(),
                        telaCliente.cpfText.getText(),
                        telaCliente.emailText.getText(),
                        telaCliente.telefoneText.getText(),
                        telaCliente.enderecoText.getText()
                );

                try {
                    new CadastrarConta(cliente,telaCliente);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }
}
