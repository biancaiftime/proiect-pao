package dao;

import entities.Event;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Order;
import java.util.List;

public final class EventDao {
    private final EntityManager em;

    public EventDao(EntityManager em) {
        this.em = em;
    }

    public void addEvent(Event event) {
        em.persist(event);
    }

    public Event getEventById(Long id) {
        return em.find(Event.class, id);
    }

    public List<Event> getEvents() {
        final String sql = "SELECT e FROM Event e";
        TypedQuery<Event> query = em.createQuery(sql, Event.class);
        return query.getResultList();
    }

}