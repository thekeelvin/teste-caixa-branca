package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * A classe {@code User} representa um usuário e contém métodos
 * para conectar ao banco de dados e verificar o login e a senha.
 */
public class User {

    /**
     * Estabelece a conexão com o banco de dados MySQL.
     * 
     * @return A conexão com o banco de dados ou null se a conexão falhar.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.Driver.Manager").newInstance();
            
            // URL de conexão com o banco de dados
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Tratar exceção
        }
        return conn;
    }

    // Variáveis de instância
    /** O nome do usuário */
    public String nome = "";
    
    /** Resultado da verificação do usuário (se o login foi bem-sucedido) */
    public boolean result = false;

    /**
     * Verifica se o usuário e a senha fornecidos são válidos no banco de dados.
     * 
     * @param login O login do usuário.
     * @param senha A senha do usuário.
     * @return Retorna {@code true} se o usuário for encontrado e validado, caso contrário {@code false}.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        
        // Conecta ao banco de dados
        Connection conn = conectarBD();
        
        // Comando SQL para verificar o usuário
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";  // Faz a comparação com o login fornecido
        sql += " and senha = '" + senha + "';"; // E também com a senha fornecida
        
        try {
            // Cria uma statement para executar a consulta SQL
            Statement st = conn.createStatement();
            // Executa a consulta
            ResultSet rs = st.executeQuery(sql);
            
            // Verifica se algum usuário foi encontrado
            if (rs.next()) {
                result = true; // Usuário validado
                nome = rs.getString("nome"); // Armazena o nome do usuário
            }
        } catch (Exception e) {
            // Tratar exceção (caso ocorra)
        }
        return result; // Retorna o resultado da verificação
    }
}
