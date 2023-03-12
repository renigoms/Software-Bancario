package Model.Eventos;

import Controller.ClienteController;
import Controller.ContaController;
import Controller.DadosController;
import Model.Utilidadesv2;
import View.TelasDeCadastroELogin.CadastrarCliente;
import View.TelasDeCadastroELogin.CadastrarConta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EventosCadastrarConta extends KeyAdapter implements ActionListener {
    CadastrarConta telaConta;
    CadastrarCliente telaCliente;
    ClienteController cliente;


    public EventosCadastrarConta(CadastrarConta telaConta, CadastrarCliente telaCliente, ClienteController cliente) {
        this.telaConta = telaConta;
        this.telaCliente = telaCliente;
        this.cliente = cliente;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            Utilidadesv2.passarFocu(telaConta.tipoBox, telaConta.saldoText);
            Utilidadesv2.passarFocu(telaConta.saldoText, telaConta.salvarButton);
            Utilidadesv2.darUmCLick(telaConta.salvarButton, telaConta.salvarButton);
            Utilidadesv2.darUmCLick(telaConta.cancelarButton, telaConta.cancelarButton);


        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){

            Utilidadesv2.passarFocu(telaConta.tipoBox, telaConta.saldoText);
            Utilidadesv2.passarFocu(telaConta.saldoText, telaConta.cancelarButton);
            Utilidadesv2.passarFocu(telaConta.cancelarButton, telaConta.salvarButton);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            Utilidadesv2.passarFocu(telaConta.saldoText, telaConta.tipoBox);
            Utilidadesv2.passarFocu(telaConta.cancelarButton, telaConta.saldoText);
            Utilidadesv2.passarFocu(telaConta.salvarButton, telaConta.cancelarButton);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == telaConta.salvarButton){
            telaConta.saldoVazio.setVisible(telaConta.saldoText.getText().equals(""));
            Utilidadesv2.mudarBordas(telaConta.saldoText, Color.RED, Color.LIGHT_GRAY);
            if (!telaConta.saldoVazio.isVisible()){
                double saldoConvertido = Double.parseDouble(telaConta.saldoText.getText());
                ContaController conta = new ContaController(
                        telaConta.numContaText.getText(),
                        telaConta.numAgenciaText.getText(),
                        telaConta.tipoBox.getItemAt(telaConta.tipoBox.getSelectedIndex()),
                        saldoConvertido
                );
                // CORRER JUROS CASO CONTA POUPANÇA
                if (conta.getConta().getTipo().equals("Poupança")){
                    double rendimento = conta.getConta().renderJuros(0.0015);
                    double rendeuQuant = rendimento - saldoConvertido;
                    JOptionPane.showMessageDialog(null, "Seu saldo rendeu R$ "+rendeuQuant+" reais.");

                }
                // RENDER JUROS CASO CONTA CORRENTE
                if (conta.getConta().getTipo().equals("Corrente")) {
                    double rendimento = conta.getConta().correrJuros(0.03);
                    double rendeuQuant = rendimento - saldoConvertido;
                    JOptionPane.showMessageDialog(null, "Seu saldo correu R$ " + rendeuQuant + " reais.");
                }
                cliente.getCliente().setconta(conta.getConta());
//                VERIFICAR SE O CLIENTE JÁ FOI CADASTRADO ANTES
                if (DadosController.buscar(telaCliente.cpfText.getText()) != null)
                    JOptionPane.showMessageDialog(null, "O cliente já foi registrado anteriormente.");
                else{
                    DadosController.adcionarCliente(cliente);
                    JOptionPane.showMessageDialog(null,"Cadastro Realizado com sucesso. " +
                            "Sua senha será definida no momento do primeiro login!", "Bem vindo(a) ao nosso benco",JOptionPane.INFORMATION_MESSAGE);
                }
                telaConta.dispose();
                telaCliente.dispose();
            }
        }
        if (e.getSource() == telaConta.cancelarButton){
            telaConta.dispose();
        }
    }
}
