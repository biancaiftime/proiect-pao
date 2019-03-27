package service.repositories;

import entities.Location;
import repositories.LocationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LocationRepositoryImpl implements LocationRepository {
    private final Map<Long, Location> locations = new HashMap<>();
    @Override
    public Optional<Location> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Location> getAll() {
        return null;
    }

    @Override
    public Long put(Location item) {
        return null;
    }

    @Override
    public List<Long> putAll(List<Location> items) {
        return null;
    }
}
