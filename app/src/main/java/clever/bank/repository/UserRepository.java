package clever.bank.repository;

import clever.bank.entity.User;

import java.util.List;

public interface UserRepository {
    Long create(User user);
    User read (Long id);
    boolean update(User user, Long id);
    boolean delete(Long id);
    List<User> readAll();
}
