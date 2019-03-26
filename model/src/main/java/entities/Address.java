package entities;

import java.util.Objects;

public class Address {
    private Long id;
    private String region;
    private String city;
    private String street;
    private String streetNumber;

    public Long getId() {
        return id;
    }

    public Address(Long id, String region, String city, String street, String streetNumber) {
        this.id = Objects.requireNonNull(id);
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

}
