package clever.bank.connect;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectPostgresQL implements Connect{
    private Connection connection;
    Yaml yaml = new Yaml();
    InputStream inputStream = ConnectPostgresQL.class.getResourceAsStream("/properties.yml");
    AppConfig config = yaml.loadAs(inputStream, AppConfig.class);



    @Override
    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String password = "root";
        String url = "jdbc:postgresql://localhost:5432/artemaverkov";
        String username ="artemaverkov";
        Connection connections = DriverManager.getConnection(url, username, password);
        return connections;
    }

    @Override
    public boolean close() {
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
