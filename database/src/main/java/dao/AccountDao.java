package dao;

import entities.Account;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public final class AccountDao {
    private final EntityManager em;

    public AccountDao(EntityManager em) {
        this.em = em;
    }

    public void addAccount(Account account) {
        em.persist(account);
    }

    public Account getAccountById(Long id) {
        return em.find(Account.class, id);
    }

    public List<Account> getAccounts() {
        final String sql = "SELECT a FROM Account a";
        TypedQuery<Account> query = em.createQuery(sql, Account.class);
        return query.getResultList();
    }

    public User findUser(String username, String password) {
        final String sql = "SELECT a FROM Account a WHERE a.username = :username  AND a.password = :password";
        TypedQuery<Account> query = em.createQuery(sql, Account.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<Account> accounts = query.getResultList();
        if (accounts.isEmpty()) return null;
        return accounts.get(0).getUser();
    }

    public Account getAccountbyUser(User user) {
        final String sql = "SELECT a FROM Account a WHERE a.user = :user";
        TypedQuery<Account> query = em.createQuery(sql, Account.class);
        query.setParameter("user", user);
        List<Account> accounts = query.getResultList();
        return accounts.get(0);
    }

    public void deleteAccount(Account account){
        em.remove(account);
    }
    public void updateAccount(Account account){
        em.merge(account);
    }

}