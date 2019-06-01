package reader;

import entities.Artist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArtistReader extends Reader<Artist> {

    private static List<Artist> artistList = new ArrayList<Artist>();

    @Override
    public void run() {
        ArtistReader artistReader = new ArtistReader();

        artistList = artistReader.readAndCreateObjects(
                "E:\\Projects\\Laboratoare an II sem II\\PAO\\proiect-pao\\csv-reader\\src\\main\\resources\\artist.csv"
        );

    }


    public static List<Artist> getArtistList() {
        return Collections.unmodifiableList(artistList);
    }

    @Override
    Artist createObject(String[] objectDetails) {
        return new Artist(objectDetails[0], objectDetails[1]);
    }
}
