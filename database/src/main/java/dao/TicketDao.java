package dao;

import entities.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public final class TicketDao {
    private final EntityManager em;

    public TicketDao(EntityManager em) {
        this.em = em;
    }

    public void addTicket(Ticket ticket) {
        em.persist(ticket);
    }

    public Ticket getTicketById(Long id) {
        return em.find(Ticket.class, id);
    }

    public List<Ticket> getTickets() {
        final String sql = "SELECT t FROM Ticket t";
        TypedQuery<Ticket> query = em.createQuery(sql, Ticket.class);
        return query.getResultList();
    }

    public void deleteTicket(Ticket ticket){
        em.remove(ticket);
    }
}
