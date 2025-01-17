package Repository;

import Domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter
public class MemoryRepository implements UserRepository {
    private static Map<Long, User> users = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public User save(User user) {
        user.setId(++sequence);
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return users.get(id);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return users.values().stream()
                .filter(user -> user.getUserName().equals(userName))
                .findAny();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
}
