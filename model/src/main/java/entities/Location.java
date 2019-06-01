package entities;

import entities.Address;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private String details;

    public Location() {
    }

    public Location(String name, Address address, String details) {
        if (name != null && !name.trim().isEmpty())
            this.name = name;
        else throw new IllegalArgumentException("Name cannot be null or empty.");
        this.address = Objects.requireNonNull(address);
        this.details = Objects.requireNonNull(details.trim());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", address: " + this.address;
    }
}

