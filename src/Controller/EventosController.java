package Controller;

import Model.Eventos.*;
import View.TelasDeCadastroELogin.CadastrarCliente;
import View.TelasDeCadastroELogin.CadastrarConta;
import View.TelasDeCadastroELogin.FazerLoginView;

import javax.swing.*;

public class EventosController {
    private FazerLoginView telaLogin;
    private CadastrarCliente telaCliente;
    private CadastrarConta telaConta;
    private ClienteController cliente;

    private JButton buttonController;




    public EventosController(FazerLoginView telaLogin, CadastrarCliente telaCliente, CadastrarConta telaConta) {
        this.telaLogin = telaLogin;
        this.telaCliente = telaCliente;
        this.telaConta = telaConta;
    }

    public EventosController(JButton buttonController) {
        this.buttonController = buttonController;
    }

    public EventosController(FazerLoginView telaLogin, CadastrarCliente telaCliente, CadastrarConta telaConta, ClienteController cliente) {
        this.telaLogin = telaLogin;
        this.telaCliente = telaCliente;
        this.telaConta = telaConta;
        this.cliente = cliente;
    }


    public EventosLoginModel eventoLogin(){
        return new EventosLoginModel(telaLogin);

    }
    public EventosCadastrarClienteModel eventoCliente(){
        return new EventosCadastrarClienteModel(telaCliente);
    }

    public EventosCadastrarConta eventoConta(){
        return new EventosCadastrarConta(telaConta,telaCliente, cliente);
    }

    public EventosWindows windowsEventos(){
        return new EventosWindows(telaConta);
    }

    public EventosMouse eventosMouse(){
        return new EventosMouse(buttonController);
    }
}
