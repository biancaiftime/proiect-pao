package service.repositories;

import entities.Account;
import entities.Event;
import entities.Ticket;
import repositories.TicketRepository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TicketRepositoryImpl implements TicketRepository {
    private final Map<Long, Ticket> tickets_map = new HashMap<>();
    private final ArrayList<Ticket> tickets = new ArrayList<>();

    @Override
    public Optional<Ticket> findById(Long id) {
        return Optional.ofNullable(tickets_map.get(id));
    }

    @Override
    public List<Ticket> getAll() {
        return new ArrayList<>(tickets_map.values());
    }

    @Override
    public Long put(Ticket item) {
        tickets_map.put(item.getId(), item);
        tickets.add(item);
        return item.getId();
    }

    @Override
    public List<Long> putAll(List<Ticket> items) {
        final var ids = items.stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());

        final Map<Long, Ticket> newValues = items.stream()
                .collect(Collectors.toMap(Ticket::getId, Function.identity()));

        tickets_map.putAll(newValues);
        tickets.addAll(items);

        return ids;
    }
    public List<Ticket> getByEvent(Event event){
        ArrayList<Ticket> tickets_event = new ArrayList<>();
        tickets.forEach(ticket -> {
            if(ticket.getEvent() == event)
                tickets_event.add(ticket);
        });
        return tickets_event;
    }
    public List<Ticket> getByAccount(Account account){
        ArrayList<Ticket> tickets_account = new ArrayList<>();
        tickets.forEach(ticket -> {
            if(ticket.getAccount() == account)
                tickets_account.add(ticket);
        });
        return tickets_account;
    }
}
