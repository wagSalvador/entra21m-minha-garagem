package dao;

import java.sql.Date;
import model.Carro;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alunos
 */
public class CarrosDAOJUnitTest {

    @Test
    public void inserir() {
        Carro gol = new Carro();
        gol.setDataCompra(new Date(2017, 8, 14));
        gol.setAnoFabricacao((short) 2017);
        gol.setAnoLancamento((short) 2017);
        gol.setChassi("5151874");
        gol.setCor("Vermelho");
        gol.setDescricao("Otimo Carro");
        gol.setEstaFuncional(false);
        gol.setFabricante("VW");
        gol.setNome("Gol");
        gol.setPlaca("FLA-2017");
        gol.setPotencia(100);
        gol.setPermitidaCirculacao(true);
        gol.setQtdBatidas((byte) 0);
        gol.setQtdPortas((byte) 4);
        gol.setQuilometragem(1588740);
        gol.setTipoPneu((short) 17);
        gol.setRenavam(198745);

        CarroDAO dao = new CarroDAO();
        dao.truncate();
        int codigo = dao.inserir(gol);
        assertEquals(codigo, 1);

        gol.setId(codigo);

        Carro carroBuscado = dao.buscarPorId(codigo);
        validarIgualdadedeCarro(gol, carroBuscado);

    }

    @Test
    public void excluir() {
        Carro gol = new Carro();
        gol.setDataCompra(new Date(2017, 8, 14));
        gol.setAnoFabricacao((short) 2017);
        gol.setAnoLancamento((short) 2017);
        gol.setChassi("5151874");
        gol.setCor("Vermelho");
        gol.setDescricao("Otimo Carro");
        gol.setEstaFuncional(false);
        gol.setFabricante("VW");
        gol.setNome("Gol");
        gol.setPlaca("FLA-2017");
        gol.setPotencia(100);
        gol.setPermitidaCirculacao(true);
        gol.setQtdBatidas((byte) 0);
        gol.setQtdPortas((byte) 4);
        gol.setQuilometragem(1588740);
        gol.setTipoPneu((short) 17);
        gol.setRenavam(198745);

        CarroDAO dao = new CarroDAO();
        dao.truncate();
        int condigo = dao.inserir(gol);
        dao.excluir(condigo);

        Carro carroBuscado = dao.buscarPorId(condigo);
        assertNull(carroBuscado);
    }

    @Test
    public void alterar() {
        Carro gol = new Carro();
        gol.setDataCompra(new Date(2017, 8, 14));
        gol.setAnoFabricacao((short) 2017);
        gol.setAnoLancamento((short) 2017);
        gol.setChassi("5151874");
        gol.setCor("Vermelho");
        gol.setDescricao("Otimo Carro");
        gol.setEstaFuncional(false);
        gol.setFabricante("VW");
        gol.setNome("Gol");
        gol.setPlaca("FLA-2017");
        gol.setPotencia(100);
        gol.setPermitidaCirculacao(true);
        gol.setQtdBatidas((byte) 0);
        gol.setQtdPortas((byte) 4);
        gol.setQuilometragem(1588740);
        gol.setTipoPneu((short) 17);
        gol.setRenavam(198745);

        CarroDAO dao = new CarroDAO();
        dao.truncate();
        int codigo = dao.inserir(gol);
        gol.setId(codigo);

        gol.setDataCompra(new Date(2020, 9, 14));
        gol.setAnoFabricacao((short) 2019);
        gol.setAnoLancamento((short) 2018);
        gol.setChassi("10203070");
        gol.setCor("Preto");
        gol.setDescricao("Pessimo Carro");
        gol.setEstaFuncional(true);
        gol.setFabricante("FIAT");
        gol.setNome("Freemont");
        gol.setPlaca("LYQ-2017");
        gol.setPotencia(350);
        gol.setPermitidaCirculacao(false);
        gol.setQtdBatidas((byte) 2);
        gol.setQtdPortas((byte) 4);
        gol.setQuilometragem(0);
        gol.setTipoPneu((short) 17);
        gol.setRenavam(198745);
        
        dao.alterar(gol);
        
        Carro carroModificado = dao.buscarPorId(gol.getId());
        validarIgualdadedeCarro(gol, carroModificado);
        
    }

    public void validarIgualdadedeCarro(Carro carro, Carro outroCarro) {
        assertEquals(carro.getId(), outroCarro.getId());
        assertEquals(carro.getAnoFabricacao(), outroCarro.getAnoFabricacao());
        assertEquals(carro.getAnoLancamento(), outroCarro.getAnoLancamento());
        assertEquals(carro.getChassi(), outroCarro.getChassi());
        assertEquals(carro.getCor(), outroCarro.getCor());
        assertEquals(carro.getDataCompra(), outroCarro.getDataCompra());
        assertEquals(carro.getDescricao(), outroCarro.getDescricao());
        assertEquals(carro.getFabricante(), outroCarro.getFabricante());
        assertEquals(carro.getNome(), outroCarro.getNome());
        assertEquals(carro.getPlaca(), outroCarro.getPlaca());
        assertEquals(carro.getPotencia(), outroCarro.getPotencia(), 0);
        assertEquals(carro.getQtdBatidas(), outroCarro.getQtdBatidas());
        assertEquals(carro.getQtdPortas(), outroCarro.getQtdPortas());
        assertEquals(carro.getQuilometragem(), outroCarro.getQuilometragem(), 0);
        assertEquals(carro.getRenavam(), outroCarro.getRenavam());
        assertEquals(carro.getTipoPneu(), outroCarro.getTipoPneu());
        assertEquals(carro.isEstaFuncional(), outroCarro.isEstaFuncional());
        assertEquals(carro.isPermitidaCirculacao(), outroCarro.isPermitidaCirculacao());
    }

}
