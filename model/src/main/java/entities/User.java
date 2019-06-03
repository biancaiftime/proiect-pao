package entities;

import entities.Address;
import entities.Contact;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
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
    public User(String name, String surname) {
        if (name != null && !name.trim().isEmpty())
            this.name = name;
        else throw new IllegalArgumentException("Name cannot be null or empty.");
        if (surname != null && !surname.trim().isEmpty())
            this.surname = surname;
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

    @Override
    public String toString() {
        return "Name: " + this.name + ", surname: " + this.surname + ", age: " + this.age
                + ", Address: " + this.address + ", contact: " + this.contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
