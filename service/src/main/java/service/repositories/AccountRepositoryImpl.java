package service.repositories;

import entities.Account;
import repositories.AccountRepository;
import writer.Writer;

import java.util.*;

public class AccountRepositoryImpl implements AccountRepository {
    private final Map<Long, Account> accountsMap = new HashMap<>();
    private final List<Account> accounts = new ArrayList<Account>();
    private final Writer audit = new Writer();

    public AccountRepositoryImpl() {
    }

    @Override
    public Optional<Account> findById(Long id) {
        audit.writeData("AccountRepository", "findById");
        return Optional.ofNullable(accountsMap.get(id));
    }

    @Override
    public List<Account> getAll() {
        audit.writeData("AccountRepository", "getAll");
        return Collections.unmodifiableList(accounts);
    }

    @Override
    public Long put(Account item) {
        audit.writeData("AccountRepository","put");
        accounts.add(item);
        accountsMap.put(item.getId(), item);
        return item.getId();
    }

    @Override
    public List<Long> putAll(List<Account> items) {
        audit.writeData("AccountRepository","putAll");

        /*final Map<Long, Account> newValues = items.stream()
                .collect(Collectors.toMap(Account::getId, Function.identity()));

        accountsMap.putAll(newValues);*/
        accounts.addAll(items);

        /*final var ids = items.stream()
                .map(Account::getId)
                .collect(Collectors.toList());*/
        final var ids = new ArrayList<Long>();

        return ids;
    }
}
