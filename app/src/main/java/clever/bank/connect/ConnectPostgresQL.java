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
    public Connection connect() throws SQLException {
        String password = config.getDatabaseConfig().getPassword();
        String url = config.getDatabaseConfig().getUrl();
        String username = config.getDatabaseConfig().getUsername();
        Connection connections = DriverManager.getConnection(password, url, username);
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
