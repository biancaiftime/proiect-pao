package entities;

import java.util.Objects;

public class Artist {
    private Long id;
    private String name;
    private String description;

    public Artist() {
    }

    public Artist(String name, String description) {
        if (name != null && !name.trim().isEmpty())
            this.name = name;
        else throw new IllegalArgumentException("Name cannot be null or empty.");
        this.description = Objects.requireNonNull(description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }
}
