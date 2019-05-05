package reader;

import com.opencsv.CSVReader;
import entities.Account;
import entities.Address;
import entities.Contact;
import entities.User;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountReader extends Reader<Account> {

    private static List<Account> accountList = new ArrayList<Account>();

    public static void main(String args[]) {

        AccountReader accountReader = new AccountReader();

        accountList = accountReader.readAndCreateObjects(
                "E:\\Projects\\Laboratoare an II sem II\\PAO\\proiect-pao\\csv-reader\\src\\main\\resources\\account.csv");

        for(Account account : accountList){
            System.out.println(account);
        }



    }

    public static List<Account> getAccountList() {
        return Collections.unmodifiableList(accountList);
    }

    @Override
    Account createObject(String[] objectDetails) {

        Account account = new Account(objectDetails[0], objectDetails[1], new User(objectDetails[2],
                objectDetails[3], Integer.parseInt(objectDetails[4]),
                new Address(objectDetails[5], objectDetails[6], objectDetails[7], objectDetails[8]),
                new Contact(objectDetails[9], objectDetails[10])));

        return account;
    }
}
