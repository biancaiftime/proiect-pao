package service.repositories;

import entities.Event;
import repositories.EventRepository;

import java.util.List;
import java.util.Optional;

public class EventRepositoryImpl implements EventRepository {
    @Override
    public Optional<Event> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Event> getAll() {
        return null;
    }

    @Override
    public Long put(Event item) {
        return null;
    }

    @Override
    public List<Long> putAll(List<Event> items) {
        return null;
    }
}
