package service;

import dao.EventDao;
import entities.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.function.Consumer;

public final class EventService {
    private final EntityManagerFactory emf;

    private static final String PERSISTENCE_UNIT_NAME = "proiect-pao";

    private EventService() {
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    private final static class SingletonHolder {
        private final static EventService INSTANCE = new EventService();
    }

    public static EventService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addEvent(Event event) {
        final EntityManager em = emf.createEntityManager();
        final EventDao eventDao = new EventDao(em);
        //orice modif de INSERT, UPDATE, DELETE se face intr-o tranzactie
        runInTransaction(event, eventDao::addEvent, em.getTransaction());
    }

    private static void runInTransaction(Event event, Consumer<Event> operation, EntityTransaction transaction) {
        transaction.begin();
        operation.accept(event);
        transaction.commit();
    }

    public Event getEventById(Long id) {
        final var em = emf.createEntityManager();
        final var eventDao = new EventDao(em);
        return eventDao.getEventById(id);
    }

//    public List<Order> getOrders() {
//        final var em = emf.createEntityManager();
//        final var orderDao = new OrderDao(em);
//        return orderDao.getOrders();
//    }
}