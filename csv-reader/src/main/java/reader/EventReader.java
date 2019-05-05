package reader;

import entities.*;
import utils.Category;
import utils.EventType;
import utils.Status;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventReader extends Reader<Event> {

    private static List<Event> eventList = new ArrayList<Event>();

    public static void main(String args[]) {

        EventReader eventReader = new EventReader();

        eventList = eventReader.readAndCreateObjects(
                "E:\\Projects\\Laboratoare an II sem II\\PAO\\proiect-pao\\csv-reader\\src\\main\\resources\\event.csv");

        for (Event event : eventList) {
            System.out.println(event);
        }

    }

    public static List<Event> getEventList() {
        return Collections.unmodifiableList(eventList);
    }

    @Override
    Event createObject(String[] objectDetails) {

        Event event = new Event(objectDetails[0], Category.valueOf(objectDetails[1]), EventType.valueOf(objectDetails[2]),
                new Location(objectDetails[3], new Address(objectDetails[4], objectDetails[5], objectDetails[6],
                        objectDetails[7]), objectDetails[8]), Instant.parse(objectDetails[9]),
                Status.valueOf(objectDetails[10]), objectDetails[11], new Artist(objectDetails[12], objectDetails[13]));

        return event;
    }
}
