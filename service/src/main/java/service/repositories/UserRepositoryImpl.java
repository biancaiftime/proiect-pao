package service.repositories;

import entities.User;
import repositories.UserRepository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public Long put(User item) {
        users.put(item.getId(), item);
        return item.getId();
    }

    @Override
    public List<Long> putAll(List<User> items) {
        final var ids = items.stream()
                .map(User::getId)
                .collect(Collectors.toList());

        final Map<Long, User> newValues = items.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));

        users.putAll(newValues);

        return ids;
    }
}
