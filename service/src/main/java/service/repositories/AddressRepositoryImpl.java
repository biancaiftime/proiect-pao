package service.repositories;

import entities.Address;
import repositories.AddressRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AddressRepositoryImpl implements AddressRepository {
    private final Map<Long, Address> addresses = new HashMap<>();
    @Override
    public Optional<Address> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public Long put(Address item) {
        return null;
    }

    @Override
    public List<Long> putAll(List<Address> items) {
        return null;
    }
}
