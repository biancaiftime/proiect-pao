package entities;

import utils.Category;
import utils.EventType;
import utils.Status;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Event {
    private Long id;
    private String name;
    private Category category;
    private EventType type;
    private Location location;
    private Date date;
    private Status status;
    private String details;
    private List<Artist> artists;

    public Event() {
    }

    public Event(String name, Category category, EventType type, Location location, Date date, Status status, String details, List<Artist> artists) {
        if (name != null && !name.trim().isEmpty())
            this.name = name;
        else throw new IllegalArgumentException("Name cannot be null or empty.");
        this.category = Objects.requireNonNull(category);
        this.type = Objects.requireNonNull(type);
        this.location = Objects.requireNonNull(location);
        this.date = Objects.requireNonNull(date);
        this.status = Objects.requireNonNull(status);
        this.details = Objects.requireNonNull(details);
        this.artists = Objects.requireNonNull(Collections.unmodifiableList(artists));
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public EventType getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public List<Artist> getArtists() {
        return Collections.unmodifiableList(artists);
    }

    public Long getId() {
        return id;
    }
}
