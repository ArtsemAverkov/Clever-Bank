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
    public Long create(User user) {
        try (Connection conn = connection.connect()) {
            PreparedStatement statement =
                    conn.prepareStatement("INSERT INTO user (name, lastName, email) VALUES (?,?,?)");
            int returnGeneratedKeys = Statement.RETURN_GENERATED_KEYS;
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            int i = statement.executeUpdate();
            if (i == 0) {
                throw new SQLException("Вставка записи не удалась, ни одна строка не была изменена.");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();

            connection.close();
            if (generatedKeys.next()) {
                long generatedId = generatedKeys.getLong(1);
                return generatedId;

            } else {
                throw new SQLException("Не удалось получить сгенерированный ключ.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
