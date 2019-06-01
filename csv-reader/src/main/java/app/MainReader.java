package app;

import reader.AccountReader;
import reader.ArtistReader;
import reader.EventReader;
import reader.UserReader;

public class MainReader {
    public static void main(String[] args) throws InterruptedException {
        AccountReader accountReader = new AccountReader();
        ArtistReader artistReader = new ArtistReader();
        EventReader eventReader = new EventReader();
        UserReader userReader = new UserReader();

        Thread eventThread = new Thread(eventReader);
        Thread accountThread = new Thread(accountReader);
        Thread artistThread = new Thread(artistReader);
        Thread userThread = new Thread(userReader);

        eventThread.start();
        eventThread.join();
        accountThread.start();
        accountThread.join();
        artistThread.start();
        artistThread.join();
        userThread.start();
        userThread.join();

        EventReader.getEventList().forEach(System.out::println);
        AccountReader.getAccountList().forEach(System.out::println);
        ArtistReader.getArtistList().forEach(System.out::println);
        UserReader.getUserList().forEach(System.out::println);

    }
}
