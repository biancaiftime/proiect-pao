package service.repositories;

import entities.Artist;
import entities.Event;
import entities.Location;
import repositories.EventRepository;
import utils.Category;
import utils.EventType;
import utils.Status;
import writer.Audit;
import writer.Writer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EventRepositoryImpl implements EventRepository {
    private final Map<Long, Event> events_map = new HashMap<>();
    private final ArrayList<Event> events = new ArrayList<>();
    private final Writer audit = new Writer();

    @Override
    @Audit(className = "EventRepository", methodName = "findById")
    public Optional<Event> findById(Long id) {
        audit.writeData("EventRepository","findById");
        return Optional.ofNullable(events_map.get(id));
    }

    @Override
    @Audit(className = "EventRepository", methodName = "getAll")
    public List<Event> getAll() {
        audit.writeData("EventRepository","getAll");
        return new ArrayList<>(events);
    }

    @Override
    @Audit(className = "EventRepository", methodName = "put")
    public Long put(Event item) {
        audit.writeData("EventRepository","put");
        events_map.put(item.getId(), item);
        events.add(item);
        return item.getId();
    }

    @Override
    @Audit(className = "EventRepository", methodName = "putAll")
    public List<Long> putAll(List<Event> items) {
        audit.writeData("EventRepository","putAll");
        /*final var ids = items.stream()
                .map(Event::getId)
                .collect(Collectors.toList());
        final Map<Long, Event> newValues;
        newValues = items.stream()
                .collect(Collectors.toMap(Event::getId, Function.identity()));
        events_map.putAll(newValues);*/
        final var ids = new ArrayList<Long>();
        events.addAll(items);
        return ids;
    }

    @Override
    @Audit(className = "EventRepository", methodName = "getByArtist")
    public List<Event> getByArtist(Artist artist) {
        audit.writeData("EventRepository","getByArtist");
        ArrayList<Event> events_artist = new ArrayList<>();

        events.forEach(event -> {
            if (event.getArtist() == artist)
                events_artist.add(event);
        });
        return events_artist;
    }

    @Override
    @Audit(className = "EventRepository", methodName = "getByType")
    public List<Event> getByType(EventType eventType) {
        audit.writeData("EventRepository","getByType");

        ArrayList<Event> events_type = new ArrayList<>();

        events.forEach(event -> {
            if (event.getType() == eventType)
                events_type.add(event);
        });
        return events_type;
    }

    @Override
    @Audit(className = "EventRepository", methodName = "getByCategory")
    public List<Event> getByCategory(Category category) {
        audit.writeData("EventRepository","getByCategory");

        ArrayList<Event> events_category = new ArrayList<>();

        events.forEach(event -> {
            if (event.getCategory() == category)
                events_category.add(event);
        });
        return events_category;
    }

    @Override
    @Audit(className = "EventRepository", methodName = "getByStatus")
    public List<Event> getByStatus(Status status) {
        audit.writeData("EventRepository","getByStatus");
        ArrayList<Event> events_status = new ArrayList<>();

        events.forEach(event -> {
            if (event.getStatus() == status)
                events_status.add(event);
        });
        return events_status;
    }

    @Override
    @Audit(className = "EventRepository", methodName = "getByLocation")
    public List<Event> getByLocation(Location location) {
        audit.writeData("EventRepository","getByLocation");
        ArrayList<Event> events_location = new ArrayList<>();

        events.forEach(event -> {
            if (event.getLocation() == location)
                events_location.add(event);
        });
        return events_location;
    }
}
