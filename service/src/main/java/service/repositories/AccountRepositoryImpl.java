package service.repositories;

import entities.Account;
import repositories.AccountRepository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {
    private final Map<Long, Account> accounts = new HashMap<>();

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public Long put(Account item) {
        accounts.put(item.getId(), item);
        return item.getId();
    }

    @Override
    public List<Long> putAll(List<Account> items) {

        final Map<Long, Account> newValues = items.stream()
                .collect(Collectors.toMap(Account::getId, Function.identity()));

        accounts.putAll(newValues);

        final var ids = items.stream()
                .map(Account::getId)
                .collect(Collectors.toList());

        return ids;
    }
}
