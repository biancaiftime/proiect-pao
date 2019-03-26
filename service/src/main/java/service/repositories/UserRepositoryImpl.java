package service.repositories;

import entities.User;
import repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Long put(User item) {
        return null;
    }

    @Override
    public List<Long> putAll(List<User> items) {
        return null;
    }
}
