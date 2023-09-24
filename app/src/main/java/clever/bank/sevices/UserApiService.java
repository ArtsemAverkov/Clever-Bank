package clever.bank.sevices;

import clever.bank.entity.User;
import clever.bank.repository.UserRepository;

import java.util.List;

public class UserApiService implements UserService{

    private UserRepository userRepository;
    public UserApiService(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    @Override
    public Long create(User user) {
        return null;
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
