package dao;

import database.Conexao;
import database.Utilitarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Categoria;

/**
 * @author Alunos
 */
public class CategoriaDAO {

    public int inserir(Categoria c) {
        int codInserido = Utilitarios.NAO_FOI_POSSIVEL_INSERIR;
        String sql = "INSERT INTO categorias (nome,descricao)";
        sql += "\n VALUE(?,?)";
        try {
            //Classe utilizada para criar o sql substituindo as interrogações
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getDescricao());
            ps.execute();
            //classe que pega as informações que o bd retorna
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                codInserido = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO AO INSERIR CATEGORIADAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }
        return codInserido;

    }

    public int alterar(Categoria c) {
        int codAlterado = Utilitarios.NAO_FOI_POSSIVEL_ALTERAR;
        String sql = "UPDATE categorias SET nome=?, descricao=? WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getDescricao());
            ps.setInt(3, c.getId());
            codAlterado = ps.executeUpdate();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERRO AO ALTERAR CATEGORIADAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }
        return codAlterado;
    }

    public int excluir(int id) {
        int codExcluir = Utilitarios.NAO_FOI_POSSIVEL_EXCLUIR;
        String sql = "DELETE FROM categorias WHERE id =? ";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            codExcluir = ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO AO EXCLUIR CATEGORIADAO", JOptionPane.ERROR_MESSAGE);
        }finally{
            Conexao.desconectar();
        }
        return codExcluir;
    }

    public ArrayList<Categoria> retornarListaCategoria() {
        ArrayList<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT id, nome, descricao, ativo FROM categorias";
        try {
            Statement s = Conexao.conectar().createStatement();
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                Categoria ca = new Categoria();
                ca.setId(rs.getInt("id"));
                ca.setNome(rs.getString("nome"));
                ca.setDescricao(rs.getString("descricao"));
                ca.setAtivo(rs.getBoolean("ativo"));
                categorias.add(ca);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO AO RETORNAR LISTA CATEGORIADAO", JOptionPane.ERROR_MESSAGE);

        }finally{
            Conexao.desconectar();
        }
        return categorias;
    }

    public Categoria buscarCategoriaPorId(int codigo) {
        Categoria categoria = null;
        String sql = "SELECT nome, descricao, ativo FROM categorias WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            
            if(rs.next()){
                categoria = new Categoria();
                categoria.setId(codigo);
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("desscricao"));
                categoria.setAtivo(rs.getBoolean("ativo"));
            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "ERRO AO ALTERAR CATEGORIADAO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.desconectar();
        }
        return categoria;
    }

    public Categoria buscarCategoriaPorNome(String nome) {
        Categoria categoria = null;
        return categoria;
    }

    public ArrayList<Categoria> buscarCategoriaPorStatus(boolean status) {
        ArrayList<Categoria> categorias = new ArrayList<>();
        return categorias;
    }

}
