package service.repositories;

import entities.Artist;
import entities.Event;
import entities.Location;
import repositories.EventRepository;
import utils.Category;
import utils.EventType;
import utils.Status;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EventRepositoryImpl implements EventRepository {
    private final Map<Long, Event> events_map = new HashMap<>();
    private final ArrayList<Event> events = new ArrayList<>();

    @Override
    public Optional<Event> findById(Long id) {
        return Optional.ofNullable(events_map.get(id));
    }

    @Override
    public List<Event> getAll() {
        return new ArrayList<>(events_map.values());
    }

    @Override
    public Long put(Event item) {
        events_map.put(item.getId(), item);
        events.add(item);
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
        events_map.putAll(newValues);
        events.addAll(items);
        return ids;
    }

    @Override
    public List<Event> getByArtist(Artist artist) {
        ArrayList<Event> events_artist = new ArrayList<>();

        events.forEach(event -> {
            if (event.getArtist() == artist)
                events_artist.add(event);
        });
        return events_artist;
    }

    @Override
    public List<Event> getByType(EventType eventType) {

        ArrayList<Event> events_type = new ArrayList<>();

        events.forEach(event -> {
            if (event.getType() == eventType)
                events_type.add(event);
        });
        return events_type;
    }

    @Override
    public List<Event> getByCategory(Category category) {

        ArrayList<Event> events_category = new ArrayList<>();

        events.forEach(event -> {
            if (event.getCategory() == category)
                events_category.add(event);
        });
        return events_category;
    }

    @Override
    public List<Event> getByStatus(Status status) {
        ArrayList<Event> events_status = new ArrayList<>();

        events.forEach(event -> {
            if (event.getStatus() == status)
                events_status.add(event);
        });
        return events_status;
    }

    @Override
    public List<Event> getByLocation(Location location) {
        ArrayList<Event> events_location = new ArrayList<>();

        events.forEach(event -> {
            if (event.getLocation() == location)
                events_location.add(event);
        });
        return events_location;
    }
}
