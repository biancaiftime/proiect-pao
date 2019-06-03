package service;

import dao.ArtistDao;
import entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.function.Consumer;

public final class ArtistService {
    private final EntityManagerFactory emf;

    private static final String PERSISTENCE_UNIT_NAME = "proiect-pao";

    private ArtistService() {
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    private final static class SingletonHolder {
        private final static ArtistService INSTANCE = new ArtistService();
    }

    public static ArtistService getInstance() {
        return ArtistService.SingletonHolder.INSTANCE;
    }

    public void addArtist(Artist artist) {
        final EntityManager em = emf.createEntityManager();
        final ArtistDao artistDao = new ArtistDao(em);
        //orice modif de INSERT, UPDATE, DELETE se face intr-o tranzactie
        runInTransaction(artist, artistDao::addArtist, em.getTransaction());
    }

    private static void runInTransaction(Artist artist, Consumer<Artist> operation, EntityTransaction transaction) {
        transaction.begin();
        operation.accept(artist);
        transaction.commit();
    }

    public Artist getEventById(Long id) {
        final var em = emf.createEntityManager();
        final var artistDao = new ArtistDao(em);
        return artistDao.getArtistById(id);
    }

    public List<Artist> getArtists() {
        final var em = emf.createEntityManager();
        final var artistDao = new ArtistDao(em);
        return artistDao.getArtists();
    }
    public void deleteArtist(Artist artist){
        final var em = emf.createEntityManager();
        final var artistDao = new ArtistDao(em);
        runInTransaction(artist, artistDao::deleteArtist, em.getTransaction());
    }
}
