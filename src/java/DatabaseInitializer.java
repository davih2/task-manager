import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private static final String URL = "jdbc:mysql://localhost:3306/root";
    private static final String USER = "root";
    private static final String PASSWORD = "d123456d";

    public void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                   + "id INT AUTO_INCREMENT PRIMARY KEY, "
                   + "nome VARCHAR(100), "
                   + "email VARCHAR(100) UNIQUE, "
                   + "senha VARCHAR(100));";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
             
            statement.execute(sql);
            System.out.println("Tabela 'usuarios' criada com sucesso.");

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}