package service;

import dao.TicketDao;
import entities.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.function.Consumer;

public final class TicketService {
    private final EntityManagerFactory emf;

    private static final String PERSISTENCE_UNIT_NAME = "proiect-pao";

    private TicketService() {
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    private final static class SingletonHolder {
        private final static TicketService INSTANCE = new TicketService();
    }

    public static TicketService getInstance() {
        return TicketService.SingletonHolder.INSTANCE;
    }

    public void addTicket(Ticket ticket) {
        final EntityManager em = emf.createEntityManager();
        final TicketDao ticketDao = new TicketDao(em);
        //orice modif de INSERT, UPDATE, DELETE se face intr-o tranzactie
        runInTransaction(ticket, ticketDao::addTicket, em.getTransaction());
    }

    private static void runInTransaction(Ticket ticket, Consumer<Ticket> operation, EntityTransaction transaction) {
        transaction.begin();
        operation.accept(ticket);
        transaction.commit();
    }

    public Ticket getTicketById(Long id) {
        final var em = emf.createEntityManager();
        final var ticketDao = new TicketDao(em);
        return ticketDao.getTicketById(id);
    }

    public List<Ticket> getTickets() {
        final var em = emf.createEntityManager();
        final var ticketDao = new TicketDao(em);
        return ticketDao.getTickets();
    }

    public void deleteTicket(Ticket ticket){
        final var em = emf.createEntityManager();
        final var ticketDao = new TicketDao(em);
        runInTransaction(ticket, ticketDao::deleteTicket,em.getTransaction());
    }
}
