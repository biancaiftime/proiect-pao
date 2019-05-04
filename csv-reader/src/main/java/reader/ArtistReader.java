package reader;

import entities.Artist;

import java.util.List;

public class ArtistReader extends Reader<Artist> {

    public static void main(String[] args) {
        ArtistReader artistReader = new ArtistReader();

        List<Artist> artistList = artistReader.readAndCreateObjects(
                "E:\\Projects\\Laboratoare an II sem II\\PAO\\proiect-pao\\csv-reader\\src\\main\\resources\\artist.csv"
        );

        for(Artist artist : artistList)
            System.out.println(artist);
    }


    @Override
    Artist createObject(String[] objectDetails) {
        return new Artist(objectDetails[0], objectDetails[1]);
    }
}
