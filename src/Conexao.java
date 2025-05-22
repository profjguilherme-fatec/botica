
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    private final String driver = "com.mysql.jdbc.Driver";
    private final String caminho = "jdbc:mysql://192.168.0.55:3306/boticario";
    private final String usuario = "master";
    private final String senha = "master";
    private Connection con;
    private String status = "Desconectado";

    public String getStatus() {
        return status;
    }

    /**
     * Método para conectar ao banco de dados
     */
    public void conectar() {
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
            status = "Conectado";
        } catch (SQLException ex) {
            status = "Desconectado";
            JOptionPane.showMessageDialog(null, "Servidor não encontrado. Consulte o administrador da rede.\nErro: " + ex.getMessage());
        }
    }

    /**
     * Método para desconectar do banco de dados
     */
    public void desconectar() {
        if (con != null) {
            try {
                con.close();
                status = "Desconectado";
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao desconectar do banco de dados.\nErro: " + ex.getMessage());
            }
        }
    }

    /**
     * Método para obter a conexão atual
     * 
     * @return Connection
     */
    public Connection getConnection() {
        return con;
    }
}