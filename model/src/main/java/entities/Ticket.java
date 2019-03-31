package entities;

import java.util.Objects;

public class Ticket {
    private Long id;
    private Account account;
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
