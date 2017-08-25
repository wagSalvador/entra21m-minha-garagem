package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class Conexao {

    private static Connection conexao;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String HOST = "jdbc:mysql://localhost/minha_garagem";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection conectar() {
        try {
            Properties propriedades = new Properties();
            propriedades.setProperty("user", USUARIO);
            propriedades.setProperty("password", SENHA);

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(HOST, propriedades);
            return conexao;
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public static void desconectar() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            }
        }
    }

    public static void truncate() {
        conectar();
        if (conexao != null) {
            String sql = "TRUNCATE TABLE carros";
            sql += "TRUNCATE TABLE categorias";
            sql += "TRUNCATE TABLE avioes";
            try {
                Statement st = conexao.createStatement();
                st.addBatch("SET FOREIGN_KEY_CHECKS = 0;");

                st.addBatch("TRUNCATE TABLE carros;");
                st.addBatch("TRUNCATE TABLE categorias;");
                st.addBatch("TRUNCATE TABLE avioes;");
                st.addBatch("SET FOREIGN_KEY_CHECKS = 1;");
                st.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                desconectar();
            }
        }
    }

}
