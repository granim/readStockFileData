package client;

import com.opencsv.CSVReaderHeaderAware;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadAddFile {

    private static Scanner x;
    private static Scanner y;

    public static void main(String[] args) {
        String filepath = "table.csv";
        //  readRecord(filepath);
        // readCSVHeader(filepath);
    }

    public static void readRecord(String filePath) {

        boolean found = false;
        List<String> allValues = new ArrayList<>();
        List<List<String>> stockInfo = new ArrayList<>();
        List<String> splitValues = new ArrayList<>();
        try {
            x = new Scanner(new File(filePath));
            y = new Scanner(new File(filePath));
            //Separator
            x.useDelimiter("[,]");
            y.useDelimiter("[\n]");
            while (y.hasNext() && !found) {
                allValues.add(x.next());
                stockInfo.add(allValues);

            if (found) {
                break;
            }
        }
        }
        catch(Exception e){
            System.out.println("There was na error");
        }


        System.out.println(allValues.size() + " Size of list allvalues");
       System.out.println(allValues.get(0));
       System.out.println(stockInfo.size());
      System.out.println(stockInfo.get(0) + "stockInfo");

}

    public static void readCSVHeader(String filepath) {
       Map<String, String> values = new HashMap<>();
        try {
            values = new CSVReaderHeaderAware(new FileReader(filepath)).readMap();


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(values);
    }



}
