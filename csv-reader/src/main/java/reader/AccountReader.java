package reader;

import com.opencsv.CSVReader;
import entities.Account;
import entities.Address;
import entities.Contact;
import entities.User;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AccountReader {
    public static void main(String args[]) {
        CSVReader csvReader = null;

        try {
            csvReader = new CSVReader(new FileReader("E:\\Projects\\Laboratoare an II sem II\\PAO\\proiect-pao\\csv-reader\\src\\main\\resources\\account.csv"), ',', '"', 1);

            String[] accountDetails = null;

            List<Account> accountList = new ArrayList<Account>();

            while ((accountDetails = csvReader.readNext()) != null) {

                Account emp = new Account(accountDetails[0], accountDetails[1], new User(accountDetails[2],
                        accountDetails[3], Integer.parseInt(accountDetails[4]),
                        new Address(accountDetails[5], accountDetails[6], accountDetails[7], accountDetails[8]),
                        new Contact(accountDetails[9], accountDetails[10])));

                accountList.add(emp);
            }

            for (Account account : accountList)
                System.out.println(account);

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}
