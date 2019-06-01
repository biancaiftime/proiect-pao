package service.app;

import app.MainReader;
import reader.AccountReader;
import reader.ArtistReader;
import reader.EventReader;
import reader.UserReader;
import service.repositories.*;
import utils.Category;

public class MainService {
    public static void main(String[] args) throws InterruptedException{

        EventRepositoryImpl eventRepository = new EventRepositoryImpl();
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl();
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        ArtistRepositoryImpl artistRepository = new ArtistRepositoryImpl();

        EntitiesService.CreateEntities(eventRepository, accountRepository, ticketRepository);

        eventRepository.getByCategory(Category.MUSIC).forEach(event -> {
            System.out.println(event.getName());
        });

        MainReader.main(args);

        accountRepository.putAll(AccountReader.getAccountList());
        artistRepository.putAll(ArtistReader.getArtistList());
        eventRepository.putAll(EventReader.getEventList());
        userRepository.putAll(UserReader.getUserList());

    }
}
