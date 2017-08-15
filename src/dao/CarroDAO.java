package dao;

import database.Conexao;
import database.Utilitarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Carro;

/**
 *
 * @author (name = Igor Hinckel, date= 2017-08-07)
 */
public class CarroDAO {

    public ArrayList<Carro> retornarListagem() {
        ArrayList<Carro> carros = new ArrayList<>();
        String sql = "SELECT ";
        sql += "id, nome,cor,fabricante, placa, chassi,";
        sql += "quilometragem, potencia,data_compra,";
        sql += "esta_funcionando, permitida_circulacao,";
        sql += "quantidade_portas, quantidade_batidas,";
        sql += "ano_fabricacao, ano_lancamento,tipo_pneu,";
        sql += "renavam, descricao ";
        sql += "FROM carros";
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            try {
                Statement statement = conexao.createStatement();
                statement.execute(sql);
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {

                    Carro carro = new Carro();
                    carro.setId(resultSet.getInt("id"));
                    carro.setNome(resultSet.getString("nome"));
                    carro.setCor(resultSet.getString("cor"));
                    carro.setFabricante(resultSet.getString("fabricante"));
                    carro.setPlaca(resultSet.getString("placa"));
                    carro.setChassi(resultSet.getString("chassi"));

                    carro.setAnoFabricacao(resultSet.getShort("ano_fabricacao"));
                    carro.setAnoLancamento(resultSet.getShort("ano_lancamento"));
                    carro.setTipoPneu(resultSet.getShort("tipo_pneu"));

                    carro.setQuilometragem(resultSet.getFloat("quilometragem"));
                    carro.setPotencia(resultSet.getFloat("potencia"));

                    carro.setEstaFuncional(resultSet.getBoolean("esta_funcionando"));
                    carro.setPermitidaCirculacao(resultSet.getBoolean("permitida_circulacao"));

                    carro.setQtdBatidas(resultSet.getByte("quantidade_batidas"));
                    carro.setQtdPortas(resultSet.getByte("quantidade_portas"));

                    carro.setRenavam(resultSet.getInt("renavam"));

                    carro.setDataCompra(resultSet.getDate("data_compra"));

                    carro.setDescricao(resultSet.getString("descricao"));

                    //adicionando no ArrayList
                    carros.add(carro);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.exit(0);
            }
        }
        return carros;
    }

    public int inserir(Carro carro) {
        int codigoInserido = Utilitarios.NAO_FOI_POSSIVEL_INSERIR;
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO carros(";
            sql += "nome, cor, fabricante, placa, chassi, quilometragem,";
            sql += "potencia, data_compra, esta_funcionando,";
            sql += "permitida_circulacao, quantidade_portas,";
            sql += "quantidade_batidas, ano_fabricacao, ano_lancamento,";
            sql += "tipo_pneu, renavam, descricao) VALUE";
            sql += "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement preparador = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                preparador.setString(1, carro.getNome());
                preparador.setString(2, carro.getCor());
                preparador.setString(3, carro.getFabricante());
                preparador.setString(4, carro.getPlaca());
                preparador.setString(5, carro.getChassi());
                preparador.setFloat(6, carro.getQuilometragem());
                preparador.setFloat(7, carro.getPotencia());
                preparador.setDate(8, carro.getDataCompra());
                preparador.setBoolean(9, carro.isEstaFuncional());
                preparador.setBoolean(10, carro.isPermitidaCirculacao());
                preparador.setByte(11, carro.getQtdPortas());
                preparador.setByte(12, carro.getQtdBatidas());
                preparador.setShort(13, carro.getAnoFabricacao());
                preparador.setShort(14, carro.getAnoLancamento());
                preparador.setShort(15, carro.getTipoPneu());
                preparador.setInt(16, carro.getRenavam());
                preparador.setString(17, carro.getDescricao());

                preparador.execute();
                ResultSet resultado = preparador.getGeneratedKeys();
                while (resultado.next()) {
                    codigoInserido = resultado.getInt(1);
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.getMessage());
                System.exit(0);
            } finally {
                Conexao.desconectar();
            }
        }
        return codigoInserido;
    }

    public int alterar(Carro carro) {
        int codigoAlteracao = Utilitarios.NAO_FOI_POSSIVEL_ALTERAR;

        String sql = "UPDATE carros SET ";
        sql += "nome = ?,";
        sql += "cor = ?,";
        sql += "fabricante = ?,";
        sql += "placa = ?,";
        sql += "chassi = ?,";
        sql += "quilometragem = ?,";
        sql += "potencia = ?,";
        sql += "data_compra = ?,";
        sql += "esta_funcionando = ?,";
        sql += "permitida_circulacao= ?,";
        sql += "quantidade_portas = ?,";
        sql += "quantidade_batidas = ?, ";
        sql += "ano_fabricacao = ?,";
        sql += "ano_lancamento = ?,";
        sql += "tipo_pneu = ?,";
        sql += "renavam = ?,";
        sql += "descricao = ?";
        sql += "WHERE id = ?";
        try {
            PreparedStatement substituidor = Conexao.conectar().prepareStatement(sql);
            substituidor.setString(1, carro.getNome());
            substituidor.setString(2, carro.getCor());
            substituidor.setString(3, carro.getFabricante());
            substituidor.setString(4, carro.getPlaca());
            substituidor.setString(5, carro.getChassi());
            substituidor.setFloat(6, carro.getQuilometragem());
            substituidor.setFloat(7, carro.getPotencia());
            substituidor.setDate(8, carro.getDataCompra());
            substituidor.setBoolean(9, carro.isEstaFuncional());
            substituidor.setBoolean(10, carro.isPermitidaCirculacao());
            substituidor.setByte(11, carro.getQtdPortas());
            substituidor.setByte(12, carro.getQtdBatidas());
            substituidor.setShort(13, carro.getAnoFabricacao());
            substituidor.setShort(14, carro.getAnoLancamento());
            substituidor.setShort(15, carro.getTipoPneu());
            substituidor.setInt(16, carro.getRenavam());
            substituidor.setString(17, carro.getDescricao());
            substituidor.setInt(18, carro.getId());

            codigoAlteracao = substituidor.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
            System.exit(0);
        } finally {
            Conexao.desconectar();
        }

        return codigoAlteracao;
    }

    public int excluir(int id) {
        String sql = "DELETE FROM carros WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
            System.exit(0);
        } finally {
            Conexao.desconectar();
        }
        return Utilitarios.NAO_FOI_POSSIVEL_EXCLUIR;
    }

    public void truncate() {
        String sql = "TRUNCATE carros";
        try {
            Statement statement = Conexao.conectar().createStatement();
            statement.execute(sql);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
            System.exit(0);
        }
    }

    public Carro buscarPorId(int id) {
        Carro carro = null;
        String sql = "SELECT ";
        sql += "id, nome,cor,fabricante, placa, chassi, ";
        sql += "quilometragem, potencia,data_compra, ";
        sql += "esta_funcionando, permitida_circulacao, ";
        sql += "quantidade_portas, quantidade_batidas, ";
        sql += "ano_fabricacao, ano_lancamento,tipo_pneu, ";
        sql += "renavam, descricao ";
        sql += "FROM carros ";
        sql += "WHERE id = ?";

        try {
            PreparedStatement botador = Conexao.conectar().prepareStatement(sql);
            botador.setInt(1, id);
            botador.execute();
            ResultSet resultado = botador.getResultSet();

            if (resultado.next()) {

                carro = new Carro();
                carro.setId(resultado.getInt("id"));
                carro.setNome(resultado.getString("nome"));
                carro.setCor(resultado.getString("cor"));
                carro.setFabricante(resultado.getString("fabricante"));
                carro.setPlaca(resultado.getString("placa"));
                carro.setChassi(resultado.getString("chassi"));

                carro.setAnoFabricacao(resultado.getShort("ano_fabricacao"));
                carro.setAnoLancamento(resultado.getShort("ano_lancamento"));
                carro.setTipoPneu(resultado.getShort("tipo_pneu"));

                carro.setQuilometragem(resultado.getFloat("quilometragem"));
                carro.setPotencia(resultado.getFloat("potencia"));

                carro.setEstaFuncional(resultado.getBoolean("esta_funcionando"));
                carro.setPermitidaCirculacao(resultado.getBoolean("permitida_circulacao"));

                carro.setQtdBatidas(resultado.getByte("quantidade_batidas"));
                carro.setQtdPortas(resultado.getByte("quantidade_portas"));

                carro.setRenavam(resultado.getInt("renavam"));

                carro.setDataCompra(resultado.getDate("data_compra"));

                carro.setDescricao(resultado.getString("descricao"));
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
            System.exit(0);
        }

        return carro;

    }
}
