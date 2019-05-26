package service.repositories;

import entities.User;
import repositories.UserRepository;
import writer.Writer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> usersMap = new HashMap<>();
    private final List<User> users = new ArrayList<User>();
    private final Writer audit = new Writer();

    public UserRepositoryImpl() {
    }

    @Override
    public Optional<User> findById(Long id) {
        audit.writeData("UserRepository","findById");
        return Optional.ofNullable(usersMap.get(id));
    }

    @Override
    public List<User> getAll() {
        audit.writeData("UserRepository","getAll");
        return Collections.unmodifiableList(users);
    }

    @Override
    public Long put(User item) {
        audit.writeData("UserRepository","put");
        users.add(item);
        usersMap.put(item.getId(), item);
        return item.getId();
    }

    @Override
    public List<Long> putAll(List<User> items) {
        audit.writeData("UserRepository","putAll");
        /*final var ids = items.stream()
                .map(User::getId)
                .collect(Collectors.toList());

        final Map<Long, User> newValues = items.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));

        users.putAll(newValues);*/
        final var ids = new ArrayList<Long>();
        users.addAll(items);

        return ids;
    }
}
