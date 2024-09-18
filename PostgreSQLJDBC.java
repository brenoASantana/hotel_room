import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLJDBC {
    public static void main(String[] args) {
        // Informações de conexão
        String url = "jdbc:postgresql://localhost:5432/hotel_room";
        String user = "admin";
        String password = "admin";

        // Estabelecendo a conexão
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");
            // Faça operações no banco de dados aqui

            // Fechar a conexão após o uso
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
