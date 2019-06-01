package main;


import entities.*;
import reader.AccountReader;
import reader.ArtistReader;
import reader.EventReader;
import reader.UserReader;
import service.AccountService;
import service.EventService;
import utils.Category;
import utils.EventType;
import utils.Status;

import java.sql.SQLException;
import java.time.Instant;

public class MainService {
    public static void main(String[] args) throws SQLException {

        //addElements(args);
        AccountService accountService = AccountService.getInstance();
        accountService.getAccounts().stream().forEach(System.out::println);
    }

    public static void addElements(String[] args) throws SQLException {
        EventService eventService = EventService.getInstance();
        AccountService accountService = AccountService.getInstance();

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

        eventService.addEvent(A);
        eventService.addEvent(B);
        eventService.addEvent(C);

        accountService.addAccount(Mihai);
        accountService.addAccount(Vlad);
        accountService.addAccount(Alex);

        AccountReader.main(args);
        ArtistReader.main(args);
        EventReader.main(args);
        UserReader.main(args);

        EventReader.getEventList().stream().forEach(eventService::addEvent);
        AccountReader.getAccountList().stream().forEach(accountService::addAccount);
    }

}
