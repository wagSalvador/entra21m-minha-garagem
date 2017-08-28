package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Alunos
 */
public class JFrameInicial extends JFrame implements JFrameComportamentosInterface {

    private JButton jButtonListaCarros, jButtonCadastroCarro, jButtonListaCategorias;
    private JButton jButtonListaAvioes;

    public JFrameInicial() {
        criarTela();
        criarComponentes();
        definirLocalizacao();
        adicionarComponetes();
        adicionarOnClick();
    }

    @Override
    public void criarTela() {
        setSize(600, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void criarComponentes() {
        jButtonListaCarros = new JButton("Lista de Carros");
        jButtonCadastroCarro = new JButton("Cadastro de Carros");
        jButtonListaCategorias = new JButton("Lista categorias");
        jButtonListaAvioes = new JButton("Lista avioes");
    }

    @Override
    public void definirLocalizacao() {
        jButtonListaCarros.setBounds(10, 10, 200, 35);
        jButtonCadastroCarro.setBounds(10, 55, 200, 35);
        jButtonListaCategorias.setBounds(10, 100, 200, 35);
        jButtonListaAvioes.setBounds(10,160,200,35);
    }

    @Override
    public void adicionarComponetes() {
        add(jButtonListaCarros);
        add(jButtonCadastroCarro);
        add(jButtonListaCategorias);
        add(jButtonListaAvioes);
    }

    @Override
    public void adicionarOnClick() {
        jButtonListaCarros.addActionListener((ActionEvent e) -> {
           // JFrameListaCarros lista = new JFrameListaCarros();
        });

        jButtonCadastroCarro.addActionListener((ActionEvent e) -> {
            new JFrameCadastroCarro().setVisible(true);
        });
        jButtonListaCategorias.addActionListener((ActionEvent e) -> {
            new JFrameListaCategorias().setVisible(true);
        });
        jButtonListaAvioes.addActionListener((ActionEvent e) -> {
            new JFrameListaDeAvioes().setVisible(true);
        });
    }

}
