package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
    public Connection conectarBD() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/teste?useSSL=false";
            String user = "root";
            String password = "200419"; // Substitua pela senha do usuário root
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conn;
    }

    public String nome = "";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha) {
        String sql = "SELECT nome FROM usuarios WHERE login = ? AND senha = ?";
        try (Connection conn = conectarBD();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            System.err.println("Erro ao verificar usuário: " + e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        User user = new User();
        boolean isValid = user.verificarUsuario("admin", "1234");
        System.out.println("Usuário válido? " + isValid);
    }
}
