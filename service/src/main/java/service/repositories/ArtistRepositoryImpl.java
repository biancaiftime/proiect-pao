package service.repositories;

import entities.Artist;
import repositories.ArtistRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ArtistRepositoryImpl implements ArtistRepository {
    private final Map<Long, Artist> artists = new HashMap<>();
    @Override
    public Optional<Artist> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Artist> getAll() {
        return null;
    }

    @Override
    public Long put(Artist item) {
        return null;
    }

    @Override
    public List<Long> putAll(List<Artist> items) {
        return null;
    }
}
