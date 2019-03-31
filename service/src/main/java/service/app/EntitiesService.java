package service.app;

import entities.*;
import service.repositories.AccountRepositoryImpl;
import service.repositories.EventRepositoryImpl;
import service.repositories.TicketRepositoryImpl;
import utils.Category;
import utils.EventType;
import utils.Status;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;

public class EntitiesService {
    public static void CreateEntities(EventRepositoryImpl eventRepository, AccountRepositoryImpl accountRepository, TicketRepositoryImpl ticketRepository) {
        Address SalaPalatuluiAdr = new Address("Bucuresti", "Bucuresti", "Ion Campineanu", "28");
        Address AreneleRomaneAdr = new Address("Bucuresti", "Bucuresti", "Cutitul de Argint", "26");
        Address RomexpoAdr = new Address("Bucuresti", "Bucuresti", "Marasti", "65-67");

        Artist TheMotans = new Artist("The Motans", "");
        Artist EdSheeran = new Artist("Ed Sheeran", "");
        Artist BonJovi = new Artist("Bon Jovi", "");

        Contact MihaiContact = new Contact("mihai1234@gmail.com", "0746538921");
        Contact VladContact = new Contact("vlad1234@gmail.com", "0758938320");
        Contact AlexContact = new Contact("alex1234@gmail.com", "0734734971");


        Location SalaPalatului = new Location("Sala Palatului", SalaPalatuluiAdr, "");
        Location AreneleRomane = new Location("Arenele Romane", AreneleRomaneAdr, "");
        Location Romexpo = new Location("Romexpo", RomexpoAdr, "");

        User MihaiUsr = new User("Mihai", "Popescu", 20, new Address(), MihaiContact);
        User VladUsr = new User("Vlad", "Georgescu", 22, new Address(), VladContact);
        User AlexUsr = new User("Alex", "Popa", 23, new Address(), AlexContact);

        Account Mihai = new Account("mihai", "123456", MihaiUsr);
        Account Vlad = new Account("VLAD", "123456", VladUsr);
        Account Alex = new Account("Alex", "123456", AlexUsr);

        Event A = new Event("A", Category.MUSIC, EventType.CONCERT, SalaPalatului,
                Instant.parse("2019-05-10T22:00:00Z"), Status.INCOMMING, "", TheMotans);
        Event B = new Event("B", Category.MUSIC, EventType.CONCERT, AreneleRomane,
                Instant.parse("2019-10-21T18:00:00Z"), Status.INCOMMING, "", EdSheeran);
        Event C = new Event("C", Category.MUSIC, EventType.CONCERT, Romexpo,
                Instant.parse("2019-04-05T18:30:00Z"), Status.INCOMMING, "", BonJovi);

        Ticket a = new Ticket(Mihai, A, 200d);
        Ticket b = new Ticket(Vlad, B, 300d);
        Ticket c = new Ticket(Alex, C, 500d);

        eventRepository.put(A);
        eventRepository.put(B);
        eventRepository.put(C);

        accountRepository.put(Mihai);
        accountRepository.put(Vlad);
        accountRepository.put(Alex);

        ticketRepository.put(a);
        ticketRepository.put(b);
        ticketRepository.put(c);
    }

}
