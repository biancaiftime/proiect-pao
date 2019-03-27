package service.repositories;

import entities.Event;
import entities.User;
import repositories.EventRepository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EventRepositoryImpl implements EventRepository {
    private final Map<Long, Event> events = new HashMap<>();

    @Override
    public Optional<Event> findById(Long id) {
        return Optional.ofNullable(events.get(id));
    }

    @Override
    public List<Event> getAll() {
        return new ArrayList<>(events.values());
    }

    @Override
    public Long put(Event item) {
        events.put(item.getId(), item);
        return item.getId();
    }

    @Override
    public List<Long> putAll(List<Event> items) {
        final var ids = items.stream()
                .map(Event::getId)
                .collect(Collectors.toList());
        final Map<Long, Event> newValues;
        newValues = items.stream()
                .collect(Collectors.toMap(Event::getId, Function.identity()));
        events.putAll(newValues);
        return ids;
    }
}
