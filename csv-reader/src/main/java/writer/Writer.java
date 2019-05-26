package writer;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;


public class Writer {

    private static File file = new File("E:\\Projects\\Laboratoare an II sem II\\PAO\\proiect-pao\\csv-reader\\src\\main\\resources\\audit.csv");

    public  void writeData(String className, String methodName ) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());


        try {
            FileWriter outputfile = new FileWriter(file, true );

            CSVWriter writer = new CSVWriter(outputfile);

            String message = "Method " + methodName + " from class " + className + " was called.";
            String[] messageToCSV = {timestamp.toString(), message};
            //System.out.println(timestamp.toString());

            writer.writeNext(messageToCSV);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}