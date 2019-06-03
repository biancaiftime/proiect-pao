package dao;

import entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public final class ArtistDao {
    private final EntityManager em;

    public ArtistDao(EntityManager em) {
        this.em = em;
    }

    public void addArtist(Artist artist) {
        em.persist(artist);
    }

    public Artist getArtistById(Long id) {
        return em.find(Artist.class, id);
    }

    public List<Artist> getArtists() {
        final String sql = "SELECT a FROM Artist a";
        TypedQuery<Artist> query = em.createQuery(sql, Artist.class);
        return query.getResultList();
    }

    public void deleteArtist(Artist artist){
        em.remove(artist);
    }
}
