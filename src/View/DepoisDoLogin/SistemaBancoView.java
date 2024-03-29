package View.DepoisDoLogin;

import Controller.EventosController;
import Controller.EventosPosLoginController;
import Model.ClienteModel;
import View.TelaView;
import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class SistemaBancoView extends TelaView {
    public JButton atualizarButton, removerButton, transferirButton, extratoButton, exibirDadosButton, sairButtton,
            adicionarButton, sacarButton;

    public ClienteModel clienteModel;



    public  JPanel cardMenstre, painelLogo, painelExibirInformacoes, painelConta,
            painelRemover, painelSacar, painelDepositar, painelExtrato, painelEditar;

    UtilidadesView caixaDeFerramentas;
    public SistemaBancoView(ClienteModel clienteModel) throws ParseException, FileNotFoundException {
//    DEFINIÇÕES
        setSize(590,514);
        this.clienteModel = clienteModel;
//        LAYOUT
        SpringLayout layout = new SpringLayout();
//    Painel1
        setPainel1_0(layout, 140,314 );
//        BOTÕES
//        BOTÃO ATUALIZAR: CRIAÇÃO E ADIÇÃO
        atualizarButton = new JButton("<html>Atualizar <br> informações</html>");
        getPainel1().add(atualizarButton);
        //        BOTÃO ATUALIZAR: LAYOUT E FONTE
        layout.putConstraint(SpringLayout.NORTH, atualizarButton,100, SpringLayout.NORTH,getPainel1());
        atualizarButton.setFont(new Font("Arial", Font.BOLD, 16));
        //        BOTÃO ATUALIZAR: EVENTOS E REQUISIÇÃO DE FOCO
        atualizarButton.addKeyListener(new EventosPosLoginController(this).keyEventos());
        atualizarButton.addActionListener(new EventosPosLoginController(this, atualizarButton).actionsEventos());
        atualizarButton.addFocusListener(new EventosPosLoginController(this, atualizarButton).focusEventos());
        atualizarButton.addMouseListener(new EventosController(atualizarButton).eventosMouse());
        atualizarButton.requestFocus();

//      BOTÃO REMOVER: CRIAÇÃO E ADIÇÃO
        removerButton = new JButton("Excluir Conta");
        getPainel1().add(removerButton);
        //      BOTÃO REMOVER: LAYOUT E FONTES
        layout.putConstraint(SpringLayout.NORTH, removerButton, 30, SpringLayout.SOUTH, atualizarButton);
        removerButton.setFont(new Font("Arial", Font.BOLD, 16));
        //      BOTÃO REMOVER: EVENTOS
        removerButton.addKeyListener(new EventosPosLoginController(this).keyEventos());
        removerButton.addMouseListener(new EventosController(removerButton).eventosMouse());
        removerButton.addFocusListener(new EventosPosLoginController(this, removerButton).focusEventos());
        removerButton.addActionListener(new EventosPosLoginController(this, removerButton).actionsEventos());

//       BOTÃO ADICIONAR: CRIAÇÃO E ADIÇÃO
        adicionarButton = new JButton("Depositar");
        getPainel1().add(adicionarButton);
        //       BOTÃO ADICIONAR: LAYOUT E FONTE
        layout.putConstraint(SpringLayout.NORTH, adicionarButton, 30, SpringLayout.SOUTH, removerButton);
        adicionarButton.setFont(new Font("Arial", Font.BOLD, 16));
        //       BOTÃO ADICIONAR: EVENTOS
        adicionarButton.addKeyListener(new EventosPosLoginController(this).keyEventos());
        adicionarButton.addFocusListener(new EventosPosLoginController(this, adicionarButton).focusEventos());
        adicionarButton.addMouseListener(new EventosController(adicionarButton).eventosMouse());
        adicionarButton.addActionListener(new EventosPosLoginController(this, adicionarButton).actionsEventos());
//      BOTÃO EXIBIRDADOS: CRIAÇÃO E ADIÇÃO
        exibirDadosButton = new JButton("Exibir Dados");
        getPainel1().add(exibirDadosButton);
        //      BOTÃO EXIBIRDADOS: LAYOUT E FONTE
        layout.putConstraint(SpringLayout.NORTH, exibirDadosButton, 30, SpringLayout.SOUTH, adicionarButton);
        exibirDadosButton.setFont(new Font("Arial", Font.BOLD, 16));
        //      BOTÃO EXIBIRDADOS: EVENTOS
        exibirDadosButton.addKeyListener(new EventosPosLoginController(this).keyEventos());
        exibirDadosButton.addMouseListener(new EventosController(exibirDadosButton).eventosMouse());
        exibirDadosButton.addFocusListener(new EventosPosLoginController(this, exibirDadosButton).focusEventos());
        exibirDadosButton.addActionListener(new EventosPosLoginController(this, exibirDadosButton).actionsEventos());
//    Painel2
//        CARTÃO MESTRE
        caixaDeFerramentas = new UtilidadesView();
        cardMenstre = caixaDeFerramentas.getPainel(new CardLayout(), 330,314);
//        PAINEL LOGO
        painelLogo = PainelLogo.getPainelLogo(null, 330,314);
        cardMenstre.add(painelLogo, "logo");
//        PAINEL EXIBIR INFORMAÇÕES
        painelExibirInformacoes = ExibirInformacoes.getPainelExibirInformacoes(null, 330,314, clienteModel, this);
        cardMenstre.add(painelExibirInformacoes, "exibirInfo");
        //        PAINEL EXIBIR INFORMAÇÕES DA CONTA
        painelConta = ExibirConta.getPainelConta(null, 330,314, clienteModel);
        cardMenstre.add(painelConta, "exibirConta");
        //        PAINEL REMOVER
        painelRemover = RemoverUsuario.getPainelRemover(null, 330,314,clienteModel,this);
        cardMenstre.add(painelRemover, "remover");

//        PAINEL SACAR
        painelSacar = SacarView.getPainelSacar(null, 330,314, clienteModel, this);
        cardMenstre.add(painelSacar, "sacar");

        // PAINEL DEPOSITAR

        painelDepositar = DepositarView.getPainelDepositar(null, 330,314, this,clienteModel);
        cardMenstre.add(painelDepositar, "depositar");

//        PAINEL EXTRATO
        painelExtrato = ExtratoView.getPainelExtrato(null, 330, 314, this, clienteModel);
        cardMenstre.add(painelExtrato,"extrato");

//         PAINEL DE EDITAR
        painelEditar = EditarView.getPainelConta(null, 330,314, clienteModel, this);
        cardMenstre.add(painelEditar, "atualizarInformacoes");

//        SHOW
        add(cardMenstre, BorderLayout.CENTER);


//    Painel3

//      DEFINIÇÕES
        setPainel3_0(layout,109,314);

        //          BOTÕES
//         BOTÃO TRANSFERÊNCIA: CRIAÇÃO
        transferirButton = new JButton("Transferir");
        transferirButton.setFont(new Font("Arial", Font.BOLD, 16));
//         BOTÃO TRANSFERÊNCIA: EVENTOS
        transferirButton.addKeyListener(new EventosPosLoginController(this).keyEventos());
        transferirButton.addMouseListener(new EventosController(transferirButton).eventosMouse());
        transferirButton.addFocusListener(new EventosPosLoginController(this, transferirButton).focusEventos());
        //         BOTÃO TRANSFERÊNCIA: ADIÇÃO
        getPainel3().add(transferirButton);
        //         BOTÃO TRANSFERÊNCIA: LAYOUT
        layout.putConstraint(SpringLayout.NORTH, transferirButton, 100, SpringLayout.NORTH, getPainel3());
        layout.putConstraint(SpringLayout.EAST, transferirButton,1, SpringLayout.EAST, getPainel3());

        //         BOTÃO EXTRATO: CRIAÇÃO E FONTE
        extratoButton = new JButton("Extrato");
        extratoButton.setFont(new Font("Arial", Font.BOLD, 16));
        //         BOTÃO EXTRATO: EVENTOS
        extratoButton.addActionListener(new EventosPosLoginController(this).actionsEventos());
        extratoButton.addKeyListener(new EventosPosLoginController(this).keyEventos());
        extratoButton.addMouseListener(new EventosController(extratoButton).eventosMouse());
        extratoButton.addFocusListener(new EventosPosLoginController(this, extratoButton).focusEventos());
        //         BOTÃO EXTRATO: ADIÇÃO
        getPainel3().add(extratoButton);
        //         BOTÃO EXTRATO: LAYOUT
        layout.putConstraint(SpringLayout.NORTH, extratoButton, 30, SpringLayout.SOUTH, transferirButton);
        layout.putConstraint(SpringLayout.EAST, extratoButton,1, SpringLayout.EAST, getPainel3());

        //         BOTÃO SACAR: CRIAÇÃO E FONTE
        sacarButton = new JButton("Sacar");
        sacarButton.setFont(new Font("Arial", Font.BOLD, 16));
        //         BOTÃO SACAR: EVENTOS
        sacarButton.addKeyListener(new EventosPosLoginController(this).keyEventos());
        sacarButton.addMouseListener(new EventosController(sacarButton).eventosMouse());
        sacarButton.addFocusListener(new EventosPosLoginController(this, sacarButton).focusEventos());
        sacarButton.addActionListener(new EventosPosLoginController(this).actionsEventos());
        //         BOTÃO SACAR: ADIÇÃO
        getPainel3().add(sacarButton);
        //         BOTÃO SACAR: LAYOUT
        layout.putConstraint(SpringLayout.NORTH, sacarButton, 30, SpringLayout.SOUTH, extratoButton);
        layout.putConstraint(SpringLayout.EAST, sacarButton,1, SpringLayout.EAST, getPainel3());

        //         BOTÃO SAIR: CRIAÇÃO E FONTE
        sairButtton = new JButton("Sair");
        sairButtton.setFont(new Font("Arial", Font.BOLD, 16));
//        BOTÃO SAIR: EVENTOS
        sairButtton.addKeyListener(new EventosPosLoginController(this).keyEventos());
        sairButtton.addFocusListener(new EventosPosLoginController(this, sairButtton).focusEventos());
        sairButtton.addMouseListener(new EventosController(sairButtton).eventosMouse());
        sairButtton.addActionListener(new EventosPosLoginController(this).actionsEventos());
//        BOTÃO SAIR: ADIÇÃO
        getPainel3().add(sairButtton);
//        BOTÃO SAIR : LAYOUT
        layout.putConstraint(SpringLayout.NORTH, sairButtton, 30, SpringLayout.SOUTH, sacarButton);
        layout.putConstraint(SpringLayout.EAST, sairButtton,1, SpringLayout.EAST, getPainel3());

//      SHOW
        setVisible(true);
    }

}
