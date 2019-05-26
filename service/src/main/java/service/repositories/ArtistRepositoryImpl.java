package service.repositories;

import entities.Artist;
import repositories.ArtistRepository;
import writer.Writer;

import java.util.*;

public class ArtistRepositoryImpl implements ArtistRepository {
    private final Map<Long, Artist> artistsMap = new HashMap<>();
    private final List<Artist> artists = new ArrayList<Artist>();
    private final Writer audit = new Writer();

    public ArtistRepositoryImpl() {
    }

    @Override
    public Optional<Artist> findById(Long id) {
        audit.writeData("ArtistRepository","findById");
        return Optional.ofNullable(artistsMap.get(id));
    }

    @Override
    public List<Artist> getAll() {
        audit.writeData("ArtistRepository","getAll");
        return Collections.unmodifiableList(artists);
    }

    @Override
    public Long put(Artist item) {
        audit.writeData("ArtistRepository","put");
        artists.add(item);
        artistsMap.put(item.getId(), item);
        return item.getId();
    }

    @Override
    public List<Long> putAll(List<Artist> items) {
        audit.writeData("ArtistRepository","putAll");
        artists.addAll(items);
        final var ids = new ArrayList<Long>();
        return ids;
    }
}
