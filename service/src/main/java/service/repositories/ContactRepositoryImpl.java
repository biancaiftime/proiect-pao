package service.repositories;

import entities.Contact;
import repositories.ContactRepository;

import java.util.List;
import java.util.Optional;

public class ContactRepositoryImpl implements ContactRepository {
    @Override
    public Optional<Contact> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Contact> getAll() {
        return null;
    }

    @Override
    public Long put(Contact item) {
        return null;
    }

    @Override
    public List<Long> putAll(List<Contact> items) {
        return null;
    }
}
