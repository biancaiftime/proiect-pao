package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;


    public Long getId() {
        return id;
    }

    public Account() {
    }

    public Account(String username, String password, User user) {
        if (username != null && !username.trim().isEmpty())
            this.username = username;
        else throw new IllegalArgumentException("Username cannot be null or empty.");
        if (password != null && !password.trim().isEmpty())
            this.password = password;
        else throw new IllegalArgumentException("Password cannot be null or empty.");
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

    @Override
    public String toString() {
        return "Account{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user=" + user +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
