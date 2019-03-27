package entities;

import entities.Address;
import entities.Contact;

import java.util.Objects;

public class User {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private Address address;
    private Contact contact;

    public User() {
    }

    public User(String name, String surname, int age, Address address, Contact contact) {
        if (name != null && !name.trim().isEmpty())
            this.name = name;
        else throw new IllegalArgumentException("Name cannot be null or empty.");
        if (surname != null && !surname.trim().isEmpty())
            this.surname = surname;
        else throw new IllegalArgumentException("Surname cannot be null or empty.");
        if (age >= 18)
            this.age = age;
        else throw new IllegalArgumentException("Age cannot be less than 18 years old.");
        this.address = Objects.requireNonNull(address);
        this.contact = Objects.requireNonNull(contact);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public Contact getContact() {
        return contact;
    }

    public Long getId() {
        return id;
    }
}
