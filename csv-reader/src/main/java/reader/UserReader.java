package reader;

import entities.Address;
import entities.Contact;
import entities.User;

import java.util.List;

public class UserReader extends Reader<User> {

    public static void main(String[] args) {

        UserReader userReader = new UserReader();

        List<User> userList = userReader.readAndCreateObjects(
                "E:\\Projects\\Laboratoare an II sem II\\PAO\\proiect-pao\\csv-reader\\src\\main\\resources\\user.csv"
        );

        for(User user : userList)
            System.out.println(user);
    }

    @Override
    User createObject(String[] objectDetails) {
        return new User(objectDetails[0],
                objectDetails[1], Integer.parseInt(objectDetails[2]),
                new Address(objectDetails[3], objectDetails[4], objectDetails[5], objectDetails[6]),
                new Contact(objectDetails[7], objectDetails[8]));
    }
}
