package entities;

import java.util.Objects;

public class Account {
    private Long id;
    private String username;
    private String password;
    private User user;

    public Long getId() {
        return id;
    }

    public Account(Long id, String username, String password, User user) {
        this.id = Objects.requireNonNull(id);
        if (username != null && !username.trim().isEmpty())
            this.username = username;
        else throw new IllegalArgumentException("Username cannot be null or empty.");
        if (password != null && !password.trim().isEmpty())
            this.password = password;
        else throw new IllegalArgumentException("Region cannot be null or empty.");
        this.user = Objects.requireNonNull(user);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User getUser() {
        return user;
    }
}
