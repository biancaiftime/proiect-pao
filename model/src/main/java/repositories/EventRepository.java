package repositories;

import entities.Artist;
import entities.Event;
import entities.Location;
import utils.Category;
import utils.EventType;
import utils.Status;

import java.util.List;

public interface EventRepository extends Repository<Event> {
    List<Event> getByArtist(Artist artist);

    List<Event> getByType(EventType eventType);

    List<Event> getByCategory(Category category);

    List<Event> getByStatus(Status status);

    List<Event> getByLocation(Location location);
}
