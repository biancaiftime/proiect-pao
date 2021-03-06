package reader;

import entities.Address;
import entities.Contact;
import entities.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserReader extends Reader<User> {

    private static List<User> userList = new ArrayList<User>();

    public void run() {

        UserReader userReader = new UserReader();

        userList = userReader.readAndCreateObjects(
                "E:\\Projects\\Laboratoare an II sem II\\PAO\\proiect-pao\\csv-reader\\src\\main\\resources\\user.csv"
        );

    }


    public static List<User> getUserList() {
        return Collections.unmodifiableList(userList);
    }

    @Override
    User createObject(String[] objectDetails) {
        return new User(objectDetails[0],
                objectDetails[1], Integer.parseInt(objectDetails[2]),
                new Address(objectDetails[3], objectDetails[4], objectDetails[5], objectDetails[6]),
                new Contact(objectDetails[7], objectDetails[8]));
    }
}
