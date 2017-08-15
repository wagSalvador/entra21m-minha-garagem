
import dao.CarroDAO;
import database.Utilitarios;
import java.awt.EventQueue;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Carro;
import view.JFrameInicial;

/**
 *
 * @author Alunos
 */
public class Principal {

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrameInicial inicial = new JFrameInicial();
            }
        });
        
        /*

        CarroDAO dao = new CarroDAO();

        Carro peugeot308 = new Carro();
        peugeot308.setNome("308");
        peugeot308.setFabricante("Peugeot");
        peugeot308.setCor("Preto");
        peugeot308.setAnoFabricacao((short) 2013);
        peugeot308.setAnoLancamento((short) 2014);
        peugeot308.setEstaFuncional(true);
        peugeot308.setPermitidaCirculacao(false);
        peugeot308.setQtdBatidas((byte) 13);
        peugeot308.setPlaca("LYQ-6225");
        peugeot308.setPotencia(146);
        peugeot308.setDataCompra(new Date(2013, 8, 24));
        peugeot308.setTipoPneu((short) 17);
        peugeot308.setRenavam(843751798);
        peugeot308.setQuilometragem(18654.15f);
        peugeot308.setQtdPortas((byte) 4);
        peugeot308.setChassi("1878-6544-1879-3548-1425");
        peugeot308.setDescricao("Dinamismo, esportividade, estilo, segurança e "
                + "tecnologia fazem do novo Peugeot 308 um carro cheio de personalidade "
                + "e identidade"
                + " única. Descubra o prazer de dirigir. ");
        int codigoInserir = dao.inserir(peugeot308);
        if (codigoInserir != Utilitarios.NAO_FOI_POSSIVEL_INSERIR) {
            peugeot308.setId(codigoInserir);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir");
        }

        peugeot308.setNome("Gol");
        peugeot308.setFabricante("VW");
        int codigoAlterar = dao.alterar(peugeot308);
        if (codigoAlterar != Utilitarios.NAO_FOI_POSSIVEL_ALTERAR) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao Alterar!");
        }

        
        for(int i = 1; i < 20; i++){
        dao.excluir(i);
    }
    

        ArrayList<Carro> carros = dao.retornarListagem();
        for (Carro carro : carros) {
            System.out.println(carro.toString());
        }*/
    }
                
}
