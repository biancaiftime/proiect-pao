package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Event event;

    private Double price;

    public Ticket() {
    }

    public Ticket(Account account, Event event, Double price) {
        this.account = Objects.requireNonNull(account);
        this.event = Objects.requireNonNull(event);
        this.price = Objects.requireNonNull(price);
    }

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public Double getPrice() {
        return price;
    }

    public Account getAccount() {
        return account;
    }
}
