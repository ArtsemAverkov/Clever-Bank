package clever.bank.repository;

import clever.bank.connect.Connect;
import clever.bank.connect.ConnectPostgresQL;
import clever.bank.entity.User;

import java.sql.*;
import java.util.List;

public class UserApiRepository implements UserRepository{
    Connect connection;

    public UserApiRepository(){
        connection = new ConnectPostgresQL();
    }

    @Override
    public boolean create(User user) {
        try (Connection conn = connection.connect()) {
            PreparedStatement statement =
                    conn.prepareStatement("INSERT INTO users (name, last_name, email) VALUES (?,?,?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted == 0) {
                throw new SQLException("Вставка записи не удалась, ни одна строка не была изменена.");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }



    @Override
    public User read(Long id) {
        return null;
    }

    @Override
    public boolean update(User user, Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<User> readAll() {
        return null;
    }
}
