package View.DepoisDoLogin;

import Model.ClienteModel;
import View.UtilidadesView;

import javax.swing.*;
import java.awt.*;

public class DepositarView {
    private static JPanel painelDepositar;

    static SistemaBancoView sistemaPrincipal;
    static ClienteModel cliente;

    // VARIÁVEIS DA LOG0TIPO
   static JLabel imagem, tituloLabel, mensagemLabel;

    public static JPanel getPainelDepositar(LayoutManager layout, int x, int y, SistemaBancoView sistemBase,
                                            ClienteModel pegarCliente) {
        cliente = pegarCliente;
        sistemaPrincipal = sistemBase;
        setPainelDepositar(layout, x, y);
        return painelDepositar;
    }

    private static void setPainelDepositar(LayoutManager layout, int x, int y) {
        //  CONSTRUÇÃO INICIAL
        UtilidadesView caixaDeFerramentas = new UtilidadesView();
        painelDepositar = caixaDeFerramentas.getPainel(layout, x, y);

        // LOGO PADRÃO DO BANCO
        // IMAGEM
        imagem = new JLabel(new ImageIcon("1802328v3.png"));
        imagem.setBounds(20,0,195,72);
        painelDepositar.add(imagem);
        // TITULO
        tituloLabel = caixaDeFerramentas.getLabels("Banco Renan", Color.BLACK,110,15,280,50);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 32));
        painelDepositar.add(tituloLabel);
        // MENSAGEM
        mensagemLabel = caixaDeFerramentas.getLabels("Fazer Deposito.",Color.DARK_GRAY,110,38,280,50);
        mensagemLabel.setFont(new Font("Serif",Font.ITALIC, 16));
        painelDepositar.add(mensagemLabel);




    }
}
