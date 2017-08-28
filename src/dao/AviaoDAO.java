package dao;

import database.Conexao;
import database.Utilitarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Aviao;
import model.Categoria;

public class AviaoDAO {

    public ArrayList<Aviao> retornarListaAvioes() {
        ArrayList<Aviao> avioes = new ArrayList<>();
        String sql = "SELECT id, id_categoria, nome FROM avioes";

        try {
            Statement s = Conexao.conectar().createStatement();
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                Aviao aviao = new Aviao();
                aviao.setCodigo(rs.getInt("id"));
                aviao.setCategoria(new CategoriaDAO().buscarCategoriaPorId(rs.getInt("id_categoria")));
                aviao.setNome(rs.getString("nome"));
                avioes.add(aviao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return avioes;

    }

    public int inserir(Aviao aviao) {
        String sql = "INSERT INTO avioes (id_categoria,nome) VALUE (?,?);";
        int idInserido = Utilitarios.NAO_FOI_POSSIVEL_INSERIR;
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, aviao.getCategoria().getId());
            ps.setString(2, aviao.getNome());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idInserido = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return idInserido;
    }

    public int alterar(Aviao aviao) {
        String sql = "UPDATE avioes SET id_categoria = ?, nome = ?";
        int idAlterado = Utilitarios.NAO_FOI_POSSIVEL_ALTERAR;
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, aviao.getCategoria().getId());
            ps.setString(2, aviao.getNome());
            ps.setInt(3, aviao.getCodigo());
            idAlterado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return idAlterado;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM avioes WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            if(buscarAviaoPorId(id)== null){
                return  true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return  false;
    }
    public Aviao buscarAviaoPorId(int id){
        String sql = "SELECT id, id_categoria, nome FROM avioes WHERE id = ?";
        Aviao aviao = null;
        try{
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                aviao = new Aviao();
                aviao.setCodigo(rs.getInt("id"));
                aviao.setCategoria(new CategoriaDAO().buscarCategoriaPorId(rs.getInt("id_categoria")));
                aviao.setNome(rs.getString("nome"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return  aviao;
    }
}
