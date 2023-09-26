package clever.bank.sevices;

import clever.bank.entity.User;

import java.util.List;

public interface UserService {
    boolean create(User user);
    User read (Long id);
    boolean update(User user, Long id);
    boolean delete(Long id);
    List<User> readAll();
}
