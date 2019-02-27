package client;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadSearchFile {

    private static Scanner x;


    public static void main(String[] args) {

        String filepath = "table.csv";
        String searchTerm = "142.440002";
        readRecord(searchTerm,filepath);


    }

    //Pass the values
    public static void readRecord(String searchTerm, String filePath) {

        boolean found = false;
        String ID = "";
        String nameOne = "";
        String age = "";
        List<String> values = new ArrayList<>();

        try {
            x = new Scanner(new File(filePath));
            //Separator
            x.useDelimiter("[,\n]");
            while(x.hasNext()) {
                String hold = x.next();
                values.add(hold);
            }

            while (x.hasNext() && !found) {
                ID = x.next();
                nameOne = x.next();
                age = x.next();

                if (ID.equals(searchTerm)) {
                    found = true;
                }
            }
            if (found) {
                JOptionPane.showMessageDialog(null, "ID: " + ID + " Name: " + nameOne + " Age: " + age);
            } else {
                JOptionPane.showMessageDialog(null, "Record not found");
            }
            }
               catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Error");
            }


        }
    }

