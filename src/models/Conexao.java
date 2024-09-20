package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection connect() {
        String url = "jdbc:postgresql://localhost:5432/seu_banco_de_dados";
        String user = "seu_usuario";
        String password = "sua_senha";
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida!");
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
        return conn;
    }
}
