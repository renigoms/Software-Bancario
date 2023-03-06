package Controller;

import Model.Eventos.EventosCadastrarClienteModel;
import Model.Eventos.EventosCadastrarConta;
import Model.Eventos.EventosLoginModel;
import Model.Eventos.EventosWindows;
import View.TelasDeCadastroELogin.CadastrarCliente;
import View.TelasDeCadastroELogin.CadastrarConta;
import View.TelasDeCadastroELogin.FazerLoginView;

public class EventosController {
    private final FazerLoginView telaLogin;
    private final CadastrarCliente telaCliente;
    private final CadastrarConta telaConta;
    private ClienteController cliente;


    public EventosController(FazerLoginView telaLogin, CadastrarCliente telaCliente, CadastrarConta telaConta) {
        this.telaLogin = telaLogin;
        this.telaCliente = telaCliente;
        this.telaConta = telaConta;
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
}
