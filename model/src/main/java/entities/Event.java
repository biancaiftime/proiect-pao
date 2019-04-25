package entities;

import utils.Category;
import utils.EventType;
import utils.Status;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class Event {
    private Long id;
    private String name;
    private Category category;
    private EventType type;
    private Location location;
    private Instant date;
    private Status status;
    private String details;
    private Artist artist;

    public Event() {
    }

    public Event(String name, Category category, EventType type, Location location, Instant date, Status status, String details, Artist artist) {
        if (name != null && !name.trim().isEmpty())
            this.name = name;
        else throw new IllegalArgumentException("Name cannot be null or empty.");
        this.category = Objects.requireNonNull(category);
        this.type = Objects.requireNonNull(type);
        this.location = Objects.requireNonNull(location);
        this.date = Objects.requireNonNull(date);
        this.status = Objects.requireNonNull(status);
        this.details = Objects.requireNonNull(details);
        this.artist = Objects.requireNonNull(artist);
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

    public Instant getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public Artist getArtist() {
        return artist;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
