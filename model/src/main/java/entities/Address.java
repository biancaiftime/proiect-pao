package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String region;
    private String city;
    private String street;
    private String streetNumber;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public Address(String region, String city, String street, String streetNumber) {
        if (region != null && !region.trim().isEmpty())
            this.region = region.trim();
        else throw new IllegalArgumentException("Region cannot be null or empty.");
        if (city != null && !city.trim().isEmpty())
            this.city = city.trim();
        else throw new IllegalArgumentException("City cannot be null or empty.");
        if (street != null && !street.trim().isEmpty())
            this.street = street.trim();
        else throw new IllegalArgumentException("Street cannot be null or empty.");
        this.streetNumber = Objects.requireNonNull(streetNumber.trim());
    }


    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }


    public String getStreet() {
        return street;
    }


    public String getStreetNumber() {
        return streetNumber;
    }

    @Override
    public String toString() {
        return " region: " + region + ", city: " + city
                +",\n street:" + street + ", street number: " + streetNumber ;
    }
}
