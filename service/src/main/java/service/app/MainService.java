package service.app;

import reader.AccountReader;
import reader.ArtistReader;
import reader.EventReader;
import reader.UserReader;
import service.repositories.*;
import utils.Category;

public class MainService {
    public static void main(String[] args) {

        EventRepositoryImpl eventRepository = new EventRepositoryImpl();
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl();
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        ArtistRepositoryImpl artistRepository = new ArtistRepositoryImpl();

        EntitiesService.CreateEntities(eventRepository, accountRepository, ticketRepository);

        eventRepository.getByCategory(Category.MUSIC).forEach(event -> {
            System.out.println(event.getName());
        });

        AccountReader.main(args);
        ArtistReader.main(args);
        EventReader.main(args);
        UserReader.main(args);

        accountRepository.putAll(AccountReader.getAccountList());
        artistRepository.putAll(ArtistReader.getArtistList());
        eventRepository.putAll(EventReader.getEventList());
        userRepository.putAll(UserReader.getUserList());

    }
}
