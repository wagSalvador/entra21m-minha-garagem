package view;

import dao.CarroDAO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Carro;

/**
 *
 * @author Alunos
 */
public class JFrameListaCarros extends JFrame implements JFrameComportamentosInterface {

    private JTable jTable;
    private DefaultTableModel modelo;
    private JScrollPane scroll;

    public JFrameListaCarros() {
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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void criarComponentes() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        modelo.addColumn("Fabricante");
        modelo.addColumn("Nome");
        modelo.addColumn("Placa");
        modelo.addColumn("Cor");
        
        popoularJTable();
        jTable = new JTable(modelo);
        scroll = new JScrollPane(jTable);
    }

    @Override
    public void definirLocalizacao() {
        scroll.setBounds(10, 10, 500, 500);
    }

    @Override
    public void adicionarComponetes() {
        add(scroll);
    }

    @Override
    public void adicionarOnClick() {
    }

    private void popoularJTable() {
        ArrayList<Carro> carros = new CarroDAO().retornarListagem();
        for(Carro carro: carros){
            modelo.addRow(new Object[]{
            carro.getFabricante(), 
            carro.getNome(),
            carro.getPlaca(), carro.getCor()
        });
        }
    }
}
