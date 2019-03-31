package service.app;

import repositories.AccountRepository;
import repositories.EventRepository;
import repositories.TicketRepository;
import service.repositories.AccountRepositoryImpl;
import service.repositories.EventRepositoryImpl;
import service.repositories.TicketRepositoryImpl;
import utils.Category;

public class MainService {
    public static void main(String[] args) {

        EventRepositoryImpl eventRepository = new EventRepositoryImpl();
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl();

        EntitiesService.CreateEntities(eventRepository, accountRepository, ticketRepository);

        eventRepository.getByCategory(Category.MUSIC).forEach(event -> {
            System.out.println(event.getName());
        });

//        System.out.println("Alegeti una dintre optiuni: \n");
//        System.out.println("1.Creare cont: \n");
//        System.out.println("2.Adaugare eveniment nou: \n");
//        System.out.println("3.Afisare evenimente ale artistului tau preferat: \n");
//        System.out.println("4.Cumparare bilet: \n");
//        System.out.println("5.Afisare detalii eveniment: \n");
//        System.out.println("6.Afisare evenimente dupa tip: \n");
//        System.out.println("7.Afisare evenimente dupa categorie: \n");
//        System.out.println("8.Afisare evenimente incomming: \n");
//        System.out.println("9.Afisare evenimente care au loc acum: \n");
//        System.out.println("10.Afisare evenimente dupa locatie: \n");

    }
}
