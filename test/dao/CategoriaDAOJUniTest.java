package dao;

import database.Conexao;
import database.Utilitarios;
import model.Categoria;
import org.junit.Test;
import static org.junit.Assert.*;

public class CategoriaDAOJUniTest {

    @Test
    public void inserir() {
        Conexao.truncate();
        Categoria categoria = new Categoria();
        categoria.setAtivo(true);
        categoria.setDescricao("isaodhisaud");
        categoria.setNome("Média");
        int id = new CategoriaDAO().inserir(categoria);
        assertEquals(1, id);

    }

    @Test
    public void buscarPorId() {
        Conexao.truncate();
        Categoria categoria = new Categoria();
        categoria.setAtivo(true);
        categoria.setDescricao("isaodhisaud");
        categoria.setNome("Média");
        int id = new CategoriaDAO().inserir(categoria);
        categoria.setId(id);
        Categoria categoriaBuscada = new CategoriaDAO().buscarCategoriaPorId(id);

        assertNotNull(categoriaBuscada);
        assertEquals(categoria.getId(), categoriaBuscada.getId());
        assertEquals(categoria.getNome(), categoriaBuscada.getNome());
        assertEquals(categoria.getDescricao(), categoriaBuscada.getDescricao());
        assertEquals(categoria.isAtivo(), categoriaBuscada.isAtivo());
    }

    public void alterar() {
        Conexao.truncate();
        Categoria categoria = new Categoria();
        categoria.setAtivo(true);
        categoria.setDescricao("isaodhisaud");
        categoria.setNome("Média");
        int id = new CategoriaDAO().inserir(categoria);
        categoria.setId(id);
        categoria.setDescricao("isaDAdadhisaud");
        categoria.setNome("Alta");
        int idAterar = new CategoriaDAO().alterar(categoria);
        assertNotSame(Utilitarios.NAO_FOI_POSSIVEL_ALTERAR, idAterar);
       Categoria categoriaBuscada = new CategoriaDAO().buscarCategoriaPorId(categoria.getId());
        assertEquals(categoria.getId(), categoriaBuscada.getId());
        assertEquals(categoria.getNome(), categoriaBuscada.getNome());
        assertEquals(categoria.getDescricao(), categoriaBuscada.getDescricao());
        assertEquals(categoria.isAtivo(), categoriaBuscada.isAtivo());
    }

    public void excluir() {

    }

}
