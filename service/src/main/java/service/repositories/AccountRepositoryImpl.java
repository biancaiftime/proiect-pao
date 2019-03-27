package service.repositories;

import entities.Account;
import repositories.AccountRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {
    private final Map<Long, Account> accounts = new HashMap<>();
    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public Long put(Account item) {
        return null;
    }

    @Override
    public List<Long> putAll(List<Account> items) {
        return null;
    }
}
