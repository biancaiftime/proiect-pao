package service;

import dao.AccountDao;
import entities.Account;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.function.Consumer;

public final class AccountService {
    private final EntityManagerFactory emf;

    private static final String PERSISTENCE_UNIT_NAME = "proiect-pao";

    private AccountService() {
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    private final static class SingletonHolder {
        private final static AccountService INSTANCE = new AccountService();
    }

    public static AccountService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addAccount(Account account) {
        final EntityManager em = emf.createEntityManager();
        final AccountDao accountDao = new AccountDao(em);
        //orice modif de INSERT, UPDATE, DELETE se face intr-o tranzactie
        runInTransaction(account, accountDao::addAccount, em.getTransaction());
    }

    private static void runInTransaction(Account account, Consumer<Account> operation, EntityTransaction transaction) {
        transaction.begin();
        operation.accept(account);
        transaction.commit();
    }

    public Account getAccountById(Long id) {
        final var em = emf.createEntityManager();
        final var accountDao = new AccountDao(em);
        return accountDao.getAccountById(id);
    }

    public List<Account> getAccounts() {
        final var em = emf.createEntityManager();
        final var accountDao = new AccountDao(em);
        return accountDao.getAccounts();
    }

    public User findUser(String username, String password) {
        final var em = emf.createEntityManager();
        final var accountDao = new AccountDao(em);
        return accountDao.findUser(username, password);
    }
    public  Account getAccountbyUser(User user){
        final var em = emf.createEntityManager();
        final var accountDao = new AccountDao(em);
        return accountDao.getAccountbyUser(user);
    }
}