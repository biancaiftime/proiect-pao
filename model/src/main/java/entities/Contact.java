package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String phone;

    public Contact() {
    }

    public Contact(String email, String phone) {
        if (email != null && !email.trim().isEmpty())
            this.email = email.trim();
        else throw new IllegalArgumentException("Email cannot be null or empty.");
        if (phone != null && !phone.trim().isEmpty())
            this.phone = phone.trim();
        else throw new IllegalArgumentException("Phone cannot be null or empty.");
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "email: " + this.email + ", phone: " + this.phone;
    }
}
